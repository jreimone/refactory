/**
 */
package org.qualitune.tracing.vapoditrace;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Trace Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getTraceType()
 * @model
 * @generated
 */
public enum TraceType implements Enumerator {
	/**
	 * The '<em><b>OMITTED TRACETYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OMITTED_TRACETYPE_VALUE
	 * @generated
	 * @ordered
	 */
	OMITTED_TRACETYPE(5, "OMITTED_TRACETYPE", "OMITTED_TRACETYPE"),

	/**
	 * The '<em><b>CREATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_VALUE
	 * @generated
	 * @ordered
	 */
	CREATE(0, "CREATE", "CREATE"),

	/**
	 * The '<em><b>READ</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #READ_VALUE
	 * @generated
	 * @ordered
	 */
	READ(1, "READ", "READ"),

	/**
	 * The '<em><b>UPDATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATE_VALUE
	 * @generated
	 * @ordered
	 */
	UPDATE(2, "UPDATE", "UPDATE"),

	/**
	 * The '<em><b>DELETE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE(3, "DELETE", "DELETE"),

	/**
	 * The '<em><b>WRITE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WRITE_VALUE
	 * @generated
	 * @ordered
	 */
	WRITE(4, "WRITE", "WRITE"),

	/**
	 * The '<em><b>EXISTENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXISTENCE_VALUE
	 * @generated
	 * @ordered
	 */
	EXISTENCE(6, "EXISTENCE", "EXISTENCE");

	/**
	 * The '<em><b>OMITTED TRACETYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OMITTED TRACETYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OMITTED_TRACETYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OMITTED_TRACETYPE_VALUE = 5;

	/**
	 * The '<em><b>CREATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CREATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CREATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CREATE_VALUE = 0;

	/**
	 * The '<em><b>READ</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>READ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #READ
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int READ_VALUE = 1;

	/**
	 * The '<em><b>UPDATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UPDATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UPDATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UPDATE_VALUE = 2;

	/**
	 * The '<em><b>DELETE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DELETE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DELETE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_VALUE = 3;

	/**
	 * The '<em><b>WRITE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WRITE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WRITE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WRITE_VALUE = 4;

	/**
	 * The '<em><b>EXISTENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXISTENCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXISTENCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXISTENCE_VALUE = 6;

	/**
	 * An array of all the '<em><b>Trace Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TraceType[] VALUES_ARRAY =
		new TraceType[] {
			OMITTED_TRACETYPE,
			CREATE,
			READ,
			UPDATE,
			DELETE,
			WRITE,
			EXISTENCE,
		};

	/**
	 * A public read-only list of all the '<em><b>Trace Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TraceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Trace Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TraceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TraceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Trace Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TraceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TraceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Trace Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TraceType get(int value) {
		switch (value) {
			case OMITTED_TRACETYPE_VALUE: return OMITTED_TRACETYPE;
			case CREATE_VALUE: return CREATE;
			case READ_VALUE: return READ;
			case UPDATE_VALUE: return UPDATE;
			case DELETE_VALUE: return DELETE;
			case WRITE_VALUE: return WRITE;
			case EXISTENCE_VALUE: return EXISTENCE;
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
	private TraceType(int value, String name, String literal) {
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
	
} //TraceType
