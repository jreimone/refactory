/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

public class GueryNature implements org.eclipse.core.resources.IProjectNature {
	
	public static final String NATURE_ID = "org.modelrefactoring.guery.resource.guery.nature";
	
	private org.eclipse.core.resources.IProject project;
	
	/**
	 * the IDs of all builders, IDs of additional builders can be added here
	 */
	public final static String[] BUILDER_IDS = {org.modelrefactoring.guery.resource.guery.mopp.GueryBuilderAdapter.BUILDER_ID};
	
	public static void activate(org.eclipse.core.resources.IProject project) {
		try {
			org.eclipse.core.resources.IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();
			
			for (int i = 0; i < natures.length; ++i) {
				if (NATURE_ID.equals(natures[i])) {
					// already active
					return;
				}
			}
			// Add the nature
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = NATURE_ID;
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		} catch (org.eclipse.core.runtime.CoreException e) {
		}
	}
	
	public static void deactivate(org.eclipse.core.resources.IProject project) {
		try {
			org.eclipse.core.resources.IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();
			
			for (int i = 0; i < natures.length; ++i) {
				if (NATURE_ID.equals(natures[i])) {
					// Remove the nature
					String[] newNatures = new String[natures.length - 1];
					System.arraycopy(natures, 0, newNatures, 0, i);
					System.arraycopy(natures, i + 1, newNatures, i, natures.length - i - 1);
					description.setNatureIds(newNatures);
					project.setDescription(description, null);
					return;
				}
			}
		} catch (org.eclipse.core.runtime.CoreException e) {
		}
	}
	
	public static boolean hasNature(org.eclipse.core.resources.IProject project) {
		try {
			org.eclipse.core.resources.IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();
			for (int i = 0; i < natures.length; ++i) {
				if (NATURE_ID.equals(natures[i])) {
					return true;
				}
			}
		} catch (org.eclipse.core.runtime.CoreException e) {
		}
		return false;
	}
	
	public void configure() throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IProjectDescription desc = project.getDescription();
		org.eclipse.core.resources.ICommand[] commands = desc.getBuildSpec();
		
		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(org.modelrefactoring.guery.resource.guery.mopp.GueryBuilderAdapter.BUILDER_ID)) {
				return;
			}
		}
		org.eclipse.core.resources.ICommand[] newCommands = commands;
		outer: for (int j = 0; j < BUILDER_IDS.length; j++) {
			for (int i = 0; i < commands.length; ++i) {
				if (commands[i].getBuilderName().equals(BUILDER_IDS[j])) {
					continue outer;
				}
			}
			org.eclipse.core.resources.ICommand[] tempCommands = new org.eclipse.core.resources.ICommand[newCommands.length + 1];
			System.arraycopy(newCommands, 0, tempCommands, 0, newCommands.length);
			org.eclipse.core.resources.ICommand command = desc.newCommand();
			command.setBuilderName(BUILDER_IDS[j]);
			tempCommands[tempCommands.length - 1] = command;
			newCommands = tempCommands;
		}
		if (newCommands != commands) {
			desc.setBuildSpec(newCommands);
			project.setDescription(desc, null);
		}
	}
	
	public void deconfigure() throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IProjectDescription description = getProject().getDescription();
		org.eclipse.core.resources.ICommand[] commands = description.getBuildSpec();
		org.eclipse.core.resources.ICommand[] newCommands = commands;
		for (int j = 0; j < BUILDER_IDS.length; j++) {
			for (int i = 0; i < newCommands.length; ++i) {
				if (newCommands[i].getBuilderName().equals(BUILDER_IDS[j])) {
					org.eclipse.core.resources.ICommand[] tempCommands = new org.eclipse.core.resources.ICommand[newCommands.length - 1];
					System.arraycopy(newCommands, 0, tempCommands, 0, i);
					System.arraycopy(newCommands, i + 1, tempCommands, i, newCommands.length - i - 1);
					newCommands = tempCommands;
					break;
				}
			}
		}
		if (newCommands != commands) {
			description.setBuildSpec(newCommands);
		}
	}
	
	public org.eclipse.core.resources.IProject getProject() {
		return project;
	}
	
	public void setProject(org.eclipse.core.resources.IProject project) {
		this.project = project;
	}
	
}
