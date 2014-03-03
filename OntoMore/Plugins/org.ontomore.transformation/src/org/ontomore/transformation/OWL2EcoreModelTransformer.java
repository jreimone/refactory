package org.ontomore.transformation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.owl.AbbreviatedRDFTextLiteral;
import org.emftext.language.owl.AbbreviatedXSDStringLiteral;
import org.emftext.language.owl.BooleanLiteral;
import org.emftext.language.owl.Class;
import org.emftext.language.owl.ClassAtomic;
import org.emftext.language.owl.Conjunction;
import org.emftext.language.owl.DataProperty;
import org.emftext.language.owl.DataPropertyFact;
import org.emftext.language.owl.DecimalLiteral;
import org.emftext.language.owl.Disjunction;
import org.emftext.language.owl.Fact;
import org.emftext.language.owl.FloatingPointLiteral;
import org.emftext.language.owl.Individual;
import org.emftext.language.owl.IntegerLiteral;
import org.emftext.language.owl.Literal;
import org.emftext.language.owl.ObjectProperty;
import org.emftext.language.owl.ObjectPropertyFact;
import org.emftext.language.owl.Primary;
import org.ontomore.transformation.exception.OntomoreTransformationException;

/**
 * Transforms the individuals of an OWL-Model in an Ecore-Model. The OWL-Model
 * must be an "transformable ontology".
 * 
 * @author Erik Tittel
 * 
 */
public class OWL2EcoreModelTransformer {

	private static final String ROOTELEMENT_ANNOTATION = "rootelement";
	
	private OWL2EcoreMetaModelTransformer metaModelTransformer;
	private EFactory modelFactory;
	// Individuals are handled by their IRI because the
	// objects itself aren't unique
	private Map<String, EObject> individualEObjectMap;
	private int individualCount;

	/**
	 * Model transformer should be initialised only after(!) the meta model has
	 * been generated.
	 */
	public OWL2EcoreModelTransformer(OWL2EcoreMetaModelTransformer metaModelTransformer) {
		this.metaModelTransformer = metaModelTransformer;
		this.modelFactory = metaModelTransformer.getModelFactory();
	}

	/**
	 * Transforms the Individuals to EObject, DataPropertyFacts to attribute
	 * values and ObjectPropertyFacts to references.
	 * 
	 * @return The root element of the transformed EObject graph.
	 */
	public EObject getModel() {
		individualCount = 0;
		if (thereAreIndividuals()) {
			return transformIndividuals();
		} else {
			return null;
		}
	}

	private boolean thereAreIndividuals() {
		return metaModelTransformer.getOwlIndividuals().size() > 0;
	}

	private EObject transformIndividuals() {
		individualEObjectMap = new HashMap<String, EObject>();
		transformAllIndividuals();
		System.out.println("Transformed " + individualCount + " Individuals to EObjects");
		return getRootElement();
	}

	private EObject getRootElement() {
		Individual rootIndividual = null;
		for (Individual individual : metaModelTransformer.getOwlIndividuals()) {
			if (metaModelTransformer.getAnnotationValue(individual, ROOTELEMENT_ANNOTATION).equals("true")) {
				rootIndividual = individual;
				break;
			}
		}
		if (rootIndividual == null) {
			throw new OntomoreTransformationException("There is no individual defined to be the root element");
		}
		return getEObjectFromMap(rootIndividual);
	}

	private EObject getEObjectFromMap(Individual individual) {
		EObject eObject = individualEObjectMap.get(individual.getIri());
		if (eObject == null) {
			throw new OntomoreTransformationException("Individual " + individual.getIri()
					+ " was not yet transformed.");
		}
		return eObject;
	}

	private void transformAllIndividuals() {
		createEObjectsAndAttributesFromIndividuals();
		transformObjectPropertiesToReferences();
	}

	private void createEObjectsAndAttributesFromIndividuals() {
		for (Individual individual : metaModelTransformer.getOwlIndividuals()) {
			EObject eObject = createEcoreObjectForIndividualAndPutInMap(individual);
			transformDataPropertyToAttributeValues(eObject, individual);
		}
	}

	private EObject createEcoreObjectForIndividualAndPutInMap(Individual individual) {
		EObject eObject = null;
		if (individual.getTypes().size() == 1) {
			Disjunction disj = (Disjunction) individual.getTypes().get(0);
			Conjunction conj = (Conjunction) disj.getConjunctions().get(0);
			Primary primary = (Primary) conj.getPrimaries().get(0);
			if (primary instanceof ClassAtomic) {
				ClassAtomic classAtomic = (ClassAtomic) primary;
				Class owlClass = classAtomic.getClazz();
				EClass ecoreClass = metaModelTransformer.getEClassByName(owlClass.getIri());
				eObject = modelFactory.create(ecoreClass);
			}
		}
		if (eObject == null) {
			throw new OntomoreTransformationException("Individual " + individual.getIri()
					+ " could not be transformed to instance of Ecore class.");
		}
		individualEObjectMap.put(individual.getIri(), eObject);
		individualCount++;
		return eObject;
	}

	private void transformDataPropertyToAttributeValues(EObject rootEObject,
			Individual rootIndividual) {
		List<Entry<DataProperty, Object>> dataPropertyValueEntryList = getDataPropertyValueEntryList(rootIndividual);
		for (Entry<DataProperty, Object> dataPropertyValueEntry : dataPropertyValueEntryList) {
			EAttribute attribute = getAttributeFromDataProperty(dataPropertyValueEntry.key);
			Object value = dataPropertyValueEntry.value;
			rootEObject.eSet(attribute, value);
		}
	}

	private List<Entry<DataProperty, Object>> getDataPropertyValueEntryList(
			Individual rootIndividual) {
		List<Entry<DataProperty, Object>> dataPropertyValueEntryList = new ArrayList<Entry<DataProperty, Object>>();
		EList<Fact> facts = rootIndividual.getFacts();
		for (Fact fact : facts) {
			if (fact instanceof DataPropertyFact) {
				DataPropertyFact dataPropertyFact = (DataPropertyFact) fact;
				Entry<DataProperty, Object> entry = new Entry<DataProperty, Object>();
				entry.key = dataPropertyFact.getDataProperty();
				entry.value = getValueFromLiteral(dataPropertyFact.getLiteral());
				if (entry.value == null) {
					throw new OntomoreTransformationException("Value of DataProperty "
							+ dataPropertyFact.getDataProperty().getIri() + " in "
							+ rootIndividual.getIri() + " could not be determined.");
				}
				dataPropertyValueEntryList.add(entry);
			}
		}
		return dataPropertyValueEntryList;
	}

	private Object getValueFromLiteral(Literal literal) {
		Object result = null;
		if (literal instanceof AbbreviatedXSDStringLiteral) {
			AbbreviatedXSDStringLiteral stringLiteral = (AbbreviatedXSDStringLiteral) literal;
			result = stringLiteral.getValue();
		} else if (literal instanceof AbbreviatedRDFTextLiteral) {
			AbbreviatedRDFTextLiteral textLiteral = (AbbreviatedRDFTextLiteral) literal;
			result = textLiteral.getValue();
		} else if (literal instanceof IntegerLiteral) {
			IntegerLiteral integerLiteral = (IntegerLiteral) literal;
			result = integerLiteral.getValue();
		} else if (literal instanceof DecimalLiteral) {
			DecimalLiteral decimalLiteral = (DecimalLiteral) literal;
			result = decimalLiteral.getValue();
		} else if (literal instanceof FloatingPointLiteral) {
			FloatingPointLiteral floatLiteral = (FloatingPointLiteral) literal;
			result = floatLiteral.getLiteral();
		} else if (literal instanceof BooleanLiteral) {
			BooleanLiteral booleanLiteral = (BooleanLiteral) literal;
			result = booleanLiteral.isValue();
		}
		checkForAllowedClass(result);
		return result;
	}

	private void checkForAllowedClass(Object object) {
		if (!(object instanceof String || object instanceof Float || object instanceof Integer || object instanceof BigDecimal || object instanceof Boolean)) {
			throw new OntomoreTransformationException(
					"Value of DataPropertyFact is not of one of the allowed classes: " + object);
		}
	}

	private EAttribute getAttributeFromDataProperty(DataProperty dataProperty) {
		String propertyIri = dataProperty.getIri();
		return metaModelTransformer.getDataPropertyMap().get(propertyIri);
	}

	private void transformObjectPropertiesToReferences() {
		for (Individual individual : metaModelTransformer.getOwlIndividuals()) {
			EObject rootEObject = getEObjectFromMap(individual);
			transformContainedElementsToReferences(rootEObject, individual);
		}
	}

	private void transformContainedElementsToReferences(EObject rootEObject,
			Individual rootIndividual) {
		List<Entry<ObjectProperty, Individual>> objectPropertyIndividualEntryList = getObjectPropertyIndividualEntryList(rootIndividual);
		for (Entry<ObjectProperty, Individual> entry : objectPropertyIndividualEntryList) {
			ObjectProperty objectProperty = entry.key;
			Individual individual = entry.value;
			EStructuralFeature feature = getFeatureFromProperty(objectProperty);
			EObject eObject = getEObjectFromMap(individual);
			Object featureValue = rootEObject.eGet(feature);
			if (featureValue instanceof List<?>) {
				@SuppressWarnings("unchecked")
				List<EObject> featureList = (List<EObject>) featureValue;
				featureList.add(eObject);
			} else {
				rootEObject.eSet(feature, eObject);
			}
		}
	}

	private List<Entry<ObjectProperty, Individual>> getObjectPropertyIndividualEntryList(
			Individual rootIndividual) {
		List<Entry<ObjectProperty, Individual>> objectPropertyIndividualEntryList = new ArrayList<Entry<ObjectProperty, Individual>>();
		EList<Fact> facts = rootIndividual.getFacts();
		for (Fact fact : facts) {
			if (fact instanceof ObjectPropertyFact) {
				ObjectPropertyFact objectPropertyFact = (ObjectPropertyFact) fact;
				Entry<ObjectProperty, Individual> entry = new Entry<ObjectProperty, Individual>();
				entry.key = (ObjectProperty) objectPropertyFact.getObjectProperty();
				entry.value = (Individual) objectPropertyFact.getIndividual();
				if (entry.key == null || entry.key.getIri() == null || entry.value == null || entry.value.getIri() == null) {
					throw new OntomoreTransformationException(
							"In the Individual "
									+ rootIndividual.getIri()
									+ " an ObjectPropertyFact or its target Individual could not be transformed.");
				}
				objectPropertyIndividualEntryList.add(entry);
			}
		}
		return objectPropertyIndividualEntryList;
	}

	private EStructuralFeature getFeatureFromProperty(ObjectProperty objectProperty) {
		String propertyIri = objectProperty.getIri();
		return metaModelTransformer.getPropertyMap().get(propertyIri);
	}

	private class Entry<K, V> {
		private K key;
		private V value;
	}

}
