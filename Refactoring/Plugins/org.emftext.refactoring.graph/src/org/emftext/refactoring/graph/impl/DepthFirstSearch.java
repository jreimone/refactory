/**
 * 
 */
package org.emftext.refactoring.graph.impl;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.refactoring.graph.IShortestPathAlgorithm;
import org.emftext.refactoring.graph.util.GraphUtil;
import org.emftext.refactoring.graph.util.IPath;
import org.emftext.refactoring.graph.util.TreeLeaf;
import org.emftext.refactoring.graph.util.TreeNode;
import org.emftext.refactoring.graph.util.TreeNodeReferenceLeaf;
import org.emftext.refactoring.graph.util.TreeParent;

/**
 * @author Jan Reimann
 *
 */
public class DepthFirstSearch implements IShortestPathAlgorithm {

	private Map<EClass, TreeNode> visitedNodesMap;
	private List<IPath> paths;
	private EClass sourceClass;
	private EClass targetClass;

	private boolean output = false;

	public DepthFirstSearch(){
		//		visitedNodes = new ArrayList<EClass>();
		paths = new ArrayList<IPath>();
		visitedNodesMap = new HashMap<EClass, TreeNode>();
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.graph.IShortestPathAlgorithm#calculatePaths(org.eclipse.emf.ecore.resource.Resource, org.eclipse.emf.ecore.EClass, org.eclipse.emf.ecore.EClass)
	 */
	public List<IPath> calculatePaths(EObject source, EObject target) {
		sourceClass = source.eClass();
		targetClass = target.eClass();
		TreeNode root = new TreeParent(sourceClass);
		visitedNodesMap.put(sourceClass, root);
		if(output){
			System.err.println(root.getEClass().getName());
		}
		createContainmentTree(root);
		return paths;
	}

	private void createContainmentTree(TreeNode parent){
		EList<EReference> containments = parent.getEClass().getEAllContainments();
		if(containments == null || containments.size() == 0){
			if(parent.getEClass().isAbstract() || parent.getEClass().isInterface()){
				EList<EClass> subTypes = GraphUtil.getAllSubTypes(parent.getEClass());
				if(subTypes.size() == 0){
					convertNodeToLeaf(parent, parent.getReference());
					return;
				} else {
					for (EClass eClass : subTypes) {
						checkTargetEquality(parent, eClass, parent.getReference());
					}
				}
			} else {
				convertNodeToLeaf(parent, null);
				return;
			}
		} else {
			//		if(parent.getEClass().isAbstract() || parent.getEClass().isInterface()){
			//			parent = parent.getParent();
			//		}
			for (EReference eReference : containments) {
				EClass contained = eReference.getEReferenceType();
				checkTargetEquality(parent, contained, eReference);
			}
		}
	}

	/**
	 * @param parent
	 * @param contained
	 */
	private void checkTargetEquality(TreeNode parent, EClass contained, EReference reference) {
		if(contained.equals(targetClass)){
			createPath(parent, contained, reference);
		} else {
			createSubTree(parent, contained, reference);
		}
	}

	/**
	 * @param parent
	 * @param contained
	 */
	private void createPath(TreeNode parent, EClass contained, EReference reference) {
		TreeNode child;
		child = new TreeLeaf(contained);
		parent.addChild(child);
		child.setReferenceFromParent(reference);
		visitedNodesMap.put(contained, child);
		IPath path = child.getPathFromRoot();
		paths.add(path);
		outputEClassInTree(child, System.out, "*");
	}

	/**
	 * @param parent
	 * @param contained
	 */
	private void createSubTree(TreeNode parent, EClass contained, EReference reference) {
		TreeNode child = visitedNodesMap.get(contained);
		if(child == null){
			child = distinguishNodeType(contained);
			parent.addChild(child);
			child.setReferenceFromParent(reference);
			visitedNodesMap.put(contained, child);
			checkUniqueNodeInPath(child);
		} else {
			TreeNode nodeReferenceLeaf = new TreeNodeReferenceLeaf(contained, child);
			parent.addChild(nodeReferenceLeaf);
			child.setReferenceFromParent(reference);
			outputEClassInTree(nodeReferenceLeaf, System.out, "~");
		}

	}

	private void outputEClassInTree(TreeNode child, PrintStream stream, String addon) {
		if(output){
			int offset = child.getPathFromRoot().size();
			StringBuffer spaces = new StringBuffer();
			for (int i = 1; i < offset; i++) {
				spaces.append("  ");
			}
			spaces.append("|__" + addon + child.getEClass().getName());
			stream.println(spaces.toString());
		}
	}

	/**
	 * @param child
	 */
	private void checkUniqueNodeInPath(TreeNode child) {
		if(child.pathContainsEClass(child.getEClass())){
			child.getParent().removeChild(child);
		} else {
			if(child instanceof TreeParent){
				outputEClassInTree(child, System.err, "+");
				createContainmentTree(child);
			} else {
				outputEClassInTree(child, System.err, "]");
			}
		}
	}

	/**
	 * @param eClass
	 * @return
	 */
	private TreeNode distinguishNodeType(EClass eClass) {
		//		TreeNode subTypeNode;
		EList<EReference> subContainments = eClass.getEAllContainments();
		if(subContainments == null || subContainments.size() == 0){
			if(eClass.isAbstract() || eClass.isInterface()){
				EList<EClass> subTypes = GraphUtil.getAllSubTypes(eClass);
				if(subTypes.size() > 0){
					return new TreeParent(eClass);
				}
			}
			return new TreeLeaf(eClass);
		}
		return new TreeParent(eClass);
	}

	/**
	 * @param nodeToConvert
	 */
	private void convertNodeToLeaf(TreeNode nodeToConvert, EReference reference) {
		TreeNode parentParent = nodeToConvert.getParent();
		parentParent.removeChild(nodeToConvert);
		TreeNode parentLeaf = new TreeLeaf(nodeToConvert.getEClass());
		parentParent.addChild(parentLeaf);
		parentLeaf.setReferenceFromParent(reference);
	}

	/**
	 * @param output the output to set
	 */
	public void setOutput(boolean output) {
		this.output = output;
	}

}
