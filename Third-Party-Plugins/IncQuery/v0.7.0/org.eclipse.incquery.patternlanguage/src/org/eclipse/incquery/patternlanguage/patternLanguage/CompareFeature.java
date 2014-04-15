/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Compare Feature</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getCompareFeature()
 * @model
 * @generated
 */
public enum CompareFeature implements Enumerator
{
  /**
	 * The '<em><b>Equality</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #EQUALITY_VALUE
	 * @generated
	 * @ordered
	 */
  EQUALITY(0, "equality", "=="),

  /**
	 * The '<em><b>Inequality</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #INEQUALITY_VALUE
	 * @generated
	 * @ordered
	 */
  INEQUALITY(1, "inequality", "!=");

  /**
	 * The '<em><b>Equality</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Equality</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #EQUALITY
	 * @model name="equality" literal="=="
	 * @generated
	 * @ordered
	 */
  public static final int EQUALITY_VALUE = 0;

  /**
	 * The '<em><b>Inequality</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Inequality</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #INEQUALITY
	 * @model name="inequality" literal="!="
	 * @generated
	 * @ordered
	 */
  public static final int INEQUALITY_VALUE = 1;

  /**
	 * An array of all the '<em><b>Compare Feature</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final CompareFeature[] VALUES_ARRAY =
    new CompareFeature[] {
			EQUALITY,
			INEQUALITY,
		};

  /**
	 * A public read-only list of all the '<em><b>Compare Feature</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<CompareFeature> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Compare Feature</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static CompareFeature get(String literal)
  {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompareFeature result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Compare Feature</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static CompareFeature getByName(String name)
  {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompareFeature result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Compare Feature</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static CompareFeature get(int value)
  {
		switch (value) {
			case EQUALITY_VALUE: return EQUALITY;
			case INEQUALITY_VALUE: return INEQUALITY;
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
  private CompareFeature(int value, String name, String literal)
  {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getValue()
  {
	  return value;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getName()
  {
	  return name;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getLiteral()
  {
	  return literal;
	}

  /**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString()
  {
		return literal;
	}
  
} //CompareFeature
