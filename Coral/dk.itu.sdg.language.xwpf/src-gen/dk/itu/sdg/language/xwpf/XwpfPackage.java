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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dk.itu.sdg.language.xwpf.XwpfFactory
 * @model kind="package"
 * @generated
 */
public interface XwpfPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2012 \r\nRolf-Helge Pfeiffer (IT University Copenhagen)\r\nJan Reimann (TU Dresden, Software Technology Group)\r\nMirko Seifert (DevBoost GmbH)\r\n\r\nLicensed under the Apache License, Version 2.0 (the \"License\");\r\nyou may not use this file except in compliance with the License.\r\nYou may obtain a copy of the License at\r\n\r\n  http://www.apache.org/licenses/LICENSE-2.0\r\n\r\nUnless required by applicable law or agreed to in writing, software\r\ndistributed under the License is distributed on an \"AS IS\" BASIS,\r\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\r\nSee the License for the specific language governing permissions and\r\nlimitations under the License.";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xwpf";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.itu.dk/sdg/language/xwpf";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xwpf";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XwpfPackage eINSTANCE = dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl.init();

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.ContentImpl <em>Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.ContentImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getContent()
	 * @generated
	 */
	int CONTENT = 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__TEXT = 0;

	/**
	 * The feature id for the '<em><b>Nlp Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__NLP_CONTENT = 1;

	/**
	 * The number of structural features of the '<em>Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl <em>Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.DocumentImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getDocument()
	 * @generated
	 */
	int DOCUMENT = 1;

	/**
	 * The feature id for the '<em><b>Body Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__BODY_ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__COMMENTS = 1;

	/**
	 * The feature id for the '<em><b>Endnotes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__ENDNOTES = 2;

	/**
	 * The feature id for the '<em><b>Footers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__FOOTERS = 3;

	/**
	 * The feature id for the '<em><b>Footnotes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__FOOTNOTES = 4;

	/**
	 * The feature id for the '<em><b>Headers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__HEADERS = 5;

	/**
	 * The feature id for the '<em><b>Hyperlinks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__HYPERLINKS = 6;

	/**
	 * The feature id for the '<em><b>Numbering</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__NUMBERING = 7;

	/**
	 * The feature id for the '<em><b>Package Pictures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__PACKAGE_PICTURES = 8;

	/**
	 * The feature id for the '<em><b>Paragraphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__PARAGRAPHS = 9;

	/**
	 * The feature id for the '<em><b>Pictures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__PICTURES = 10;

	/**
	 * The feature id for the '<em><b>Styles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__STYLES = 11;

	/**
	 * The feature id for the '<em><b>Tables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__TABLES = 12;

	/**
	 * The number of structural features of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_FEATURE_COUNT = 13;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.BodyElementImpl <em>Body Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.BodyElementImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getBodyElement()
	 * @generated
	 */
	int BODY_ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>Body Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BODY_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.CommentImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__TEXT = CONTENT__TEXT;

	/**
	 * The feature id for the '<em><b>Nlp Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__NLP_CONTENT = CONTENT__NLP_CONTENT;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__AUTHOR = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__IDENTIFIER = CONTENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.FootnoteImpl <em>Footnote</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.FootnoteImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getFootnote()
	 * @generated
	 */
	int FOOTNOTE = 4;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTNOTE__TEXT = CONTENT__TEXT;

	/**
	 * The feature id for the '<em><b>Nlp Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTNOTE__NLP_CONTENT = CONTENT__NLP_CONTENT;

	/**
	 * The number of structural features of the '<em>Footnote</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTNOTE_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.FooterImpl <em>Footer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.FooterImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getFooter()
	 * @generated
	 */
	int FOOTER = 5;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTER__TEXT = CONTENT__TEXT;

	/**
	 * The feature id for the '<em><b>Nlp Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTER__NLP_CONTENT = CONTENT__NLP_CONTENT;

	/**
	 * The number of structural features of the '<em>Footer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTER_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.HeaderImpl <em>Header</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.HeaderImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getHeader()
	 * @generated
	 */
	int HEADER = 6;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER__TEXT = CONTENT__TEXT;

	/**
	 * The feature id for the '<em><b>Nlp Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER__NLP_CONTENT = CONTENT__NLP_CONTENT;

	/**
	 * The number of structural features of the '<em>Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.HyperlinkImpl <em>Hyperlink</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.HyperlinkImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getHyperlink()
	 * @generated
	 */
	int HYPERLINK = 7;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERLINK__IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERLINK__URL = 1;

	/**
	 * The number of structural features of the '<em>Hyperlink</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERLINK_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.NumberingImpl <em>Numbering</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.NumberingImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getNumbering()
	 * @generated
	 */
	int NUMBERING = 8;

	/**
	 * The number of structural features of the '<em>Numbering</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBERING_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.PictureDataImpl <em>Picture Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.PictureDataImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getPictureData()
	 * @generated
	 */
	int PICTURE_DATA = 9;

	/**
	 * The number of structural features of the '<em>Picture Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICTURE_DATA_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl <em>Paragraph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.ParagraphImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getParagraph()
	 * @generated
	 */
	int PARAGRAPH = 10;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__TEXT = CONTENT__TEXT;

	/**
	 * The feature id for the '<em><b>Nlp Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__NLP_CONTENT = CONTENT__NLP_CONTENT;

	/**
	 * The feature id for the '<em><b>Runs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__RUNS = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__PART = CONTENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__BODY = CONTENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__ALIGNMENT = CONTENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Border Bottom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__BORDER_BOTTOM = CONTENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Border Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__BORDER_TOP = CONTENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Border Between</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__BORDER_BETWEEN = CONTENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Border Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__BORDER_LEFT = CONTENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Border Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__BORDER_RIGHT = CONTENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Vertical Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__VERTICAL_ALIGNMENT = CONTENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Footnote Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__FOOTNOTE_TEXT = CONTENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Indent Fst Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__INDENT_FST_LINE = CONTENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Indent Hanging</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__INDENT_HANGING = CONTENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Indent Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__INDENT_LEFT = CONTENT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Indent Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__INDENT_RIGHT = CONTENT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Spacing After</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__SPACING_AFTER = CONTENT_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Spacing After Lines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__SPACING_AFTER_LINES = CONTENT_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Spacing Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__SPACING_BEFORE = CONTENT_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Spacing Before Lines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__SPACING_BEFORE_LINES = CONTENT_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Spacing Line Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__SPACING_LINE_RULE = CONTENT_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__STYLE = CONTENT_FEATURE_COUNT + 20;

	/**
	 * The number of structural features of the '<em>Paragraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 21;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.TableImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 11;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.RunImpl <em>Run</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.RunImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getRun()
	 * @generated
	 */
	int RUN = 12;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN__TEXT = CONTENT__TEXT;

	/**
	 * The feature id for the '<em><b>Nlp Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN__NLP_CONTENT = CONTENT__NLP_CONTENT;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN__FONT_FAMILY = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN__FONT_SIZE = CONTENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Bold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN__IS_BOLD = CONTENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Italic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN__IS_ITALIC = CONTENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Strike</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN__IS_STRIKE = CONTENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN__COLOR = CONTENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Text Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN__TEXT_POSITION = CONTENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Run</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.PartImpl <em>Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.PartImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getPart()
	 * @generated
	 */
	int PART = 13;

	/**
	 * The number of structural features of the '<em>Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.impl.BodyImpl <em>Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.impl.BodyImpl
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getBody()
	 * @generated
	 */
	int BODY = 14;

	/**
	 * The number of structural features of the '<em>Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BODY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link dk.itu.sdg.language.xwpf.Style <em>Style</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.sdg.language.xwpf.Style
	 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getStyle()
	 * @generated
	 */
	int STYLE = 15;


	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.Content <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content</em>'.
	 * @see dk.itu.sdg.language.xwpf.Content
	 * @generated
	 */
	EClass getContent();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Content#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see dk.itu.sdg.language.xwpf.Content#getText()
	 * @see #getContent()
	 * @generated
	 */
	EAttribute getContent_Text();

	/**
	 * Returns the meta object for the containment reference '{@link dk.itu.sdg.language.xwpf.Content#getNlpContent <em>Nlp Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Nlp Content</em>'.
	 * @see dk.itu.sdg.language.xwpf.Content#getNlpContent()
	 * @see #getContent()
	 * @generated
	 */
	EReference getContent_NlpContent();

	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.Document <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document</em>'.
	 * @see dk.itu.sdg.language.xwpf.Document
	 * @generated
	 */
	EClass getDocument();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.sdg.language.xwpf.Document#getBodyElements <em>Body Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Body Elements</em>'.
	 * @see dk.itu.sdg.language.xwpf.Document#getBodyElements()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_BodyElements();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.sdg.language.xwpf.Document#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Comments</em>'.
	 * @see dk.itu.sdg.language.xwpf.Document#getComments()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Comments();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.sdg.language.xwpf.Document#getEndnotes <em>Endnotes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Endnotes</em>'.
	 * @see dk.itu.sdg.language.xwpf.Document#getEndnotes()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Endnotes();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.sdg.language.xwpf.Document#getFooters <em>Footers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Footers</em>'.
	 * @see dk.itu.sdg.language.xwpf.Document#getFooters()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Footers();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.sdg.language.xwpf.Document#getFootnotes <em>Footnotes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Footnotes</em>'.
	 * @see dk.itu.sdg.language.xwpf.Document#getFootnotes()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Footnotes();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.sdg.language.xwpf.Document#getHeaders <em>Headers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Headers</em>'.
	 * @see dk.itu.sdg.language.xwpf.Document#getHeaders()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Headers();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.sdg.language.xwpf.Document#getHyperlinks <em>Hyperlinks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Hyperlinks</em>'.
	 * @see dk.itu.sdg.language.xwpf.Document#getHyperlinks()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Hyperlinks();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.sdg.language.xwpf.Document#getNumbering <em>Numbering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Numbering</em>'.
	 * @see dk.itu.sdg.language.xwpf.Document#getNumbering()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Numbering();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.sdg.language.xwpf.Document#getPackagePictures <em>Package Pictures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Package Pictures</em>'.
	 * @see dk.itu.sdg.language.xwpf.Document#getPackagePictures()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_PackagePictures();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.sdg.language.xwpf.Document#getParagraphs <em>Paragraphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Paragraphs</em>'.
	 * @see dk.itu.sdg.language.xwpf.Document#getParagraphs()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Paragraphs();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.sdg.language.xwpf.Document#getPictures <em>Pictures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pictures</em>'.
	 * @see dk.itu.sdg.language.xwpf.Document#getPictures()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Pictures();

	/**
	 * Returns the meta object for the attribute list '{@link dk.itu.sdg.language.xwpf.Document#getStyles <em>Styles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Styles</em>'.
	 * @see dk.itu.sdg.language.xwpf.Document#getStyles()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_Styles();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.sdg.language.xwpf.Document#getTables <em>Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tables</em>'.
	 * @see dk.itu.sdg.language.xwpf.Document#getTables()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Tables();

	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.BodyElement <em>Body Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Body Element</em>'.
	 * @see dk.itu.sdg.language.xwpf.BodyElement
	 * @generated
	 */
	EClass getBodyElement();

	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see dk.itu.sdg.language.xwpf.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Comment#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see dk.itu.sdg.language.xwpf.Comment#getAuthor()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Author();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Comment#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see dk.itu.sdg.language.xwpf.Comment#getIdentifier()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Identifier();

	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.Footnote <em>Footnote</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Footnote</em>'.
	 * @see dk.itu.sdg.language.xwpf.Footnote
	 * @generated
	 */
	EClass getFootnote();

	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.Footer <em>Footer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Footer</em>'.
	 * @see dk.itu.sdg.language.xwpf.Footer
	 * @generated
	 */
	EClass getFooter();

	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.Header <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Header</em>'.
	 * @see dk.itu.sdg.language.xwpf.Header
	 * @generated
	 */
	EClass getHeader();

	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.Hyperlink <em>Hyperlink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hyperlink</em>'.
	 * @see dk.itu.sdg.language.xwpf.Hyperlink
	 * @generated
	 */
	EClass getHyperlink();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Hyperlink#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see dk.itu.sdg.language.xwpf.Hyperlink#getIdentifier()
	 * @see #getHyperlink()
	 * @generated
	 */
	EAttribute getHyperlink_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Hyperlink#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see dk.itu.sdg.language.xwpf.Hyperlink#getUrl()
	 * @see #getHyperlink()
	 * @generated
	 */
	EAttribute getHyperlink_Url();

	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.Numbering <em>Numbering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numbering</em>'.
	 * @see dk.itu.sdg.language.xwpf.Numbering
	 * @generated
	 */
	EClass getNumbering();

	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.PictureData <em>Picture Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Picture Data</em>'.
	 * @see dk.itu.sdg.language.xwpf.PictureData
	 * @generated
	 */
	EClass getPictureData();

	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.Paragraph <em>Paragraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paragraph</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph
	 * @generated
	 */
	EClass getParagraph();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.sdg.language.xwpf.Paragraph#getRuns <em>Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Runs</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getRuns()
	 * @see #getParagraph()
	 * @generated
	 */
	EReference getParagraph_Runs();

	/**
	 * Returns the meta object for the containment reference '{@link dk.itu.sdg.language.xwpf.Paragraph#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Part</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getPart()
	 * @see #getParagraph()
	 * @generated
	 */
	EReference getParagraph_Part();

	/**
	 * Returns the meta object for the containment reference '{@link dk.itu.sdg.language.xwpf.Paragraph#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getBody()
	 * @see #getParagraph()
	 * @generated
	 */
	EReference getParagraph_Body();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getAlignment <em>Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alignment</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getAlignment()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_Alignment();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderBottom <em>Border Bottom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Border Bottom</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getBorderBottom()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_BorderBottom();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderTop <em>Border Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Border Top</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getBorderTop()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_BorderTop();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderBetween <em>Border Between</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Border Between</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getBorderBetween()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_BorderBetween();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderLeft <em>Border Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Border Left</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getBorderLeft()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_BorderLeft();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getBorderRight <em>Border Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Border Right</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getBorderRight()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_BorderRight();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getVerticalAlignment <em>Vertical Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vertical Alignment</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getVerticalAlignment()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_VerticalAlignment();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getFootnoteText <em>Footnote Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Footnote Text</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getFootnoteText()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_FootnoteText();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getIndentFstLine <em>Indent Fst Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indent Fst Line</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getIndentFstLine()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_IndentFstLine();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getIndentHanging <em>Indent Hanging</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indent Hanging</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getIndentHanging()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_IndentHanging();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getIndentLeft <em>Indent Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indent Left</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getIndentLeft()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_IndentLeft();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getIndentRight <em>Indent Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indent Right</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getIndentRight()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_IndentRight();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingAfter <em>Spacing After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spacing After</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getSpacingAfter()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_SpacingAfter();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingAfterLines <em>Spacing After Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spacing After Lines</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getSpacingAfterLines()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_SpacingAfterLines();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingBefore <em>Spacing Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spacing Before</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getSpacingBefore()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_SpacingBefore();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingBeforeLines <em>Spacing Before Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spacing Before Lines</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getSpacingBeforeLines()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_SpacingBeforeLines();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getSpacingLineRule <em>Spacing Line Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spacing Line Rule</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getSpacingLineRule()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_SpacingLineRule();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Paragraph#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style</em>'.
	 * @see dk.itu.sdg.language.xwpf.Paragraph#getStyle()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_Style();

	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see dk.itu.sdg.language.xwpf.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.Run <em>Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Run</em>'.
	 * @see dk.itu.sdg.language.xwpf.Run
	 * @generated
	 */
	EClass getRun();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Run#getFontFamily <em>Font Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Family</em>'.
	 * @see dk.itu.sdg.language.xwpf.Run#getFontFamily()
	 * @see #getRun()
	 * @generated
	 */
	EAttribute getRun_FontFamily();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Run#getFontSize <em>Font Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Size</em>'.
	 * @see dk.itu.sdg.language.xwpf.Run#getFontSize()
	 * @see #getRun()
	 * @generated
	 */
	EAttribute getRun_FontSize();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Run#isIsBold <em>Is Bold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Bold</em>'.
	 * @see dk.itu.sdg.language.xwpf.Run#isIsBold()
	 * @see #getRun()
	 * @generated
	 */
	EAttribute getRun_IsBold();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Run#isIsItalic <em>Is Italic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Italic</em>'.
	 * @see dk.itu.sdg.language.xwpf.Run#isIsItalic()
	 * @see #getRun()
	 * @generated
	 */
	EAttribute getRun_IsItalic();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Run#isIsStrike <em>Is Strike</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Strike</em>'.
	 * @see dk.itu.sdg.language.xwpf.Run#isIsStrike()
	 * @see #getRun()
	 * @generated
	 */
	EAttribute getRun_IsStrike();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Run#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see dk.itu.sdg.language.xwpf.Run#getColor()
	 * @see #getRun()
	 * @generated
	 */
	EAttribute getRun_Color();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.sdg.language.xwpf.Run#getTextPosition <em>Text Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Position</em>'.
	 * @see dk.itu.sdg.language.xwpf.Run#getTextPosition()
	 * @see #getRun()
	 * @generated
	 */
	EAttribute getRun_TextPosition();

	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.Part <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part</em>'.
	 * @see dk.itu.sdg.language.xwpf.Part
	 * @generated
	 */
	EClass getPart();

	/**
	 * Returns the meta object for class '{@link dk.itu.sdg.language.xwpf.Body <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Body</em>'.
	 * @see dk.itu.sdg.language.xwpf.Body
	 * @generated
	 */
	EClass getBody();

	/**
	 * Returns the meta object for enum '{@link dk.itu.sdg.language.xwpf.Style <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Style</em>'.
	 * @see dk.itu.sdg.language.xwpf.Style
	 * @generated
	 */
	EEnum getStyle();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XwpfFactory getXwpfFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.ContentImpl <em>Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.ContentImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getContent()
		 * @generated
		 */
		EClass CONTENT = eINSTANCE.getContent();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT__TEXT = eINSTANCE.getContent_Text();

		/**
		 * The meta object literal for the '<em><b>Nlp Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTENT__NLP_CONTENT = eINSTANCE.getContent_NlpContent();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl <em>Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.DocumentImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getDocument()
		 * @generated
		 */
		EClass DOCUMENT = eINSTANCE.getDocument();

		/**
		 * The meta object literal for the '<em><b>Body Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__BODY_ELEMENTS = eINSTANCE.getDocument_BodyElements();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__COMMENTS = eINSTANCE.getDocument_Comments();

		/**
		 * The meta object literal for the '<em><b>Endnotes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__ENDNOTES = eINSTANCE.getDocument_Endnotes();

		/**
		 * The meta object literal for the '<em><b>Footers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__FOOTERS = eINSTANCE.getDocument_Footers();

		/**
		 * The meta object literal for the '<em><b>Footnotes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__FOOTNOTES = eINSTANCE.getDocument_Footnotes();

		/**
		 * The meta object literal for the '<em><b>Headers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__HEADERS = eINSTANCE.getDocument_Headers();

		/**
		 * The meta object literal for the '<em><b>Hyperlinks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__HYPERLINKS = eINSTANCE.getDocument_Hyperlinks();

		/**
		 * The meta object literal for the '<em><b>Numbering</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__NUMBERING = eINSTANCE.getDocument_Numbering();

		/**
		 * The meta object literal for the '<em><b>Package Pictures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__PACKAGE_PICTURES = eINSTANCE.getDocument_PackagePictures();

		/**
		 * The meta object literal for the '<em><b>Paragraphs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__PARAGRAPHS = eINSTANCE.getDocument_Paragraphs();

		/**
		 * The meta object literal for the '<em><b>Pictures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__PICTURES = eINSTANCE.getDocument_Pictures();

		/**
		 * The meta object literal for the '<em><b>Styles</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT__STYLES = eINSTANCE.getDocument_Styles();

		/**
		 * The meta object literal for the '<em><b>Tables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__TABLES = eINSTANCE.getDocument_Tables();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.BodyElementImpl <em>Body Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.BodyElementImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getBodyElement()
		 * @generated
		 */
		EClass BODY_ELEMENT = eINSTANCE.getBodyElement();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.CommentImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__AUTHOR = eINSTANCE.getComment_Author();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__IDENTIFIER = eINSTANCE.getComment_Identifier();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.FootnoteImpl <em>Footnote</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.FootnoteImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getFootnote()
		 * @generated
		 */
		EClass FOOTNOTE = eINSTANCE.getFootnote();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.FooterImpl <em>Footer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.FooterImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getFooter()
		 * @generated
		 */
		EClass FOOTER = eINSTANCE.getFooter();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.HeaderImpl <em>Header</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.HeaderImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getHeader()
		 * @generated
		 */
		EClass HEADER = eINSTANCE.getHeader();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.HyperlinkImpl <em>Hyperlink</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.HyperlinkImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getHyperlink()
		 * @generated
		 */
		EClass HYPERLINK = eINSTANCE.getHyperlink();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYPERLINK__IDENTIFIER = eINSTANCE.getHyperlink_Identifier();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYPERLINK__URL = eINSTANCE.getHyperlink_Url();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.NumberingImpl <em>Numbering</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.NumberingImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getNumbering()
		 * @generated
		 */
		EClass NUMBERING = eINSTANCE.getNumbering();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.PictureDataImpl <em>Picture Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.PictureDataImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getPictureData()
		 * @generated
		 */
		EClass PICTURE_DATA = eINSTANCE.getPictureData();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl <em>Paragraph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.ParagraphImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getParagraph()
		 * @generated
		 */
		EClass PARAGRAPH = eINSTANCE.getParagraph();

		/**
		 * The meta object literal for the '<em><b>Runs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAGRAPH__RUNS = eINSTANCE.getParagraph_Runs();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAGRAPH__PART = eINSTANCE.getParagraph_Part();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAGRAPH__BODY = eINSTANCE.getParagraph_Body();

		/**
		 * The meta object literal for the '<em><b>Alignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__ALIGNMENT = eINSTANCE.getParagraph_Alignment();

		/**
		 * The meta object literal for the '<em><b>Border Bottom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__BORDER_BOTTOM = eINSTANCE.getParagraph_BorderBottom();

		/**
		 * The meta object literal for the '<em><b>Border Top</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__BORDER_TOP = eINSTANCE.getParagraph_BorderTop();

		/**
		 * The meta object literal for the '<em><b>Border Between</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__BORDER_BETWEEN = eINSTANCE.getParagraph_BorderBetween();

		/**
		 * The meta object literal for the '<em><b>Border Left</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__BORDER_LEFT = eINSTANCE.getParagraph_BorderLeft();

		/**
		 * The meta object literal for the '<em><b>Border Right</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__BORDER_RIGHT = eINSTANCE.getParagraph_BorderRight();

		/**
		 * The meta object literal for the '<em><b>Vertical Alignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__VERTICAL_ALIGNMENT = eINSTANCE.getParagraph_VerticalAlignment();

		/**
		 * The meta object literal for the '<em><b>Footnote Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__FOOTNOTE_TEXT = eINSTANCE.getParagraph_FootnoteText();

		/**
		 * The meta object literal for the '<em><b>Indent Fst Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__INDENT_FST_LINE = eINSTANCE.getParagraph_IndentFstLine();

		/**
		 * The meta object literal for the '<em><b>Indent Hanging</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__INDENT_HANGING = eINSTANCE.getParagraph_IndentHanging();

		/**
		 * The meta object literal for the '<em><b>Indent Left</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__INDENT_LEFT = eINSTANCE.getParagraph_IndentLeft();

		/**
		 * The meta object literal for the '<em><b>Indent Right</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__INDENT_RIGHT = eINSTANCE.getParagraph_IndentRight();

		/**
		 * The meta object literal for the '<em><b>Spacing After</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__SPACING_AFTER = eINSTANCE.getParagraph_SpacingAfter();

		/**
		 * The meta object literal for the '<em><b>Spacing After Lines</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__SPACING_AFTER_LINES = eINSTANCE.getParagraph_SpacingAfterLines();

		/**
		 * The meta object literal for the '<em><b>Spacing Before</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__SPACING_BEFORE = eINSTANCE.getParagraph_SpacingBefore();

		/**
		 * The meta object literal for the '<em><b>Spacing Before Lines</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__SPACING_BEFORE_LINES = eINSTANCE.getParagraph_SpacingBeforeLines();

		/**
		 * The meta object literal for the '<em><b>Spacing Line Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__SPACING_LINE_RULE = eINSTANCE.getParagraph_SpacingLineRule();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__STYLE = eINSTANCE.getParagraph_Style();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.TableImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.RunImpl <em>Run</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.RunImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getRun()
		 * @generated
		 */
		EClass RUN = eINSTANCE.getRun();

		/**
		 * The meta object literal for the '<em><b>Font Family</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN__FONT_FAMILY = eINSTANCE.getRun_FontFamily();

		/**
		 * The meta object literal for the '<em><b>Font Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN__FONT_SIZE = eINSTANCE.getRun_FontSize();

		/**
		 * The meta object literal for the '<em><b>Is Bold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN__IS_BOLD = eINSTANCE.getRun_IsBold();

		/**
		 * The meta object literal for the '<em><b>Is Italic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN__IS_ITALIC = eINSTANCE.getRun_IsItalic();

		/**
		 * The meta object literal for the '<em><b>Is Strike</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN__IS_STRIKE = eINSTANCE.getRun_IsStrike();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN__COLOR = eINSTANCE.getRun_Color();

		/**
		 * The meta object literal for the '<em><b>Text Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN__TEXT_POSITION = eINSTANCE.getRun_TextPosition();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.PartImpl <em>Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.PartImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getPart()
		 * @generated
		 */
		EClass PART = eINSTANCE.getPart();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.impl.BodyImpl <em>Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.impl.BodyImpl
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getBody()
		 * @generated
		 */
		EClass BODY = eINSTANCE.getBody();

		/**
		 * The meta object literal for the '{@link dk.itu.sdg.language.xwpf.Style <em>Style</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.sdg.language.xwpf.Style
		 * @see dk.itu.sdg.language.xwpf.impl.XwpfPackageImpl#getStyle()
		 * @generated
		 */
		EEnum STYLE = eINSTANCE.getStyle();

	}

} //XwpfPackage
