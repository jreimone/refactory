/*******************************************************************************
 * Copyright (c) 2006, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.compare.ITypedElement;
import org.eclipse.compare.structuremergeviewer.ICompareInput;
import org.eclipse.compare.structuremergeviewer.ICompareInputChangeListener;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.diff.merge.service.MergeService;
import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DiffResourceSet;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChange;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.MatchResourceSet;
import org.eclipse.emf.compare.ui.util.EMFCompareConstants;
import org.eclipse.emf.compare.ui.util.EMFCompareEObjectUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.graphics.Image;

/**
 * Input to be used for a 2 or 3-way comparison in a
 * {@link org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer ModelContentMergeViewer}.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
public class ModelCompareInput implements ICompareInput {
	/** Resource containing the ancestor object of this comparison. */
	private Resource ancestorResource;

	/** Diff result of the underlying comparison. Can be either a DiffModel or a DiffResourceSet. */
	private final Object diff;

	/** Keeps a list of all the differences (without DiffGroup) detected. */
	private List<DiffElement> diffList;

	/** Memorizes all listeners registered for this {@link ICompareInput compare input}. */
	private final List<ICompareInputChangeListener> inputChangeListeners = new ArrayList<ICompareInputChangeListener>();

	/** Resource containing the left compared object. */
	private Resource leftResource;

	/** match result of the underlying comparison. Can be either a MatchModel or a MatchResourceSet. */
	private final Object match;

	/** Resource containing the right compared object. */
	private Resource rightResource;

	/** The compare input we've originaly been fed. */
	private ICompareInput initialInput;

	/**
	 * Creates a CompareInput given the resulting {@link org.eclipse.emf.compare.match.diff.match.MatchModel
	 * match} and {@link org.eclipse.emf.compare.match.diff.diff.DiffModel diff} of the comparison.
	 * 
	 * @param matchModel
	 *            {@link org.eclipse.emf.compare.match.diff.match.MatchModel match} of the comparison.
	 * @param diffModel
	 *            {@link org.eclipse.emf.compare.match.diff.diff.DiffModel diff} of the comparison.
	 */
	public ModelCompareInput(MatchModel matchModel, DiffModel diffModel) {
		match = matchModel;
		diff = diffModel;
	}

	/**
	 * Creates a CompareInput given the resulting {@link MatchResourceSet match} and {@link DiffResourceSet
	 * diff} of the comparison.
	 * 
	 * @param matchResourceset
	 *            {@link MatchResourceSet match} of the comparison.
	 * @param diffResourceSet
	 *            {@link DiffResourceSet diff} of the comparison.
	 */
	public ModelCompareInput(MatchResourceSet matchResourceset, DiffResourceSet diffResourceSet) {
		match = matchResourceset;
		diff = diffResourceSet;
	}

	/**
	 * Creates a CompareInput given the resulting {@link org.eclipse.emf.compare.match.diff.match.MatchModel
	 * match} and {@link org.eclipse.emf.compare.match.diff.diff.DiffModel diff} of the comparison.
	 * 
	 * @param matchModel
	 *            {@link org.eclipse.emf.compare.match.diff.match.MatchModel match} of the comparison.
	 * @param diffModel
	 *            {@link org.eclipse.emf.compare.match.diff.diff.DiffModel diff} of the comparison.
	 * @param provider
	 *            The input provider which has been used for this comparison.
	 * @since 1.1
	 */
	public ModelCompareInput(MatchModel matchModel, DiffModel diffModel,
			ICompareInputDetailsProvider provider) {
		this(matchModel, diffModel);
		if (provider != null) {
			leftResource = provider.getLeftResource();
			rightResource = provider.getRightResource();
			ancestorResource = provider.getAncestorResource();
			initialInput = provider.getCompareInput();
		}
	}

	/**
	 * Creates a CompareInput given the resulting {@link MatchResourceSet match} and {@link DiffResourceSet
	 * diff} of the comparison.
	 * 
	 * @param matchResourceset
	 *            {@link MatchResourceSet match} of the comparison.
	 * @param diffResourceSet
	 *            {@link DiffResourceSet diff} of the comparison.
	 * @param provider
	 *            The input provider which has been used for this comparison.
	 * @since 1.1
	 */
	public ModelCompareInput(MatchResourceSet matchResourceset, DiffResourceSet diffResourceSet,
			ICompareInputDetailsProvider provider) {
		this(matchResourceset, diffResourceSet);
		if (provider != null) {
			leftResource = provider.getLeftResource();
			rightResource = provider.getRightResource();
			ancestorResource = provider.getAncestorResource();
			initialInput = provider.getCompareInput();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#addCompareInputChangeListener(ICompareInputChangeListener)
	 */
	public void addCompareInputChangeListener(ICompareInputChangeListener listener) {
		inputChangeListeners.add(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#copy(boolean)
	 */
	public void copy(boolean leftToRight) {
		final List<DiffElement> differences = new ArrayList<DiffElement>();
		if (diff instanceof DiffModel) {
			differences.addAll(((DiffModel)diff).getOwnedElements());
		} else {
			for (final DiffModel aDiff : ((DiffResourceSet)diff).getDiffModels()) {
				differences.addAll(aDiff.getOwnedElements());
			}
		}
		doCopy(differences, leftToRight);
		fireCompareInputChanged();
	}

	/**
	 * Copies a single {@link DiffElement} or a {@link DiffGroup} in the given direction.
	 * 
	 * @param element
	 *            {@link DiffElement Element} to copy.
	 * @param leftToRight
	 *            Direction of the copy.
	 */
	public void copy(DiffElement element, boolean leftToRight) {
		doCopy(element, leftToRight);
		fireCompareInputChanged();
	}

	/**
	 * Copies a list of {@link DiffElement}s or {@link DiffGroup}s in the given direction.
	 * 
	 * @param elements
	 *            {@link DiffElement Element}s to copy.
	 * @param leftToRight
	 *            Direction of the copy.
	 */
	public void copy(List<DiffElement> elements, boolean leftToRight) {
		doCopy(elements, leftToRight);
		fireCompareInputChanged();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#getAncestor()
	 */
	public ITypedElement getAncestor() {
		if (initialInput != null)
			return initialInput.getAncestor();
		ITypedElement ancestor = null;
		if (ancestorResource != null) {
			if (ancestorResource.getContents().size() > 0) {
				ancestor = new TypedElementWrapper(ancestorResource.getContents().get(0));
			}
		} else {
			MatchModel matchModel = null;
			if (match instanceof MatchModel) {
				matchModel = (MatchModel)match;
			} else if (((MatchResourceSet)match).getMatchModels().size() != 0) {
				matchModel = ((MatchResourceSet)match).getMatchModels().get(0);
			}
			if (matchModel != null && !matchModel.getAncestorRoots().isEmpty()) {
				ancestor = new TypedElementWrapper(matchModel.getAncestorRoots().get(0));
			}
		}
		return ancestor;
	}

	/**
	 * Returns the left resource of this input.
	 * 
	 * @return The left loaded resource.
	 * @since 1.0
	 */
	public Resource getAncestorResource() {
		if (ancestorResource == null) {
			final MatchModel matchModel;
			if (match instanceof MatchModel) {
				matchModel = (MatchModel)match;
			} else if (match == null || ((MatchResourceSet)match).getMatchModels().size() == 0) {
				return null;
			} else {
				matchModel = ((MatchResourceSet)match).getMatchModels().get(0);
			}
			if (!matchModel.getAncestorRoots().isEmpty()) {
				ancestorResource = matchModel.getAncestorRoots().get(0).eResource();
			}
		}
		return ancestorResource;
	}

	/**
	 * Returns this ModelCompareInput's DiffModel.
	 * 
	 * @return This ModelCompareInput's DiffModel.
	 */
	public Object getDiff() {
		return diff;
	}

	/**
	 * Returns the {@link DiffElement} of the input {@link DiffModel} as a list. Doesn't take
	 * {@link DiffGroup}s into account.
	 * 
	 * @return The {@link DiffElement} of the input {@link DiffModel} as a list.
	 */
	public List<DiffElement> getDiffAsList() {
		if (diffList == null) {
			diffList = new ArrayList<DiffElement>();
			if (getDiff() == null)
				return diffList;
			// ordering is needed in order to merge modelElement diffs before references change
			// We'll order the diffs by class (modelElementChange, attributechange then referenceChange)
			final List<ModelElementChange> modelElementDiffs = new ArrayList<ModelElementChange>();
			final List<AttributeChange> attributeChangeDiffs = new ArrayList<AttributeChange>();
			final List<ReferenceChange> referenceChangeDiffs = new ArrayList<ReferenceChange>();
			final TreeIterator<EObject> iterator = ((EObject)getDiff()).eAllContents();
			while (iterator.hasNext()) {
				final EObject next = iterator.next();
				if (next instanceof ModelElementChange) {
					modelElementDiffs.add((ModelElementChange)next);
				} else if (next instanceof AttributeChange) {
					attributeChangeDiffs.add((AttributeChange)next);
				} else if (next instanceof ReferenceChange) {
					referenceChangeDiffs.add((ReferenceChange)next);
				} else if (next instanceof DiffElement && !(next instanceof DiffGroup)) {
					diffList.add((DiffElement)next);
				}
			}
			diffList.addAll(modelElementDiffs);
			diffList.addAll(attributeChangeDiffs);
			diffList.addAll(referenceChangeDiffs);
			modelElementDiffs.clear();
			attributeChangeDiffs.clear();
			referenceChangeDiffs.clear();
		}

		return diffList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#getImage()
	 */
	public Image getImage() {
		Image image = null;

		if (getMatch() != null) {
			image = EMFCompareEObjectUtils.computeObjectImage((EObject)getMatch());
		} else if (getDiff() != null) {
			image = EMFCompareEObjectUtils.computeObjectImage((EObject)getDiff());
		}

		return image;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#getKind()
	 */
	public int getKind() {
		if (getAncestor() != null)
			return EMFCompareConstants.ENABLE_ANCESTOR;
		return EMFCompareConstants.NO_CHANGE;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#getLeft()
	 */
	public ITypedElement getLeft() {
		if (initialInput != null)
			return initialInput.getLeft();
		ITypedElement left = null;
		if (leftResource != null) {
			if (leftResource.getContents().size() > 0) {
				left = new TypedElementWrapper(leftResource.getContents().get(0));
			}
		} else {
			MatchModel matchModel = null;
			if (match instanceof MatchModel) {
				matchModel = (MatchModel)match;
			} else if (!((MatchResourceSet)match).getMatchModels().isEmpty()) {
				matchModel = ((MatchResourceSet)match).getMatchModels().get(0);
			}
			if (matchModel == null || matchModel.getLeftRoots().isEmpty()) {
				left = new TypedElementWrapper(null);
			} else {
				left = new TypedElementWrapper(matchModel.getLeftRoots().get(0));
			}
		}
		return left;
	}

	/**
	 * Returns the left resource of this input.
	 * 
	 * @return The left loaded resource.
	 * @since 1.0
	 */
	public Resource getLeftResource() {
		if (leftResource == null) {
			final MatchModel matchModel;
			if (match instanceof MatchModel) {
				matchModel = (MatchModel)match;
			} else if (match == null || ((MatchResourceSet)match).getMatchModels().size() == 0) {
				return null;
			} else {
				matchModel = ((MatchResourceSet)match).getMatchModels().get(0);
			}
			if (!matchModel.getLeftRoots().isEmpty()) {
				leftResource = matchModel.getLeftRoots().get(0).eResource();
			}
		}
		return leftResource;
	}

	/**
	 * Returns this ModelCompareInput's MatchModel.
	 * 
	 * @return This ModelCompareInput's MatchModel.
	 */
	public Object getMatch() {
		return match;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#getName()
	 */
	public String getName() {
		String name = null;

		if (getMatch() instanceof EObject) {
			name = EMFCompareEObjectUtils.computeObjectName((EObject)getMatch());
		} else if (getDiff() instanceof EObject) {
			name = EMFCompareEObjectUtils.computeObjectName((EObject)getDiff());
		}

		return name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#getRight()
	 */
	public ITypedElement getRight() {
		if (initialInput != null)
			return initialInput.getRight();
		ITypedElement right = null;
		if (rightResource != null) {
			if (rightResource.getContents().size() > 0) {
				right = new TypedElementWrapper(rightResource.getContents().get(0));
			}
		} else {
			MatchModel matchModel = null;
			if (match instanceof MatchModel) {
				matchModel = (MatchModel)match;
			} else if (!((MatchResourceSet)match).getMatchModels().isEmpty()) {
				matchModel = ((MatchResourceSet)match).getMatchModels().get(0);
			}
			if (matchModel == null || matchModel.getRightRoots().isEmpty()) {
				right = new TypedElementWrapper(null);
			} else {
				right = new TypedElementWrapper(matchModel.getRightRoots().get(0));
			}
		}
		return right;
	}

	/**
	 * Returns the left resource of this input.
	 * 
	 * @return The left loaded resource.
	 * @since 1.0
	 */
	public Resource getRightResource() {
		if (rightResource == null) {
			final MatchModel matchModel;
			if (match instanceof MatchModel) {
				matchModel = (MatchModel)match;
			} else if (match == null || ((MatchResourceSet)match).getMatchModels().size() == 0) {
				return null;
			} else {
				matchModel = ((MatchResourceSet)match).getMatchModels().get(0);
			}
			if (!matchModel.getRightRoots().isEmpty()) {
				rightResource = matchModel.getRightRoots().get(0).eResource();
			}
		}
		return rightResource;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#removeCompareInputChangeListener(ICompareInputChangeListener)
	 */
	public void removeCompareInputChangeListener(ICompareInputChangeListener listener) {
		inputChangeListeners.remove(listener);
	}

	/**
	 * Applies the changes implied by a given {@link DiffElement} in the direction specified by
	 * <code>leftToRight</code>.
	 * 
	 * @param element
	 *            {@link DiffElement} containing the copy information.
	 * @param leftToRight
	 *            <code>True</code> if the changes must be applied from the left to the right model,
	 *            <code>False</code> otherwise.
	 */
	protected void doCopy(DiffElement element, boolean leftToRight) {
		MergeService.merge(element, leftToRight);
	}

	/**
	 * Applies the changes implied by a list of {@link DiffElement} in the direction specified by
	 * <code>leftToRight</code>.
	 * 
	 * @param elements
	 *            {@link DiffElement}s containing the copy information.
	 * @param leftToRight
	 *            <code>True</code> if the changes must be applied from the left to the right model,
	 *            <code>False</code> otherwise.
	 */
	protected void doCopy(List<DiffElement> elements, boolean leftToRight) {
		MergeService.merge(elements, leftToRight);
	}

	/**
	 * Notifies all {@link ICompareInputChangeListener listeners} registered for this
	 * {@link ModelCompareInput input} that a change occured.
	 */
	protected void fireCompareInputChanged() {
		diffList.clear();
		diffList = null;
		for (final ICompareInputChangeListener listener : inputChangeListeners) {
			listener.compareInputChanged(this);
		}
	}
}
