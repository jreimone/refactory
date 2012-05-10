/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see html.HtmlPackage
 * @generated
 */
public interface HtmlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HtmlFactory eINSTANCE = html.impl.HtmlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Complete Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Document</em>'.
	 * @generated
	 */
	CompleteDocument createCompleteDocument();

	/**
	 * Returns a new object of class '<em>Content Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Content Document</em>'.
	 * @generated
	 */
	ContentDocument createContentDocument();

	/**
	 * Returns a new object of class '<em>Doc Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Doc Type</em>'.
	 * @generated
	 */
	DocType createDocType();

	/**
	 * Returns a new object of class '<em>String Val Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Val Parameter</em>'.
	 * @generated
	 */
	StringValParameter createStringValParameter();

	/**
	 * Returns a new object of class '<em>Color Val Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Color Val Parameter</em>'.
	 * @generated
	 */
	ColorValParameter createColorValParameter();

	/**
	 * Returns a new object of class '<em>ID Val Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ID Val Parameter</em>'.
	 * @generated
	 */
	IDValParameter createIDValParameter();

	/**
	 * Returns a new object of class '<em>ID Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ID Parameter</em>'.
	 * @generated
	 */
	IDParameter createIDParameter();

	/**
	 * Returns a new object of class '<em>String Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Parameter</em>'.
	 * @generated
	 */
	StringParameter createStringParameter();

	/**
	 * Returns a new object of class '<em>Web Page Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Web Page Body</em>'.
	 * @generated
	 */
	WebPageBody createWebPageBody();

	/**
	 * Returns a new object of class '<em>Head</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Head</em>'.
	 * @generated
	 */
	Head createHead();

	/**
	 * Returns a new object of class '<em>Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Body</em>'.
	 * @generated
	 */
	Body createBody();

	/**
	 * Returns a new object of class '<em>Title Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Title Item</em>'.
	 * @generated
	 */
	TitleItem createTitleItem();

	/**
	 * Returns a new object of class '<em>Meta Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Item</em>'.
	 * @generated
	 */
	MetaItem createMetaItem();

	/**
	 * Returns a new object of class '<em>Link Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Item</em>'.
	 * @generated
	 */
	LinkItem createLinkItem();

	/**
	 * Returns a new object of class '<em>Base Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Item</em>'.
	 * @generated
	 */
	BaseItem createBaseItem();

	/**
	 * Returns a new object of class '<em>Base Font Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Font Item</em>'.
	 * @generated
	 */
	BaseFontItem createBaseFontItem();

	/**
	 * Returns a new object of class '<em>Script Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Script Item</em>'.
	 * @generated
	 */
	ScriptItem createScriptItem();

	/**
	 * Returns a new object of class '<em>Content</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Content</em>'.
	 * @generated
	 */
	Content createContent();

	/**
	 * Returns a new object of class '<em>PContent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PContent</em>'.
	 * @generated
	 */
	PContent createPContent();

	/**
	 * Returns a new object of class '<em>Word</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Word</em>'.
	 * @generated
	 */
	Word createWord();

	/**
	 * Returns a new object of class '<em>Image Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Tag</em>'.
	 * @generated
	 */
	ImageTag createImageTag();

	/**
	 * Returns a new object of class '<em>Br Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Br Tag</em>'.
	 * @generated
	 */
	BrTag createBrTag();

	/**
	 * Returns a new object of class '<em>Hr Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hr Tag</em>'.
	 * @generated
	 */
	HrTag createHrTag();

	/**
	 * Returns a new object of class '<em>PTag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PTag</em>'.
	 * @generated
	 */
	PTag createPTag();

	/**
	 * Returns a new object of class '<em>H1 Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>H1 Tag</em>'.
	 * @generated
	 */
	H1Tag createH1Tag();

	/**
	 * Returns a new object of class '<em>H2 Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>H2 Tag</em>'.
	 * @generated
	 */
	H2Tag createH2Tag();

	/**
	 * Returns a new object of class '<em>H3 Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>H3 Tag</em>'.
	 * @generated
	 */
	H3Tag createH3Tag();

	/**
	 * Returns a new object of class '<em>H4 Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>H4 Tag</em>'.
	 * @generated
	 */
	H4Tag createH4Tag();

	/**
	 * Returns a new object of class '<em>H5 Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>H5 Tag</em>'.
	 * @generated
	 */
	H5Tag createH5Tag();

	/**
	 * Returns a new object of class '<em>H6 Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>H6 Tag</em>'.
	 * @generated
	 */
	H6Tag createH6Tag();

	/**
	 * Returns a new object of class '<em>ATag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ATag</em>'.
	 * @generated
	 */
	ATag createATag();

	/**
	 * Returns a new object of class '<em>Map Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Tag</em>'.
	 * @generated
	 */
	MapTag createMapTag();

	/**
	 * Returns a new object of class '<em>BTag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BTag</em>'.
	 * @generated
	 */
	BTag createBTag();

	/**
	 * Returns a new object of class '<em>UTag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UTag</em>'.
	 * @generated
	 */
	UTag createUTag();

	/**
	 * Returns a new object of class '<em>Em Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Em Tag</em>'.
	 * @generated
	 */
	EmTag createEmTag();

	/**
	 * Returns a new object of class '<em>ITag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ITag</em>'.
	 * @generated
	 */
	ITag createITag();

	/**
	 * Returns a new object of class '<em>Strike Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Strike Tag</em>'.
	 * @generated
	 */
	StrikeTag createStrikeTag();

	/**
	 * Returns a new object of class '<em>Strong Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Strong Tag</em>'.
	 * @generated
	 */
	StrongTag createStrongTag();

	/**
	 * Returns a new object of class '<em>Font Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Font Tag</em>'.
	 * @generated
	 */
	FontTag createFontTag();

	/**
	 * Returns a new object of class '<em>Big Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Big Tag</em>'.
	 * @generated
	 */
	BigTag createBigTag();

	/**
	 * Returns a new object of class '<em>Small Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Small Tag</em>'.
	 * @generated
	 */
	SmallTag createSmallTag();

	/**
	 * Returns a new object of class '<em>Sup Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sup Tag</em>'.
	 * @generated
	 */
	SupTag createSupTag();

	/**
	 * Returns a new object of class '<em>Sub Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Tag</em>'.
	 * @generated
	 */
	SubTag createSubTag();

	/**
	 * Returns a new object of class '<em>Block Quote Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Quote Tag</em>'.
	 * @generated
	 */
	BlockQuoteTag createBlockQuoteTag();

	/**
	 * Returns a new object of class '<em>Address Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address Tag</em>'.
	 * @generated
	 */
	AddressTag createAddressTag();

	/**
	 * Returns a new object of class '<em>Code Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Tag</em>'.
	 * @generated
	 */
	CodeTag createCodeTag();

	/**
	 * Returns a new object of class '<em>Cite Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cite Tag</em>'.
	 * @generated
	 */
	CiteTag createCiteTag();

	/**
	 * Returns a new object of class '<em>Caption Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Caption Tag</em>'.
	 * @generated
	 */
	CaptionTag createCaptionTag();

	/**
	 * Returns a new object of class '<em>Samp Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Samp Tag</em>'.
	 * @generated
	 */
	SampTag createSampTag();

	/**
	 * Returns a new object of class '<em>Kbd Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Kbd Tag</em>'.
	 * @generated
	 */
	KbdTag createKbdTag();

	/**
	 * Returns a new object of class '<em>Tt Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tt Tag</em>'.
	 * @generated
	 */
	TtTag createTtTag();

	/**
	 * Returns a new object of class '<em>Center Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Center Tag</em>'.
	 * @generated
	 */
	CenterTag createCenterTag();

	/**
	 * Returns a new object of class '<em>Span Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Span Tag</em>'.
	 * @generated
	 */
	SpanTag createSpanTag();

	/**
	 * Returns a new object of class '<em>Div Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Div Tag</em>'.
	 * @generated
	 */
	DivTag createDivTag();

	/**
	 * Returns a new object of class '<em>Applet Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Applet Tag</em>'.
	 * @generated
	 */
	AppletTag createAppletTag();

	/**
	 * Returns a new object of class '<em>Object Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Tag</em>'.
	 * @generated
	 */
	ObjectTag createObjectTag();

	/**
	 * Returns a new object of class '<em>Table Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Table Tag</em>'.
	 * @generated
	 */
	TableTag createTableTag();

	/**
	 * Returns a new object of class '<em>UI Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UI Tag</em>'.
	 * @generated
	 */
	UITag createUITag();

	/**
	 * Returns a new object of class '<em>Ol Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ol Tag</em>'.
	 * @generated
	 */
	OlTag createOlTag();

	/**
	 * Returns a new object of class '<em>Dir Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dir Tag</em>'.
	 * @generated
	 */
	DirTag createDirTag();

	/**
	 * Returns a new object of class '<em>Menutag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Menutag</em>'.
	 * @generated
	 */
	Menutag createMenutag();

	/**
	 * Returns a new object of class '<em>Dl Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dl Tag</em>'.
	 * @generated
	 */
	DlTag createDlTag();

	/**
	 * Returns a new object of class '<em>Form Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Form Tag</em>'.
	 * @generated
	 */
	FormTag createFormTag();

	/**
	 * Returns a new object of class '<em>Input Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Tag</em>'.
	 * @generated
	 */
	InputTag createInputTag();

	/**
	 * Returns a new object of class '<em>Select Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select Tag</em>'.
	 * @generated
	 */
	SelectTag createSelectTag();

	/**
	 * Returns a new object of class '<em>Text Area Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Area Tag</em>'.
	 * @generated
	 */
	TextAreaTag createTextAreaTag();

	/**
	 * Returns a new object of class '<em>Table Row</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Table Row</em>'.
	 * @generated
	 */
	TableRow createTableRow();

	/**
	 * Returns a new object of class '<em>TD Table Cell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TD Table Cell</em>'.
	 * @generated
	 */
	TDTableCell createTDTableCell();

	/**
	 * Returns a new object of class '<em>TH Table Cell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TH Table Cell</em>'.
	 * @generated
	 */
	THTableCell createTHTableCell();

	/**
	 * Returns a new object of class '<em>Dd Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dd Item</em>'.
	 * @generated
	 */
	DdItem createDdItem();

	/**
	 * Returns a new object of class '<em>Dt Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dt Item</em>'.
	 * @generated
	 */
	DtItem createDtItem();

	/**
	 * Returns a new object of class '<em>List Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Item</em>'.
	 * @generated
	 */
	ListItem createListItem();

	/**
	 * Returns a new object of class '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Option</em>'.
	 * @generated
	 */
	Option createOption();

	/**
	 * Returns a new object of class '<em>Map Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Item</em>'.
	 * @generated
	 */
	MapItem createMapItem();

	/**
	 * Returns a new object of class '<em>Area</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Area</em>'.
	 * @generated
	 */
	Area createArea();

	/**
	 * Returns a new object of class '<em>Param</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Param</em>'.
	 * @generated
	 */
	Param createParam();

	/**
	 * Returns a new object of class '<em>DSL Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DSL Tag</em>'.
	 * @generated
	 */
	DSLTag createDSLTag();

	/**
	 * Returns a new object of class '<em>DSL Tag Structure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DSL Tag Structure</em>'.
	 * @generated
	 */
	DSLTagStructure createDSLTagStructure();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HtmlPackage getHtmlPackage();

} //HtmlFactory
