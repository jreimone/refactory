/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.itu.sdg.language.xwpf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Paragraph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getRuns <em>Runs</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getPart <em>Part</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getBody <em>Body</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getAlignment <em>Alignment</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderBottom <em>Border Bottom</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderTop <em>Border Top</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderBetween <em>Border Between</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderLeft <em>Border Left</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderRight <em>Border Right</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getVerticalAlignment <em>Vertical Alignment</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getFootnoteText <em>Footnote Text</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getIndentFstLine <em>Indent Fst Line</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getIndentHanging <em>Indent Hanging</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getIndentLeft <em>Indent Left</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getIndentRight <em>Indent Right</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingAfter <em>Spacing After</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingAfterLines <em>Spacing After Lines</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingBefore <em>Spacing Before</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingBeforeLines <em>Spacing Before Lines</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingLineRule <em>Spacing Line Rule</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Paragraph#getStyle <em>Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph()
 * @model
 * @generated
 */
public interface Paragraph extends Content {
	/**
	 * Returns the value of the '<em><b>Runs</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.sdg.language.xwpf.Run}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runs</em>' containment reference list.
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_Runs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Run> getRuns();

	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference.
	 * @see #setPart(Part)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_Part()
	 * @model containment="true"
	 * @generated
	 */
	Part getPart();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getPart <em>Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part</em>' containment reference.
	 * @see #getPart()
	 * @generated
	 */
	void setPart(Part value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Body)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_Body()
	 * @model containment="true"
	 * @generated
	 */
	Body getBody();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Body value);

	/**
	 * Returns the value of the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alignment</em>' attribute.
	 * @see #setAlignment(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_Alignment()
	 * @model
	 * @generated
	 */
	int getAlignment();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getAlignment <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alignment</em>' attribute.
	 * @see #getAlignment()
	 * @generated
	 */
	void setAlignment(int value);

	/**
	 * Returns the value of the '<em><b>Border Bottom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Bottom</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Border Bottom</em>' attribute.
	 * @see #setBorderBottom(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_BorderBottom()
	 * @model
	 * @generated
	 */
	int getBorderBottom();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderBottom <em>Border Bottom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Bottom</em>' attribute.
	 * @see #getBorderBottom()
	 * @generated
	 */
	void setBorderBottom(int value);

	/**
	 * Returns the value of the '<em><b>Border Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Top</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Border Top</em>' attribute.
	 * @see #setBorderTop(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_BorderTop()
	 * @model
	 * @generated
	 */
	int getBorderTop();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderTop <em>Border Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Top</em>' attribute.
	 * @see #getBorderTop()
	 * @generated
	 */
	void setBorderTop(int value);

	/**
	 * Returns the value of the '<em><b>Border Between</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Between</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Border Between</em>' attribute.
	 * @see #setBorderBetween(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_BorderBetween()
	 * @model
	 * @generated
	 */
	int getBorderBetween();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderBetween <em>Border Between</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Between</em>' attribute.
	 * @see #getBorderBetween()
	 * @generated
	 */
	void setBorderBetween(int value);

	/**
	 * Returns the value of the '<em><b>Border Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Left</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Border Left</em>' attribute.
	 * @see #setBorderLeft(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_BorderLeft()
	 * @model
	 * @generated
	 */
	int getBorderLeft();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderLeft <em>Border Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Left</em>' attribute.
	 * @see #getBorderLeft()
	 * @generated
	 */
	void setBorderLeft(int value);

	/**
	 * Returns the value of the '<em><b>Border Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Right</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Border Right</em>' attribute.
	 * @see #setBorderRight(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_BorderRight()
	 * @model
	 * @generated
	 */
	int getBorderRight();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderRight <em>Border Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Right</em>' attribute.
	 * @see #getBorderRight()
	 * @generated
	 */
	void setBorderRight(int value);

	/**
	 * Returns the value of the '<em><b>Vertical Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertical Alignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertical Alignment</em>' attribute.
	 * @see #setVerticalAlignment(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_VerticalAlignment()
	 * @model
	 * @generated
	 */
	int getVerticalAlignment();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getVerticalAlignment <em>Vertical Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertical Alignment</em>' attribute.
	 * @see #getVerticalAlignment()
	 * @generated
	 */
	void setVerticalAlignment(int value);

	/**
	 * Returns the value of the '<em><b>Footnote Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Footnote Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Footnote Text</em>' attribute.
	 * @see #setFootnoteText(String)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_FootnoteText()
	 * @model
	 * @generated
	 */
	String getFootnoteText();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getFootnoteText <em>Footnote Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Footnote Text</em>' attribute.
	 * @see #getFootnoteText()
	 * @generated
	 */
	void setFootnoteText(String value);

	/**
	 * Returns the value of the '<em><b>Indent Fst Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indent Fst Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indent Fst Line</em>' attribute.
	 * @see #setIndentFstLine(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_IndentFstLine()
	 * @model
	 * @generated
	 */
	int getIndentFstLine();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getIndentFstLine <em>Indent Fst Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indent Fst Line</em>' attribute.
	 * @see #getIndentFstLine()
	 * @generated
	 */
	void setIndentFstLine(int value);

	/**
	 * Returns the value of the '<em><b>Indent Hanging</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indent Hanging</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indent Hanging</em>' attribute.
	 * @see #setIndentHanging(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_IndentHanging()
	 * @model
	 * @generated
	 */
	int getIndentHanging();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getIndentHanging <em>Indent Hanging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indent Hanging</em>' attribute.
	 * @see #getIndentHanging()
	 * @generated
	 */
	void setIndentHanging(int value);

	/**
	 * Returns the value of the '<em><b>Indent Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indent Left</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indent Left</em>' attribute.
	 * @see #setIndentLeft(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_IndentLeft()
	 * @model
	 * @generated
	 */
	int getIndentLeft();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getIndentLeft <em>Indent Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indent Left</em>' attribute.
	 * @see #getIndentLeft()
	 * @generated
	 */
	void setIndentLeft(int value);

	/**
	 * Returns the value of the '<em><b>Indent Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indent Right</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indent Right</em>' attribute.
	 * @see #setIndentRight(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_IndentRight()
	 * @model
	 * @generated
	 */
	int getIndentRight();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getIndentRight <em>Indent Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indent Right</em>' attribute.
	 * @see #getIndentRight()
	 * @generated
	 */
	void setIndentRight(int value);

	/**
	 * Returns the value of the '<em><b>Spacing After</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spacing After</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spacing After</em>' attribute.
	 * @see #setSpacingAfter(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_SpacingAfter()
	 * @model
	 * @generated
	 */
	int getSpacingAfter();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingAfter <em>Spacing After</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spacing After</em>' attribute.
	 * @see #getSpacingAfter()
	 * @generated
	 */
	void setSpacingAfter(int value);

	/**
	 * Returns the value of the '<em><b>Spacing After Lines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spacing After Lines</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spacing After Lines</em>' attribute.
	 * @see #setSpacingAfterLines(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_SpacingAfterLines()
	 * @model
	 * @generated
	 */
	int getSpacingAfterLines();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingAfterLines <em>Spacing After Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spacing After Lines</em>' attribute.
	 * @see #getSpacingAfterLines()
	 * @generated
	 */
	void setSpacingAfterLines(int value);

	/**
	 * Returns the value of the '<em><b>Spacing Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spacing Before</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spacing Before</em>' attribute.
	 * @see #setSpacingBefore(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_SpacingBefore()
	 * @model
	 * @generated
	 */
	int getSpacingBefore();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingBefore <em>Spacing Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spacing Before</em>' attribute.
	 * @see #getSpacingBefore()
	 * @generated
	 */
	void setSpacingBefore(int value);

	/**
	 * Returns the value of the '<em><b>Spacing Before Lines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spacing Before Lines</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spacing Before Lines</em>' attribute.
	 * @see #setSpacingBeforeLines(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_SpacingBeforeLines()
	 * @model
	 * @generated
	 */
	int getSpacingBeforeLines();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingBeforeLines <em>Spacing Before Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spacing Before Lines</em>' attribute.
	 * @see #getSpacingBeforeLines()
	 * @generated
	 */
	void setSpacingBeforeLines(int value);

	/**
	 * Returns the value of the '<em><b>Spacing Line Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spacing Line Rule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spacing Line Rule</em>' attribute.
	 * @see #setSpacingLineRule(int)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_SpacingLineRule()
	 * @model
	 * @generated
	 */
	int getSpacingLineRule();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingLineRule <em>Spacing Line Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spacing Line Rule</em>' attribute.
	 * @see #getSpacingLineRule()
	 * @generated
	 */
	void setSpacingLineRule(int value);

	/**
	 * Returns the value of the '<em><b>Style</b></em>' attribute.
	 * The literals are from the enumeration {@link dk.itu.sdg.language.xwpf.Style}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' attribute.
	 * @see dk.itu.sdg.language.xwpf.Style
	 * @see #setStyle(Style)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getParagraph_Style()
	 * @model transient="true"
	 * @generated
	 */
	Style getStyle();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Paragraph#getStyle <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' attribute.
	 * @see dk.itu.sdg.language.xwpf.Style
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(Style value);

} // Paragraph
