/**
 */
package org.emftext.refactoring.smell.calculation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Monotonicity</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * <b>increasing:</b> the higher the calculated
 * 	value, the better the quality satisfaction
 * </br></br>
 * <b>decreasing:</b> the lower the calculated
 * 	value, the better the quality satisfaction
 * <!-- end-model-doc -->
 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getMonotonicity()
 * @model
 * @generated
 */
public enum Monotonicity implements Enumerator {
	/**
	 * The '<em><b>INCREASING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INCREASING_VALUE
	 * @generated
	 * @ordered
	 */
	INCREASING(0, "INCREASING", "INCREASING"),

	/**
	 * The '<em><b>DECREASING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECREASING_VALUE
	 * @generated
	 * @ordered
	 */
	DECREASING(1, "DECREASING", "DECREASING");

	/**
	 * The '<em><b>INCREASING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INCREASING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INCREASING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INCREASING_VALUE = 0;

	/**
	 * The '<em><b>DECREASING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DECREASING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECREASING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DECREASING_VALUE = 1;

	/**
	 * An array of all the '<em><b>Monotonicity</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Monotonicity[] VALUES_ARRAY =
		new Monotonicity[] {
			INCREASING,
			DECREASING,
		};

	/**
	 * A public read-only list of all the '<em><b>Monotonicity</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Monotonicity> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Monotonicity</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Monotonicity get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Monotonicity result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Monotonicity</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Monotonicity getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Monotonicity result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Monotonicity</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Monotonicity get(int value) {
		switch (value) {
			case INCREASING_VALUE: return INCREASING;
			case DECREASING_VALUE: return DECREASING;
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
	private Monotonicity(int value, String name, String literal) {
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
	
} //Monotonicity
