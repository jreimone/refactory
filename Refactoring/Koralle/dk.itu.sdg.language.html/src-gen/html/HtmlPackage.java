/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see html.HtmlFactory
 * @model kind="package"
 * @generated
 */
public interface HtmlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "html";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.itu.dk/language/html";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "html";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HtmlPackage eINSTANCE = html.impl.HtmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link html.impl.DocumentImpl <em>Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.DocumentImpl
	 * @see html.impl.HtmlPackageImpl#getDocument()
	 * @generated
	 */
	int DOCUMENT = 0;

	/**
	 * The feature id for the '<em><b>Doctype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__DOCTYPE = 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__PARAMETERS = 1;

	/**
	 * The feature id for the '<em><b>Web Page Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__WEB_PAGE_BODY = 2;

	/**
	 * The number of structural features of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link html.impl.DocTypeImpl <em>Doc Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.DocTypeImpl
	 * @see html.impl.HtmlPackageImpl#getDocType()
	 * @generated
	 */
	int DOC_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE__PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Doc Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link html.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.ParameterImpl
	 * @see html.impl.HtmlPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 2;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link html.impl.StringValParameterImpl <em>String Val Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.StringValParameterImpl
	 * @see html.impl.HtmlPackageImpl#getStringValParameter()
	 * @generated
	 */
	int STRING_VAL_PARAMETER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VAL_PARAMETER__NAME = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VAL_PARAMETER__VALUE = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>String Val Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VAL_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link html.impl.ColorValParameterImpl <em>Color Val Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.ColorValParameterImpl
	 * @see html.impl.HtmlPackageImpl#getColorValParameter()
	 * @generated
	 */
	int COLOR_VAL_PARAMETER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VAL_PARAMETER__NAME = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VAL_PARAMETER__VALUE = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Color Val Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VAL_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link html.impl.IDValParameterImpl <em>ID Val Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.IDValParameterImpl
	 * @see html.impl.HtmlPackageImpl#getIDValParameter()
	 * @generated
	 */
	int ID_VAL_PARAMETER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_VAL_PARAMETER__NAME = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_VAL_PARAMETER__VALUE = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>ID Val Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_VAL_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link html.impl.IDParameterImpl <em>ID Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.IDParameterImpl
	 * @see html.impl.HtmlPackageImpl#getIDParameter()
	 * @generated
	 */
	int ID_PARAMETER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_PARAMETER__NAME = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ID Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.StringParameterImpl <em>String Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.StringParameterImpl
	 * @see html.impl.HtmlPackageImpl#getStringParameter()
	 * @generated
	 */
	int STRING_PARAMETER = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER__NAME = 0;

	/**
	 * The number of structural features of the '<em>String Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link html.impl.WebPageBodyImpl <em>Web Page Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.WebPageBodyImpl
	 * @see html.impl.HtmlPackageImpl#getWebPageBody()
	 * @generated
	 */
	int WEB_PAGE_BODY = 8;

	/**
	 * The feature id for the '<em><b>Head</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_PAGE_BODY__HEAD = 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_PAGE_BODY__BODY = 1;

	/**
	 * The number of structural features of the '<em>Web Page Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_PAGE_BODY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link html.impl.HeadImpl <em>Head</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.HeadImpl
	 * @see html.impl.HtmlPackageImpl#getHead()
	 * @generated
	 */
	int HEAD = 9;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAD__PARAMETERS = 0;

	/**
	 * The feature id for the '<em><b>Head Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAD__HEAD_ITEMS = 1;

	/**
	 * The number of structural features of the '<em>Head</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAD_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link html.impl.BodyImpl <em>Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.BodyImpl
	 * @see html.impl.HtmlPackageImpl#getBody()
	 * @generated
	 */
	int BODY = 10;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BODY__PARAMETERS = 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BODY__CONTENT = 1;

	/**
	 * The number of structural features of the '<em>Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BODY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link html.impl.HeadItemImpl <em>Head Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.HeadItemImpl
	 * @see html.impl.HtmlPackageImpl#getHeadItem()
	 * @generated
	 */
	int HEAD_ITEM = 11;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAD_ITEM__PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Head Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAD_ITEM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link html.impl.TitleItemImpl <em>Title Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.TitleItemImpl
	 * @see html.impl.HtmlPackageImpl#getTitleItem()
	 * @generated
	 */
	int TITLE_ITEM = 12;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_ITEM__PARAMETERS = HEAD_ITEM__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_ITEM__CONTENT = HEAD_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Title Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_ITEM_FEATURE_COUNT = HEAD_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.MetaItemImpl <em>Meta Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.MetaItemImpl
	 * @see html.impl.HtmlPackageImpl#getMetaItem()
	 * @generated
	 */
	int META_ITEM = 13;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_ITEM__PARAMETERS = HEAD_ITEM__PARAMETERS;

	/**
	 * The number of structural features of the '<em>Meta Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_ITEM_FEATURE_COUNT = HEAD_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link html.impl.LinkItemImpl <em>Link Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.LinkItemImpl
	 * @see html.impl.HtmlPackageImpl#getLinkItem()
	 * @generated
	 */
	int LINK_ITEM = 14;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ITEM__PARAMETERS = HEAD_ITEM__PARAMETERS;

	/**
	 * The number of structural features of the '<em>Link Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ITEM_FEATURE_COUNT = HEAD_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link html.impl.BaseItemImpl <em>Base Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.BaseItemImpl
	 * @see html.impl.HtmlPackageImpl#getBaseItem()
	 * @generated
	 */
	int BASE_ITEM = 15;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_ITEM__PARAMETERS = HEAD_ITEM__PARAMETERS;

	/**
	 * The number of structural features of the '<em>Base Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_ITEM_FEATURE_COUNT = HEAD_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link html.impl.BaseFontItemImpl <em>Base Font Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.BaseFontItemImpl
	 * @see html.impl.HtmlPackageImpl#getBaseFontItem()
	 * @generated
	 */
	int BASE_FONT_ITEM = 16;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_FONT_ITEM__PARAMETERS = HEAD_ITEM__PARAMETERS;

	/**
	 * The number of structural features of the '<em>Base Font Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_FONT_ITEM_FEATURE_COUNT = HEAD_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link html.impl.ScriptItemImpl <em>Script Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.ScriptItemImpl
	 * @see html.impl.HtmlPackageImpl#getScriptItem()
	 * @generated
	 */
	int SCRIPT_ITEM = 17;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_ITEM__PARAMETERS = HEAD_ITEM__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_ITEM__CONTENT = HEAD_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Script Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_ITEM_FEATURE_COUNT = HEAD_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.ContentImpl <em>Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.ContentImpl
	 * @see html.impl.HtmlPackageImpl#getContent()
	 * @generated
	 */
	int CONTENT = 18;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__PARAMETERS = 0;

	/**
	 * The feature id for the '<em><b>PContent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__PCONTENT = 1;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__CONTENT = 2;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__TAG = 3;

	/**
	 * The feature id for the '<em><b>Word</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__WORD = 4;

	/**
	 * The number of structural features of the '<em>Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link html.impl.PContentImpl <em>PContent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.PContentImpl
	 * @see html.impl.HtmlPackageImpl#getPContent()
	 * @generated
	 */
	int PCONTENT = 19;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTENT__TAG = 0;

	/**
	 * The feature id for the '<em><b>Word</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTENT__WORD = 1;

	/**
	 * The feature id for the '<em><b>PContent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTENT__PCONTENT = 2;

	/**
	 * The number of structural features of the '<em>PContent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link html.impl.TagImpl <em>Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.TagImpl
	 * @see html.impl.HtmlPackageImpl#getTag()
	 * @generated
	 */
	int TAG = 20;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link html.impl.WordImpl <em>Word</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.WordImpl
	 * @see html.impl.HtmlPackageImpl#getWord()
	 * @generated
	 */
	int WORD = 21;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>Word</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link html.impl.ImageTagImpl <em>Image Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.ImageTagImpl
	 * @see html.impl.HtmlPackageImpl#getImageTag()
	 * @generated
	 */
	int IMAGE_TAG = 22;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The number of structural features of the '<em>Image Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link html.impl.BrTagImpl <em>Br Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.BrTagImpl
	 * @see html.impl.HtmlPackageImpl#getBrTag()
	 * @generated
	 */
	int BR_TAG = 23;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BR_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The number of structural features of the '<em>Br Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BR_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link html.impl.HrTagImpl <em>Hr Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.HrTagImpl
	 * @see html.impl.HtmlPackageImpl#getHrTag()
	 * @generated
	 */
	int HR_TAG = 24;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HR_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The number of structural features of the '<em>Hr Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HR_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link html.impl.PTagImpl <em>PTag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.PTagImpl
	 * @see html.impl.HtmlPackageImpl#getPTag()
	 * @generated
	 */
	int PTAG = 25;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>PContent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTAG__PCONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PTag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.H1TagImpl <em>H1 Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.H1TagImpl
	 * @see html.impl.HtmlPackageImpl#getH1Tag()
	 * @generated
	 */
	int H1_TAG = 26;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H1_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H1_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>H1 Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H1_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.H2TagImpl <em>H2 Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.H2TagImpl
	 * @see html.impl.HtmlPackageImpl#getH2Tag()
	 * @generated
	 */
	int H2_TAG = 27;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H2_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H2_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>H2 Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H2_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.H3TagImpl <em>H3 Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.H3TagImpl
	 * @see html.impl.HtmlPackageImpl#getH3Tag()
	 * @generated
	 */
	int H3_TAG = 28;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H3_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H3_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>H3 Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H3_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.H4TagImpl <em>H4 Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.H4TagImpl
	 * @see html.impl.HtmlPackageImpl#getH4Tag()
	 * @generated
	 */
	int H4_TAG = 29;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H4_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H4_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>H4 Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H4_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.H5TagImpl <em>H5 Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.H5TagImpl
	 * @see html.impl.HtmlPackageImpl#getH5Tag()
	 * @generated
	 */
	int H5_TAG = 30;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H5_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H5_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>H5 Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H5_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.H6TagImpl <em>H6 Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.H6TagImpl
	 * @see html.impl.HtmlPackageImpl#getH6Tag()
	 * @generated
	 */
	int H6_TAG = 31;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H6_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H6_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>H6 Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int H6_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.ATagImpl <em>ATag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.ATagImpl
	 * @see html.impl.HtmlPackageImpl#getATag()
	 * @generated
	 */
	int ATAG = 32;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ATag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.MapTagImpl <em>Map Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.MapTagImpl
	 * @see html.impl.HtmlPackageImpl#getMapTag()
	 * @generated
	 */
	int MAP_TAG = 33;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Map Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_TAG__MAP_ITEMS = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Map Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.BTagImpl <em>BTag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.BTagImpl
	 * @see html.impl.HtmlPackageImpl#getBTag()
	 * @generated
	 */
	int BTAG = 34;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BTag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.UTagImpl <em>UTag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.UTagImpl
	 * @see html.impl.HtmlPackageImpl#getUTag()
	 * @generated
	 */
	int UTAG = 35;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>UTag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.EmTagImpl <em>Em Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.EmTagImpl
	 * @see html.impl.HtmlPackageImpl#getEmTag()
	 * @generated
	 */
	int EM_TAG = 36;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EM_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EM_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Em Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EM_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.ITagImpl <em>ITag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.ITagImpl
	 * @see html.impl.HtmlPackageImpl#getITag()
	 * @generated
	 */
	int ITAG = 37;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ITag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.StrikeTagImpl <em>Strike Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.StrikeTagImpl
	 * @see html.impl.HtmlPackageImpl#getStrikeTag()
	 * @generated
	 */
	int STRIKE_TAG = 38;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRIKE_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRIKE_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Strike Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRIKE_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.StrongTagImpl <em>Strong Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.StrongTagImpl
	 * @see html.impl.HtmlPackageImpl#getStrongTag()
	 * @generated
	 */
	int STRONG_TAG = 39;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRONG_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRONG_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Strong Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRONG_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.FontTagImpl <em>Font Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.FontTagImpl
	 * @see html.impl.HtmlPackageImpl#getFontTag()
	 * @generated
	 */
	int FONT_TAG = 40;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Font Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.BigTagImpl <em>Big Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.BigTagImpl
	 * @see html.impl.HtmlPackageImpl#getBigTag()
	 * @generated
	 */
	int BIG_TAG = 41;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Big Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.SmallTagImpl <em>Small Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.SmallTagImpl
	 * @see html.impl.HtmlPackageImpl#getSmallTag()
	 * @generated
	 */
	int SMALL_TAG = 42;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Small Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.SupTagImpl <em>Sup Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.SupTagImpl
	 * @see html.impl.HtmlPackageImpl#getSupTag()
	 * @generated
	 */
	int SUP_TAG = 43;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUP_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUP_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sup Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUP_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.SubTagImpl <em>Sub Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.SubTagImpl
	 * @see html.impl.HtmlPackageImpl#getSubTag()
	 * @generated
	 */
	int SUB_TAG = 44;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sub Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.BlockQuoteTagImpl <em>Block Quote Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.BlockQuoteTagImpl
	 * @see html.impl.HtmlPackageImpl#getBlockQuoteTag()
	 * @generated
	 */
	int BLOCK_QUOTE_TAG = 45;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_QUOTE_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_QUOTE_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Quote Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_QUOTE_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.AddressTagImpl <em>Address Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.AddressTagImpl
	 * @see html.impl.HtmlPackageImpl#getAddressTag()
	 * @generated
	 */
	int ADDRESS_TAG = 46;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Address Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.CodeTagImpl <em>Code Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.CodeTagImpl
	 * @see html.impl.HtmlPackageImpl#getCodeTag()
	 * @generated
	 */
	int CODE_TAG = 47;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Code Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.CiteTagImpl <em>Cite Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.CiteTagImpl
	 * @see html.impl.HtmlPackageImpl#getCiteTag()
	 * @generated
	 */
	int CITE_TAG = 48;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CITE_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CITE_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cite Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CITE_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.CaptionTagImpl <em>Caption Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.CaptionTagImpl
	 * @see html.impl.HtmlPackageImpl#getCaptionTag()
	 * @generated
	 */
	int CAPTION_TAG = 49;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTION_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTION_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Caption Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTION_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.SampTagImpl <em>Samp Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.SampTagImpl
	 * @see html.impl.HtmlPackageImpl#getSampTag()
	 * @generated
	 */
	int SAMP_TAG = 50;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMP_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMP_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Samp Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMP_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.KbdTagImpl <em>Kbd Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.KbdTagImpl
	 * @see html.impl.HtmlPackageImpl#getKbdTag()
	 * @generated
	 */
	int KBD_TAG = 51;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KBD_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KBD_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Kbd Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KBD_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.TtTagImpl <em>Tt Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.TtTagImpl
	 * @see html.impl.HtmlPackageImpl#getTtTag()
	 * @generated
	 */
	int TT_TAG = 52;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TT_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TT_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tt Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TT_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.CenterTagImpl <em>Center Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.CenterTagImpl
	 * @see html.impl.HtmlPackageImpl#getCenterTag()
	 * @generated
	 */
	int CENTER_TAG = 53;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CENTER_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CENTER_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Center Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CENTER_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.SpanTagImpl <em>Span Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.SpanTagImpl
	 * @see html.impl.HtmlPackageImpl#getSpanTag()
	 * @generated
	 */
	int SPAN_TAG = 54;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Span Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.DivTagImpl <em>Div Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.DivTagImpl
	 * @see html.impl.HtmlPackageImpl#getDivTag()
	 * @generated
	 */
	int DIV_TAG = 55;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Div Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.AppletTagImpl <em>Applet Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.AppletTagImpl
	 * @see html.impl.HtmlPackageImpl#getAppletTag()
	 * @generated
	 */
	int APPLET_TAG = 56;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET_TAG__PARAMS = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Applet Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.ObjectTagImpl <em>Object Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.ObjectTagImpl
	 * @see html.impl.HtmlPackageImpl#getObjectTag()
	 * @generated
	 */
	int OBJECT_TAG = 57;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TAG__PARAMS = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.TableTagImpl <em>Table Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.TableTagImpl
	 * @see html.impl.HtmlPackageImpl#getTableTag()
	 * @generated
	 */
	int TABLE_TAG = 58;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Table Rows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_TAG__TABLE_ROWS = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Table Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.UITagImpl <em>UI Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.UITagImpl
	 * @see html.impl.HtmlPackageImpl#getUITag()
	 * @generated
	 */
	int UI_TAG = 59;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>List Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_TAG__LIST_ITEMS = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>UI Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.OlTagImpl <em>Ol Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.OlTagImpl
	 * @see html.impl.HtmlPackageImpl#getOlTag()
	 * @generated
	 */
	int OL_TAG = 60;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OL_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>List Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OL_TAG__LIST_ITEMS = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ol Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OL_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.DirTagImpl <em>Dir Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.DirTagImpl
	 * @see html.impl.HtmlPackageImpl#getDirTag()
	 * @generated
	 */
	int DIR_TAG = 61;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIR_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>List Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIR_TAG__LIST_ITEMS = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dir Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIR_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.MenutagImpl <em>Menutag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.MenutagImpl
	 * @see html.impl.HtmlPackageImpl#getMenutag()
	 * @generated
	 */
	int MENUTAG = 62;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENUTAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>List Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENUTAG__LIST_ITEMS = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Menutag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENUTAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.DlTagImpl <em>Dl Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.DlTagImpl
	 * @see html.impl.HtmlPackageImpl#getDlTag()
	 * @generated
	 */
	int DL_TAG = 63;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DL_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Def Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DL_TAG__DEF_ITEMS = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dl Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DL_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.FormTagImpl <em>Form Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.FormTagImpl
	 * @see html.impl.HtmlPackageImpl#getFormTag()
	 * @generated
	 */
	int FORM_TAG = 64;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Form Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.InputTagImpl <em>Input Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.InputTagImpl
	 * @see html.impl.HtmlPackageImpl#getInputTag()
	 * @generated
	 */
	int INPUT_TAG = 65;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The number of structural features of the '<em>Input Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link html.impl.SelectTagImpl <em>Select Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.SelectTagImpl
	 * @see html.impl.HtmlPackageImpl#getSelectTag()
	 * @generated
	 */
	int SELECT_TAG = 66;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_TAG__OPTIONS = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Select Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.TextAreaTagImpl <em>Text Area Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.TextAreaTagImpl
	 * @see html.impl.HtmlPackageImpl#getTextAreaTag()
	 * @generated
	 */
	int TEXT_AREA_TAG = 67;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_AREA_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_AREA_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text Area Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_AREA_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.TableRowImpl <em>Table Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.TableRowImpl
	 * @see html.impl.HtmlPackageImpl#getTableRow()
	 * @generated
	 */
	int TABLE_ROW = 68;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ROW__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Table Cells</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ROW__TABLE_CELLS = TAG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Table Rows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ROW__TABLE_ROWS = TAG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Table Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ROW_FEATURE_COUNT = TAG_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link html.impl.TableCellImpl <em>Table Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.TableCellImpl
	 * @see html.impl.HtmlPackageImpl#getTableCell()
	 * @generated
	 */
	int TABLE_CELL = 69;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CELL__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CELL__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Table Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CELL_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.TDTableCellImpl <em>TD Table Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.TDTableCellImpl
	 * @see html.impl.HtmlPackageImpl#getTDTableCell()
	 * @generated
	 */
	int TD_TABLE_CELL = 70;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TD_TABLE_CELL__PARAMETERS = TABLE_CELL__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TD_TABLE_CELL__CONTENT = TABLE_CELL__CONTENT;

	/**
	 * The number of structural features of the '<em>TD Table Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TD_TABLE_CELL_FEATURE_COUNT = TABLE_CELL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link html.impl.THTableCellImpl <em>TH Table Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.THTableCellImpl
	 * @see html.impl.HtmlPackageImpl#getTHTableCell()
	 * @generated
	 */
	int TH_TABLE_CELL = 71;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TH_TABLE_CELL__PARAMETERS = TABLE_CELL__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TH_TABLE_CELL__CONTENT = TABLE_CELL__CONTENT;

	/**
	 * The number of structural features of the '<em>TH Table Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TH_TABLE_CELL_FEATURE_COUNT = TABLE_CELL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link html.impl.DefItemImpl <em>Def Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.DefItemImpl
	 * @see html.impl.HtmlPackageImpl#getDefItem()
	 * @generated
	 */
	int DEF_ITEM = 72;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_ITEM__PARAMETERS = 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_ITEM__CONTENT = 1;

	/**
	 * The number of structural features of the '<em>Def Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_ITEM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link html.impl.DdItemImpl <em>Dd Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.DdItemImpl
	 * @see html.impl.HtmlPackageImpl#getDdItem()
	 * @generated
	 */
	int DD_ITEM = 73;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DD_ITEM__PARAMETERS = DEF_ITEM__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DD_ITEM__CONTENT = DEF_ITEM__CONTENT;

	/**
	 * The number of structural features of the '<em>Dd Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DD_ITEM_FEATURE_COUNT = DEF_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link html.impl.DtItemImpl <em>Dt Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.DtItemImpl
	 * @see html.impl.HtmlPackageImpl#getDtItem()
	 * @generated
	 */
	int DT_ITEM = 74;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DT_ITEM__PARAMETERS = DEF_ITEM__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DT_ITEM__CONTENT = DEF_ITEM__CONTENT;

	/**
	 * The number of structural features of the '<em>Dt Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DT_ITEM_FEATURE_COUNT = DEF_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link html.impl.ListItemImpl <em>List Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.ListItemImpl
	 * @see html.impl.HtmlPackageImpl#getListItem()
	 * @generated
	 */
	int LIST_ITEM = 75;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_ITEM__PARAMETERS = 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_ITEM__CONTENT = 1;

	/**
	 * The number of structural features of the '<em>List Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_ITEM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link html.impl.OptionImpl <em>Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.OptionImpl
	 * @see html.impl.HtmlPackageImpl#getOption()
	 * @generated
	 */
	int OPTION = 76;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link html.impl.MapItemImpl <em>Map Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.MapItemImpl
	 * @see html.impl.HtmlPackageImpl#getMapItem()
	 * @generated
	 */
	int MAP_ITEM = 77;

	/**
	 * The feature id for the '<em><b>Area</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ITEM__AREA = 0;

	/**
	 * The feature id for the '<em><b>Map Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ITEM__MAP_ITEMS = 1;

	/**
	 * The number of structural features of the '<em>Map Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ITEM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link html.impl.AreaImpl <em>Area</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.AreaImpl
	 * @see html.impl.HtmlPackageImpl#getArea()
	 * @generated
	 */
	int AREA = 78;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link html.impl.ParamImpl <em>Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.ParamImpl
	 * @see html.impl.HtmlPackageImpl#getParam()
	 * @generated
	 */
	int PARAM = 79;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM__PARAMETERS = 0;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM__PARAMS = 1;

	/**
	 * The number of structural features of the '<em>Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link html.impl.DSLTagImpl <em>DSL Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.DSLTagImpl
	 * @see html.impl.HtmlPackageImpl#getDSLTag()
	 * @generated
	 */
	int DSL_TAG = 80;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSL_TAG__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSL_TAG__CONTENT = TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DSL Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSL_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link html.impl.DSLTagStructureImpl <em>DSL Tag Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see html.impl.DSLTagStructureImpl
	 * @see html.impl.HtmlPackageImpl#getDSLTagStructure()
	 * @generated
	 */
	int DSL_TAG_STRUCTURE = 81;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSL_TAG_STRUCTURE__PARAMETERS = TAG__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSL_TAG_STRUCTURE__NAME = TAG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name Close</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSL_TAG_STRUCTURE__NAME_CLOSE = TAG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSL_TAG_STRUCTURE__CONTENT = TAG_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>DSL Tag Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSL_TAG_STRUCTURE_FEATURE_COUNT = TAG_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link html.Document <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document</em>'.
	 * @see html.Document
	 * @generated
	 */
	EClass getDocument();

	/**
	 * Returns the meta object for the containment reference '{@link html.Document#getDoctype <em>Doctype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Doctype</em>'.
	 * @see html.Document#getDoctype()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Doctype();

	/**
	 * Returns the meta object for the containment reference list '{@link html.Document#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see html.Document#getParameters()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link html.Document#getWebPageBody <em>Web Page Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Web Page Body</em>'.
	 * @see html.Document#getWebPageBody()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_WebPageBody();

	/**
	 * Returns the meta object for class '{@link html.DocType <em>Doc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Doc Type</em>'.
	 * @see html.DocType
	 * @generated
	 */
	EClass getDocType();

	/**
	 * Returns the meta object for the containment reference list '{@link html.DocType#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see html.DocType#getParameters()
	 * @see #getDocType()
	 * @generated
	 */
	EReference getDocType_Parameters();

	/**
	 * Returns the meta object for class '{@link html.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see html.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link html.StringValParameter <em>String Val Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Val Parameter</em>'.
	 * @see html.StringValParameter
	 * @generated
	 */
	EClass getStringValParameter();

	/**
	 * Returns the meta object for the attribute '{@link html.StringValParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see html.StringValParameter#getName()
	 * @see #getStringValParameter()
	 * @generated
	 */
	EAttribute getStringValParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link html.StringValParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see html.StringValParameter#getValue()
	 * @see #getStringValParameter()
	 * @generated
	 */
	EAttribute getStringValParameter_Value();

	/**
	 * Returns the meta object for class '{@link html.ColorValParameter <em>Color Val Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Val Parameter</em>'.
	 * @see html.ColorValParameter
	 * @generated
	 */
	EClass getColorValParameter();

	/**
	 * Returns the meta object for the attribute '{@link html.ColorValParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see html.ColorValParameter#getName()
	 * @see #getColorValParameter()
	 * @generated
	 */
	EAttribute getColorValParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link html.ColorValParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see html.ColorValParameter#getValue()
	 * @see #getColorValParameter()
	 * @generated
	 */
	EAttribute getColorValParameter_Value();

	/**
	 * Returns the meta object for class '{@link html.IDValParameter <em>ID Val Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ID Val Parameter</em>'.
	 * @see html.IDValParameter
	 * @generated
	 */
	EClass getIDValParameter();

	/**
	 * Returns the meta object for the attribute '{@link html.IDValParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see html.IDValParameter#getName()
	 * @see #getIDValParameter()
	 * @generated
	 */
	EAttribute getIDValParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link html.IDValParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see html.IDValParameter#getValue()
	 * @see #getIDValParameter()
	 * @generated
	 */
	EAttribute getIDValParameter_Value();

	/**
	 * Returns the meta object for class '{@link html.IDParameter <em>ID Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ID Parameter</em>'.
	 * @see html.IDParameter
	 * @generated
	 */
	EClass getIDParameter();

	/**
	 * Returns the meta object for the attribute '{@link html.IDParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see html.IDParameter#getName()
	 * @see #getIDParameter()
	 * @generated
	 */
	EAttribute getIDParameter_Name();

	/**
	 * Returns the meta object for class '{@link html.StringParameter <em>String Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Parameter</em>'.
	 * @see html.StringParameter
	 * @generated
	 */
	EClass getStringParameter();

	/**
	 * Returns the meta object for the attribute '{@link html.StringParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see html.StringParameter#getName()
	 * @see #getStringParameter()
	 * @generated
	 */
	EAttribute getStringParameter_Name();

	/**
	 * Returns the meta object for class '{@link html.WebPageBody <em>Web Page Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Page Body</em>'.
	 * @see html.WebPageBody
	 * @generated
	 */
	EClass getWebPageBody();

	/**
	 * Returns the meta object for the containment reference '{@link html.WebPageBody#getHead <em>Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Head</em>'.
	 * @see html.WebPageBody#getHead()
	 * @see #getWebPageBody()
	 * @generated
	 */
	EReference getWebPageBody_Head();

	/**
	 * Returns the meta object for the containment reference list '{@link html.WebPageBody#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Body</em>'.
	 * @see html.WebPageBody#getBody()
	 * @see #getWebPageBody()
	 * @generated
	 */
	EReference getWebPageBody_Body();

	/**
	 * Returns the meta object for class '{@link html.Head <em>Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Head</em>'.
	 * @see html.Head
	 * @generated
	 */
	EClass getHead();

	/**
	 * Returns the meta object for the containment reference list '{@link html.Head#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see html.Head#getParameters()
	 * @see #getHead()
	 * @generated
	 */
	EReference getHead_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link html.Head#getHeadItems <em>Head Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Head Items</em>'.
	 * @see html.Head#getHeadItems()
	 * @see #getHead()
	 * @generated
	 */
	EReference getHead_HeadItems();

	/**
	 * Returns the meta object for class '{@link html.Body <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Body</em>'.
	 * @see html.Body
	 * @generated
	 */
	EClass getBody();

	/**
	 * Returns the meta object for the containment reference list '{@link html.Body#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see html.Body#getParameters()
	 * @see #getBody()
	 * @generated
	 */
	EReference getBody_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link html.Body#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.Body#getContent()
	 * @see #getBody()
	 * @generated
	 */
	EReference getBody_Content();

	/**
	 * Returns the meta object for class '{@link html.HeadItem <em>Head Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Head Item</em>'.
	 * @see html.HeadItem
	 * @generated
	 */
	EClass getHeadItem();

	/**
	 * Returns the meta object for the containment reference list '{@link html.HeadItem#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see html.HeadItem#getParameters()
	 * @see #getHeadItem()
	 * @generated
	 */
	EReference getHeadItem_Parameters();

	/**
	 * Returns the meta object for class '{@link html.TitleItem <em>Title Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Title Item</em>'.
	 * @see html.TitleItem
	 * @generated
	 */
	EClass getTitleItem();

	/**
	 * Returns the meta object for the containment reference '{@link html.TitleItem#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.TitleItem#getContent()
	 * @see #getTitleItem()
	 * @generated
	 */
	EReference getTitleItem_Content();

	/**
	 * Returns the meta object for class '{@link html.MetaItem <em>Meta Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Item</em>'.
	 * @see html.MetaItem
	 * @generated
	 */
	EClass getMetaItem();

	/**
	 * Returns the meta object for class '{@link html.LinkItem <em>Link Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Item</em>'.
	 * @see html.LinkItem
	 * @generated
	 */
	EClass getLinkItem();

	/**
	 * Returns the meta object for class '{@link html.BaseItem <em>Base Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Item</em>'.
	 * @see html.BaseItem
	 * @generated
	 */
	EClass getBaseItem();

	/**
	 * Returns the meta object for class '{@link html.BaseFontItem <em>Base Font Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Font Item</em>'.
	 * @see html.BaseFontItem
	 * @generated
	 */
	EClass getBaseFontItem();

	/**
	 * Returns the meta object for class '{@link html.ScriptItem <em>Script Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Item</em>'.
	 * @see html.ScriptItem
	 * @generated
	 */
	EClass getScriptItem();

	/**
	 * Returns the meta object for the containment reference '{@link html.ScriptItem#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.ScriptItem#getContent()
	 * @see #getScriptItem()
	 * @generated
	 */
	EReference getScriptItem_Content();

	/**
	 * Returns the meta object for class '{@link html.Content <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content</em>'.
	 * @see html.Content
	 * @generated
	 */
	EClass getContent();

	/**
	 * Returns the meta object for the containment reference list '{@link html.Content#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see html.Content#getParameters()
	 * @see #getContent()
	 * @generated
	 */
	EReference getContent_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link html.Content#getPContent <em>PContent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>PContent</em>'.
	 * @see html.Content#getPContent()
	 * @see #getContent()
	 * @generated
	 */
	EReference getContent_PContent();

	/**
	 * Returns the meta object for the containment reference '{@link html.Content#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.Content#getContent()
	 * @see #getContent()
	 * @generated
	 */
	EReference getContent_Content();

	/**
	 * Returns the meta object for the containment reference '{@link html.Content#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tag</em>'.
	 * @see html.Content#getTag()
	 * @see #getContent()
	 * @generated
	 */
	EReference getContent_Tag();

	/**
	 * Returns the meta object for the containment reference '{@link html.Content#getWord <em>Word</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Word</em>'.
	 * @see html.Content#getWord()
	 * @see #getContent()
	 * @generated
	 */
	EReference getContent_Word();

	/**
	 * Returns the meta object for class '{@link html.PContent <em>PContent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PContent</em>'.
	 * @see html.PContent
	 * @generated
	 */
	EClass getPContent();

	/**
	 * Returns the meta object for the containment reference '{@link html.PContent#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tag</em>'.
	 * @see html.PContent#getTag()
	 * @see #getPContent()
	 * @generated
	 */
	EReference getPContent_Tag();

	/**
	 * Returns the meta object for the containment reference '{@link html.PContent#getWord <em>Word</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Word</em>'.
	 * @see html.PContent#getWord()
	 * @see #getPContent()
	 * @generated
	 */
	EReference getPContent_Word();

	/**
	 * Returns the meta object for the containment reference '{@link html.PContent#getPContent <em>PContent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>PContent</em>'.
	 * @see html.PContent#getPContent()
	 * @see #getPContent()
	 * @generated
	 */
	EReference getPContent_PContent();

	/**
	 * Returns the meta object for class '{@link html.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag</em>'.
	 * @see html.Tag
	 * @generated
	 */
	EClass getTag();

	/**
	 * Returns the meta object for the containment reference list '{@link html.Tag#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see html.Tag#getParameters()
	 * @see #getTag()
	 * @generated
	 */
	EReference getTag_Parameters();

	/**
	 * Returns the meta object for class '{@link html.Word <em>Word</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Word</em>'.
	 * @see html.Word
	 * @generated
	 */
	EClass getWord();

	/**
	 * Returns the meta object for the attribute '{@link html.Word#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see html.Word#getContent()
	 * @see #getWord()
	 * @generated
	 */
	EAttribute getWord_Content();

	/**
	 * Returns the meta object for class '{@link html.ImageTag <em>Image Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Tag</em>'.
	 * @see html.ImageTag
	 * @generated
	 */
	EClass getImageTag();

	/**
	 * Returns the meta object for class '{@link html.BrTag <em>Br Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Br Tag</em>'.
	 * @see html.BrTag
	 * @generated
	 */
	EClass getBrTag();

	/**
	 * Returns the meta object for class '{@link html.HrTag <em>Hr Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hr Tag</em>'.
	 * @see html.HrTag
	 * @generated
	 */
	EClass getHrTag();

	/**
	 * Returns the meta object for class '{@link html.PTag <em>PTag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PTag</em>'.
	 * @see html.PTag
	 * @generated
	 */
	EClass getPTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.PTag#getPContent <em>PContent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>PContent</em>'.
	 * @see html.PTag#getPContent()
	 * @see #getPTag()
	 * @generated
	 */
	EReference getPTag_PContent();

	/**
	 * Returns the meta object for class '{@link html.H1Tag <em>H1 Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>H1 Tag</em>'.
	 * @see html.H1Tag
	 * @generated
	 */
	EClass getH1Tag();

	/**
	 * Returns the meta object for the containment reference '{@link html.H1Tag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.H1Tag#getContent()
	 * @see #getH1Tag()
	 * @generated
	 */
	EReference getH1Tag_Content();

	/**
	 * Returns the meta object for class '{@link html.H2Tag <em>H2 Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>H2 Tag</em>'.
	 * @see html.H2Tag
	 * @generated
	 */
	EClass getH2Tag();

	/**
	 * Returns the meta object for the containment reference '{@link html.H2Tag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.H2Tag#getContent()
	 * @see #getH2Tag()
	 * @generated
	 */
	EReference getH2Tag_Content();

	/**
	 * Returns the meta object for class '{@link html.H3Tag <em>H3 Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>H3 Tag</em>'.
	 * @see html.H3Tag
	 * @generated
	 */
	EClass getH3Tag();

	/**
	 * Returns the meta object for the containment reference '{@link html.H3Tag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.H3Tag#getContent()
	 * @see #getH3Tag()
	 * @generated
	 */
	EReference getH3Tag_Content();

	/**
	 * Returns the meta object for class '{@link html.H4Tag <em>H4 Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>H4 Tag</em>'.
	 * @see html.H4Tag
	 * @generated
	 */
	EClass getH4Tag();

	/**
	 * Returns the meta object for the containment reference '{@link html.H4Tag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.H4Tag#getContent()
	 * @see #getH4Tag()
	 * @generated
	 */
	EReference getH4Tag_Content();

	/**
	 * Returns the meta object for class '{@link html.H5Tag <em>H5 Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>H5 Tag</em>'.
	 * @see html.H5Tag
	 * @generated
	 */
	EClass getH5Tag();

	/**
	 * Returns the meta object for the containment reference '{@link html.H5Tag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.H5Tag#getContent()
	 * @see #getH5Tag()
	 * @generated
	 */
	EReference getH5Tag_Content();

	/**
	 * Returns the meta object for class '{@link html.H6Tag <em>H6 Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>H6 Tag</em>'.
	 * @see html.H6Tag
	 * @generated
	 */
	EClass getH6Tag();

	/**
	 * Returns the meta object for the containment reference '{@link html.H6Tag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.H6Tag#getContent()
	 * @see #getH6Tag()
	 * @generated
	 */
	EReference getH6Tag_Content();

	/**
	 * Returns the meta object for class '{@link html.ATag <em>ATag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ATag</em>'.
	 * @see html.ATag
	 * @generated
	 */
	EClass getATag();

	/**
	 * Returns the meta object for the containment reference '{@link html.ATag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.ATag#getContent()
	 * @see #getATag()
	 * @generated
	 */
	EReference getATag_Content();

	/**
	 * Returns the meta object for class '{@link html.MapTag <em>Map Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Tag</em>'.
	 * @see html.MapTag
	 * @generated
	 */
	EClass getMapTag();

	/**
	 * Returns the meta object for the containment reference list '{@link html.MapTag#getMapItems <em>Map Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Map Items</em>'.
	 * @see html.MapTag#getMapItems()
	 * @see #getMapTag()
	 * @generated
	 */
	EReference getMapTag_MapItems();

	/**
	 * Returns the meta object for class '{@link html.BTag <em>BTag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BTag</em>'.
	 * @see html.BTag
	 * @generated
	 */
	EClass getBTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.BTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.BTag#getContent()
	 * @see #getBTag()
	 * @generated
	 */
	EReference getBTag_Content();

	/**
	 * Returns the meta object for class '{@link html.UTag <em>UTag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UTag</em>'.
	 * @see html.UTag
	 * @generated
	 */
	EClass getUTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.UTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.UTag#getContent()
	 * @see #getUTag()
	 * @generated
	 */
	EReference getUTag_Content();

	/**
	 * Returns the meta object for class '{@link html.EmTag <em>Em Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Em Tag</em>'.
	 * @see html.EmTag
	 * @generated
	 */
	EClass getEmTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.EmTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.EmTag#getContent()
	 * @see #getEmTag()
	 * @generated
	 */
	EReference getEmTag_Content();

	/**
	 * Returns the meta object for class '{@link html.ITag <em>ITag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ITag</em>'.
	 * @see html.ITag
	 * @generated
	 */
	EClass getITag();

	/**
	 * Returns the meta object for the containment reference '{@link html.ITag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.ITag#getContent()
	 * @see #getITag()
	 * @generated
	 */
	EReference getITag_Content();

	/**
	 * Returns the meta object for class '{@link html.StrikeTag <em>Strike Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strike Tag</em>'.
	 * @see html.StrikeTag
	 * @generated
	 */
	EClass getStrikeTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.StrikeTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.StrikeTag#getContent()
	 * @see #getStrikeTag()
	 * @generated
	 */
	EReference getStrikeTag_Content();

	/**
	 * Returns the meta object for class '{@link html.StrongTag <em>Strong Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strong Tag</em>'.
	 * @see html.StrongTag
	 * @generated
	 */
	EClass getStrongTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.StrongTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.StrongTag#getContent()
	 * @see #getStrongTag()
	 * @generated
	 */
	EReference getStrongTag_Content();

	/**
	 * Returns the meta object for class '{@link html.FontTag <em>Font Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font Tag</em>'.
	 * @see html.FontTag
	 * @generated
	 */
	EClass getFontTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.FontTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.FontTag#getContent()
	 * @see #getFontTag()
	 * @generated
	 */
	EReference getFontTag_Content();

	/**
	 * Returns the meta object for class '{@link html.BigTag <em>Big Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Big Tag</em>'.
	 * @see html.BigTag
	 * @generated
	 */
	EClass getBigTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.BigTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.BigTag#getContent()
	 * @see #getBigTag()
	 * @generated
	 */
	EReference getBigTag_Content();

	/**
	 * Returns the meta object for class '{@link html.SmallTag <em>Small Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Small Tag</em>'.
	 * @see html.SmallTag
	 * @generated
	 */
	EClass getSmallTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.SmallTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.SmallTag#getContent()
	 * @see #getSmallTag()
	 * @generated
	 */
	EReference getSmallTag_Content();

	/**
	 * Returns the meta object for class '{@link html.SupTag <em>Sup Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sup Tag</em>'.
	 * @see html.SupTag
	 * @generated
	 */
	EClass getSupTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.SupTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.SupTag#getContent()
	 * @see #getSupTag()
	 * @generated
	 */
	EReference getSupTag_Content();

	/**
	 * Returns the meta object for class '{@link html.SubTag <em>Sub Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Tag</em>'.
	 * @see html.SubTag
	 * @generated
	 */
	EClass getSubTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.SubTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.SubTag#getContent()
	 * @see #getSubTag()
	 * @generated
	 */
	EReference getSubTag_Content();

	/**
	 * Returns the meta object for class '{@link html.BlockQuoteTag <em>Block Quote Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Quote Tag</em>'.
	 * @see html.BlockQuoteTag
	 * @generated
	 */
	EClass getBlockQuoteTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.BlockQuoteTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.BlockQuoteTag#getContent()
	 * @see #getBlockQuoteTag()
	 * @generated
	 */
	EReference getBlockQuoteTag_Content();

	/**
	 * Returns the meta object for class '{@link html.AddressTag <em>Address Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address Tag</em>'.
	 * @see html.AddressTag
	 * @generated
	 */
	EClass getAddressTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.AddressTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.AddressTag#getContent()
	 * @see #getAddressTag()
	 * @generated
	 */
	EReference getAddressTag_Content();

	/**
	 * Returns the meta object for class '{@link html.CodeTag <em>Code Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Tag</em>'.
	 * @see html.CodeTag
	 * @generated
	 */
	EClass getCodeTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.CodeTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.CodeTag#getContent()
	 * @see #getCodeTag()
	 * @generated
	 */
	EReference getCodeTag_Content();

	/**
	 * Returns the meta object for class '{@link html.CiteTag <em>Cite Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cite Tag</em>'.
	 * @see html.CiteTag
	 * @generated
	 */
	EClass getCiteTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.CiteTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.CiteTag#getContent()
	 * @see #getCiteTag()
	 * @generated
	 */
	EReference getCiteTag_Content();

	/**
	 * Returns the meta object for class '{@link html.CaptionTag <em>Caption Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Caption Tag</em>'.
	 * @see html.CaptionTag
	 * @generated
	 */
	EClass getCaptionTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.CaptionTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.CaptionTag#getContent()
	 * @see #getCaptionTag()
	 * @generated
	 */
	EReference getCaptionTag_Content();

	/**
	 * Returns the meta object for class '{@link html.SampTag <em>Samp Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Samp Tag</em>'.
	 * @see html.SampTag
	 * @generated
	 */
	EClass getSampTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.SampTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.SampTag#getContent()
	 * @see #getSampTag()
	 * @generated
	 */
	EReference getSampTag_Content();

	/**
	 * Returns the meta object for class '{@link html.KbdTag <em>Kbd Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Kbd Tag</em>'.
	 * @see html.KbdTag
	 * @generated
	 */
	EClass getKbdTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.KbdTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.KbdTag#getContent()
	 * @see #getKbdTag()
	 * @generated
	 */
	EReference getKbdTag_Content();

	/**
	 * Returns the meta object for class '{@link html.TtTag <em>Tt Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tt Tag</em>'.
	 * @see html.TtTag
	 * @generated
	 */
	EClass getTtTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.TtTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.TtTag#getContent()
	 * @see #getTtTag()
	 * @generated
	 */
	EReference getTtTag_Content();

	/**
	 * Returns the meta object for class '{@link html.CenterTag <em>Center Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Center Tag</em>'.
	 * @see html.CenterTag
	 * @generated
	 */
	EClass getCenterTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.CenterTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.CenterTag#getContent()
	 * @see #getCenterTag()
	 * @generated
	 */
	EReference getCenterTag_Content();

	/**
	 * Returns the meta object for class '{@link html.SpanTag <em>Span Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Span Tag</em>'.
	 * @see html.SpanTag
	 * @generated
	 */
	EClass getSpanTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.SpanTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.SpanTag#getContent()
	 * @see #getSpanTag()
	 * @generated
	 */
	EReference getSpanTag_Content();

	/**
	 * Returns the meta object for class '{@link html.DivTag <em>Div Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Div Tag</em>'.
	 * @see html.DivTag
	 * @generated
	 */
	EClass getDivTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.DivTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.DivTag#getContent()
	 * @see #getDivTag()
	 * @generated
	 */
	EReference getDivTag_Content();

	/**
	 * Returns the meta object for class '{@link html.AppletTag <em>Applet Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Applet Tag</em>'.
	 * @see html.AppletTag
	 * @generated
	 */
	EClass getAppletTag();

	/**
	 * Returns the meta object for the containment reference list '{@link html.AppletTag#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see html.AppletTag#getParams()
	 * @see #getAppletTag()
	 * @generated
	 */
	EReference getAppletTag_Params();

	/**
	 * Returns the meta object for class '{@link html.ObjectTag <em>Object Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Tag</em>'.
	 * @see html.ObjectTag
	 * @generated
	 */
	EClass getObjectTag();

	/**
	 * Returns the meta object for the containment reference list '{@link html.ObjectTag#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see html.ObjectTag#getParams()
	 * @see #getObjectTag()
	 * @generated
	 */
	EReference getObjectTag_Params();

	/**
	 * Returns the meta object for class '{@link html.TableTag <em>Table Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Tag</em>'.
	 * @see html.TableTag
	 * @generated
	 */
	EClass getTableTag();

	/**
	 * Returns the meta object for the containment reference list '{@link html.TableTag#getTableRows <em>Table Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Table Rows</em>'.
	 * @see html.TableTag#getTableRows()
	 * @see #getTableTag()
	 * @generated
	 */
	EReference getTableTag_TableRows();

	/**
	 * Returns the meta object for class '{@link html.UITag <em>UI Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Tag</em>'.
	 * @see html.UITag
	 * @generated
	 */
	EClass getUITag();

	/**
	 * Returns the meta object for the containment reference list '{@link html.UITag#getListItems <em>List Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>List Items</em>'.
	 * @see html.UITag#getListItems()
	 * @see #getUITag()
	 * @generated
	 */
	EReference getUITag_ListItems();

	/**
	 * Returns the meta object for class '{@link html.OlTag <em>Ol Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ol Tag</em>'.
	 * @see html.OlTag
	 * @generated
	 */
	EClass getOlTag();

	/**
	 * Returns the meta object for the containment reference list '{@link html.OlTag#getListItems <em>List Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>List Items</em>'.
	 * @see html.OlTag#getListItems()
	 * @see #getOlTag()
	 * @generated
	 */
	EReference getOlTag_ListItems();

	/**
	 * Returns the meta object for class '{@link html.DirTag <em>Dir Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dir Tag</em>'.
	 * @see html.DirTag
	 * @generated
	 */
	EClass getDirTag();

	/**
	 * Returns the meta object for the containment reference list '{@link html.DirTag#getListItems <em>List Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>List Items</em>'.
	 * @see html.DirTag#getListItems()
	 * @see #getDirTag()
	 * @generated
	 */
	EReference getDirTag_ListItems();

	/**
	 * Returns the meta object for class '{@link html.Menutag <em>Menutag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menutag</em>'.
	 * @see html.Menutag
	 * @generated
	 */
	EClass getMenutag();

	/**
	 * Returns the meta object for the containment reference list '{@link html.Menutag#getListItems <em>List Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>List Items</em>'.
	 * @see html.Menutag#getListItems()
	 * @see #getMenutag()
	 * @generated
	 */
	EReference getMenutag_ListItems();

	/**
	 * Returns the meta object for class '{@link html.DlTag <em>Dl Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dl Tag</em>'.
	 * @see html.DlTag
	 * @generated
	 */
	EClass getDlTag();

	/**
	 * Returns the meta object for the containment reference list '{@link html.DlTag#getDefItems <em>Def Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Def Items</em>'.
	 * @see html.DlTag#getDefItems()
	 * @see #getDlTag()
	 * @generated
	 */
	EReference getDlTag_DefItems();

	/**
	 * Returns the meta object for class '{@link html.FormTag <em>Form Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Form Tag</em>'.
	 * @see html.FormTag
	 * @generated
	 */
	EClass getFormTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.FormTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.FormTag#getContent()
	 * @see #getFormTag()
	 * @generated
	 */
	EReference getFormTag_Content();

	/**
	 * Returns the meta object for class '{@link html.InputTag <em>Input Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Tag</em>'.
	 * @see html.InputTag
	 * @generated
	 */
	EClass getInputTag();

	/**
	 * Returns the meta object for class '{@link html.SelectTag <em>Select Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select Tag</em>'.
	 * @see html.SelectTag
	 * @generated
	 */
	EClass getSelectTag();

	/**
	 * Returns the meta object for the containment reference list '{@link html.SelectTag#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see html.SelectTag#getOptions()
	 * @see #getSelectTag()
	 * @generated
	 */
	EReference getSelectTag_Options();

	/**
	 * Returns the meta object for class '{@link html.TextAreaTag <em>Text Area Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Area Tag</em>'.
	 * @see html.TextAreaTag
	 * @generated
	 */
	EClass getTextAreaTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.TextAreaTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.TextAreaTag#getContent()
	 * @see #getTextAreaTag()
	 * @generated
	 */
	EReference getTextAreaTag_Content();

	/**
	 * Returns the meta object for class '{@link html.TableRow <em>Table Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Row</em>'.
	 * @see html.TableRow
	 * @generated
	 */
	EClass getTableRow();

	/**
	 * Returns the meta object for the containment reference list '{@link html.TableRow#getTableCells <em>Table Cells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Table Cells</em>'.
	 * @see html.TableRow#getTableCells()
	 * @see #getTableRow()
	 * @generated
	 */
	EReference getTableRow_TableCells();

	/**
	 * Returns the meta object for the containment reference list '{@link html.TableRow#getTableRows <em>Table Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Table Rows</em>'.
	 * @see html.TableRow#getTableRows()
	 * @see #getTableRow()
	 * @generated
	 */
	EReference getTableRow_TableRows();

	/**
	 * Returns the meta object for class '{@link html.TableCell <em>Table Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Cell</em>'.
	 * @see html.TableCell
	 * @generated
	 */
	EClass getTableCell();

	/**
	 * Returns the meta object for the containment reference '{@link html.TableCell#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.TableCell#getContent()
	 * @see #getTableCell()
	 * @generated
	 */
	EReference getTableCell_Content();

	/**
	 * Returns the meta object for class '{@link html.TDTableCell <em>TD Table Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TD Table Cell</em>'.
	 * @see html.TDTableCell
	 * @generated
	 */
	EClass getTDTableCell();

	/**
	 * Returns the meta object for class '{@link html.THTableCell <em>TH Table Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TH Table Cell</em>'.
	 * @see html.THTableCell
	 * @generated
	 */
	EClass getTHTableCell();

	/**
	 * Returns the meta object for class '{@link html.DefItem <em>Def Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Def Item</em>'.
	 * @see html.DefItem
	 * @generated
	 */
	EClass getDefItem();

	/**
	 * Returns the meta object for the containment reference list '{@link html.DefItem#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see html.DefItem#getParameters()
	 * @see #getDefItem()
	 * @generated
	 */
	EReference getDefItem_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link html.DefItem#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.DefItem#getContent()
	 * @see #getDefItem()
	 * @generated
	 */
	EReference getDefItem_Content();

	/**
	 * Returns the meta object for class '{@link html.DdItem <em>Dd Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dd Item</em>'.
	 * @see html.DdItem
	 * @generated
	 */
	EClass getDdItem();

	/**
	 * Returns the meta object for class '{@link html.DtItem <em>Dt Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dt Item</em>'.
	 * @see html.DtItem
	 * @generated
	 */
	EClass getDtItem();

	/**
	 * Returns the meta object for class '{@link html.ListItem <em>List Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Item</em>'.
	 * @see html.ListItem
	 * @generated
	 */
	EClass getListItem();

	/**
	 * Returns the meta object for the containment reference list '{@link html.ListItem#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see html.ListItem#getParameters()
	 * @see #getListItem()
	 * @generated
	 */
	EReference getListItem_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link html.ListItem#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.ListItem#getContent()
	 * @see #getListItem()
	 * @generated
	 */
	EReference getListItem_Content();

	/**
	 * Returns the meta object for class '{@link html.Option <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option</em>'.
	 * @see html.Option
	 * @generated
	 */
	EClass getOption();

	/**
	 * Returns the meta object for the containment reference list '{@link html.Option#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see html.Option#getParameters()
	 * @see #getOption()
	 * @generated
	 */
	EReference getOption_Parameters();

	/**
	 * Returns the meta object for class '{@link html.MapItem <em>Map Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Item</em>'.
	 * @see html.MapItem
	 * @generated
	 */
	EClass getMapItem();

	/**
	 * Returns the meta object for the containment reference '{@link html.MapItem#getArea <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Area</em>'.
	 * @see html.MapItem#getArea()
	 * @see #getMapItem()
	 * @generated
	 */
	EReference getMapItem_Area();

	/**
	 * Returns the meta object for the containment reference list '{@link html.MapItem#getMapItems <em>Map Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Map Items</em>'.
	 * @see html.MapItem#getMapItems()
	 * @see #getMapItem()
	 * @generated
	 */
	EReference getMapItem_MapItems();

	/**
	 * Returns the meta object for class '{@link html.Area <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area</em>'.
	 * @see html.Area
	 * @generated
	 */
	EClass getArea();

	/**
	 * Returns the meta object for the containment reference list '{@link html.Area#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see html.Area#getParameters()
	 * @see #getArea()
	 * @generated
	 */
	EReference getArea_Parameters();

	/**
	 * Returns the meta object for class '{@link html.Param <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param</em>'.
	 * @see html.Param
	 * @generated
	 */
	EClass getParam();

	/**
	 * Returns the meta object for the containment reference list '{@link html.Param#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see html.Param#getParameters()
	 * @see #getParam()
	 * @generated
	 */
	EReference getParam_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link html.Param#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see html.Param#getParams()
	 * @see #getParam()
	 * @generated
	 */
	EReference getParam_Params();

	/**
	 * Returns the meta object for class '{@link html.DSLTag <em>DSL Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSL Tag</em>'.
	 * @see html.DSLTag
	 * @generated
	 */
	EClass getDSLTag();

	/**
	 * Returns the meta object for the containment reference '{@link html.DSLTag#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.DSLTag#getContent()
	 * @see #getDSLTag()
	 * @generated
	 */
	EReference getDSLTag_Content();

	/**
	 * Returns the meta object for class '{@link html.DSLTagStructure <em>DSL Tag Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSL Tag Structure</em>'.
	 * @see html.DSLTagStructure
	 * @generated
	 */
	EClass getDSLTagStructure();

	/**
	 * Returns the meta object for the attribute '{@link html.DSLTagStructure#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see html.DSLTagStructure#getName()
	 * @see #getDSLTagStructure()
	 * @generated
	 */
	EAttribute getDSLTagStructure_Name();

	/**
	 * Returns the meta object for the attribute '{@link html.DSLTagStructure#getNameClose <em>Name Close</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Close</em>'.
	 * @see html.DSLTagStructure#getNameClose()
	 * @see #getDSLTagStructure()
	 * @generated
	 */
	EAttribute getDSLTagStructure_NameClose();

	/**
	 * Returns the meta object for the containment reference '{@link html.DSLTagStructure#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see html.DSLTagStructure#getContent()
	 * @see #getDSLTagStructure()
	 * @generated
	 */
	EReference getDSLTagStructure_Content();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HtmlFactory getHtmlFactory();

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
		 * The meta object literal for the '{@link html.impl.DocumentImpl <em>Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.DocumentImpl
		 * @see html.impl.HtmlPackageImpl#getDocument()
		 * @generated
		 */
		EClass DOCUMENT = eINSTANCE.getDocument();

		/**
		 * The meta object literal for the '<em><b>Doctype</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__DOCTYPE = eINSTANCE.getDocument_Doctype();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__PARAMETERS = eINSTANCE.getDocument_Parameters();

		/**
		 * The meta object literal for the '<em><b>Web Page Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__WEB_PAGE_BODY = eINSTANCE.getDocument_WebPageBody();

		/**
		 * The meta object literal for the '{@link html.impl.DocTypeImpl <em>Doc Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.DocTypeImpl
		 * @see html.impl.HtmlPackageImpl#getDocType()
		 * @generated
		 */
		EClass DOC_TYPE = eINSTANCE.getDocType();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOC_TYPE__PARAMETERS = eINSTANCE.getDocType_Parameters();

		/**
		 * The meta object literal for the '{@link html.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.ParameterImpl
		 * @see html.impl.HtmlPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link html.impl.StringValParameterImpl <em>String Val Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.StringValParameterImpl
		 * @see html.impl.HtmlPackageImpl#getStringValParameter()
		 * @generated
		 */
		EClass STRING_VAL_PARAMETER = eINSTANCE.getStringValParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_VAL_PARAMETER__NAME = eINSTANCE.getStringValParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_VAL_PARAMETER__VALUE = eINSTANCE.getStringValParameter_Value();

		/**
		 * The meta object literal for the '{@link html.impl.ColorValParameterImpl <em>Color Val Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.ColorValParameterImpl
		 * @see html.impl.HtmlPackageImpl#getColorValParameter()
		 * @generated
		 */
		EClass COLOR_VAL_PARAMETER = eINSTANCE.getColorValParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_VAL_PARAMETER__NAME = eINSTANCE.getColorValParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_VAL_PARAMETER__VALUE = eINSTANCE.getColorValParameter_Value();

		/**
		 * The meta object literal for the '{@link html.impl.IDValParameterImpl <em>ID Val Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.IDValParameterImpl
		 * @see html.impl.HtmlPackageImpl#getIDValParameter()
		 * @generated
		 */
		EClass ID_VAL_PARAMETER = eINSTANCE.getIDValParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ID_VAL_PARAMETER__NAME = eINSTANCE.getIDValParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ID_VAL_PARAMETER__VALUE = eINSTANCE.getIDValParameter_Value();

		/**
		 * The meta object literal for the '{@link html.impl.IDParameterImpl <em>ID Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.IDParameterImpl
		 * @see html.impl.HtmlPackageImpl#getIDParameter()
		 * @generated
		 */
		EClass ID_PARAMETER = eINSTANCE.getIDParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ID_PARAMETER__NAME = eINSTANCE.getIDParameter_Name();

		/**
		 * The meta object literal for the '{@link html.impl.StringParameterImpl <em>String Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.StringParameterImpl
		 * @see html.impl.HtmlPackageImpl#getStringParameter()
		 * @generated
		 */
		EClass STRING_PARAMETER = eINSTANCE.getStringParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_PARAMETER__NAME = eINSTANCE.getStringParameter_Name();

		/**
		 * The meta object literal for the '{@link html.impl.WebPageBodyImpl <em>Web Page Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.WebPageBodyImpl
		 * @see html.impl.HtmlPackageImpl#getWebPageBody()
		 * @generated
		 */
		EClass WEB_PAGE_BODY = eINSTANCE.getWebPageBody();

		/**
		 * The meta object literal for the '<em><b>Head</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WEB_PAGE_BODY__HEAD = eINSTANCE.getWebPageBody_Head();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WEB_PAGE_BODY__BODY = eINSTANCE.getWebPageBody_Body();

		/**
		 * The meta object literal for the '{@link html.impl.HeadImpl <em>Head</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.HeadImpl
		 * @see html.impl.HtmlPackageImpl#getHead()
		 * @generated
		 */
		EClass HEAD = eINSTANCE.getHead();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HEAD__PARAMETERS = eINSTANCE.getHead_Parameters();

		/**
		 * The meta object literal for the '<em><b>Head Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HEAD__HEAD_ITEMS = eINSTANCE.getHead_HeadItems();

		/**
		 * The meta object literal for the '{@link html.impl.BodyImpl <em>Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.BodyImpl
		 * @see html.impl.HtmlPackageImpl#getBody()
		 * @generated
		 */
		EClass BODY = eINSTANCE.getBody();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BODY__PARAMETERS = eINSTANCE.getBody_Parameters();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BODY__CONTENT = eINSTANCE.getBody_Content();

		/**
		 * The meta object literal for the '{@link html.impl.HeadItemImpl <em>Head Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.HeadItemImpl
		 * @see html.impl.HtmlPackageImpl#getHeadItem()
		 * @generated
		 */
		EClass HEAD_ITEM = eINSTANCE.getHeadItem();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HEAD_ITEM__PARAMETERS = eINSTANCE.getHeadItem_Parameters();

		/**
		 * The meta object literal for the '{@link html.impl.TitleItemImpl <em>Title Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.TitleItemImpl
		 * @see html.impl.HtmlPackageImpl#getTitleItem()
		 * @generated
		 */
		EClass TITLE_ITEM = eINSTANCE.getTitleItem();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TITLE_ITEM__CONTENT = eINSTANCE.getTitleItem_Content();

		/**
		 * The meta object literal for the '{@link html.impl.MetaItemImpl <em>Meta Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.MetaItemImpl
		 * @see html.impl.HtmlPackageImpl#getMetaItem()
		 * @generated
		 */
		EClass META_ITEM = eINSTANCE.getMetaItem();

		/**
		 * The meta object literal for the '{@link html.impl.LinkItemImpl <em>Link Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.LinkItemImpl
		 * @see html.impl.HtmlPackageImpl#getLinkItem()
		 * @generated
		 */
		EClass LINK_ITEM = eINSTANCE.getLinkItem();

		/**
		 * The meta object literal for the '{@link html.impl.BaseItemImpl <em>Base Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.BaseItemImpl
		 * @see html.impl.HtmlPackageImpl#getBaseItem()
		 * @generated
		 */
		EClass BASE_ITEM = eINSTANCE.getBaseItem();

		/**
		 * The meta object literal for the '{@link html.impl.BaseFontItemImpl <em>Base Font Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.BaseFontItemImpl
		 * @see html.impl.HtmlPackageImpl#getBaseFontItem()
		 * @generated
		 */
		EClass BASE_FONT_ITEM = eINSTANCE.getBaseFontItem();

		/**
		 * The meta object literal for the '{@link html.impl.ScriptItemImpl <em>Script Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.ScriptItemImpl
		 * @see html.impl.HtmlPackageImpl#getScriptItem()
		 * @generated
		 */
		EClass SCRIPT_ITEM = eINSTANCE.getScriptItem();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_ITEM__CONTENT = eINSTANCE.getScriptItem_Content();

		/**
		 * The meta object literal for the '{@link html.impl.ContentImpl <em>Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.ContentImpl
		 * @see html.impl.HtmlPackageImpl#getContent()
		 * @generated
		 */
		EClass CONTENT = eINSTANCE.getContent();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTENT__PARAMETERS = eINSTANCE.getContent_Parameters();

		/**
		 * The meta object literal for the '<em><b>PContent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTENT__PCONTENT = eINSTANCE.getContent_PContent();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTENT__CONTENT = eINSTANCE.getContent_Content();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTENT__TAG = eINSTANCE.getContent_Tag();

		/**
		 * The meta object literal for the '<em><b>Word</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTENT__WORD = eINSTANCE.getContent_Word();

		/**
		 * The meta object literal for the '{@link html.impl.PContentImpl <em>PContent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.PContentImpl
		 * @see html.impl.HtmlPackageImpl#getPContent()
		 * @generated
		 */
		EClass PCONTENT = eINSTANCE.getPContent();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCONTENT__TAG = eINSTANCE.getPContent_Tag();

		/**
		 * The meta object literal for the '<em><b>Word</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCONTENT__WORD = eINSTANCE.getPContent_Word();

		/**
		 * The meta object literal for the '<em><b>PContent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCONTENT__PCONTENT = eINSTANCE.getPContent_PContent();

		/**
		 * The meta object literal for the '{@link html.impl.TagImpl <em>Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.TagImpl
		 * @see html.impl.HtmlPackageImpl#getTag()
		 * @generated
		 */
		EClass TAG = eINSTANCE.getTag();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG__PARAMETERS = eINSTANCE.getTag_Parameters();

		/**
		 * The meta object literal for the '{@link html.impl.WordImpl <em>Word</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.WordImpl
		 * @see html.impl.HtmlPackageImpl#getWord()
		 * @generated
		 */
		EClass WORD = eINSTANCE.getWord();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORD__CONTENT = eINSTANCE.getWord_Content();

		/**
		 * The meta object literal for the '{@link html.impl.ImageTagImpl <em>Image Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.ImageTagImpl
		 * @see html.impl.HtmlPackageImpl#getImageTag()
		 * @generated
		 */
		EClass IMAGE_TAG = eINSTANCE.getImageTag();

		/**
		 * The meta object literal for the '{@link html.impl.BrTagImpl <em>Br Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.BrTagImpl
		 * @see html.impl.HtmlPackageImpl#getBrTag()
		 * @generated
		 */
		EClass BR_TAG = eINSTANCE.getBrTag();

		/**
		 * The meta object literal for the '{@link html.impl.HrTagImpl <em>Hr Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.HrTagImpl
		 * @see html.impl.HtmlPackageImpl#getHrTag()
		 * @generated
		 */
		EClass HR_TAG = eINSTANCE.getHrTag();

		/**
		 * The meta object literal for the '{@link html.impl.PTagImpl <em>PTag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.PTagImpl
		 * @see html.impl.HtmlPackageImpl#getPTag()
		 * @generated
		 */
		EClass PTAG = eINSTANCE.getPTag();

		/**
		 * The meta object literal for the '<em><b>PContent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PTAG__PCONTENT = eINSTANCE.getPTag_PContent();

		/**
		 * The meta object literal for the '{@link html.impl.H1TagImpl <em>H1 Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.H1TagImpl
		 * @see html.impl.HtmlPackageImpl#getH1Tag()
		 * @generated
		 */
		EClass H1_TAG = eINSTANCE.getH1Tag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference H1_TAG__CONTENT = eINSTANCE.getH1Tag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.H2TagImpl <em>H2 Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.H2TagImpl
		 * @see html.impl.HtmlPackageImpl#getH2Tag()
		 * @generated
		 */
		EClass H2_TAG = eINSTANCE.getH2Tag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference H2_TAG__CONTENT = eINSTANCE.getH2Tag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.H3TagImpl <em>H3 Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.H3TagImpl
		 * @see html.impl.HtmlPackageImpl#getH3Tag()
		 * @generated
		 */
		EClass H3_TAG = eINSTANCE.getH3Tag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference H3_TAG__CONTENT = eINSTANCE.getH3Tag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.H4TagImpl <em>H4 Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.H4TagImpl
		 * @see html.impl.HtmlPackageImpl#getH4Tag()
		 * @generated
		 */
		EClass H4_TAG = eINSTANCE.getH4Tag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference H4_TAG__CONTENT = eINSTANCE.getH4Tag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.H5TagImpl <em>H5 Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.H5TagImpl
		 * @see html.impl.HtmlPackageImpl#getH5Tag()
		 * @generated
		 */
		EClass H5_TAG = eINSTANCE.getH5Tag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference H5_TAG__CONTENT = eINSTANCE.getH5Tag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.H6TagImpl <em>H6 Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.H6TagImpl
		 * @see html.impl.HtmlPackageImpl#getH6Tag()
		 * @generated
		 */
		EClass H6_TAG = eINSTANCE.getH6Tag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference H6_TAG__CONTENT = eINSTANCE.getH6Tag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.ATagImpl <em>ATag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.ATagImpl
		 * @see html.impl.HtmlPackageImpl#getATag()
		 * @generated
		 */
		EClass ATAG = eINSTANCE.getATag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATAG__CONTENT = eINSTANCE.getATag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.MapTagImpl <em>Map Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.MapTagImpl
		 * @see html.impl.HtmlPackageImpl#getMapTag()
		 * @generated
		 */
		EClass MAP_TAG = eINSTANCE.getMapTag();

		/**
		 * The meta object literal for the '<em><b>Map Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_TAG__MAP_ITEMS = eINSTANCE.getMapTag_MapItems();

		/**
		 * The meta object literal for the '{@link html.impl.BTagImpl <em>BTag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.BTagImpl
		 * @see html.impl.HtmlPackageImpl#getBTag()
		 * @generated
		 */
		EClass BTAG = eINSTANCE.getBTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BTAG__CONTENT = eINSTANCE.getBTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.UTagImpl <em>UTag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.UTagImpl
		 * @see html.impl.HtmlPackageImpl#getUTag()
		 * @generated
		 */
		EClass UTAG = eINSTANCE.getUTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UTAG__CONTENT = eINSTANCE.getUTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.EmTagImpl <em>Em Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.EmTagImpl
		 * @see html.impl.HtmlPackageImpl#getEmTag()
		 * @generated
		 */
		EClass EM_TAG = eINSTANCE.getEmTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EM_TAG__CONTENT = eINSTANCE.getEmTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.ITagImpl <em>ITag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.ITagImpl
		 * @see html.impl.HtmlPackageImpl#getITag()
		 * @generated
		 */
		EClass ITAG = eINSTANCE.getITag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITAG__CONTENT = eINSTANCE.getITag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.StrikeTagImpl <em>Strike Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.StrikeTagImpl
		 * @see html.impl.HtmlPackageImpl#getStrikeTag()
		 * @generated
		 */
		EClass STRIKE_TAG = eINSTANCE.getStrikeTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRIKE_TAG__CONTENT = eINSTANCE.getStrikeTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.StrongTagImpl <em>Strong Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.StrongTagImpl
		 * @see html.impl.HtmlPackageImpl#getStrongTag()
		 * @generated
		 */
		EClass STRONG_TAG = eINSTANCE.getStrongTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRONG_TAG__CONTENT = eINSTANCE.getStrongTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.FontTagImpl <em>Font Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.FontTagImpl
		 * @see html.impl.HtmlPackageImpl#getFontTag()
		 * @generated
		 */
		EClass FONT_TAG = eINSTANCE.getFontTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FONT_TAG__CONTENT = eINSTANCE.getFontTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.BigTagImpl <em>Big Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.BigTagImpl
		 * @see html.impl.HtmlPackageImpl#getBigTag()
		 * @generated
		 */
		EClass BIG_TAG = eINSTANCE.getBigTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIG_TAG__CONTENT = eINSTANCE.getBigTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.SmallTagImpl <em>Small Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.SmallTagImpl
		 * @see html.impl.HtmlPackageImpl#getSmallTag()
		 * @generated
		 */
		EClass SMALL_TAG = eINSTANCE.getSmallTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMALL_TAG__CONTENT = eINSTANCE.getSmallTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.SupTagImpl <em>Sup Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.SupTagImpl
		 * @see html.impl.HtmlPackageImpl#getSupTag()
		 * @generated
		 */
		EClass SUP_TAG = eINSTANCE.getSupTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUP_TAG__CONTENT = eINSTANCE.getSupTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.SubTagImpl <em>Sub Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.SubTagImpl
		 * @see html.impl.HtmlPackageImpl#getSubTag()
		 * @generated
		 */
		EClass SUB_TAG = eINSTANCE.getSubTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_TAG__CONTENT = eINSTANCE.getSubTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.BlockQuoteTagImpl <em>Block Quote Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.BlockQuoteTagImpl
		 * @see html.impl.HtmlPackageImpl#getBlockQuoteTag()
		 * @generated
		 */
		EClass BLOCK_QUOTE_TAG = eINSTANCE.getBlockQuoteTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_QUOTE_TAG__CONTENT = eINSTANCE.getBlockQuoteTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.AddressTagImpl <em>Address Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.AddressTagImpl
		 * @see html.impl.HtmlPackageImpl#getAddressTag()
		 * @generated
		 */
		EClass ADDRESS_TAG = eINSTANCE.getAddressTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDRESS_TAG__CONTENT = eINSTANCE.getAddressTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.CodeTagImpl <em>Code Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.CodeTagImpl
		 * @see html.impl.HtmlPackageImpl#getCodeTag()
		 * @generated
		 */
		EClass CODE_TAG = eINSTANCE.getCodeTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_TAG__CONTENT = eINSTANCE.getCodeTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.CiteTagImpl <em>Cite Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.CiteTagImpl
		 * @see html.impl.HtmlPackageImpl#getCiteTag()
		 * @generated
		 */
		EClass CITE_TAG = eINSTANCE.getCiteTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CITE_TAG__CONTENT = eINSTANCE.getCiteTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.CaptionTagImpl <em>Caption Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.CaptionTagImpl
		 * @see html.impl.HtmlPackageImpl#getCaptionTag()
		 * @generated
		 */
		EClass CAPTION_TAG = eINSTANCE.getCaptionTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPTION_TAG__CONTENT = eINSTANCE.getCaptionTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.SampTagImpl <em>Samp Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.SampTagImpl
		 * @see html.impl.HtmlPackageImpl#getSampTag()
		 * @generated
		 */
		EClass SAMP_TAG = eINSTANCE.getSampTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAMP_TAG__CONTENT = eINSTANCE.getSampTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.KbdTagImpl <em>Kbd Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.KbdTagImpl
		 * @see html.impl.HtmlPackageImpl#getKbdTag()
		 * @generated
		 */
		EClass KBD_TAG = eINSTANCE.getKbdTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KBD_TAG__CONTENT = eINSTANCE.getKbdTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.TtTagImpl <em>Tt Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.TtTagImpl
		 * @see html.impl.HtmlPackageImpl#getTtTag()
		 * @generated
		 */
		EClass TT_TAG = eINSTANCE.getTtTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TT_TAG__CONTENT = eINSTANCE.getTtTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.CenterTagImpl <em>Center Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.CenterTagImpl
		 * @see html.impl.HtmlPackageImpl#getCenterTag()
		 * @generated
		 */
		EClass CENTER_TAG = eINSTANCE.getCenterTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CENTER_TAG__CONTENT = eINSTANCE.getCenterTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.SpanTagImpl <em>Span Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.SpanTagImpl
		 * @see html.impl.HtmlPackageImpl#getSpanTag()
		 * @generated
		 */
		EClass SPAN_TAG = eINSTANCE.getSpanTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPAN_TAG__CONTENT = eINSTANCE.getSpanTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.DivTagImpl <em>Div Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.DivTagImpl
		 * @see html.impl.HtmlPackageImpl#getDivTag()
		 * @generated
		 */
		EClass DIV_TAG = eINSTANCE.getDivTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIV_TAG__CONTENT = eINSTANCE.getDivTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.AppletTagImpl <em>Applet Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.AppletTagImpl
		 * @see html.impl.HtmlPackageImpl#getAppletTag()
		 * @generated
		 */
		EClass APPLET_TAG = eINSTANCE.getAppletTag();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLET_TAG__PARAMS = eINSTANCE.getAppletTag_Params();

		/**
		 * The meta object literal for the '{@link html.impl.ObjectTagImpl <em>Object Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.ObjectTagImpl
		 * @see html.impl.HtmlPackageImpl#getObjectTag()
		 * @generated
		 */
		EClass OBJECT_TAG = eINSTANCE.getObjectTag();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TAG__PARAMS = eINSTANCE.getObjectTag_Params();

		/**
		 * The meta object literal for the '{@link html.impl.TableTagImpl <em>Table Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.TableTagImpl
		 * @see html.impl.HtmlPackageImpl#getTableTag()
		 * @generated
		 */
		EClass TABLE_TAG = eINSTANCE.getTableTag();

		/**
		 * The meta object literal for the '<em><b>Table Rows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_TAG__TABLE_ROWS = eINSTANCE.getTableTag_TableRows();

		/**
		 * The meta object literal for the '{@link html.impl.UITagImpl <em>UI Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.UITagImpl
		 * @see html.impl.HtmlPackageImpl#getUITag()
		 * @generated
		 */
		EClass UI_TAG = eINSTANCE.getUITag();

		/**
		 * The meta object literal for the '<em><b>List Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_TAG__LIST_ITEMS = eINSTANCE.getUITag_ListItems();

		/**
		 * The meta object literal for the '{@link html.impl.OlTagImpl <em>Ol Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.OlTagImpl
		 * @see html.impl.HtmlPackageImpl#getOlTag()
		 * @generated
		 */
		EClass OL_TAG = eINSTANCE.getOlTag();

		/**
		 * The meta object literal for the '<em><b>List Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OL_TAG__LIST_ITEMS = eINSTANCE.getOlTag_ListItems();

		/**
		 * The meta object literal for the '{@link html.impl.DirTagImpl <em>Dir Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.DirTagImpl
		 * @see html.impl.HtmlPackageImpl#getDirTag()
		 * @generated
		 */
		EClass DIR_TAG = eINSTANCE.getDirTag();

		/**
		 * The meta object literal for the '<em><b>List Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIR_TAG__LIST_ITEMS = eINSTANCE.getDirTag_ListItems();

		/**
		 * The meta object literal for the '{@link html.impl.MenutagImpl <em>Menutag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.MenutagImpl
		 * @see html.impl.HtmlPackageImpl#getMenutag()
		 * @generated
		 */
		EClass MENUTAG = eINSTANCE.getMenutag();

		/**
		 * The meta object literal for the '<em><b>List Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MENUTAG__LIST_ITEMS = eINSTANCE.getMenutag_ListItems();

		/**
		 * The meta object literal for the '{@link html.impl.DlTagImpl <em>Dl Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.DlTagImpl
		 * @see html.impl.HtmlPackageImpl#getDlTag()
		 * @generated
		 */
		EClass DL_TAG = eINSTANCE.getDlTag();

		/**
		 * The meta object literal for the '<em><b>Def Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DL_TAG__DEF_ITEMS = eINSTANCE.getDlTag_DefItems();

		/**
		 * The meta object literal for the '{@link html.impl.FormTagImpl <em>Form Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.FormTagImpl
		 * @see html.impl.HtmlPackageImpl#getFormTag()
		 * @generated
		 */
		EClass FORM_TAG = eINSTANCE.getFormTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORM_TAG__CONTENT = eINSTANCE.getFormTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.InputTagImpl <em>Input Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.InputTagImpl
		 * @see html.impl.HtmlPackageImpl#getInputTag()
		 * @generated
		 */
		EClass INPUT_TAG = eINSTANCE.getInputTag();

		/**
		 * The meta object literal for the '{@link html.impl.SelectTagImpl <em>Select Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.SelectTagImpl
		 * @see html.impl.HtmlPackageImpl#getSelectTag()
		 * @generated
		 */
		EClass SELECT_TAG = eINSTANCE.getSelectTag();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_TAG__OPTIONS = eINSTANCE.getSelectTag_Options();

		/**
		 * The meta object literal for the '{@link html.impl.TextAreaTagImpl <em>Text Area Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.TextAreaTagImpl
		 * @see html.impl.HtmlPackageImpl#getTextAreaTag()
		 * @generated
		 */
		EClass TEXT_AREA_TAG = eINSTANCE.getTextAreaTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_AREA_TAG__CONTENT = eINSTANCE.getTextAreaTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.TableRowImpl <em>Table Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.TableRowImpl
		 * @see html.impl.HtmlPackageImpl#getTableRow()
		 * @generated
		 */
		EClass TABLE_ROW = eINSTANCE.getTableRow();

		/**
		 * The meta object literal for the '<em><b>Table Cells</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_ROW__TABLE_CELLS = eINSTANCE.getTableRow_TableCells();

		/**
		 * The meta object literal for the '<em><b>Table Rows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_ROW__TABLE_ROWS = eINSTANCE.getTableRow_TableRows();

		/**
		 * The meta object literal for the '{@link html.impl.TableCellImpl <em>Table Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.TableCellImpl
		 * @see html.impl.HtmlPackageImpl#getTableCell()
		 * @generated
		 */
		EClass TABLE_CELL = eINSTANCE.getTableCell();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_CELL__CONTENT = eINSTANCE.getTableCell_Content();

		/**
		 * The meta object literal for the '{@link html.impl.TDTableCellImpl <em>TD Table Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.TDTableCellImpl
		 * @see html.impl.HtmlPackageImpl#getTDTableCell()
		 * @generated
		 */
		EClass TD_TABLE_CELL = eINSTANCE.getTDTableCell();

		/**
		 * The meta object literal for the '{@link html.impl.THTableCellImpl <em>TH Table Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.THTableCellImpl
		 * @see html.impl.HtmlPackageImpl#getTHTableCell()
		 * @generated
		 */
		EClass TH_TABLE_CELL = eINSTANCE.getTHTableCell();

		/**
		 * The meta object literal for the '{@link html.impl.DefItemImpl <em>Def Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.DefItemImpl
		 * @see html.impl.HtmlPackageImpl#getDefItem()
		 * @generated
		 */
		EClass DEF_ITEM = eINSTANCE.getDefItem();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEF_ITEM__PARAMETERS = eINSTANCE.getDefItem_Parameters();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEF_ITEM__CONTENT = eINSTANCE.getDefItem_Content();

		/**
		 * The meta object literal for the '{@link html.impl.DdItemImpl <em>Dd Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.DdItemImpl
		 * @see html.impl.HtmlPackageImpl#getDdItem()
		 * @generated
		 */
		EClass DD_ITEM = eINSTANCE.getDdItem();

		/**
		 * The meta object literal for the '{@link html.impl.DtItemImpl <em>Dt Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.DtItemImpl
		 * @see html.impl.HtmlPackageImpl#getDtItem()
		 * @generated
		 */
		EClass DT_ITEM = eINSTANCE.getDtItem();

		/**
		 * The meta object literal for the '{@link html.impl.ListItemImpl <em>List Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.ListItemImpl
		 * @see html.impl.HtmlPackageImpl#getListItem()
		 * @generated
		 */
		EClass LIST_ITEM = eINSTANCE.getListItem();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_ITEM__PARAMETERS = eINSTANCE.getListItem_Parameters();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_ITEM__CONTENT = eINSTANCE.getListItem_Content();

		/**
		 * The meta object literal for the '{@link html.impl.OptionImpl <em>Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.OptionImpl
		 * @see html.impl.HtmlPackageImpl#getOption()
		 * @generated
		 */
		EClass OPTION = eINSTANCE.getOption();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTION__PARAMETERS = eINSTANCE.getOption_Parameters();

		/**
		 * The meta object literal for the '{@link html.impl.MapItemImpl <em>Map Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.MapItemImpl
		 * @see html.impl.HtmlPackageImpl#getMapItem()
		 * @generated
		 */
		EClass MAP_ITEM = eINSTANCE.getMapItem();

		/**
		 * The meta object literal for the '<em><b>Area</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_ITEM__AREA = eINSTANCE.getMapItem_Area();

		/**
		 * The meta object literal for the '<em><b>Map Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_ITEM__MAP_ITEMS = eINSTANCE.getMapItem_MapItems();

		/**
		 * The meta object literal for the '{@link html.impl.AreaImpl <em>Area</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.AreaImpl
		 * @see html.impl.HtmlPackageImpl#getArea()
		 * @generated
		 */
		EClass AREA = eINSTANCE.getArea();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA__PARAMETERS = eINSTANCE.getArea_Parameters();

		/**
		 * The meta object literal for the '{@link html.impl.ParamImpl <em>Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.ParamImpl
		 * @see html.impl.HtmlPackageImpl#getParam()
		 * @generated
		 */
		EClass PARAM = eINSTANCE.getParam();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAM__PARAMETERS = eINSTANCE.getParam_Parameters();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAM__PARAMS = eINSTANCE.getParam_Params();

		/**
		 * The meta object literal for the '{@link html.impl.DSLTagImpl <em>DSL Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.DSLTagImpl
		 * @see html.impl.HtmlPackageImpl#getDSLTag()
		 * @generated
		 */
		EClass DSL_TAG = eINSTANCE.getDSLTag();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSL_TAG__CONTENT = eINSTANCE.getDSLTag_Content();

		/**
		 * The meta object literal for the '{@link html.impl.DSLTagStructureImpl <em>DSL Tag Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see html.impl.DSLTagStructureImpl
		 * @see html.impl.HtmlPackageImpl#getDSLTagStructure()
		 * @generated
		 */
		EClass DSL_TAG_STRUCTURE = eINSTANCE.getDSLTagStructure();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSL_TAG_STRUCTURE__NAME = eINSTANCE.getDSLTagStructure_Name();

		/**
		 * The meta object literal for the '<em><b>Name Close</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSL_TAG_STRUCTURE__NAME_CLOSE = eINSTANCE.getDSLTagStructure_NameClose();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSL_TAG_STRUCTURE__CONTENT = eINSTANCE.getDSLTagStructure_Content();

	}

} //HtmlPackage
