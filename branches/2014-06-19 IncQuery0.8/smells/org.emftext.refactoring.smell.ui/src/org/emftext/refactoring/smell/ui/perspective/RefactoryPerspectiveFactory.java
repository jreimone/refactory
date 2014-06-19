package org.emftext.refactoring.smell.ui.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.emftext.refactoring.smell.ui.views.QualitiesView;
import org.emftext.refactoring.smell.ui.views.QualitySmellsView;
import org.emftext.refactoring.ui.views.registry.RefactoringRegistryView;

public class RefactoryPerspectiveFactory implements IPerspectiveFactory {

	private static final String PACKAGE_EXPLORER_VIEW_ID	= "org.eclipse.jdt.ui.PackageExplorer";
	
	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		IFolderLayout bottomLeft = layout.createFolder("bottomLeft", IPageLayout.BOTTOM, 0.7f, editorArea);
		bottomLeft.addView(QualitiesView.ID);
		bottomLeft.addPlaceholder(IPageLayout.ID_PROBLEM_VIEW);
		IFolderLayout bottomRight = layout.createFolder("bottomRight", IPageLayout.RIGHT, 0.4f, QualitiesView.ID);
		bottomRight.addView(QualitySmellsView.ID);
		bottomRight.addView(RefactoringRegistryView.ID);
		
		IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, 0.2f, editorArea);
//		left.addView(IPageLayout.ID_PROJECT_EXPLORER);
		left.addView(PACKAGE_EXPLORER_VIEW_ID);
		
		IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT, 0.75f, editorArea);
		right.addView(IPageLayout.ID_OUTLINE);
	}

}
