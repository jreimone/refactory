/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.itu.sdg.language.xwpf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Run</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dk.itu.sdg.language.xwpf.Run#getFontFamily <em>Font Family</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Run#getFontSize <em>Font Size</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Run#isIsBold <em>Is Bold</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Run#isIsItalic <em>Is Italic</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Run#isIsStrike <em>Is Strike</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Run#getColor <em>Color</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Run#getTextPosition <em>Text Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getRun()
 * @model
 * @generated
 */
public interface Run extends Content {
	/**
	 * Returns the value of the '<em><b>Font Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Family</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Family</em>' attribute.
	 * @see #setFontFamily(String)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getRun_FontFamily()
	 * @model
	 * @generated
	 */
	String getFontFamily();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Run#getFontFamily <em>Font Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Family</em>' attribute.
	 * @see #getFontFamily()
	 * @generated
	 */
	void setFontFamily(String value);

	/**
	 * Returns the value of the '<em><b>Font Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Size</em>' attribute.
	 * @see #setFontSize(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getRun_FontSize()
	 * @model
	 * @generated
	 */
	int getFontSize();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Run#getFontSize <em>Font Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Size</em>' attribute.
	 * @see #getFontSize()
	 * @generated
	 */
	void setFontSize(int value);

	/**
	 * Returns the value of the '<em><b>Is Bold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Bold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Bold</em>' attribute.
	 * @see #setIsBold(boolean)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getRun_IsBold()
	 * @model
	 * @generated
	 */
	boolean isIsBold();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Run#isIsBold <em>Is Bold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Bold</em>' attribute.
	 * @see #isIsBold()
	 * @generated
	 */
	void setIsBold(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Italic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Italic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Italic</em>' attribute.
	 * @see #setIsItalic(boolean)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getRun_IsItalic()
	 * @model
	 * @generated
	 */
	boolean isIsItalic();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Run#isIsItalic <em>Is Italic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Italic</em>' attribute.
	 * @see #isIsItalic()
	 * @generated
	 */
	void setIsItalic(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Strike</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Strike</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Strike</em>' attribute.
	 * @see #setIsStrike(boolean)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getRun_IsStrike()
	 * @model
	 * @generated
	 */
	boolean isIsStrike();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Run#isIsStrike <em>Is Strike</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Strike</em>' attribute.
	 * @see #isIsStrike()
	 * @generated
	 */
	void setIsStrike(boolean value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see #setColor(String)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getRun_Color()
	 * @model
	 * @generated
	 */
	String getColor();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Run#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(String value);

	/**
	 * Returns the value of the '<em><b>Text Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Position</em>' attribute.
	 * @see #setTextPosition(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getRun_TextPosition()
	 * @model
	 * @generated
	 */
	int getTextPosition();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Run#getTextPosition <em>Text Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Position</em>' attribute.
	 * @see #getTextPosition()
	 * @generated
	 */
	void setTextPosition(int value);

} // Run
