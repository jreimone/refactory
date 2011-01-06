package org.reuseware.build;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.emftext.sdk.util.StreamUtil;

public class BuildFileGenerator {

	public class Language {
		
		private String dir;
		private String pluginID;
		private String csFile;
		private boolean generateEditCode;
		private String secondaryExtension;
		private String secondaryGenExtension;
		private String ecoreFile;
		private String resourcePluginID;

		public Language(String pluginID, String ecoreFile, String resourcePluginID, String csFile, boolean generateEditCode) {
			this(pluginID, ecoreFile, resourcePluginID, csFile, generateEditCode, null);
		}
		
		public Language(String pluginID, String ecoreFile, String resourcePluginID, String csFile, boolean generateEditCode, String secondaryExtension) {
			this(pluginID, ecoreFile, resourcePluginID, csFile, generateEditCode, secondaryExtension, null);
		}
		
		public Language(String pluginID, String ecoreFile, String resourcePluginID, String csFile, boolean generateEditCode, String secondaryExtension, String secondaryGenExtension) {
			super();
			this.pluginID = pluginID;
			this.ecoreFile = ecoreFile;
			this.resourcePluginID = resourcePluginID;
			this.csFile = csFile;
			this.generateEditCode = generateEditCode;
			this.secondaryExtension = secondaryExtension;
			this.secondaryGenExtension = secondaryGenExtension;
		}

		public String getDir() {
			return dir;
		}

		public String getPluginID() {
			return pluginID;
		}

		public String getCsFile() {
			return csFile;
		}

		public boolean generateEditCode() {
			return generateEditCode;
		}

		public String getSecondaryExtension() {
			return secondaryExtension;
		}

		public String getSecondaryGenExtension() {
			return secondaryGenExtension;
		}

		public String getEcoreFile() {
			return ecoreFile;
		}

		public String getResourcePluginID() {
			return resourcePluginID;
		}

		protected void setDir(String dir) {
			this.dir = dir;
		}
	}
	
	public class OntoMoPPLanguage extends Language {
		
		private static final String ONTOMOPP_DIR = "${ontomopp.plugins.dir}";

		public OntoMoPPLanguage(String pluginID, String ecoreFile, String resourcePluginID, String csFile, boolean generateEditCode) {
			this(pluginID, ecoreFile, resourcePluginID, csFile, generateEditCode, null);
		}

		public OntoMoPPLanguage(String pluginID, String ecoreFile, String resourcePluginID, String csFile, boolean generateEditCode, String secondaryExtension) {
			this(pluginID, ecoreFile, resourcePluginID, csFile, generateEditCode, secondaryExtension, null);
		}

		public OntoMoPPLanguage(String pluginID, String ecoreFile, String resourcePluginID, String csFile, boolean generateEditCode, String secondaryExtension, String secondaryGenExtension) {
			super(pluginID, ecoreFile, resourcePluginID, csFile, generateEditCode, secondaryExtension, secondaryGenExtension);
			setDir(ONTOMOPP_DIR);
		}
	}
	
	public class RefactoryLanguage extends Language {
		
		private static final String REFACTORY_DIR = "${refactory.plugins.dir}";

		public RefactoryLanguage(String pluginID, String ecoreFile, String resourcePluginID, String csFile, boolean generateEditCode) {
			super(pluginID, ecoreFile, resourcePluginID, csFile, generateEditCode);
			setDir(REFACTORY_DIR);
		}
	}
	
	public class TestLanguage extends Language {
		
		private static final String TEST_DIR = "${test.plugins.dir}";

		public TestLanguage(String pluginID, String ecoreFile, String resourcePluginID, String csFile, boolean generateEditCode) {
			super(pluginID, ecoreFile, resourcePluginID, csFile, generateEditCode);
			setDir(TEST_DIR);
		}
	}

	private static final String NEW_LINE = System.getProperty("line.separator");
	
	public Language[] languages = new Language[] {
			new Language(
					"org.emftext.language.abnf", "abnf",
					"org.emftext.language.abnf.resource.abnf", "abnf", 
					false),
			new Language(
					"org.emftext.language.aterms", "aterms",
					"org.emftext.language.aterms.resource.aterms", "aterms", 
					false),
			new Language(
					"org.emftext.language.b", "B",
					"org.emftext.language.b.resource.mch", "B", 
					false),
			new Language(
					"org.emftext.language.bool", "bool",
					"org.emftext.language.bool.resource.bool", "bool", 
					false),
			new Language(
					"org.emftext.language.chess", "chess",
					"org.emftext.language.chess.resource.cg", "chess", 
					false),
			new Language(
					"org.emftext.language.c_sharp", "c_sharp",
					"org.emftext.language.c_sharp.resource.csharp", "c_sharp", 
					false),
			new Language(
					"org.emftext.language.conference", "conference",
					"org.emftext.language.conference.resource.conference", "conference", 
					false),
			new Language(
					"org.emftext.language.csv", "csv",
					"org.emftext.language.csv.resource.csv", "csv", 
					false),
			new Language(
					"org.emftext.language.customsandwich", "customsandwich",
					"org.emftext.language.customsandwich.resource.customsandwich", "customsandwich", 
					false),
			new Language(
					"org.emftext.language.customer", "customer",
					"org.emftext.language.customer.resource.customer", "customer", 
					false),
			new Language(
					"org.emftext.language.dot", "dot",
					"org.emftext.language.dot.resource.dot", "dot", 
					false),
			// TODO for some reason building the EAG language fails
			/*
			new Language(
					"org.emftext.language.eag", "eag",
					"org.emftext.language.eag.resource.eag", "eag", 
					false),
			*/
			new Language(
					"org.emftext.language.emfdoc", "emfdoc",
					"org.emftext.language.emfdoc.resource.emfdoc", "emfdoc", 
					true),
			new Language(
					"org.emftext.language.efactory", "efactory",
					"org.emftext.language.efactory.resource.efactory", "efactory", 
					false),
			new Language(
					"org.emftext.language.ecore.resource.facade", null,
					"org.emftext.language.ecore.resource.facade", "facade.ecore", 
					false),
			new Language(
					"org.emftext.language.featherweightjava", "featherweightjava",
					"org.emftext.language.featherweightjava.resource.fj", "featherweightjava", 
					false),
			new Language(
					"org.emftext.language.feature", "feature",
					"org.emftext.language.feature.resource.feature", "feature", 
					false),
			new Language(
					"org.emftext.language.filesystem", "filesystem",
					"org.emftext.language.filesystem.resource.fs", "filesystem",
					false),
			new Language(
					"org.emftext.language.forms", "forms",
					"org.emftext.language.forms.resource.forms", "forms",
					true),
			new Language(
					"org.emftext.language.formsembedded", "formsembedded",
					"org.emftext.language.formsembedded.resource.formsembedded", "formsembedded",
					false),
			new Language(
					"org.emftext.language.formsextension", "formsextension",
					"org.emftext.language.formsextension.resource.formsextension", "formsextension",
					false),
			new Language(
					"org.emftext.language.formular", "FormularMM",
					"org.emftext.language.formular.resource.formular", "FormularMM", 
					true),
			new Language(
					"org.emftext.language.km3", "KM3",
					"org.emftext.language.km3.resource.km3", "KM3",
					false),
			new Language(
					"org.emftext.language.martinfowlerdsl", "martinfowlerdsl",
					"org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl", "martinfowlerdsl", 
					false),
			new Language(
					"org.emftext.language.modelquery", "modelquery",
					"org.emftext.language.modelquery.resource.modelquery", "modelquery", 
					false),
			new Language(
					"org.emftext.language.models", "models",
					"org.emftext.language.models.resource.model", "models", 
					false),
			new Language(
					"org.emftext.language.office", "office",
					"org.emftext.language.office.resource.office", "office",
					false),
			new Language(
					"org.emftext.language.office2", "office2",
					"org.emftext.language.office2.resource.office2", "office2",
					false),
			new OntoMoPPLanguage(
					"org.emftext.language.owl", "owl",
					"org.emftext.language.owl.resource.owl", "owl", 
					true, ".text"),
			new OntoMoPPLanguage(
					"org.emftext.runtime.owltext.test", "owlTextTestLanguage",
					"org.emftext.runtime.owltext.test", "owlTextTestLanguage.text", 
					false, ".text", ".text"),
			new OntoMoPPLanguage(
					"org.emftext.language.owlcl", "owlcl",
					"org.emftext.language.owlcl.resource.owlcl", "owlcl", 
					false),
			new Language(
				"org.emftext.language.java", "java",
				"org.emftext.language.java.resource.java", "java", 
				true),
			new Language(
					"org.emftext.language.java.ejava", "eJava",
					"org.emftext.language.java.ejava.resource.ejava", "eJava", 
					true),
			new Language(
					"org.emftext.language.java.closures", "closures",
					"org.emftext.language.java.closures.resource.closure", "closures", 
					true),
			new Language(
				"org.emftext.language.java.javabehavior4uml", "JavaBehavior4UML",
				"org.emftext.language.java.javabehavior4uml.resource.javabehavior", "JavaBehavior4UML", 
				false),
			new Language(
				"org.emftext.language.java.properties", "properties",
				"org.emftext.language.java.properties.resource.propjava", "properties", 
				true),
			new Language(
				"org.emftext.language.java.reusejava", "reusejava",
				"org.emftext.language.java.reusejava.resource.reusejava", "reusejava", 
				false),
			new Language(
				"org.emftext.language.java.jtemplates", "jtemplates",
				"org.emftext.language.java.jtemplates.resource.javatemplate", "jtemplates", 
				false),
			new Language(
					"org.emftext.language.java.sqljava", "sqljava",
					"org.emftext.language.java.sqljava.resource.sqljava", "sqljava", 
					false),
			new Language(
				"org.emftext.language.java.treejava", "treejava",
				"org.emftext.language.java.treejava.resource.treejava", "treejava", 
				true),
			new Language(
					"org.emftext.language.javaforms", "javaforms",
					"org.emftext.language.javaforms.resource.javaforms", "javaforms", 
					false),
			new Language(
					"org.emftext.language.javaforms.codegen", "javaformscodegen",
					null, null, 
					false),
			new Language(
				"org.emftext.language.javaproperties", "javaproperties",
				"org.emftext.language.javaproperties.resource.javaproperties", "javaproperties", 
				false),
			new Language(
					"org.emftext.language.mecore", "mecore",
					"org.emftext.language.ecore.resource.mecore", "min.ecore", 
					false),
			new Language(
					"org.emftext.language.manifest", "manifest",
					"org.emftext.language.manifest.resource.manifest", "manifest", 
					false),
			new Language(
					"org.emftext.language.pacad", "pacad",
					"org.emftext.language.pacad.resource.pacad", "pacad", 
					false),
			new Language(
				"org.emftext.language.parametercheck", "parametercheck",
				"org.emftext.language.parametercheck.resource.pcheck", "parametercheck", 
				false),
			new Language(
					"org.emftext.language.petrinet", "petrinet",
					"org.emftext.language.petrinet.resource.petrinet", "petrinet", 
					false),
			new Language(
					"org.emftext.language.pico", "pico",
					"org.emftext.language.pico.resource.pico", "pico", 
					false),
			new Language(
					"org.emftext.language.primitivetypes", "primitivetypes",
					null, null,
					false),
			new Language(
					"org.emftext.language.pl0", "pl0",
					"org.emftext.language.pl0.resource.pl0", "pl0", 
					false),
			new Language(
					"org.emftext.language.pl0.extended", "pl0extended",
					"org.emftext.language.pl0extended.resource.pl0extended", "pl0extended", 
					false),
			new Language(
					"org.emftext.language.plugin", "plugin",
					"org.emftext.language.plugin.resource.topf", "plugin", 
					false, ".text"),
			new Language(
					"org.emftext.language.quickuml", null,
					"org.emftext.language.quickuml.resource.quml", "quickuml", 
					false),
			new Language(
					"org.emftext.language.rails", "rails",
					"org.emftext.language.rails.resource.rails", "rails", 
					false),
			new Language(
					"org.emftext.language.regexp", "regular_expressions",
					null, null, 
					false),
			new Language(
					"org.emftext.language.regexp", null,
					"org.emftext.language.regexp.resource.regexp_antlr", "regular_expressions_antlr",
					false),
			new Language(
					"org.emftext.language.regexp", null,
					"org.emftext.language.regexp.resource.regexp_sdf", "regular_expressions_sdf", 
					false),
			new Language(
					"org.emftext.language.regexp", null,
					"org.emftext.language.regexp.resource.regexp_automaton", "regular_expressions_automaton", 
					false),
			new Language(
					"org.emftext.language.sandwich", "sandwich",
					"org.emftext.language.sandwich.resource.sandwich", "sandwich", 
					false),
			new Language(
					"org.emftext.language.secprop", "secprop",
					"org.emftext.language.secprop.resource.text.secprop", "text.secprop", 
					true, ".text", ".text"),
			new Language(
					"org.emftext.language.simplec", "c",
					"org.emftext.language.simplec.resource.c", "c", 
					false),
			new Language(
					"org.emftext.language.simplegui", "simplegui",
					"org.emftext.language.simplegui.resource.simplegui", "simplegui", 
					false),
			new Language(
					"org.emftext.language.simplemath", "simplemath",
					"org.emftext.language.simplemath.resource.sm", "simplemath", 
					false),
			new Language(
					"org.emftext.language.simpleweave", "simpleweave",
					"org.emftext.language.simpleweave.resource.simpleweave", "simpleweave", 
					false),
			new OntoMoPPLanguage(
					"org.emftext.language.sparql", "sparql",
					"org.emftext.language.sparql.resource.sparql", "sparql",
					false),
			new Language(
					"org.emftext.language.sql", "sql",
					"org.emftext.language.sql.resource.sql", "sql",
					false),
			new Language(
					"org.emftext.language.statemachine", null,
					"org.emftext.language.statemachine.resource.statemachine", "statemachine", 
					false),
			new Language(
					"org.emftext.language.templateconcepts", "templateconcepts",
					null, null,
					false),
			new Language(
					"org.emftext.language.templateconcepts.call", "templatecall",
					"org.emftext.language.templateconcepts.call.resource.templatecall", "templatecall", 
					false),
			new Language(
					"org.emftext.language.tbool", "tbool",
					"org.emftext.language.tbool.resource.tbool", "tbool", 
					false),
			// removed temporarily until bug 1496 (TclTk - Fix token definitions) is fixed
			/*
			new Language(
					"org.emftext.language.tcltk", "tcl",
					"org.emftext.language.tcltk.resource.tcl", "tcl", 
					false),
			*/
			new Language(
					"org.emftext.language.textadventure", "textadventure",
					"org.emftext.language.textadventure.resource.tas", "textadventure", 
					false),
			new Language(
					"org.emftext.language.theater", "theater",
					"org.emftext.language.theater.resource.theater", "theater", 
					false),
			new Language(
					"org.emftext.language.threevaluedlogic", "threevaluedlogic",
					"org.emftext.language.threevaluedlogic.resource.tvl", "threevaluedlogic", 
					false),
			new Language(
					"org.emftext.language.timedautomata", "timedAutomata",
					"org.emftext.language.timedautomata.resource.ta", "timedAutomata", 
					false),
			new Language(
					"org.emftext.language.usecaseinvariant", "UseCaseInvariant",
					"org.emftext.language.usecaseinvariant.resource.ucinv", "UseCaseInvariant", 
					false),
			new Language(
					"org.emftext.language.valueflow", "valueflow",
					"org.emftext.language.valueflow.resource.valueflow", "valueflow", 
					true, ".text"),
			new Language(
					"org.emftext.language.xml", "xml",
					"org.emftext.language.xml.resource.xml", "xml", 
					false),
					
			new RefactoryLanguage(
					"org.emftext.language.refactoring.rolemapping", "rolemapping", 
					"org.emftext.language.refactoring.rolemapping.resource.rolemapping", "rolemapping", 
					false),
			new RefactoryLanguage(
					"org.emftext.language.refactoring.roles", "roles", 
					"org.emftext.language.refactoring.roles.resource.rolestext", "roles", 
					false),
			new RefactoryLanguage(
					"org.emftext.language.refactoring.specification", "refactoring_specification", 
					"org.emftext.language.refactoring.specification.resource.refspec", "refactoring_specification", 
					false),
					
			new TestLanguage(
					"org.emftext.test.booleanterminal", "booleanterminal",
					"org.emftext.test.booleanterminal.resource.booleanterminal", "booleanterminal", 
					false),
			new TestLanguage(
					"org.emftext.test.bug1154", "bug1154",
					"org.emftext.test.bug1154.resource.bug1154", "bug1154", 
					false),
			new TestLanguage(
					"org.emftext.test.bug933", "bug933",
					"org.emftext.test.bug933.resource.bug933", "bug933", 
					false),
			new TestLanguage(
					"org.emftext.test.bug1233", "bug1233",
					"org.emftext.test.bug1233.resource.bug1233", "bug1233", 
					false),
			new TestLanguage(
					"org.emftext.test.bug1233", "bug1233ext",
					null, null, 
					false),
			new TestLanguage(
					"org.emftext.test.cct1", "cct1",
					"org.emftext.test.cct1.resource.cct1", "cct1",
					false),
			new TestLanguage(
					"org.emftext.test.cct2", "cct2",
					"org.emftext.test.cct2.resource.cct2", "cct2",
					false),
			new TestLanguage(
					"org.emftext.test.cct3", "cct3",
					"org.emftext.test.cct3.resource.cct3", "cct3",
					false),
			new TestLanguage(
					"org.emftext.test.cct4", "cct4",
					"org.emftext.test.cct4.resource.cct4", "cct4",
					false),
			new TestLanguage(
					"org.emftext.test.escaping", "escaping",
					"org.emftext.test.escaping.resource.escaping", "escaping",
					false),
			new TestLanguage(
					"org.emftext.test.grammar_features", "grammar_features",
					"org.emftext.test.grammar_features.resource.grammar_features", "grammar_features",
					false),
			new TestLanguage(
					"org.emftext.test.printing", "printing",
					"org.emftext.test.printing.resource.printing", "printing",
					false),
			new TestLanguage(
					"org.emftext.test.resolving", "resolving",
					"org.emftext.test.resolving.resource.resolving", "resolving",
					false),
	};
	
	public static void main(String[] args) {
		new BuildFileGenerator().run();
	}

	public void run() {
		try {
			String buildFileName = "build-text-resources.xml";
			String template = StreamUtil.getContentAsString(new File("." + File.separator + buildFileName + ".template"));
			template = template.replace("<!--GENERATE_METAMODEL_TASKS-->", getMetaModelTasks());
			template = template.replace("<!--GENERATE_TEXT_RESOURCE_TASKS-->", getTextResourceTasks());
			template = template.replace("<!--CLEAN_TASKS-->", getCleanTasks());
			// save instantiated template
			File buildFile = new File(buildFileName);
			StreamUtil.copy(new ByteArrayInputStream(template.getBytes()), new FileOutputStream(buildFile));
			System.out.println("Successfully generated build file to " + buildFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
			// signal error to build script
			System.exit(1);
		}
	}

	private String getMetaModelTasks() {
		StringBuffer result = new StringBuffer();
		for (Language language : languages) {
			if (language.getEcoreFile() == null) {
				continue;
			}
			result.append("\t\t\t<generate-metamodel-code ");
			result.append("plugin=\"" + language.getPluginID() +"\" ");
			result.append("model=\"" + language.getEcoreFile() + "\" ");
			String secondaryExtension = language.getSecondaryExtension();
			if (secondaryExtension != null) {
				result.append("secondaryExtension=\"" + secondaryExtension + "\" ");
			}
			String secondaryGenExtension = language.getSecondaryGenExtension();
			if (secondaryGenExtension != null) {
				result.append("secondaryGenmodelExtension=\"" + secondaryGenExtension + "\" ");
			}
			String dir = language.getDir();
			if (dir != null) {
				result.append("dir=\"" + dir + "\" ");
			}
			result.append("generateEditProject=\"" + language.generateEditCode() + "\" ");
			result.append("/>");
			result.append(NEW_LINE);
		}
		return result.toString();
	}

	private String getTextResourceTasks() {
		StringBuffer result = new StringBuffer();
		for (Language language : languages) {
			String pluginID = language.getPluginID();
			String resourcePluginID = language.getResourcePluginID();
			if (resourcePluginID == null) {
				continue;
			}
			result.append("\t\t<generate-text-resource ");
			result.append("plugin=\"" + pluginID +"\" ");
			result.append("syntax=\"" + language.getCsFile() + "\" ");
			result.append("resourcePlugin=\"" + resourcePluginID +"\" ");
			String dir = language.getDir();
			if (dir != null) {
				result.append("dir=\"" + dir + "\" ");
			}
			result.append("/>");
			result.append(NEW_LINE);
		}
		return result.toString();
	}

	private String getCleanTasks() {
		StringBuffer result = new StringBuffer();
		for (Language language : languages) {
			String plugin = language.getPluginID();
			String resourcePlugin = language.getResourcePluginID();
			String dir = language.getDir();
			if (dir == null) {
				dir = "${language.plugins.dir}";
			}
			if (language.getEcoreFile() != null) {
				result.append("\t\t<!-- Remove meta model code for " + plugin + " -->");
				result.append(NEW_LINE);
				result.append("\t\t<delete dir=\"" + dir + "/" + plugin + "/src-gen\" excludes=\".svn\"/>");	
				result.append(NEW_LINE);
				result.append("\t\t<eclipse.refreshLocal depth=\"infinite\" resource=\"" + plugin + "/src-gen\"/>");
				result.append(NEW_LINE);
			}
			if (language.getResourcePluginID() != null) {
				result.append("\t\t<!-- Remove text resource code for " + resourcePlugin + " -->");
				result.append(NEW_LINE);
				result.append("\t\t<delete dir=\"" + dir + "/" + resourcePlugin + "/src-gen\" includes=\"**/*\" excludes=\".svn\"/>");
				result.append(NEW_LINE);
				result.append("\t\t<eclipse.refreshLocal depth=\"infinite\" resource=\"" + resourcePlugin + "/src-gen\"/>");
				result.append(NEW_LINE);
			}
		}
		return result.toString();
	}
}
