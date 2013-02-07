/**
 */
package org.qualitune.tracing.vapoditrace;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Universe Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getUniverseType()
 * @model
 * @generated
 */
public enum UniverseType implements Enumerator {
	/**
	 * The '<em><b>OMITTED UNIVERSE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OMITTED_UNIVERSE_VALUE
	 * @generated
	 * @ordered
	 */
	OMITTED_UNIVERSE(0, "OMITTED_UNIVERSE", "OMITTED_UNIVERSE"),

	/**
	 * The '<em><b>LIGHT UNIVERSE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIGHT_UNIVERSE_VALUE
	 * @generated
	 * @ordered
	 */
	LIGHT_UNIVERSE(1, "LIGHT_UNIVERSE", "LIGHT_UNIVERSE"),

	/**
	 * The '<em><b>SHADOW UNIVERSE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHADOW_UNIVERSE_VALUE
	 * @generated
	 * @ordered
	 */
	SHADOW_UNIVERSE(2, "SHADOW_UNIVERSE", "SHADOW_UNIVERSE");

	/**
	 * The '<em><b>OMITTED UNIVERSE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OMITTED UNIVERSE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OMITTED_UNIVERSE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OMITTED_UNIVERSE_VALUE = 0;

	/**
	 * The '<em><b>LIGHT UNIVERSE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIGHT UNIVERSE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIGHT_UNIVERSE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LIGHT_UNIVERSE_VALUE = 1;

	/**
	 * The '<em><b>SHADOW UNIVERSE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHADOW UNIVERSE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHADOW_UNIVERSE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHADOW_UNIVERSE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Universe Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final UniverseType[] VALUES_ARRAY =
		new UniverseType[] {
			OMITTED_UNIVERSE,
			LIGHT_UNIVERSE,
			SHADOW_UNIVERSE,
		};

	/**
	 * A public read-only list of all the '<em><b>Universe Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<UniverseType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Universe Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UniverseType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UniverseType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Universe Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UniverseType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UniverseType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Universe Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UniverseType get(int value) {
		switch (value) {
			case OMITTED_UNIVERSE_VALUE: return OMITTED_UNIVERSE;
			case LIGHT_UNIVERSE_VALUE: return LIGHT_UNIVERSE;
			case SHADOW_UNIVERSE_VALUE: return SHADOW_UNIVERSE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private UniverseType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //UniverseType
