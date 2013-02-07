/**
 */
package org.qualitune.tracing.vapoditrace;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Concern Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getConcernType()
 * @model
 * @generated
 */
public enum ConcernType implements Enumerator {
	/**
	 * The '<em><b>OMITTED CONCERN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OMITTED_CONCERN_VALUE
	 * @generated
	 * @ordered
	 */
	OMITTED_CONCERN(3, "OMITTED_CONCERN", "OMITTED_CONCERN"),

	/**
	 * The '<em><b>OBJECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	OBJECT(0, "OBJECT", "OBJECT"),

	/**
	 * The '<em><b>ATTRIBUTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATTRIBUTE_VALUE
	 * @generated
	 * @ordered
	 */
	ATTRIBUTE(1, "ATTRIBUTE", "ATTRIBUTE"),

	/**
	 * The '<em><b>TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	TYPE(2, "TYPE", "TYPE");

	/**
	 * The '<em><b>OMITTED CONCERN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OMITTED CONCERN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OMITTED_CONCERN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OMITTED_CONCERN_VALUE = 3;

	/**
	 * The '<em><b>OBJECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OBJECT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OBJECT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_VALUE = 0;

	/**
	 * The '<em><b>ATTRIBUTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ATTRIBUTE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATTRIBUTE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ATTRIBUTE_VALUE = 1;

	/**
	 * The '<em><b>TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TYPE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Concern Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ConcernType[] VALUES_ARRAY =
		new ConcernType[] {
			OMITTED_CONCERN,
			OBJECT,
			ATTRIBUTE,
			TYPE,
		};

	/**
	 * A public read-only list of all the '<em><b>Concern Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ConcernType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Concern Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConcernType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConcernType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Concern Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConcernType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConcernType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Concern Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConcernType get(int value) {
		switch (value) {
			case OMITTED_CONCERN_VALUE: return OMITTED_CONCERN;
			case OBJECT_VALUE: return OBJECT;
			case ATTRIBUTE_VALUE: return ATTRIBUTE;
			case TYPE_VALUE: return TYPE;
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
	private ConcernType(int value, String name, String literal) {
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
	
} //ConcernType
