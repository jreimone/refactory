package dk.itu.sdg.language.coral.checker.jobs


import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import dk.itu.sdg.language.coral.checker.GReader
import dk.itu.sdg.language.coral.checker.ResourceUtil


class Convert2PrologJob	extends Job {
		
	def final IResource resource

	
	public Convert2PrologJob(IResource file) {
		super("Converting to Prolog...")
		this.resource = file
		
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
				
		
		monitor.beginTask("Converting to Prolog...", 100)
		
		monitor.subTask("Reading File... ")
		GReader reader = new GReader(ResourceUtil.getResource(this.resource))
		monitor.worked(1)

		def modelResource = reader.getEmfResource()
		if(modelResource != null) {
			def String = generateKB(modelResource)
		}
		monitor.worked(1)		
		
		monitor.done()
		
		return Status.OK_STATUS
	}
	
	private String generateKB(Resource modelResource) {
		
		def StringBuilder stringBuilder = new StringBuilder()
		
		def Iterator<EObject> i = modelResource.getAllContents()
		
		stringBuilder.append("resource(uri(\"" + modelResource.getURI() + "\")).\n")
		
		while (i.hasNext()) {
			Object o = i.next()

			
			if (o instanceof EObject) {
				def EObject eClass = (EObject) o
				
				stringBuilder.append("contains(resource(uri(\"" + modelResource.getURI() + "\"))," + eClass.eClass().getName().toLowerCase() + "(uri(\"" + EcoreUtil.getURI(eClass) + "\"))).\n")
				//stringBuilder.append(eClass.eClass().getName().toLowerCase() + "(uri(\"" + EcoreUtil.getURI(eClass) + "\")).\n")
				
				def EList<EAttribute> eAttributes = eClass.eClass().getEAllAttributes();
				def StringBuilder attributeStringBuilder
				
				for (eAttribute in eAttributes) {
					attributeStringBuilder = new StringBuilder()
					
					def attributeValue = eClass.eGet(eAttribute)
//					attributeValue.re
					
					attributeStringBuilder.append(eAttribute.getName().toLowerCase() + "(" + attributeValue + ")")
					if (eAttributes.indexOf(eAttribute) < eAttributes.size() - 1) {
						attributeStringBuilder.append(",")
					}
				}
				
				if (attributeStringBuilder != null) {
					stringBuilder.append(eClass.eClass().getName().toLowerCase() + "(uri(\"" + EcoreUtil.getURI(eClass) + "\")," + attributeStringBuilder + ").\n")
				} else {
					stringBuilder.append(eClass.eClass().getName().toLowerCase() + "(uri(\"" + EcoreUtil.getURI(eClass) + "\")).\n")
				}
				
				def eContainments = eClass.eAllContents()
				for (eContainment in eContainments) {
					
					stringBuilder.append("contains(" + eClass.eClass().getName().toLowerCase() + "(uri(\"" + EcoreUtil.getURI(eClass) + "\"))," + eContainment.eClass().getName().toLowerCase() + "(uri(\"" + EcoreUtil.getURI(eContainment) + "\"))).\n")
				}
			}
		}
		
		File file = new File(this.resource.getLocation().toString() + ".pl")
		file.write(stringBuilder.toString())
		
		return stringBuilder.toString()
	}

}
