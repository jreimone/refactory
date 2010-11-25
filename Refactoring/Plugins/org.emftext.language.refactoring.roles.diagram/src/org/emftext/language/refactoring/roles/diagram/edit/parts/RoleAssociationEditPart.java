package org.emftext.language.refactoring.roles.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.refactoring.roles.diagram.edit.policies.RoleAssociationItemSemanticEditPolicy;

/**
 * @generated
 */
public class RoleAssociationEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4003;

	/**
	 * @generated
	 */
	public RoleAssociationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RoleAssociationItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof RoleAssociationSourceNameEditPart) {
			((RoleAssociationSourceNameEditPart) childEditPart).setLabel(
					getPrimaryShape().getFigureSourceNameFigure());
			return true;
		}
		if (childEditPart instanceof RoleAssociationTargetNameEditPart) {
			((RoleAssociationTargetNameEditPart) childEditPart).setLabel(
					getPrimaryShape().getFigureTargetNameFigure());
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
		super.addChildVisual(childEditPart, index);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof RoleAssociationSourceNameEditPart) {
			return true;
		}
		if (childEditPart instanceof RoleAssociationTargetNameEditPart) {
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
		return new RoleAssociationFigure();
	}

	/**
	 * @generated
	 */
	public RoleAssociationFigure getPrimaryShape() {
		return (RoleAssociationFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class RoleAssociationFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureSourceNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureTargetNameFigure;

		/**
		 * @generated
		 */
		public RoleAssociationFigure() {
			this.setLineWidth(2);
			this.setForegroundColor(ColorConstants.gray);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureSourceNameFigure = new WrappingLabel();
			fFigureSourceNameFigure.setText("<source>");

			this.add(fFigureSourceNameFigure);

			fFigureTargetNameFigure = new WrappingLabel();
			fFigureTargetNameFigure.setText("<target>");

			this.add(fFigureTargetNameFigure);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			df.setFill(false);
			df.setLineWidth(2);
			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSourceNameFigure() {
			return fFigureSourceNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureTargetNameFigure() {
			return fFigureTargetNameFigure;
		}

	}

}
