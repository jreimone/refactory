package dk.itu.sdg.language.coral.checker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.internal.resources.Folder;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.internal.core.CompilationUnit;

@SuppressWarnings("restriction")
public class ResourceUtil {

	public static IResource getResource(Object selection) {
		
		IResource resource = null;
		if (selection instanceof File) {
			File file = (File) selection;
			resource = file;
		} else if (selection instanceof CompilationUnit) {
			CompilationUnit file = (CompilationUnit) selection;			
			resource = file.getResource();
		}
		return resource;
	}

	public static ArrayList<File> getFilesFromResource(IResource resource) {
		
		ArrayList<File> files = new ArrayList<File>();
		
		if (resource instanceof Project) {
			Project project = (Project) resource;
			
			IResource[] members = null;
			try {
				members = project.members();
			} catch (CoreException e) {
				e.printStackTrace();
			}
			
			for (IResource member : members) {
				files.addAll(getFilesFromResource(member));				
			}
		} else if (resource instanceof Folder) {
			Folder folder = (Folder) resource;
			
			IResource[] members = null;
			try {
				members = folder.members();
			} catch (CoreException e) {
				e.printStackTrace();
			}
			
			for (IResource member : members) {
				
				//TODO: put the values into the properties file!
				//remove bin folder
				boolean isBinFolder = folder.getName().equals("bin");
				//remove hidden folders
				boolean isHiddenFolder = folder.getName().startsWith(".");
				//remove target folder
				boolean isTargetFolder = folder.getName().equals("target");
				
				if (!isBinFolder && !isHiddenFolder && !isTargetFolder) {
					files.addAll(getFilesFromResource(member));
				}				
			}
		} else if (resource instanceof File) {
			File file = (File) resource;
						
			//remove hidden files
			boolean hiddenFile = file.getName().startsWith(".");
			//remove class files, more precisely all files in bin folder
			boolean classFile = file.getName().endsWith(".class");
			
			if (!hiddenFile && !classFile) {
				files.add((File)resource);
			}
		}
		
		return files;
	}

	public static Map<String,Set<File>> clusterFiles(ArrayList<File> files) {
		
		Map<String,Set<File>> clusteredFiles = new HashMap<String,Set<File>>();
		
		for (File file : files) {
			String fileName = file.getName();
			
			String language = "";
			
			if (fileName.contains(".")) {
				int languageStart = fileName.indexOf(".");
				language = fileName.substring(languageStart + 1, fileName.length());
			} 
			
			Set<File> filesPerLanguage = clusteredFiles.get(language);
			
			if (filesPerLanguage == null) {
				filesPerLanguage = new HashSet<File>();
			}
			filesPerLanguage.add(file);
				
			if (language != null) {
				clusteredFiles.put(language, filesPerLanguage);
			} else {
				clusteredFiles.put("unknown language", filesPerLanguage);
			}
		}
		
		return clusteredFiles;
	}

}
