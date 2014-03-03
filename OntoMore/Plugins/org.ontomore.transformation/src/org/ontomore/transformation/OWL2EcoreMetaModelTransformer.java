package org.ontomore.transformation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.emftext.language.owl.AbbreviatedXSDStringLiteral;
import org.emftext.language.owl.Annotateable;
import org.emftext.language.owl.Annotation;
import org.emftext.language.owl.AnnotationProperty;
import org.emftext.language.owl.AnnotationValue;
import org.emftext.language.owl.Class;
import org.emftext.language.owl.ClassAtomic;
import org.emftext.language.owl.Conjunction;
import org.emftext.language.owl.DataConjunction;
import org.emftext.language.owl.DataProperty;
import org.emftext.language.owl.DataRange;
import org.emftext.language.owl.Datatype;
import org.emftext.language.owl.DatatypeReference;
import org.emftext.language.owl.Description;
import org.emftext.language.owl.Disjunction;
import org.emftext.language.owl.Frame;
import org.emftext.language.owl.Individual;
import org.emftext.language.owl.LiteralTarget;
import org.emftext.language.owl.ObjectProperty;
import org.emftext.language.owl.ObjectPropertyReference;
import org.emftext.language.owl.Primary;
import org.emftext.language.owl.Target;
import org.ontomore.transformation.exception.OntomoreTransformationException;

/**
 * Transforms an OWL-Model in an Ecore-Metamodel and Ecore-Model. The OWL-Model
 * must be an "transformable ontology".
 * 
 * @author Erik Tittel
 * 
 */
public class OWL2EcoreMetaModelTransformer {

	private static final String CONTAINMENT_ANNOTATION = "containment";
	private static final String LOWERBOUND_ANNOTATION = "lowerbound";
	private static final String UPPERBOUND_ANNOTATION = "upperbound";
	
	private EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
	private List<Datatype> owlDatatypes;
	private List<Class> owlClasses;
	private List<ObjectProperty> objectProperties;
	// ObjectProperties and DataProperties are handled by their IRI because the
	// objects itself aren't unique
	private Map<String, EReference> objectPropertyMap;
	private Map<String, EAttribute> dataPropertyMap;
	private List<DataProperty> dataProperties;
	private List<Individual> owlIndividuals;
	
	private OntologyWrapper ontology;
	private PackageWrapper ePackage;

	/**
	 * Takes the root element of an ontology (as an EObject) and transforms the
	 * ontology in an Ecore-metamodel.
	 * 
	 * @param OntologyDocument
	 *            The OntologyDocument that contains the Ontology meant to be
	 *            transformed.
	 */
	public void transformOWL2Ecore(EObject ontologyEObject) {
		init();
		
		ontology = new OntologyWrapper(ontologyEObject);
		ePackage = new PackageWrapper(ontology.getName());
		
		transformOntologyElements();
		System.out.println("Transformed " + owlClasses.size() + " Classes to EClasses");
	}

	private void init() {
		owlDatatypes = new LinkedList<Datatype>();
		owlClasses = new LinkedList<Class>();
		objectProperties = new LinkedList<ObjectProperty>();
		objectPropertyMap = new HashMap<String, EReference>();
		dataPropertyMap = new HashMap<String, EAttribute>();
		dataProperties = new LinkedList<DataProperty>();
		owlIndividuals = new LinkedList<Individual>();
	}

	/**
	 * Transforms all Frames of the Ontology in the appropriate elements.
	 */
	private void transformOntologyElements() {
		transformFrames();
		transformSuperClassRelationships();
		transformObjectProperty();
		transformInverseProperties();
		transformDataProperty();
	}

	private void transformFrames() {
		EList<Frame> frames = ontology.getFrames();
		for (Frame frame : frames) {
			if (frame instanceof Datatype) {
				Datatype owlDatatype = (Datatype) frame;
				owlDatatypes.add(owlDatatype);
				transformDatatype(owlDatatype);
			} else if (frame instanceof Class) {
				Class owlClass = (Class) frame;
				owlClasses.add(owlClass);
				transformClass(owlClass);
			} else if (frame instanceof ObjectProperty) {
				ObjectProperty objectProperty = (ObjectProperty) frame;
				objectProperties.add(objectProperty);
			} else if (frame instanceof DataProperty) {
				DataProperty dataProperty = (DataProperty) frame;
				dataProperties.add(dataProperty);
			} else if (frame instanceof Individual) {
				Individual indiv = (Individual) frame;
				owlIndividuals.add(indiv);
			}
		}
	}

	private void transformDatatype(Datatype owlDatatype) {
		EDataType ecoreDataType = ecoreFactory.createEDataType();
		ecoreDataType.setName(owlDatatype.getIri());
		ePackage.addClassifier(ecoreDataType);
	}

	/**
	 * Transforms OWL classes in EClasses.
	 */
	private void transformClass(Class owlClass) {
		EClass ecoreClass = ecoreFactory.createEClass();
		ecoreClass.setName(owlClass.getIri());
		ePackage.addClassifier(ecoreClass);
	}

	/**
	 * Resolves and transforms inheritance relationships among classes.
	 */
	private void transformSuperClassRelationships() {
		for (Class owlClass : owlClasses) {
			List<Class> superClasses = getSuperClasses(owlClass);
			EClass ecoreClass = (EClass) getEClassifierFromPackage(owlClass.getIri());
			for (Class owlSuperClass : superClasses) {
				EClass ecoreSuperClass = (EClass) getEClassifierFromPackage(owlSuperClass.getIri());
				ecoreClass.getESuperTypes().add(ecoreSuperClass);
			}
		}

	}

	private EClassifier getEClassifierFromPackage(String className) {
		EClassifier result = ePackage.getClassifier(className);
		if (result == null) {
			throw new OntomoreTransformationException("Could not get Classifier from package: "
					+ className);
		}
		return result;
	}

	/**
	 * Collects all superclasses to a given OWL class. Only atomic superclasses
	 * are collected, no complex expressions.
	 * 
	 * @param owlClass
	 * @return list of superclasses or an empty list if there are no
	 *         superclasses
	 */
	private List<Class> getSuperClasses(Class owlClass) {
		List<Class> superClasses = new LinkedList<Class>();
		EList<Description> superClassesDescriptions = owlClass.getSuperClassesDescriptions();
		for (Description description : superClassesDescriptions) {
			Disjunction disj = (Disjunction) description;
			Conjunction conj = (Conjunction) disj.getConjunctions().get(0);
			Primary primary = (Primary) conj.getPrimaries().get(0);
			if (primary instanceof ClassAtomic) {
				ClassAtomic classAtomic = (ClassAtomic) primary;
				Class owlSuperClass = classAtomic.getClazz();
				superClasses.add(owlSuperClass);
			}
		}
		return superClasses;
	}

	private void transformObjectProperty() {
		for (ObjectProperty objectProperty : objectProperties) {
			EReference eReference = ecoreFactory.createEReference();
			eReference.setName(objectProperty.getIri());
			EClass domain = getDomainEClass(objectProperty);
			EClass Range = getRangeEClass(objectProperty);
			eReference.setEType(Range);
			eReference.setUpperBound(getUpperBound(objectProperty));
			eReference.setLowerBound(getLowerBound(objectProperty));
			eReference.setContainment(getContainment(objectProperty));
			domain.getEStructuralFeatures().add(eReference);
			objectPropertyMap.put(objectProperty.getIri(), eReference);
		}
	}

	private EClass getDomainEClass(ObjectProperty objectProperty) {
		if (objectProperty.getDomain().size() < 1) {
			throw new OntomoreTransformationException("Each ObjectProperty needs a domain");
		}
		Disjunction disj = (Disjunction) objectProperty.getDomain().get(0);
		Conjunction conj = (Conjunction) disj.getConjunctions().get(0);
		Primary primary = (Primary) conj.getPrimaries().get(0);
		Class owlClass = null;
		if (primary instanceof ClassAtomic) {
			ClassAtomic classAtomic = (ClassAtomic) primary;
			owlClass = classAtomic.getClazz();
		} else {
			throw new OntomoreTransformationException(
					"The domain of each ObjectProperty needs to be atomic");
		}
		return (EClass) getEClassifierFromPackage(owlClass.getIri());
	}

	private EClass getRangeEClass(ObjectProperty objectProperty) {
		if (objectProperty.getPropertyRange().size() < 1) {
			throw new OntomoreTransformationException("Each ObjectProperty needs a range");
		}
		Disjunction disj = (Disjunction) objectProperty.getPropertyRange().get(0);
		Conjunction conj = (Conjunction) disj.getConjunctions().get(0);
		Primary primary = (Primary) conj.getPrimaries().get(0);
		Class owlClass = null;
		if (primary instanceof ClassAtomic) {
			ClassAtomic classAtomic = (ClassAtomic) primary;
			owlClass = classAtomic.getClazz();
		} else {
			throw new OntomoreTransformationException(
					"The range of each ObjectProperty needs to be atomic");
		}
		return (EClass) getEClassifierFromPackage(owlClass.getIri());
	}

	private int getUpperBound(ObjectProperty objectProperty) {
		int upperBound = 1;
		try {
			upperBound = Integer.valueOf(getAnnotationValue(objectProperty, UPPERBOUND_ANNOTATION));
		} catch (NumberFormatException e) {
		}
		return upperBound;
	}

	private int getLowerBound(ObjectProperty objectProperty) {
		int lowerBound = 0;
		try {
			lowerBound = Integer.valueOf(getAnnotationValue(objectProperty, LOWERBOUND_ANNOTATION));
		} catch (NumberFormatException e) {
		}
		return lowerBound;
	}

	private boolean getContainment(ObjectProperty objectProperty) {
		boolean containment = false;
		try {
			containment = Boolean.valueOf(getAnnotationValue(objectProperty, CONTAINMENT_ANNOTATION));
		} catch (NumberFormatException e) {
		}
		return containment;
	}

	public String getAnnotationValue(Annotateable annotateable, String annotationName) {
		String result = "";
		try {
			result = tryGetAnnotationValue(annotateable, annotationName);
		} catch (Exception e) {
		}
		return result;
	}

	private String tryGetAnnotationValue(Annotateable annotateable, String annotationName) {
		String result = "";
		Annotation annotation = annotateable.getAnnotations().get(0);
		for (AnnotationValue annotationValue : annotation.getAnnotationValues()) {
			Target target = annotationValue.getTarget();
			if (annotationPropertyHasName(annotationValue.getAnnotationProperty(), annotationName)) {
				if (target instanceof LiteralTarget) {
					LiteralTarget literalTarget = (LiteralTarget) target;
					if (literalTarget.getLiteral() instanceof AbbreviatedXSDStringLiteral) {
						AbbreviatedXSDStringLiteral stringLiteral = (AbbreviatedXSDStringLiteral) literalTarget
								.getLiteral();
						result = stringLiteral.getValue();
					}
				}
			}
		}
		return result;
	}

	private boolean annotationPropertyHasName(AnnotationProperty annotationProperty,
			String annotationName) {
		return annotationProperty.getIri().equals(annotationName);
	}

	private void transformInverseProperties() {
		for (ObjectProperty objectProperty : objectProperties) {
			ObjectProperty owlInverseProperty = getInverseProperty(objectProperty);
			if (owlInverseProperty != null) {
				EReference eReference = objectPropertyMap.get(objectProperty.getIri());
				EReference inverseEReference = objectPropertyMap.get(owlInverseProperty.getIri());
				eReference.setEOpposite(inverseEReference);
				inverseEReference.setEOpposite(eReference);
			}
		}
	}

	private ObjectProperty getInverseProperty(ObjectProperty objectProperty) {
		ObjectProperty inverseProperty = null;
		try {
			ObjectPropertyReference objectPropertyReference = objectProperty.getInverseProperties()
					.get(0);
			inverseProperty = objectPropertyReference.getObjectProperty();
		} catch (Exception e) {
		}
		return inverseProperty;
	}

	private void transformDataProperty() {
		for (DataProperty dataProperty : dataProperties) {
			EAttribute eAttribute = ecoreFactory.createEAttribute();
			eAttribute.setName(dataProperty.getIri());
			EClass domain = getDomainEClassFromDataProperty(dataProperty);
			EDataType Range = getDatatype(dataProperty);
			eAttribute.setEType(Range);
			domain.getEStructuralFeatures().add(eAttribute);
			dataPropertyMap.put(dataProperty.getIri(), eAttribute);
		}
	}

	private EClass getDomainEClassFromDataProperty(DataProperty dataProperty) {
		if (dataProperty.getDomain().size() < 1) {
			throw new OntomoreTransformationException("Each DataProperty needs a domain");
		}
		Disjunction disj = (Disjunction) dataProperty.getDomain().get(0);
		Conjunction conj = (Conjunction) disj.getConjunctions().get(0);
		Primary primary = (Primary) conj.getPrimaries().get(0);
		Class owlClass = null;
		if (primary instanceof ClassAtomic) {
			ClassAtomic classAtomic = (ClassAtomic) primary;
			owlClass = classAtomic.getClazz();
		}
		return (EClass) ePackage.getClassifier(owlClass.getIri());
	}

	private EDataType getDatatype(DataProperty dataProperty) {
		EDataType ecoreDatatype = EcorePackage.Literals.EINT;
		if (dataProperty.getRange().size() < 1) {
			throw new OntomoreTransformationException("Each DataProperty needs a datatype");
		}
		DataRange dataRange = (DataRange) dataProperty.getRange().get(0);
		DataConjunction dataConjunction = (DataConjunction) dataRange.getDataConjunctions().get(0);
		DatatypeReference datatypeReference = (DatatypeReference) dataConjunction
				.getDataPrimaries().get(0);
		Datatype datatype = datatypeReference.getTheDatatype();
		if (datatype.getIri() != null) {
			if (getUserDefinedDataType(datatype.getIri()) != null) {
				ecoreDatatype = getUserDefinedDataType(datatype.getIri());
			} else if (datatype.getIri().equals("string")) {
				ecoreDatatype = EcorePackage.Literals.ESTRING;
			} else if (datatype.getIri().equals("boolean")) {
				ecoreDatatype = EcorePackage.Literals.EBOOLEAN;
			} else if (datatype.getIri().equals("float")) {
				ecoreDatatype = EcorePackage.Literals.EFLOAT;
			}
		}
		return ecoreDatatype;
	}

	private EDataType getUserDefinedDataType(String owlDatatypeIri) {
		EDataType userDefinedDataType = null;
		for (Datatype owlDatatype : owlDatatypes) {
			if (owlDatatype.getIri().equals(owlDatatypeIri)) {
				userDefinedDataType = (EDataType) ePackage.getClassifier(owlDatatypeIri);
			}
		}
		return userDefinedDataType;
	}

	/**
	 * Returns the metamodel that was generated from the ontology.
	 * 
	 * @return The root element of the metamodel.
	 * @throws IllegalStateException
	 *             if called before the meta model was generated with
	 *             <code>transformOWL2Ecore()</code>.
	 */
	public EObject getMetaModel() {
		if (ePackage.getInternalElement() == null) {
			throw new IllegalStateException();
		}
		return ePackage.getInternalElement();
	}

	/**
	 * Returns the model that was generated along to the metamodel. It might
	 * return null in the case that there was no model to be generated.
	 * 
	 * @return The root element of the model.
	 */
	public EObject getModel() {
		return new OWL2EcoreModelTransformer(this).getModel();
	}

	public List<Individual> getOwlIndividuals() {
		return owlIndividuals;
	}

	public EClass getEClassByName(String className) {
		return (EClass) ePackage.getClassifier(className);
	}

	public EFactory getModelFactory() {
		return ePackage.getFactory();
	}

	public Map<String, EReference> getPropertyMap() {
		return objectPropertyMap;
	}

	public Map<String, EAttribute> getDataPropertyMap() {
		return dataPropertyMap;
	}

}
