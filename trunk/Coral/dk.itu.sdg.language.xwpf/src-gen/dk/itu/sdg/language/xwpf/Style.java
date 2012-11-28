/**
 * Copyright 2012 
 * Rolf-Helge Pfeiffer (IT University Copenhagen)
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.itu.sdg.language.xwpf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Style</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getStyle()
 * @model
 * @generated
 */
public enum Style implements Enumerator {
	/**
	 * The '<em><b>Unrecognized</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNRECOGNIZED_VALUE
	 * @generated
	 * @ordered
	 */
	UNRECOGNIZED(0, "unrecognized", "unrecognized"),

	/**
	 * The '<em><b>Heading1</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEADING1_VALUE
	 * @generated
	 * @ordered
	 */
	HEADING1(1, "heading1", "Heading1"),

	/**
	 * The '<em><b>Heading2</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEADING2_VALUE
	 * @generated
	 * @ordered
	 */
	HEADING2(2, "heading2", "Heading2"),

	/**
	 * The '<em><b>Heading3</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEADING3_VALUE
	 * @generated
	 * @ordered
	 */
	HEADING3(3, "heading3", "Heading3"),

	/**
	 * The '<em><b>Heading4</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEADING4_VALUE
	 * @generated
	 * @ordered
	 */
	HEADING4(4, "heading4", "Heading4"),

	/**
	 * The '<em><b>Body Text</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BODY_TEXT_VALUE
	 * @generated
	 * @ordered
	 */
	BODY_TEXT(5, "bodyText", "BodyText"),

	/**
	 * The '<em><b>Body Text With List</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BODY_TEXT_WITH_LIST_VALUE
	 * @generated
	 * @ordered
	 */
	BODY_TEXT_WITH_LIST(6, "bodyTextWithList", "BodyTextwithList"),

	/**
	 * The '<em><b>List Paragraph</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIST_PARAGRAPH_VALUE
	 * @generated
	 * @ordered
	 */
	LIST_PARAGRAPH(7, "listParagraph", "ListParagraph"),

	/**
	 * The '<em><b>List Bullet1</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIST_BULLET1_VALUE
	 * @generated
	 * @ordered
	 */
	LIST_BULLET1(8, "listBullet1", "ListBullet1"),

	/**
	 * The '<em><b>List Bullet2</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIST_BULLET2_VALUE
	 * @generated
	 * @ordered
	 */
	LIST_BULLET2(9, "listBullet2", "ListBullet2"),

	/**
	 * The '<em><b>List Bullet3</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIST_BULLET3_VALUE
	 * @generated
	 * @ordered
	 */
	LIST_BULLET3(10, "listBullet3", "ListBullet3"),

	/**
	 * The '<em><b>Normal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NORMAL_VALUE
	 * @generated
	 * @ordered
	 */
	NORMAL(11, "normal", "null");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2012 \r\nRolf-Helge Pfeiffer (IT University Copenhagen)\r\nJan Reimann (TU Dresden, Software Technology Group)\r\nMirko Seifert (DevBoost GmbH)\r\n\r\nLicensed under the Apache License, Version 2.0 (the \"License\");\r\nyou may not use this file except in compliance with the License.\r\nYou may obtain a copy of the License at\r\n\r\n  http://www.apache.org/licenses/LICENSE-2.0\r\n\r\nUnless required by applicable law or agreed to in writing, software\r\ndistributed under the License is distributed on an \"AS IS\" BASIS,\r\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\r\nSee the License for the specific language governing permissions and\r\nlimitations under the License.";

	/**
	 * The '<em><b>Unrecognized</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unrecognized</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNRECOGNIZED
	 * @model name="unrecognized"
	 * @generated
	 * @ordered
	 */
	public static final int UNRECOGNIZED_VALUE = 0;

	/**
	 * The '<em><b>Heading1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Heading1</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEADING1
	 * @model name="heading1" literal="Heading1"
	 * @generated
	 * @ordered
	 */
	public static final int HEADING1_VALUE = 1;

	/**
	 * The '<em><b>Heading2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Heading2</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEADING2
	 * @model name="heading2" literal="Heading2"
	 * @generated
	 * @ordered
	 */
	public static final int HEADING2_VALUE = 2;

	/**
	 * The '<em><b>Heading3</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Heading3</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEADING3
	 * @model name="heading3" literal="Heading3"
	 * @generated
	 * @ordered
	 */
	public static final int HEADING3_VALUE = 3;

	/**
	 * The '<em><b>Heading4</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Heading4</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEADING4
	 * @model name="heading4" literal="Heading4"
	 * @generated
	 * @ordered
	 */
	public static final int HEADING4_VALUE = 4;

	/**
	 * The '<em><b>Body Text</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Body Text</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BODY_TEXT
	 * @model name="bodyText" literal="BodyText"
	 * @generated
	 * @ordered
	 */
	public static final int BODY_TEXT_VALUE = 5;

	/**
	 * The '<em><b>Body Text With List</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Body Text With List</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BODY_TEXT_WITH_LIST
	 * @model name="bodyTextWithList" literal="BodyTextwithList"
	 * @generated
	 * @ordered
	 */
	public static final int BODY_TEXT_WITH_LIST_VALUE = 6;

	/**
	 * The '<em><b>List Paragraph</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>List Paragraph</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIST_PARAGRAPH
	 * @model name="listParagraph" literal="ListParagraph"
	 * @generated
	 * @ordered
	 */
	public static final int LIST_PARAGRAPH_VALUE = 7;

	/**
	 * The '<em><b>List Bullet1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>List Bullet1</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIST_BULLET1
	 * @model name="listBullet1" literal="ListBullet1"
	 * @generated
	 * @ordered
	 */
	public static final int LIST_BULLET1_VALUE = 8;

	/**
	 * The '<em><b>List Bullet2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>List Bullet2</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIST_BULLET2
	 * @model name="listBullet2" literal="ListBullet2"
	 * @generated
	 * @ordered
	 */
	public static final int LIST_BULLET2_VALUE = 9;

	/**
	 * The '<em><b>List Bullet3</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>List Bullet3</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIST_BULLET3
	 * @model name="listBullet3" literal="ListBullet3"
	 * @generated
	 * @ordered
	 */
	public static final int LIST_BULLET3_VALUE = 10;

	/**
	 * The '<em><b>Normal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Normal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NORMAL
	 * @model name="normal" literal="null"
	 * @generated
	 * @ordered
	 */
	public static final int NORMAL_VALUE = 11;

	/**
	 * An array of all the '<em><b>Style</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Style[] VALUES_ARRAY =
		new Style[] {
			UNRECOGNIZED,
			HEADING1,
			HEADING2,
			HEADING3,
			HEADING4,
			BODY_TEXT,
			BODY_TEXT_WITH_LIST,
			LIST_PARAGRAPH,
			LIST_BULLET1,
			LIST_BULLET2,
			LIST_BULLET3,
			NORMAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Style</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Style> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Style</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Style get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Style result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Style</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Style getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Style result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Style</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Style get(int value) {
		switch (value) {
			case UNRECOGNIZED_VALUE: return UNRECOGNIZED;
			case HEADING1_VALUE: return HEADING1;
			case HEADING2_VALUE: return HEADING2;
			case HEADING3_VALUE: return HEADING3;
			case HEADING4_VALUE: return HEADING4;
			case BODY_TEXT_VALUE: return BODY_TEXT;
			case BODY_TEXT_WITH_LIST_VALUE: return BODY_TEXT_WITH_LIST;
			case LIST_PARAGRAPH_VALUE: return LIST_PARAGRAPH;
			case LIST_BULLET1_VALUE: return LIST_BULLET1;
			case LIST_BULLET2_VALUE: return LIST_BULLET2;
			case LIST_BULLET3_VALUE: return LIST_BULLET3;
			case NORMAL_VALUE: return NORMAL;
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
	private Style(int value, String name, String literal) {
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
	
} //Style
