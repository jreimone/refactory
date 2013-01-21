package dk.itu.sdg.aspect.tracemodel.generator;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Maps.uniqueIndex;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.generator.GeneratorComponent;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.GeneratorComponent.Outlet;

import com.google.common.base.Function;
import com.google.inject.Injector;

public class AspectGeneratorComponent extends GeneratorComponent {

	private Injector injector;
	private List<String> slotNames = newArrayList();
	private Map<String,String> outlets = newHashMap();

	
	/**
	 * registering an {@link ISetup}, which causes the execution of {@link ISetup#createInjectorAndDoEMFRegistration()}
	 * the resulting {@link com.google.inject.Inject} is stored and used to obtain the used {@link IGenerator}. 
	 */
	public void setRegister(ISetup setup) {
		injector = setup.createInjectorAndDoEMFRegistration();
	}
	
	/**
	 * sets the {@link Injector} to be used to obtain the used {@link IGenerator} instance.
	 */
	public void setInjector(Injector injector) {
		this.injector = injector;
	}
	
	/**
	 * adds a slot name to look for {@link Resource}s (the slot's contents might be a Resource or an Iterable of Resources).
	 */
	public void addSlot(String slot) {
		this.slotNames.add(slot);
	}

	public void preInvoke() {
		if (slotNames.isEmpty())
			throw new IllegalStateException("no 'slot' has been configured.");
		if (injector == null)
			throw new IllegalStateException("no Injector has been configured. Use 'register' with an ISetup or 'injector' directly.");
		if (outlets.isEmpty())
			throw new IllegalStateException("no 'outlet' has been configured.");
			
		for (Entry<String, String> outlet : outlets.entrySet()) {
			if (outlet.getKey()==null)
				throw new IllegalStateException("One of the outlets was configured without a name");
			if (outlet.getValue()==null)
				throw new IllegalStateException("The path of outle '"+outlet.getKey()+"' was null.");
		}
	}
	
	
	public static class Outlet {
		
		private String outletName = IFileSystemAccess.DEFAULT_OUTPUT;
		private String path;
		
		public void setOutletName(String outputName) {
			this.outletName = outputName;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public String getOutletName() {
			return outletName;
		}
		public String getPath() {
			return path;
		}
	}
	
	/**
	 * an outlet is defined by a name and a path.
	 * The generator will internally choose one of the configured outlets when generating a file.
	 * the given path defines the root directory of the outlet.
	 */
	public void addOutlet(Outlet out) {
		outlets.put(out.outletName,out.path);
	}
	
	public void invoke(IWorkflowContext ctx) {
//		IGenerator instance = getCompiler();
		IGenerator2 instance = getCompiler();

		IFileSystemAccess fileSystemAccess = getConfiguredFileSystemAccess();
		for (String slot : slotNames) {
			Object object = ctx.get(slot);
			if (object == null) {
				throw new IllegalStateException("Slot '"+slot+"' was empty!");
			}
			if (object instanceof Iterable) {
				Iterable<?> iterable = (Iterable<?>) object;
				for (Object object2 : iterable) {
					if (!(object2 instanceof Resource)) {
//						throw new IllegalStateException("Slot contents was not a Resource but a '"+object.getClass().getSimpleName()+"'!");
					}
				}
				instance.doGenerate(iterable, fileSystemAccess);
			} else if (object instanceof Resource) {
				instance.doGenerate((Resource) object, fileSystemAccess);
			} else {
				throw new IllegalStateException("Slot contents was not a Resource but a '"+object.getClass().getSimpleName()+"'!");
			}
		}
	}

//	protected IGenerator getCompiler() {
//		return injector.getInstance(IGenerator.class);
//	}

	protected IGenerator2 getCompiler() {
		return injector.getInstance(IGenerator2.class);
	}
	
	protected IFileSystemAccess getConfiguredFileSystemAccess() {
		final JavaIoFileSystemAccess configuredFileSystemAccess = injector.getInstance(JavaIoFileSystemAccess.class);
		configuredFileSystemAccess.setOutputConfigurations(getOutputConfigurations());
		for (Entry<String, String> outs : outlets.entrySet()) {
			configuredFileSystemAccess.setOutputPath(outs.getKey(), outs.getValue());
		}
		return configuredFileSystemAccess;
	}

	public void postInvoke() {
		
	}
	
	/**
	 * @since 2.3
	 */
	protected Map<String, OutputConfiguration> getOutputConfigurations() {
		IOutputConfigurationProvider outputConfigurationProvider = injector
				.getInstance(IOutputConfigurationProvider.class);
		Set<OutputConfiguration> configurations = outputConfigurationProvider.getOutputConfigurations();
		return uniqueIndex(configurations, new Function<OutputConfiguration, String>() {
			public String apply(OutputConfiguration from) {
				return from.getName();
			}
		});
	}
}
