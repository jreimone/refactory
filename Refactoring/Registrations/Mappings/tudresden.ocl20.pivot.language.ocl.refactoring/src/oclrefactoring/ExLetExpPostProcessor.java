/**
 * 
 */
package oclrefactoring;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

import tudresden.ocl20.pivot.datatypes.impl.DatatypesFactoryImpl;
import tudresden.ocl20.pivot.language.ocl.BodyDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.DefinitionExpCS;
import tudresden.ocl20.pivot.language.ocl.InvariantExpCS;
import tudresden.ocl20.pivot.language.ocl.LetExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.language.ocl.OclPackage;
import tudresden.ocl20.pivot.language.ocl.SimpleNameCS;
import tudresden.ocl20.pivot.language.ocl.TypePathNameSimpleCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationWithInitCS;
import tudresden.ocl20.pivot.pivotmodel.NamedElement;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.pivotmodel.impl.PivotModelFactoryImpl;
import tudresden.ocl20.pivot.language.ocl.impl.*;
import tudresden.ocl20.pivot.language.ocl.util.OclAdapterFactory;

/**
 * @author Michael Muck
 *
 */
public class ExLetExpPostProcessor  implements IRefactoringPostProcessor {
	

	
	private List<EObject> namedElements;
	private SimpleNameCS simpleName;
	private String originalName;
	
	
	private OclExpressionCS extract;
	private OclExpressionCS origContainer;
	private SimpleNameCS newContainer;
	private SimpleNameCS newType;
	private LetExpCS myLetExp;
	private Boolean newLetExp;
	
	OclFactoryImpl myOclFactory;
	DatatypesFactoryImpl myDataTypesFactory;
	PivotModelFactoryImpl myPivotModelFactory;
	
	public ExLetExpPostProcessor() {
		myOclFactory = new OclFactoryImpl();
		myDataTypesFactory = new DatatypesFactoryImpl();
		myPivotModelFactory = new PivotModelFactoryImpl();
	}
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
		System.err.println("postprocessor activated!");
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
			System.out.println("role found with name: "+role.getName());
			List<EObject> roleplayers = roleRuntimeInstanceMap.get(role);
			for (EObject roleplayer : roleplayers) {
				System.out.println("   element playing this role: "+roleplayer.eClass().getName());
				if (roleplayer instanceof SimpleNameCS) {
					System.out.println("      assigned name for SimpleNameCS: "+((SimpleNameCS)roleplayer).getSimpleName());
				}
				System.out.println();
			}
			if (role.getName().equals("Extract")) {
				if (roleplayers.size() == 1) extract = (OclExpressionCS) roleplayers.get(0);
				System.out.println("   extract identified as: "+extract.toString());
				System.out.println("");
				TreeIterator<EObject> eac = extract.eAllContents();
				while (eac.hasNext()) {
					System.out.println("     "+eac.next());
				}
				
			}
			else if (role.getName().equals("OrigContainer")) {
				if (roleplayers.size() == 1) origContainer = (OclExpressionCS) roleplayers.get(0);
				System.out.println("   OrigContainer identified as: "+origContainer.toString());
				System.out.println("");
				TreeIterator<EObject> oac = origContainer.eAllContents();
				while (oac.hasNext()) {
					System.out.println("     "+oac.next());
				}
				
			}
			else if (role.getName().equals("NewContainer")) {
				if (roleplayers.size() == 1) newContainer = (SimpleNameCS) roleplayers.get(0);
				System.out.println("   NewContainer identified as: "+newContainer.eClass());
				System.out.println("");
				TreeIterator<EObject> nac = newContainer.eAllContents();
				while (nac.hasNext()) {
					System.out.println("     "+nac.next());
				}
				
			}
			else if (role.getName().equals("NewType")) {
				if (roleplayers.size() == 1) newType = (SimpleNameCS) roleplayers.get(0);
				System.out.println("   NewType identified as: "+newType.eClass());
				System.out.println("");
				TreeIterator<EObject> ntac = newType.eAllContents();
				while (ntac.hasNext()) {
					System.out.println("     "+ntac.next());
				}
				
			}
			
		}
		
		performSpecificTransformation();
		
		return Status.OK_STATUS;
	}
	
	private void performSpecificTransformation() {
		
		
		
		
		VariableDeclarationWithInitCS myVD = myOclFactory.createVariableDeclarationWithInitCS();
		System.out.println("myvd: "+myVD.eClass());
		myVD.setVariableName(newContainer);
		
		
		//creating a new Type for the VariableDeclaration from the provided input name
		TypePathNameSimpleCS mytype = myOclFactory.createTypePathNameSimpleCS();
		
		Type type = myPivotModelFactory.createType();
		type.setName(newType.getSimpleName());
				
		mytype.setTypeName(type);
		myVD.setTypeName(mytype);
		myVD.setInitialization(extract);
		myVD.setEqual("=");
		
		
		//getting the root of the constraint and finding an existing or creating a new let-expression
		
		EObject constraintRoot = origContainer.eContainer();
		System.err.println("tempparent: "+ constraintRoot.eClass());
		while (	!(constraintRoot instanceof InvariantExpCS) && 
				!(constraintRoot instanceof BodyDeclarationCS)) 
		{
			constraintRoot = constraintRoot.eContainer();
		}
		System.out.println("found constraint-root as: "+constraintRoot.toString());
		
		myLetExp = null;
		newLetExp = false;
		
		if (constraintRoot instanceof InvariantExpCS  && ((InvariantExpCS)constraintRoot).getOclExpression() instanceof LetExpCS) {
			InvariantExpCS inv = (InvariantExpCS)constraintRoot;
			myLetExp = (LetExpCS) inv.getOclExpression();
		} else if (constraintRoot instanceof BodyDeclarationCS && ((BodyDeclarationCS)constraintRoot).getOclExpression() instanceof LetExpCS) {
			BodyDeclarationCS inv = (BodyDeclarationCS)constraintRoot;
			myLetExp = (LetExpCS) inv.getOclExpression();
		} else {
			myLetExp = myOclFactory.createLetExpCS();
			newLetExp = true;
		}
		
		System.out.println("new LetExpCS created: "+newLetExp);
		
		
		//add the new VariableDeclarationWithInit to the LetExpCS

//		if (myLetExp.getVariableDeclarations() == null) {
//			System.out.println("new LetExpCS needs to be created!");
//			EList<VariableDeclarationWithInitCS> myVarDecList = new BasicEList<VariableDeclarationWithInitCS>();
//			myVarDecList.add(myVD);
//			((LetExpCSImpl)myLetExp).eSet(OclPackage.LET_EXP_CS__VARIABLE_DECLARATIONS, myVarDecList);
//		} else {
//			myLetExp.getVariableDeclarations().add(myVD);
//		}
		
		myLetExp.getVariableDeclarations().add(myVD);
		
		
		
		if (newLetExp) {
			if (constraintRoot instanceof InvariantExpCS) {
				myLetExp.setOclExpression(((InvariantExpCS)constraintRoot).getOclExpression());
				((InvariantExpCS)constraintRoot).setOclExpression(myLetExp);
			} else if (constraintRoot instanceof BodyDeclarationCS) {
				myLetExp.setOclExpression(((BodyDeclarationCS)constraintRoot).getOclExpression());
				((BodyDeclarationCS)constraintRoot).setOclExpression(myLetExp);
			} else {
				System.err.println("constraint root is neither an InvariantExpCS nor a BodyDeclarationExpCS!!! Refactoring invalid!");
			}
		}	
	}
	
	
	

	private boolean determineOriginalName(ChangeDescription change) {
		EMap<EObject, EList<FeatureChange>> objectChanges = change.getObjectChanges();
		EList<FeatureChange> eList = objectChanges.get(simpleName);
		for (FeatureChange featureChange : eList) {
			Object value = featureChange.getValue();
			if (value instanceof String) {
				originalName = (String) value;
				System.err.println("original name determined as: "+originalName);
				return true;
			}
		}
		return false;
	}

	private void performSpecificTransformation(SimpleNameCS simpleName2) {
		//the following is just for renaming variable-definitions and their uses, so if a simpleNameCS outside a variable-definition is renamed,
		//the following steps should not be executed!
		if (simpleName2.eContainer() instanceof VariableDeclarationWithInitCS) {
			VariableDeclarationWithInitCS var = (VariableDeclarationWithInitCS) simpleName2.eContainer();
			//now, this part refers to variables inside let-expressions:
			if(var.eContainer() instanceof LetExpCS) {
				LetExpCS let = (LetExpCS) var.eContainer();
				OclExpressionCS expression = let.getOclExpression();
				TreeIterator<EObject> eAllContents = expression.eAllContents();
				while (eAllContents.hasNext()) {
					EObject eObject = (EObject) eAllContents.next();
					if (eObject instanceof NamedLiteralExpCS) {
						NamedLiteralExpCS literal = (NamedLiteralExpCS) eObject;
						NamedElement namedElement = literal.getNamedElement();
						if(namedElement.getName().equals(originalName)){
							namedElement.setName(simpleName2.getSimpleName());
						}
					}
				}
			}
		}
	}

	
	
	
	

}
