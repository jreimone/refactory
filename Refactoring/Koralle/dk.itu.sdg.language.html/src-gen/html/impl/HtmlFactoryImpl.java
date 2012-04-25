/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html.impl;

import html.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HtmlFactoryImpl extends EFactoryImpl implements HtmlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HtmlFactory init() {
		try {
			HtmlFactory theHtmlFactory = (HtmlFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.itu.dk/language/html"); 
			if (theHtmlFactory != null) {
				return theHtmlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HtmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HtmlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case HtmlPackage.DOCUMENT: return createDocument();
			case HtmlPackage.DOC_TYPE: return createDocType();
			case HtmlPackage.STRING_VAL_PARAMETER: return createStringValParameter();
			case HtmlPackage.COLOR_VAL_PARAMETER: return createColorValParameter();
			case HtmlPackage.ID_VAL_PARAMETER: return createIDValParameter();
			case HtmlPackage.ID_PARAMETER: return createIDParameter();
			case HtmlPackage.STRING_PARAMETER: return createStringParameter();
			case HtmlPackage.WEB_PAGE_BODY: return createWebPageBody();
			case HtmlPackage.HEAD: return createHead();
			case HtmlPackage.BODY: return createBody();
			case HtmlPackage.TITLE_ITEM: return createTitleItem();
			case HtmlPackage.META_ITEM: return createMetaItem();
			case HtmlPackage.LINK_ITEM: return createLinkItem();
			case HtmlPackage.BASE_ITEM: return createBaseItem();
			case HtmlPackage.BASE_FONT_ITEM: return createBaseFontItem();
			case HtmlPackage.SCRIPT_ITEM: return createScriptItem();
			case HtmlPackage.CONTENT: return createContent();
			case HtmlPackage.PCONTENT: return createPContent();
			case HtmlPackage.WORD: return createWord();
			case HtmlPackage.IMAGE_TAG: return createImageTag();
			case HtmlPackage.BR_TAG: return createBrTag();
			case HtmlPackage.HR_TAG: return createHrTag();
			case HtmlPackage.PTAG: return createPTag();
			case HtmlPackage.H1_TAG: return createH1Tag();
			case HtmlPackage.H2_TAG: return createH2Tag();
			case HtmlPackage.H3_TAG: return createH3Tag();
			case HtmlPackage.H4_TAG: return createH4Tag();
			case HtmlPackage.H5_TAG: return createH5Tag();
			case HtmlPackage.H6_TAG: return createH6Tag();
			case HtmlPackage.ATAG: return createATag();
			case HtmlPackage.MAP_TAG: return createMapTag();
			case HtmlPackage.BTAG: return createBTag();
			case HtmlPackage.UTAG: return createUTag();
			case HtmlPackage.EM_TAG: return createEmTag();
			case HtmlPackage.ITAG: return createITag();
			case HtmlPackage.STRIKE_TAG: return createStrikeTag();
			case HtmlPackage.STRONG_TAG: return createStrongTag();
			case HtmlPackage.FONT_TAG: return createFontTag();
			case HtmlPackage.BIG_TAG: return createBigTag();
			case HtmlPackage.SMALL_TAG: return createSmallTag();
			case HtmlPackage.SUP_TAG: return createSupTag();
			case HtmlPackage.SUB_TAG: return createSubTag();
			case HtmlPackage.BLOCK_QUOTE_TAG: return createBlockQuoteTag();
			case HtmlPackage.ADDRESS_TAG: return createAddressTag();
			case HtmlPackage.CODE_TAG: return createCodeTag();
			case HtmlPackage.CITE_TAG: return createCiteTag();
			case HtmlPackage.CAPTION_TAG: return createCaptionTag();
			case HtmlPackage.SAMP_TAG: return createSampTag();
			case HtmlPackage.KBD_TAG: return createKbdTag();
			case HtmlPackage.TT_TAG: return createTtTag();
			case HtmlPackage.CENTER_TAG: return createCenterTag();
			case HtmlPackage.SPAN_TAG: return createSpanTag();
			case HtmlPackage.DIV_TAG: return createDivTag();
			case HtmlPackage.APPLET_TAG: return createAppletTag();
			case HtmlPackage.OBJECT_TAG: return createObjectTag();
			case HtmlPackage.TABLE_TAG: return createTableTag();
			case HtmlPackage.UI_TAG: return createUITag();
			case HtmlPackage.OL_TAG: return createOlTag();
			case HtmlPackage.DIR_TAG: return createDirTag();
			case HtmlPackage.MENUTAG: return createMenutag();
			case HtmlPackage.DL_TAG: return createDlTag();
			case HtmlPackage.FORM_TAG: return createFormTag();
			case HtmlPackage.INPUT_TAG: return createInputTag();
			case HtmlPackage.SELECT_TAG: return createSelectTag();
			case HtmlPackage.TEXT_AREA_TAG: return createTextAreaTag();
			case HtmlPackage.TABLE_ROW: return createTableRow();
			case HtmlPackage.TD_TABLE_CELL: return createTDTableCell();
			case HtmlPackage.TH_TABLE_CELL: return createTHTableCell();
			case HtmlPackage.DD_ITEM: return createDdItem();
			case HtmlPackage.DT_ITEM: return createDtItem();
			case HtmlPackage.LIST_ITEM: return createListItem();
			case HtmlPackage.OPTION: return createOption();
			case HtmlPackage.MAP_ITEM: return createMapItem();
			case HtmlPackage.AREA: return createArea();
			case HtmlPackage.PARAM: return createParam();
			case HtmlPackage.DSL_TAG: return createDSLTag();
			case HtmlPackage.DSL_TAG_STRUCTURE: return createDSLTagStructure();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Document createDocument() {
		DocumentImpl document = new DocumentImpl();
		return document;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocType createDocType() {
		DocTypeImpl docType = new DocTypeImpl();
		return docType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringValParameter createStringValParameter() {
		StringValParameterImpl stringValParameter = new StringValParameterImpl();
		return stringValParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorValParameter createColorValParameter() {
		ColorValParameterImpl colorValParameter = new ColorValParameterImpl();
		return colorValParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDValParameter createIDValParameter() {
		IDValParameterImpl idValParameter = new IDValParameterImpl();
		return idValParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDParameter createIDParameter() {
		IDParameterImpl idParameter = new IDParameterImpl();
		return idParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringParameter createStringParameter() {
		StringParameterImpl stringParameter = new StringParameterImpl();
		return stringParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebPageBody createWebPageBody() {
		WebPageBodyImpl webPageBody = new WebPageBodyImpl();
		return webPageBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Head createHead() {
		HeadImpl head = new HeadImpl();
		return head;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Body createBody() {
		BodyImpl body = new BodyImpl();
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TitleItem createTitleItem() {
		TitleItemImpl titleItem = new TitleItemImpl();
		return titleItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaItem createMetaItem() {
		MetaItemImpl metaItem = new MetaItemImpl();
		return metaItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkItem createLinkItem() {
		LinkItemImpl linkItem = new LinkItemImpl();
		return linkItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseItem createBaseItem() {
		BaseItemImpl baseItem = new BaseItemImpl();
		return baseItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseFontItem createBaseFontItem() {
		BaseFontItemImpl baseFontItem = new BaseFontItemImpl();
		return baseFontItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptItem createScriptItem() {
		ScriptItemImpl scriptItem = new ScriptItemImpl();
		return scriptItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Content createContent() {
		ContentImpl content = new ContentImpl();
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PContent createPContent() {
		PContentImpl pContent = new PContentImpl();
		return pContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Word createWord() {
		WordImpl word = new WordImpl();
		return word;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageTag createImageTag() {
		ImageTagImpl imageTag = new ImageTagImpl();
		return imageTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BrTag createBrTag() {
		BrTagImpl brTag = new BrTagImpl();
		return brTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HrTag createHrTag() {
		HrTagImpl hrTag = new HrTagImpl();
		return hrTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PTag createPTag() {
		PTagImpl pTag = new PTagImpl();
		return pTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public H1Tag createH1Tag() {
		H1TagImpl h1Tag = new H1TagImpl();
		return h1Tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public H2Tag createH2Tag() {
		H2TagImpl h2Tag = new H2TagImpl();
		return h2Tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public H3Tag createH3Tag() {
		H3TagImpl h3Tag = new H3TagImpl();
		return h3Tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public H4Tag createH4Tag() {
		H4TagImpl h4Tag = new H4TagImpl();
		return h4Tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public H5Tag createH5Tag() {
		H5TagImpl h5Tag = new H5TagImpl();
		return h5Tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public H6Tag createH6Tag() {
		H6TagImpl h6Tag = new H6TagImpl();
		return h6Tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ATag createATag() {
		ATagImpl aTag = new ATagImpl();
		return aTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapTag createMapTag() {
		MapTagImpl mapTag = new MapTagImpl();
		return mapTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BTag createBTag() {
		BTagImpl bTag = new BTagImpl();
		return bTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UTag createUTag() {
		UTagImpl uTag = new UTagImpl();
		return uTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmTag createEmTag() {
		EmTagImpl emTag = new EmTagImpl();
		return emTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITag createITag() {
		ITagImpl iTag = new ITagImpl();
		return iTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrikeTag createStrikeTag() {
		StrikeTagImpl strikeTag = new StrikeTagImpl();
		return strikeTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrongTag createStrongTag() {
		StrongTagImpl strongTag = new StrongTagImpl();
		return strongTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontTag createFontTag() {
		FontTagImpl fontTag = new FontTagImpl();
		return fontTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigTag createBigTag() {
		BigTagImpl bigTag = new BigTagImpl();
		return bigTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmallTag createSmallTag() {
		SmallTagImpl smallTag = new SmallTagImpl();
		return smallTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupTag createSupTag() {
		SupTagImpl supTag = new SupTagImpl();
		return supTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubTag createSubTag() {
		SubTagImpl subTag = new SubTagImpl();
		return subTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockQuoteTag createBlockQuoteTag() {
		BlockQuoteTagImpl blockQuoteTag = new BlockQuoteTagImpl();
		return blockQuoteTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressTag createAddressTag() {
		AddressTagImpl addressTag = new AddressTagImpl();
		return addressTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeTag createCodeTag() {
		CodeTagImpl codeTag = new CodeTagImpl();
		return codeTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CiteTag createCiteTag() {
		CiteTagImpl citeTag = new CiteTagImpl();
		return citeTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaptionTag createCaptionTag() {
		CaptionTagImpl captionTag = new CaptionTagImpl();
		return captionTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SampTag createSampTag() {
		SampTagImpl sampTag = new SampTagImpl();
		return sampTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KbdTag createKbdTag() {
		KbdTagImpl kbdTag = new KbdTagImpl();
		return kbdTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TtTag createTtTag() {
		TtTagImpl ttTag = new TtTagImpl();
		return ttTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CenterTag createCenterTag() {
		CenterTagImpl centerTag = new CenterTagImpl();
		return centerTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpanTag createSpanTag() {
		SpanTagImpl spanTag = new SpanTagImpl();
		return spanTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DivTag createDivTag() {
		DivTagImpl divTag = new DivTagImpl();
		return divTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppletTag createAppletTag() {
		AppletTagImpl appletTag = new AppletTagImpl();
		return appletTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTag createObjectTag() {
		ObjectTagImpl objectTag = new ObjectTagImpl();
		return objectTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableTag createTableTag() {
		TableTagImpl tableTag = new TableTagImpl();
		return tableTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UITag createUITag() {
		UITagImpl uiTag = new UITagImpl();
		return uiTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OlTag createOlTag() {
		OlTagImpl olTag = new OlTagImpl();
		return olTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirTag createDirTag() {
		DirTagImpl dirTag = new DirTagImpl();
		return dirTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Menutag createMenutag() {
		MenutagImpl menutag = new MenutagImpl();
		return menutag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DlTag createDlTag() {
		DlTagImpl dlTag = new DlTagImpl();
		return dlTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormTag createFormTag() {
		FormTagImpl formTag = new FormTagImpl();
		return formTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputTag createInputTag() {
		InputTagImpl inputTag = new InputTagImpl();
		return inputTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectTag createSelectTag() {
		SelectTagImpl selectTag = new SelectTagImpl();
		return selectTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextAreaTag createTextAreaTag() {
		TextAreaTagImpl textAreaTag = new TextAreaTagImpl();
		return textAreaTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableRow createTableRow() {
		TableRowImpl tableRow = new TableRowImpl();
		return tableRow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TDTableCell createTDTableCell() {
		TDTableCellImpl tdTableCell = new TDTableCellImpl();
		return tdTableCell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public THTableCell createTHTableCell() {
		THTableCellImpl thTableCell = new THTableCellImpl();
		return thTableCell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DdItem createDdItem() {
		DdItemImpl ddItem = new DdItemImpl();
		return ddItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DtItem createDtItem() {
		DtItemImpl dtItem = new DtItemImpl();
		return dtItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListItem createListItem() {
		ListItemImpl listItem = new ListItemImpl();
		return listItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Option createOption() {
		OptionImpl option = new OptionImpl();
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapItem createMapItem() {
		MapItemImpl mapItem = new MapItemImpl();
		return mapItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Area createArea() {
		AreaImpl area = new AreaImpl();
		return area;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Param createParam() {
		ParamImpl param = new ParamImpl();
		return param;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSLTag createDSLTag() {
		DSLTagImpl dslTag = new DSLTagImpl();
		return dslTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSLTagStructure createDSLTagStructure() {
		DSLTagStructureImpl dslTagStructure = new DSLTagStructureImpl();
		return dslTagStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HtmlPackage getHtmlPackage() {
		return (HtmlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HtmlPackage getPackage() {
		return HtmlPackage.eINSTANCE;
	}

} //HtmlFactoryImpl
