/**
 */
package org.modelrefactoring.guery.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.modelrefactoring.guery.*;
import org.modelrefactoring.guery.custom.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GueryFactoryImpl extends EFactoryImpl implements GueryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GueryFactory init() {
		try {
			GueryFactory theGueryFactory = (GueryFactory)EPackage.Registry.INSTANCE.getEFactory(GueryPackage.eNS_URI);
			if (theGueryFactory != null) {
				return theGueryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GueryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GueryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GueryPackage.MOTIF_MODEL: return createMotifModel();
			case GueryPackage.MOTIF: return createMotif();
			case GueryPackage.ROLE: return createRole();
			case GueryPackage.CONSTRAINT: return createConstraint();
			case GueryPackage.VERTEX_SELECTION: return createVertexSelection();
			case GueryPackage.CONNECTED_BY: return createConnectedBy();
			case GueryPackage.CONNECTION: return createConnection();
			case GueryPackage.NOT_CONNECTED_BY: return createNotConnectedBy();
			case GueryPackage.GROUPING: return createGrouping();
			case GueryPackage.PRE_PROCESSOR: return createPreProcessor();
			case GueryPackage.STRING_TO_EOBJECT_MAP: return (EObject) createStringToEObjectMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MotifModel createMotifModel() {
		MotifModelImpl motifModel = new MotifModelImpl();
		return motifModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Motif createMotif() {
		MotifImpl motif = new MotifCustom();
		return motif;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role createRole() {
		RoleImpl role = new RoleImpl();
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createConstraint() {
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VertexSelection createVertexSelection() {
		VertexSelectionImpl vertexSelection = new VertexSelectionImpl();
		return vertexSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectedBy createConnectedBy() {
		ConnectedByImpl connectedBy = new ConnectedByImpl();
		return connectedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection createConnection() {
		ConnectionImpl connection = new ConnectionImpl();
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotConnectedBy createNotConnectedBy() {
		NotConnectedByImpl notConnectedBy = new NotConnectedByImpl();
		return notConnectedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Grouping createGrouping() {
		GroupingImpl grouping = new GroupingImpl();
		return grouping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreProcessor createPreProcessor() {
		PreProcessorImpl preProcessor = new PreProcessorCustom();
		return preProcessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String,EObject> createStringToEObjectMap() {
		StringToEObjectMapImpl stringToEObjectMap = new StringToEObjectMapImpl();
		return stringToEObjectMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GueryPackage getGueryPackage() {
		return (GueryPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GueryPackage getPackage() {
		return GueryPackage.eINSTANCE;
	}

} //GueryFactoryImpl
