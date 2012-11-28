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
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("Content".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("nlpContent".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Document".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("bodyElements".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("comments".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("endnotes".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("footers".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("footnotes".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("headers".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("hyperlinks".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("numbering".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("packagePictures".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("paragraphs".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("pictures".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("tables".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("BodyElement".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Comment".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Footnote".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Footer".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Header".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Hyperlink".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Numbering".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("PictureData".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Paragraph".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("runs".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("part".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("body".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Table".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Run".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Part".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Body".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Sentence".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("words".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("dependencies".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Word".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("governors".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("dependents".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("PlainText".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dependency".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("governor".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("dependent".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dabbrev".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dacomp".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dadvcl".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dadvmod".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dagent".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Damod".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dappos".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dattr".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Daux".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dauxpass".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dcc".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dccomp".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dcomplm".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dconj".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("collapsedWord".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dcop".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dcsubj".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dcsubjpass".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Ddep".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Ddet".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Ddobj".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dexpl".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dinfmod".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Diobj".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dmark".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dmwe".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dneg".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dnn".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dnpadvmod".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dnsubj".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dnsubjpass".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dnum".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dnumber".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dparataxis".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dpartmod".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dpcomp".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dpobj".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dposs".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dpossessive".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dpreconj".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dpredet".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dprep".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dprepc".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dprt".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dpunct".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dpurpcl".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dquantmod".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Drcmod".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dref".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Drel".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dtmod".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dxcomp".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Dxsubj".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Droot".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Collapse".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("NLPParagraph".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("sentences".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("unrecognized".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Heading1".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Heading2".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("ListParagraph".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("null".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("isBold".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("isItalic".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("isStrike".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
