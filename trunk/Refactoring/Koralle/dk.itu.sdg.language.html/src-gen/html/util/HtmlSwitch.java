/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html.util;

import html.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see html.HtmlPackage
 * @generated
 */
public class HtmlSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static HtmlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HtmlSwitch() {
		if (modelPackage == null) {
			modelPackage = HtmlPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case HtmlPackage.DOCUMENT: {
				Document document = (Document)theEObject;
				T result = caseDocument(document);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.COMPLETE_DOCUMENT: {
				CompleteDocument completeDocument = (CompleteDocument)theEObject;
				T result = caseCompleteDocument(completeDocument);
				if (result == null) result = caseDocument(completeDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.CONTENT_DOCUMENT: {
				ContentDocument contentDocument = (ContentDocument)theEObject;
				T result = caseContentDocument(contentDocument);
				if (result == null) result = caseDocument(contentDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.DOC_TYPE: {
				DocType docType = (DocType)theEObject;
				T result = caseDocType(docType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.STRING_VAL_PARAMETER: {
				StringValParameter stringValParameter = (StringValParameter)theEObject;
				T result = caseStringValParameter(stringValParameter);
				if (result == null) result = caseParameter(stringValParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.COLOR_VAL_PARAMETER: {
				ColorValParameter colorValParameter = (ColorValParameter)theEObject;
				T result = caseColorValParameter(colorValParameter);
				if (result == null) result = caseParameter(colorValParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.ID_VAL_PARAMETER: {
				IDValParameter idValParameter = (IDValParameter)theEObject;
				T result = caseIDValParameter(idValParameter);
				if (result == null) result = caseParameter(idValParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.ID_PARAMETER: {
				IDParameter idParameter = (IDParameter)theEObject;
				T result = caseIDParameter(idParameter);
				if (result == null) result = caseParameter(idParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.STRING_PARAMETER: {
				StringParameter stringParameter = (StringParameter)theEObject;
				T result = caseStringParameter(stringParameter);
				if (result == null) result = caseParameter(stringParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.WEB_PAGE_BODY: {
				WebPageBody webPageBody = (WebPageBody)theEObject;
				T result = caseWebPageBody(webPageBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.HEAD: {
				Head head = (Head)theEObject;
				T result = caseHead(head);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.BODY: {
				Body body = (Body)theEObject;
				T result = caseBody(body);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.HEAD_ITEM: {
				HeadItem headItem = (HeadItem)theEObject;
				T result = caseHeadItem(headItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.TITLE_ITEM: {
				TitleItem titleItem = (TitleItem)theEObject;
				T result = caseTitleItem(titleItem);
				if (result == null) result = caseHeadItem(titleItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.META_ITEM: {
				MetaItem metaItem = (MetaItem)theEObject;
				T result = caseMetaItem(metaItem);
				if (result == null) result = caseHeadItem(metaItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.LINK_ITEM: {
				LinkItem linkItem = (LinkItem)theEObject;
				T result = caseLinkItem(linkItem);
				if (result == null) result = caseHeadItem(linkItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.BASE_ITEM: {
				BaseItem baseItem = (BaseItem)theEObject;
				T result = caseBaseItem(baseItem);
				if (result == null) result = caseHeadItem(baseItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.BASE_FONT_ITEM: {
				BaseFontItem baseFontItem = (BaseFontItem)theEObject;
				T result = caseBaseFontItem(baseFontItem);
				if (result == null) result = caseHeadItem(baseFontItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.SCRIPT_ITEM: {
				ScriptItem scriptItem = (ScriptItem)theEObject;
				T result = caseScriptItem(scriptItem);
				if (result == null) result = caseHeadItem(scriptItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.CONTENT: {
				Content content = (Content)theEObject;
				T result = caseContent(content);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.PCONTENT: {
				PContent pContent = (PContent)theEObject;
				T result = casePContent(pContent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.TAG: {
				Tag tag = (Tag)theEObject;
				T result = caseTag(tag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.WORD: {
				Word word = (Word)theEObject;
				T result = caseWord(word);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.IMAGE_TAG: {
				ImageTag imageTag = (ImageTag)theEObject;
				T result = caseImageTag(imageTag);
				if (result == null) result = caseTag(imageTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.BR_TAG: {
				BrTag brTag = (BrTag)theEObject;
				T result = caseBrTag(brTag);
				if (result == null) result = caseTag(brTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.HR_TAG: {
				HrTag hrTag = (HrTag)theEObject;
				T result = caseHrTag(hrTag);
				if (result == null) result = caseTag(hrTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.PTAG: {
				PTag pTag = (PTag)theEObject;
				T result = casePTag(pTag);
				if (result == null) result = caseTag(pTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.H1_TAG: {
				H1Tag h1Tag = (H1Tag)theEObject;
				T result = caseH1Tag(h1Tag);
				if (result == null) result = caseTag(h1Tag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.H2_TAG: {
				H2Tag h2Tag = (H2Tag)theEObject;
				T result = caseH2Tag(h2Tag);
				if (result == null) result = caseTag(h2Tag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.H3_TAG: {
				H3Tag h3Tag = (H3Tag)theEObject;
				T result = caseH3Tag(h3Tag);
				if (result == null) result = caseTag(h3Tag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.H4_TAG: {
				H4Tag h4Tag = (H4Tag)theEObject;
				T result = caseH4Tag(h4Tag);
				if (result == null) result = caseTag(h4Tag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.H5_TAG: {
				H5Tag h5Tag = (H5Tag)theEObject;
				T result = caseH5Tag(h5Tag);
				if (result == null) result = caseTag(h5Tag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.H6_TAG: {
				H6Tag h6Tag = (H6Tag)theEObject;
				T result = caseH6Tag(h6Tag);
				if (result == null) result = caseTag(h6Tag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.ATAG: {
				ATag aTag = (ATag)theEObject;
				T result = caseATag(aTag);
				if (result == null) result = caseTag(aTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.MAP_TAG: {
				MapTag mapTag = (MapTag)theEObject;
				T result = caseMapTag(mapTag);
				if (result == null) result = caseTag(mapTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.BTAG: {
				BTag bTag = (BTag)theEObject;
				T result = caseBTag(bTag);
				if (result == null) result = caseTag(bTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.UTAG: {
				UTag uTag = (UTag)theEObject;
				T result = caseUTag(uTag);
				if (result == null) result = caseTag(uTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.EM_TAG: {
				EmTag emTag = (EmTag)theEObject;
				T result = caseEmTag(emTag);
				if (result == null) result = caseTag(emTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.ITAG: {
				ITag iTag = (ITag)theEObject;
				T result = caseITag(iTag);
				if (result == null) result = caseTag(iTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.STRIKE_TAG: {
				StrikeTag strikeTag = (StrikeTag)theEObject;
				T result = caseStrikeTag(strikeTag);
				if (result == null) result = caseTag(strikeTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.STRONG_TAG: {
				StrongTag strongTag = (StrongTag)theEObject;
				T result = caseStrongTag(strongTag);
				if (result == null) result = caseTag(strongTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.FONT_TAG: {
				FontTag fontTag = (FontTag)theEObject;
				T result = caseFontTag(fontTag);
				if (result == null) result = caseTag(fontTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.BIG_TAG: {
				BigTag bigTag = (BigTag)theEObject;
				T result = caseBigTag(bigTag);
				if (result == null) result = caseTag(bigTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.SMALL_TAG: {
				SmallTag smallTag = (SmallTag)theEObject;
				T result = caseSmallTag(smallTag);
				if (result == null) result = caseTag(smallTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.SUP_TAG: {
				SupTag supTag = (SupTag)theEObject;
				T result = caseSupTag(supTag);
				if (result == null) result = caseTag(supTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.SUB_TAG: {
				SubTag subTag = (SubTag)theEObject;
				T result = caseSubTag(subTag);
				if (result == null) result = caseTag(subTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.BLOCK_QUOTE_TAG: {
				BlockQuoteTag blockQuoteTag = (BlockQuoteTag)theEObject;
				T result = caseBlockQuoteTag(blockQuoteTag);
				if (result == null) result = caseTag(blockQuoteTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.ADDRESS_TAG: {
				AddressTag addressTag = (AddressTag)theEObject;
				T result = caseAddressTag(addressTag);
				if (result == null) result = caseTag(addressTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.CODE_TAG: {
				CodeTag codeTag = (CodeTag)theEObject;
				T result = caseCodeTag(codeTag);
				if (result == null) result = caseTag(codeTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.CITE_TAG: {
				CiteTag citeTag = (CiteTag)theEObject;
				T result = caseCiteTag(citeTag);
				if (result == null) result = caseTag(citeTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.CAPTION_TAG: {
				CaptionTag captionTag = (CaptionTag)theEObject;
				T result = caseCaptionTag(captionTag);
				if (result == null) result = caseTag(captionTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.SAMP_TAG: {
				SampTag sampTag = (SampTag)theEObject;
				T result = caseSampTag(sampTag);
				if (result == null) result = caseTag(sampTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.KBD_TAG: {
				KbdTag kbdTag = (KbdTag)theEObject;
				T result = caseKbdTag(kbdTag);
				if (result == null) result = caseTag(kbdTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.TT_TAG: {
				TtTag ttTag = (TtTag)theEObject;
				T result = caseTtTag(ttTag);
				if (result == null) result = caseTag(ttTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.CENTER_TAG: {
				CenterTag centerTag = (CenterTag)theEObject;
				T result = caseCenterTag(centerTag);
				if (result == null) result = caseTag(centerTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.SPAN_TAG: {
				SpanTag spanTag = (SpanTag)theEObject;
				T result = caseSpanTag(spanTag);
				if (result == null) result = caseTag(spanTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.DIV_TAG: {
				DivTag divTag = (DivTag)theEObject;
				T result = caseDivTag(divTag);
				if (result == null) result = caseTag(divTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.APPLET_TAG: {
				AppletTag appletTag = (AppletTag)theEObject;
				T result = caseAppletTag(appletTag);
				if (result == null) result = caseTag(appletTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.OBJECT_TAG: {
				ObjectTag objectTag = (ObjectTag)theEObject;
				T result = caseObjectTag(objectTag);
				if (result == null) result = caseTag(objectTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.TABLE_TAG: {
				TableTag tableTag = (TableTag)theEObject;
				T result = caseTableTag(tableTag);
				if (result == null) result = caseTag(tableTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.UI_TAG: {
				UITag uiTag = (UITag)theEObject;
				T result = caseUITag(uiTag);
				if (result == null) result = caseTag(uiTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.OL_TAG: {
				OlTag olTag = (OlTag)theEObject;
				T result = caseOlTag(olTag);
				if (result == null) result = caseTag(olTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.DIR_TAG: {
				DirTag dirTag = (DirTag)theEObject;
				T result = caseDirTag(dirTag);
				if (result == null) result = caseTag(dirTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.MENUTAG: {
				Menutag menutag = (Menutag)theEObject;
				T result = caseMenutag(menutag);
				if (result == null) result = caseTag(menutag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.DL_TAG: {
				DlTag dlTag = (DlTag)theEObject;
				T result = caseDlTag(dlTag);
				if (result == null) result = caseTag(dlTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.FORM_TAG: {
				FormTag formTag = (FormTag)theEObject;
				T result = caseFormTag(formTag);
				if (result == null) result = caseTag(formTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.INPUT_TAG: {
				InputTag inputTag = (InputTag)theEObject;
				T result = caseInputTag(inputTag);
				if (result == null) result = caseTag(inputTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.SELECT_TAG: {
				SelectTag selectTag = (SelectTag)theEObject;
				T result = caseSelectTag(selectTag);
				if (result == null) result = caseTag(selectTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.TEXT_AREA_TAG: {
				TextAreaTag textAreaTag = (TextAreaTag)theEObject;
				T result = caseTextAreaTag(textAreaTag);
				if (result == null) result = caseTag(textAreaTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.TABLE_ROW: {
				TableRow tableRow = (TableRow)theEObject;
				T result = caseTableRow(tableRow);
				if (result == null) result = caseTag(tableRow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.TABLE_CELL: {
				TableCell tableCell = (TableCell)theEObject;
				T result = caseTableCell(tableCell);
				if (result == null) result = caseTag(tableCell);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.TD_TABLE_CELL: {
				TDTableCell tdTableCell = (TDTableCell)theEObject;
				T result = caseTDTableCell(tdTableCell);
				if (result == null) result = caseTableCell(tdTableCell);
				if (result == null) result = caseTag(tdTableCell);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.TH_TABLE_CELL: {
				THTableCell thTableCell = (THTableCell)theEObject;
				T result = caseTHTableCell(thTableCell);
				if (result == null) result = caseTableCell(thTableCell);
				if (result == null) result = caseTag(thTableCell);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.DEF_ITEM: {
				DefItem defItem = (DefItem)theEObject;
				T result = caseDefItem(defItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.DD_ITEM: {
				DdItem ddItem = (DdItem)theEObject;
				T result = caseDdItem(ddItem);
				if (result == null) result = caseDefItem(ddItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.DT_ITEM: {
				DtItem dtItem = (DtItem)theEObject;
				T result = caseDtItem(dtItem);
				if (result == null) result = caseDefItem(dtItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.LIST_ITEM: {
				ListItem listItem = (ListItem)theEObject;
				T result = caseListItem(listItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.OPTION: {
				Option option = (Option)theEObject;
				T result = caseOption(option);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.MAP_ITEM: {
				MapItem mapItem = (MapItem)theEObject;
				T result = caseMapItem(mapItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.AREA: {
				Area area = (Area)theEObject;
				T result = caseArea(area);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.PARAM: {
				Param param = (Param)theEObject;
				T result = caseParam(param);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.DSL_TAG: {
				DSLTag dslTag = (DSLTag)theEObject;
				T result = caseDSLTag(dslTag);
				if (result == null) result = caseTag(dslTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HtmlPackage.DSL_TAG_STRUCTURE: {
				DSLTagStructure dslTagStructure = (DSLTagStructure)theEObject;
				T result = caseDSLTagStructure(dslTagStructure);
				if (result == null) result = caseTag(dslTagStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocument(Document object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complete Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complete Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompleteDocument(CompleteDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Content Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Content Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContentDocument(ContentDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Doc Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Doc Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocType(DocType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Val Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Val Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringValParameter(StringValParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color Val Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color Val Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColorValParameter(ColorValParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ID Val Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ID Val Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDValParameter(IDValParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ID Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ID Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDParameter(IDParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringParameter(StringParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web Page Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web Page Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWebPageBody(WebPageBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Head</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Head</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHead(Head object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBody(Body object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Head Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Head Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHeadItem(HeadItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Title Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Title Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTitleItem(TitleItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaItem(MetaItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkItem(LinkItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseItem(BaseItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Font Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Font Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseFontItem(BaseFontItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScriptItem(ScriptItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Content</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Content</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContent(Content object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PContent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PContent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePContent(PContent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTag(Tag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Word</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Word</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWord(Word object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageTag(ImageTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Br Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Br Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBrTag(BrTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hr Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hr Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHrTag(HrTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PTag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PTag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePTag(PTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>H1 Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>H1 Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseH1Tag(H1Tag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>H2 Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>H2 Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseH2Tag(H2Tag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>H3 Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>H3 Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseH3Tag(H3Tag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>H4 Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>H4 Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseH4Tag(H4Tag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>H5 Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>H5 Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseH5Tag(H5Tag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>H6 Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>H6 Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseH6Tag(H6Tag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ATag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ATag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseATag(ATag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapTag(MapTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BTag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BTag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBTag(BTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UTag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UTag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUTag(UTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Em Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Em Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmTag(EmTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITag(ITag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Strike Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Strike Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStrikeTag(StrikeTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Strong Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Strong Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStrongTag(StrongTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Font Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Font Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFontTag(FontTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Big Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Big Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBigTag(BigTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Small Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Small Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSmallTag(SmallTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sup Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sup Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSupTag(SupTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubTag(SubTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Quote Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Quote Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockQuoteTag(BlockQuoteTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressTag(AddressTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeTag(CodeTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cite Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cite Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCiteTag(CiteTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Caption Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Caption Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaptionTag(CaptionTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Samp Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Samp Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSampTag(SampTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Kbd Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Kbd Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKbdTag(KbdTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tt Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tt Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTtTag(TtTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Center Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Center Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCenterTag(CenterTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Span Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Span Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpanTag(SpanTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Div Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Div Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDivTag(DivTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Applet Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Applet Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAppletTag(AppletTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectTag(ObjectTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTableTag(TableTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UI Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UI Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUITag(UITag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ol Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ol Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOlTag(OlTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dir Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dir Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirTag(DirTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Menutag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Menutag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMenutag(Menutag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dl Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dl Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDlTag(DlTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Form Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Form Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormTag(FormTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputTag(InputTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Select Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Select Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectTag(SelectTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Area Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Area Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextAreaTag(TextAreaTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table Row</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table Row</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTableRow(TableRow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table Cell</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table Cell</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTableCell(TableCell object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TD Table Cell</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TD Table Cell</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTDTableCell(TDTableCell object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TH Table Cell</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TH Table Cell</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTHTableCell(THTableCell object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Def Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Def Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefItem(DefItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dd Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dd Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDdItem(DdItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dt Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dt Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDtItem(DtItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListItem(ListItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOption(Option object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapItem(MapItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Area</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArea(Area object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParam(Param object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DSL Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DSL Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDSLTag(DSLTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DSL Tag Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DSL Tag Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDSLTagStructure(DSLTagStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //HtmlSwitch
