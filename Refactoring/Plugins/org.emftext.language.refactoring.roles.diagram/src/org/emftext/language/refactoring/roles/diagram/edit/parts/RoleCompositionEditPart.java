package org.emftext.language.refactoring.roles.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.refactoring.roles.diagram.edit.policies.RoleCompositionItemSemanticEditPolicy;

/**
 * @generated
 */
public class RoleCompositionEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4004;

	/**
	 * @generated
	 */
	public RoleCompositionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RoleCompositionItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof RoleCompositionSourceNameEditPart) {
			((RoleCompositionSourceNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureCompositionSourceNameFigure());
			return true;
		}
		if (childEditPart instanceof RoleCompositionTargetNameEditPart) {
			((RoleCompositionTargetNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureCompositionTargetNameFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof RoleCompositionSourceNameEditPart) {
			return true;
		}
		if (childEditPart instanceof RoleCompositionTargetNameEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new RoleCompositionFigure();
	}

	/**
	 * @generated
	 */
	public RoleCompositionFigure getPrimaryShape() {
		return (RoleCompositionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class RoleCompositionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureCompositionSourceNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureCompositionTargetNameFigure;

		/**
		 * @generated
		 */
		public RoleCompositionFigure() {
			this.setLineWidth(2);
			this.setForegroundColor(ColorConstants.cyan);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureCompositionSourceNameFigure = new WrappingLabel();
			fFigureCompositionSourceNameFigure.setText("<source>");

			this.add(fFigureCompositionSourceNameFigure);

			fFigureCompositionTargetNameFigure = new WrappingLabel();
			fFigureCompositionTargetNameFigure.setText("<target>");

			this.add(fFigureCompositionTargetNameFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureCompositionSourceNameFigure() {
			return fFigureCompositionSourceNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureCompositionTargetNameFigure() {
			return fFigureCompositionTargetNameFigure;
		}

	}

}
