/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html.util;

import html.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see html.HtmlPackage
 * @generated
 */
public class HtmlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static HtmlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HtmlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = HtmlPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HtmlSwitch<Adapter> modelSwitch =
		new HtmlSwitch<Adapter>() {
			@Override
			public Adapter caseDocument(Document object) {
				return createDocumentAdapter();
			}
			@Override
			public Adapter caseDocType(DocType object) {
				return createDocTypeAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseStringValParameter(StringValParameter object) {
				return createStringValParameterAdapter();
			}
			@Override
			public Adapter caseColorValParameter(ColorValParameter object) {
				return createColorValParameterAdapter();
			}
			@Override
			public Adapter caseIDValParameter(IDValParameter object) {
				return createIDValParameterAdapter();
			}
			@Override
			public Adapter caseIDParameter(IDParameter object) {
				return createIDParameterAdapter();
			}
			@Override
			public Adapter caseStringParameter(StringParameter object) {
				return createStringParameterAdapter();
			}
			@Override
			public Adapter caseWebPageBody(WebPageBody object) {
				return createWebPageBodyAdapter();
			}
			@Override
			public Adapter caseHead(Head object) {
				return createHeadAdapter();
			}
			@Override
			public Adapter caseBody(Body object) {
				return createBodyAdapter();
			}
			@Override
			public Adapter caseHeadItem(HeadItem object) {
				return createHeadItemAdapter();
			}
			@Override
			public Adapter caseTitleItem(TitleItem object) {
				return createTitleItemAdapter();
			}
			@Override
			public Adapter caseMetaItem(MetaItem object) {
				return createMetaItemAdapter();
			}
			@Override
			public Adapter caseLinkItem(LinkItem object) {
				return createLinkItemAdapter();
			}
			@Override
			public Adapter caseBaseItem(BaseItem object) {
				return createBaseItemAdapter();
			}
			@Override
			public Adapter caseBaseFontItem(BaseFontItem object) {
				return createBaseFontItemAdapter();
			}
			@Override
			public Adapter caseScriptItem(ScriptItem object) {
				return createScriptItemAdapter();
			}
			@Override
			public Adapter caseContent(Content object) {
				return createContentAdapter();
			}
			@Override
			public Adapter casePContent(PContent object) {
				return createPContentAdapter();
			}
			@Override
			public Adapter caseTag(Tag object) {
				return createTagAdapter();
			}
			@Override
			public Adapter caseWord(Word object) {
				return createWordAdapter();
			}
			@Override
			public Adapter caseImageTag(ImageTag object) {
				return createImageTagAdapter();
			}
			@Override
			public Adapter caseBrTag(BrTag object) {
				return createBrTagAdapter();
			}
			@Override
			public Adapter caseHrTag(HrTag object) {
				return createHrTagAdapter();
			}
			@Override
			public Adapter casePTag(PTag object) {
				return createPTagAdapter();
			}
			@Override
			public Adapter caseH1Tag(H1Tag object) {
				return createH1TagAdapter();
			}
			@Override
			public Adapter caseH2Tag(H2Tag object) {
				return createH2TagAdapter();
			}
			@Override
			public Adapter caseH3Tag(H3Tag object) {
				return createH3TagAdapter();
			}
			@Override
			public Adapter caseH4Tag(H4Tag object) {
				return createH4TagAdapter();
			}
			@Override
			public Adapter caseH5Tag(H5Tag object) {
				return createH5TagAdapter();
			}
			@Override
			public Adapter caseH6Tag(H6Tag object) {
				return createH6TagAdapter();
			}
			@Override
			public Adapter caseATag(ATag object) {
				return createATagAdapter();
			}
			@Override
			public Adapter caseMapTag(MapTag object) {
				return createMapTagAdapter();
			}
			@Override
			public Adapter caseBTag(BTag object) {
				return createBTagAdapter();
			}
			@Override
			public Adapter caseUTag(UTag object) {
				return createUTagAdapter();
			}
			@Override
			public Adapter caseEmTag(EmTag object) {
				return createEmTagAdapter();
			}
			@Override
			public Adapter caseITag(ITag object) {
				return createITagAdapter();
			}
			@Override
			public Adapter caseStrikeTag(StrikeTag object) {
				return createStrikeTagAdapter();
			}
			@Override
			public Adapter caseStrongTag(StrongTag object) {
				return createStrongTagAdapter();
			}
			@Override
			public Adapter caseFontTag(FontTag object) {
				return createFontTagAdapter();
			}
			@Override
			public Adapter caseBigTag(BigTag object) {
				return createBigTagAdapter();
			}
			@Override
			public Adapter caseSmallTag(SmallTag object) {
				return createSmallTagAdapter();
			}
			@Override
			public Adapter caseSupTag(SupTag object) {
				return createSupTagAdapter();
			}
			@Override
			public Adapter caseSubTag(SubTag object) {
				return createSubTagAdapter();
			}
			@Override
			public Adapter caseBlockQuoteTag(BlockQuoteTag object) {
				return createBlockQuoteTagAdapter();
			}
			@Override
			public Adapter caseAddressTag(AddressTag object) {
				return createAddressTagAdapter();
			}
			@Override
			public Adapter caseCodeTag(CodeTag object) {
				return createCodeTagAdapter();
			}
			@Override
			public Adapter caseCiteTag(CiteTag object) {
				return createCiteTagAdapter();
			}
			@Override
			public Adapter caseCaptionTag(CaptionTag object) {
				return createCaptionTagAdapter();
			}
			@Override
			public Adapter caseSampTag(SampTag object) {
				return createSampTagAdapter();
			}
			@Override
			public Adapter caseKbdTag(KbdTag object) {
				return createKbdTagAdapter();
			}
			@Override
			public Adapter caseTtTag(TtTag object) {
				return createTtTagAdapter();
			}
			@Override
			public Adapter caseCenterTag(CenterTag object) {
				return createCenterTagAdapter();
			}
			@Override
			public Adapter caseSpanTag(SpanTag object) {
				return createSpanTagAdapter();
			}
			@Override
			public Adapter caseDivTag(DivTag object) {
				return createDivTagAdapter();
			}
			@Override
			public Adapter caseAppletTag(AppletTag object) {
				return createAppletTagAdapter();
			}
			@Override
			public Adapter caseObjectTag(ObjectTag object) {
				return createObjectTagAdapter();
			}
			@Override
			public Adapter caseTableTag(TableTag object) {
				return createTableTagAdapter();
			}
			@Override
			public Adapter caseUITag(UITag object) {
				return createUITagAdapter();
			}
			@Override
			public Adapter caseOlTag(OlTag object) {
				return createOlTagAdapter();
			}
			@Override
			public Adapter caseDirTag(DirTag object) {
				return createDirTagAdapter();
			}
			@Override
			public Adapter caseMenutag(Menutag object) {
				return createMenutagAdapter();
			}
			@Override
			public Adapter caseDlTag(DlTag object) {
				return createDlTagAdapter();
			}
			@Override
			public Adapter caseFormTag(FormTag object) {
				return createFormTagAdapter();
			}
			@Override
			public Adapter caseInputTag(InputTag object) {
				return createInputTagAdapter();
			}
			@Override
			public Adapter caseSelectTag(SelectTag object) {
				return createSelectTagAdapter();
			}
			@Override
			public Adapter caseTextAreaTag(TextAreaTag object) {
				return createTextAreaTagAdapter();
			}
			@Override
			public Adapter caseTableRow(TableRow object) {
				return createTableRowAdapter();
			}
			@Override
			public Adapter caseTableCell(TableCell object) {
				return createTableCellAdapter();
			}
			@Override
			public Adapter caseTDTableCell(TDTableCell object) {
				return createTDTableCellAdapter();
			}
			@Override
			public Adapter caseTHTableCell(THTableCell object) {
				return createTHTableCellAdapter();
			}
			@Override
			public Adapter caseDefItem(DefItem object) {
				return createDefItemAdapter();
			}
			@Override
			public Adapter caseDdItem(DdItem object) {
				return createDdItemAdapter();
			}
			@Override
			public Adapter caseDtItem(DtItem object) {
				return createDtItemAdapter();
			}
			@Override
			public Adapter caseListItem(ListItem object) {
				return createListItemAdapter();
			}
			@Override
			public Adapter caseOption(Option object) {
				return createOptionAdapter();
			}
			@Override
			public Adapter caseMapItem(MapItem object) {
				return createMapItemAdapter();
			}
			@Override
			public Adapter caseArea(Area object) {
				return createAreaAdapter();
			}
			@Override
			public Adapter caseParam(Param object) {
				return createParamAdapter();
			}
			@Override
			public Adapter caseDSLTag(DSLTag object) {
				return createDSLTagAdapter();
			}
			@Override
			public Adapter caseDSLTagStructure(DSLTagStructure object) {
				return createDSLTagStructureAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link html.Document <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.Document
	 * @generated
	 */
	public Adapter createDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.DocType <em>Doc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.DocType
	 * @generated
	 */
	public Adapter createDocTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.StringValParameter <em>String Val Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.StringValParameter
	 * @generated
	 */
	public Adapter createStringValParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.ColorValParameter <em>Color Val Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.ColorValParameter
	 * @generated
	 */
	public Adapter createColorValParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.IDValParameter <em>ID Val Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.IDValParameter
	 * @generated
	 */
	public Adapter createIDValParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.IDParameter <em>ID Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.IDParameter
	 * @generated
	 */
	public Adapter createIDParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.StringParameter <em>String Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.StringParameter
	 * @generated
	 */
	public Adapter createStringParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.WebPageBody <em>Web Page Body</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.WebPageBody
	 * @generated
	 */
	public Adapter createWebPageBodyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.Head <em>Head</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.Head
	 * @generated
	 */
	public Adapter createHeadAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.Body <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.Body
	 * @generated
	 */
	public Adapter createBodyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.HeadItem <em>Head Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.HeadItem
	 * @generated
	 */
	public Adapter createHeadItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.TitleItem <em>Title Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.TitleItem
	 * @generated
	 */
	public Adapter createTitleItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.MetaItem <em>Meta Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.MetaItem
	 * @generated
	 */
	public Adapter createMetaItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.LinkItem <em>Link Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.LinkItem
	 * @generated
	 */
	public Adapter createLinkItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.BaseItem <em>Base Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.BaseItem
	 * @generated
	 */
	public Adapter createBaseItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.BaseFontItem <em>Base Font Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.BaseFontItem
	 * @generated
	 */
	public Adapter createBaseFontItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.ScriptItem <em>Script Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.ScriptItem
	 * @generated
	 */
	public Adapter createScriptItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.Content <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.Content
	 * @generated
	 */
	public Adapter createContentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.PContent <em>PContent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.PContent
	 * @generated
	 */
	public Adapter createPContentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.Tag
	 * @generated
	 */
	public Adapter createTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.Word <em>Word</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.Word
	 * @generated
	 */
	public Adapter createWordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.ImageTag <em>Image Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.ImageTag
	 * @generated
	 */
	public Adapter createImageTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.BrTag <em>Br Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.BrTag
	 * @generated
	 */
	public Adapter createBrTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.HrTag <em>Hr Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.HrTag
	 * @generated
	 */
	public Adapter createHrTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.PTag <em>PTag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.PTag
	 * @generated
	 */
	public Adapter createPTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.H1Tag <em>H1 Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.H1Tag
	 * @generated
	 */
	public Adapter createH1TagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.H2Tag <em>H2 Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.H2Tag
	 * @generated
	 */
	public Adapter createH2TagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.H3Tag <em>H3 Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.H3Tag
	 * @generated
	 */
	public Adapter createH3TagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.H4Tag <em>H4 Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.H4Tag
	 * @generated
	 */
	public Adapter createH4TagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.H5Tag <em>H5 Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.H5Tag
	 * @generated
	 */
	public Adapter createH5TagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.H6Tag <em>H6 Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.H6Tag
	 * @generated
	 */
	public Adapter createH6TagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.ATag <em>ATag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.ATag
	 * @generated
	 */
	public Adapter createATagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.MapTag <em>Map Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.MapTag
	 * @generated
	 */
	public Adapter createMapTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.BTag <em>BTag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.BTag
	 * @generated
	 */
	public Adapter createBTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.UTag <em>UTag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.UTag
	 * @generated
	 */
	public Adapter createUTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.EmTag <em>Em Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.EmTag
	 * @generated
	 */
	public Adapter createEmTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.ITag <em>ITag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.ITag
	 * @generated
	 */
	public Adapter createITagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.StrikeTag <em>Strike Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.StrikeTag
	 * @generated
	 */
	public Adapter createStrikeTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.StrongTag <em>Strong Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.StrongTag
	 * @generated
	 */
	public Adapter createStrongTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.FontTag <em>Font Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.FontTag
	 * @generated
	 */
	public Adapter createFontTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.BigTag <em>Big Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.BigTag
	 * @generated
	 */
	public Adapter createBigTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.SmallTag <em>Small Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.SmallTag
	 * @generated
	 */
	public Adapter createSmallTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.SupTag <em>Sup Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.SupTag
	 * @generated
	 */
	public Adapter createSupTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.SubTag <em>Sub Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.SubTag
	 * @generated
	 */
	public Adapter createSubTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.BlockQuoteTag <em>Block Quote Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.BlockQuoteTag
	 * @generated
	 */
	public Adapter createBlockQuoteTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.AddressTag <em>Address Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.AddressTag
	 * @generated
	 */
	public Adapter createAddressTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.CodeTag <em>Code Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.CodeTag
	 * @generated
	 */
	public Adapter createCodeTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.CiteTag <em>Cite Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.CiteTag
	 * @generated
	 */
	public Adapter createCiteTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.CaptionTag <em>Caption Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.CaptionTag
	 * @generated
	 */
	public Adapter createCaptionTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.SampTag <em>Samp Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.SampTag
	 * @generated
	 */
	public Adapter createSampTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.KbdTag <em>Kbd Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.KbdTag
	 * @generated
	 */
	public Adapter createKbdTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.TtTag <em>Tt Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.TtTag
	 * @generated
	 */
	public Adapter createTtTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.CenterTag <em>Center Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.CenterTag
	 * @generated
	 */
	public Adapter createCenterTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.SpanTag <em>Span Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.SpanTag
	 * @generated
	 */
	public Adapter createSpanTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.DivTag <em>Div Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.DivTag
	 * @generated
	 */
	public Adapter createDivTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.AppletTag <em>Applet Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.AppletTag
	 * @generated
	 */
	public Adapter createAppletTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.ObjectTag <em>Object Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.ObjectTag
	 * @generated
	 */
	public Adapter createObjectTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.TableTag <em>Table Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.TableTag
	 * @generated
	 */
	public Adapter createTableTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.UITag <em>UI Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.UITag
	 * @generated
	 */
	public Adapter createUITagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.OlTag <em>Ol Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.OlTag
	 * @generated
	 */
	public Adapter createOlTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.DirTag <em>Dir Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.DirTag
	 * @generated
	 */
	public Adapter createDirTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.Menutag <em>Menutag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.Menutag
	 * @generated
	 */
	public Adapter createMenutagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.DlTag <em>Dl Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.DlTag
	 * @generated
	 */
	public Adapter createDlTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.FormTag <em>Form Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.FormTag
	 * @generated
	 */
	public Adapter createFormTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.InputTag <em>Input Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.InputTag
	 * @generated
	 */
	public Adapter createInputTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.SelectTag <em>Select Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.SelectTag
	 * @generated
	 */
	public Adapter createSelectTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.TextAreaTag <em>Text Area Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.TextAreaTag
	 * @generated
	 */
	public Adapter createTextAreaTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.TableRow <em>Table Row</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.TableRow
	 * @generated
	 */
	public Adapter createTableRowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.TableCell <em>Table Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.TableCell
	 * @generated
	 */
	public Adapter createTableCellAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.TDTableCell <em>TD Table Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.TDTableCell
	 * @generated
	 */
	public Adapter createTDTableCellAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.THTableCell <em>TH Table Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.THTableCell
	 * @generated
	 */
	public Adapter createTHTableCellAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.DefItem <em>Def Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.DefItem
	 * @generated
	 */
	public Adapter createDefItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.DdItem <em>Dd Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.DdItem
	 * @generated
	 */
	public Adapter createDdItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.DtItem <em>Dt Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.DtItem
	 * @generated
	 */
	public Adapter createDtItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.ListItem <em>List Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.ListItem
	 * @generated
	 */
	public Adapter createListItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.Option <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.Option
	 * @generated
	 */
	public Adapter createOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.MapItem <em>Map Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.MapItem
	 * @generated
	 */
	public Adapter createMapItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.Area <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.Area
	 * @generated
	 */
	public Adapter createAreaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.Param <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.Param
	 * @generated
	 */
	public Adapter createParamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.DSLTag <em>DSL Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.DSLTag
	 * @generated
	 */
	public Adapter createDSLTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link html.DSLTagStructure <em>DSL Tag Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see html.DSLTagStructure
	 * @generated
	 */
	public Adapter createDSLTagStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //HtmlAdapterFactory
