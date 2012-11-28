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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dk.itu.sdg.language.xwpf.Document#getBodyElements <em>Body Elements</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Document#getComments <em>Comments</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Document#getEndnotes <em>Endnotes</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Document#getFooters <em>Footers</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Document#getFootnotes <em>Footnotes</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Document#getHeaders <em>Headers</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Document#getHyperlinks <em>Hyperlinks</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Document#getNumbering <em>Numbering</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Document#getPackagePictures <em>Package Pictures</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Document#getParagraphs <em>Paragraphs</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Document#getPictures <em>Pictures</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Document#getStyles <em>Styles</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Document#getTables <em>Tables</em>}</li>
 * </ul>
 * </p>
 *
 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getDocument()
 * @model
 * @generated
 */
public interface Document extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2012 \r\nRolf-Helge Pfeiffer (IT University Copenhagen)\r\nJan Reimann (TU Dresden, Software Technology Group)\r\nMirko Seifert (DevBoost GmbH)\r\n\r\nLicensed under the Apache License, Version 2.0 (the \"License\");\r\nyou may not use this file except in compliance with the License.\r\nYou may obtain a copy of the License at\r\n\r\n  http://www.apache.org/licenses/LICENSE-2.0\r\n\r\nUnless required by applicable law or agreed to in writing, software\r\ndistributed under the License is distributed on an \"AS IS\" BASIS,\r\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\r\nSee the License for the specific language governing permissions and\r\nlimitations under the License.";

	/**
	 * Returns the value of the '<em><b>Body Elements</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.sdg.language.xwpf.BodyElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Elements</em>' containment reference list.
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getDocument_BodyElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<BodyElement> getBodyElements();

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.sdg.language.xwpf.Comment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' containment reference list.
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getDocument_Comments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Comment> getComments();

	/**
	 * Returns the value of the '<em><b>Endnotes</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.sdg.language.xwpf.Footnote}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endnotes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endnotes</em>' containment reference list.
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getDocument_Endnotes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Footnote> getEndnotes();

	/**
	 * Returns the value of the '<em><b>Footers</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.sdg.language.xwpf.Footer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Footers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Footers</em>' containment reference list.
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getDocument_Footers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Footer> getFooters();

	/**
	 * Returns the value of the '<em><b>Footnotes</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.sdg.language.xwpf.Footnote}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Footnotes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Footnotes</em>' containment reference list.
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getDocument_Footnotes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Footnote> getFootnotes();

	/**
	 * Returns the value of the '<em><b>Headers</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.sdg.language.xwpf.Header}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Headers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Headers</em>' containment reference list.
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getDocument_Headers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Header> getHeaders();

	/**
	 * Returns the value of the '<em><b>Hyperlinks</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.sdg.language.xwpf.Hyperlink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hyperlinks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hyperlinks</em>' containment reference list.
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getDocument_Hyperlinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Hyperlink> getHyperlinks();

	/**
	 * Returns the value of the '<em><b>Numbering</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.sdg.language.xwpf.Numbering}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numbering</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numbering</em>' containment reference list.
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getDocument_Numbering()
	 * @model containment="true"
	 * @generated
	 */
	EList<Numbering> getNumbering();

	/**
	 * Returns the value of the '<em><b>Package Pictures</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.sdg.language.xwpf.PictureData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Pictures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Pictures</em>' containment reference list.
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getDocument_PackagePictures()
	 * @model containment="true"
	 * @generated
	 */
	EList<PictureData> getPackagePictures();

	/**
	 * Returns the value of the '<em><b>Paragraphs</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.sdg.language.xwpf.Paragraph}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Paragraphs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paragraphs</em>' containment reference list.
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getDocument_Paragraphs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Paragraph> getParagraphs();

	/**
	 * Returns the value of the '<em><b>Pictures</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.sdg.language.xwpf.PictureData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pictures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pictures</em>' containment reference list.
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getDocument_Pictures()
	 * @model containment="true"
	 * @generated
	 */
	EList<PictureData> getPictures();

	/**
	 * Returns the value of the '<em><b>Styles</b></em>' attribute list.
	 * The list contents are of type {@link dk.itu.sdg.language.xwpf.Style}.
	 * The literals are from the enumeration {@link dk.itu.sdg.language.xwpf.Style}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Styles</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Styles</em>' attribute list.
	 * @see dk.itu.sdg.language.xwpf.Style
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getDocument_Styles()
	 * @model transient="true"
	 * @generated
	 */
	EList<Style> getStyles();

	/**
	 * Returns the value of the '<em><b>Tables</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.sdg.language.xwpf.Table}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tables</em>' containment reference list.
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getDocument_Tables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Table> getTables();

} // Document
