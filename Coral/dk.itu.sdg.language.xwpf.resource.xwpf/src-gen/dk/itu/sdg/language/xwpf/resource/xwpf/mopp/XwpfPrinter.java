/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfPrinter implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextPrinter {
	
	protected dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolverFactory tokenResolverFactory = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public XwpfPrinter(java.io.OutputStream outputStream, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof dk.itu.sdg.language.xwpf.Document) {
			print_dk_itu_sdg_language_xwpf_Document((dk.itu.sdg.language.xwpf.Document) element, globaltab, out);
			return;
		}
		if (element instanceof dk.itu.sdg.language.xwpf.BodyElement) {
			print_dk_itu_sdg_language_xwpf_BodyElement((dk.itu.sdg.language.xwpf.BodyElement) element, globaltab, out);
			return;
		}
		if (element instanceof dk.itu.sdg.language.xwpf.Comment) {
			print_dk_itu_sdg_language_xwpf_Comment((dk.itu.sdg.language.xwpf.Comment) element, globaltab, out);
			return;
		}
		if (element instanceof dk.itu.sdg.language.xwpf.Footnote) {
			print_dk_itu_sdg_language_xwpf_Footnote((dk.itu.sdg.language.xwpf.Footnote) element, globaltab, out);
			return;
		}
		if (element instanceof dk.itu.sdg.language.xwpf.Footer) {
			print_dk_itu_sdg_language_xwpf_Footer((dk.itu.sdg.language.xwpf.Footer) element, globaltab, out);
			return;
		}
		if (element instanceof dk.itu.sdg.language.xwpf.Header) {
			print_dk_itu_sdg_language_xwpf_Header((dk.itu.sdg.language.xwpf.Header) element, globaltab, out);
			return;
		}
		if (element instanceof dk.itu.sdg.language.xwpf.Hyperlink) {
			print_dk_itu_sdg_language_xwpf_Hyperlink((dk.itu.sdg.language.xwpf.Hyperlink) element, globaltab, out);
			return;
		}
		if (element instanceof dk.itu.sdg.language.xwpf.Numbering) {
			print_dk_itu_sdg_language_xwpf_Numbering((dk.itu.sdg.language.xwpf.Numbering) element, globaltab, out);
			return;
		}
		if (element instanceof dk.itu.sdg.language.xwpf.PictureData) {
			print_dk_itu_sdg_language_xwpf_PictureData((dk.itu.sdg.language.xwpf.PictureData) element, globaltab, out);
			return;
		}
		if (element instanceof dk.itu.sdg.language.xwpf.Paragraph) {
			print_dk_itu_sdg_language_xwpf_Paragraph((dk.itu.sdg.language.xwpf.Paragraph) element, globaltab, out);
			return;
		}
		if (element instanceof dk.itu.sdg.language.xwpf.Table) {
			print_dk_itu_sdg_language_xwpf_Table((dk.itu.sdg.language.xwpf.Table) element, globaltab, out);
			return;
		}
		if (element instanceof dk.itu.sdg.language.xwpf.Run) {
			print_dk_itu_sdg_language_xwpf_Run((dk.itu.sdg.language.xwpf.Run) element, globaltab, out);
			return;
		}
		if (element instanceof dk.itu.sdg.language.xwpf.Part) {
			print_dk_itu_sdg_language_xwpf_Part((dk.itu.sdg.language.xwpf.Part) element, globaltab, out);
			return;
		}
		if (element instanceof dk.itu.sdg.language.xwpf.Body) {
			print_dk_itu_sdg_language_xwpf_Body((dk.itu.sdg.language.xwpf.Body) element, globaltab, out);
			return;
		}
		if (element instanceof dk.itu.sdg.language.xwpf.Content) {
			print_dk_itu_sdg_language_xwpf_Content((dk.itu.sdg.language.xwpf.Content) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfReferenceResolverSwitch getReferenceResolverSwitch() {
		return (dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfReferenceResolverSwitch) new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfProblem(errorMessage, dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType.PRINT_PROBLEM, dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setEncoding(String encoding) {
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(outputStream), encoding));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_dk_itu_sdg_language_xwpf_Content(dk.itu.sdg.language.xwpf.Content element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.CONTENT__TEXT));
		printCountingMap.put("text", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.CONTENT__NLP_CONTENT));
		printCountingMap.put("nlpContent", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Content");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_dk_itu_sdg_language_xwpf_Content_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_dk_itu_sdg_language_xwpf_Content_0(dk.itu.sdg.language.xwpf.Content element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("text");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.CONTENT__TEXT));
			if (o != null) {
				dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.CONTENT__TEXT), element));
				out.print(" ");
			}
			printCountingMap.put("text", count - 1);
		}
	}
	
	
	public void print_dk_itu_sdg_language_xwpf_Document(dk.itu.sdg.language.xwpf.Document element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(13);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__BODY_ELEMENTS));
		printCountingMap.put("bodyElements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__COMMENTS));
		printCountingMap.put("comments", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__ENDNOTES));
		printCountingMap.put("endnotes", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__FOOTERS));
		printCountingMap.put("footers", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__FOOTNOTES));
		printCountingMap.put("footnotes", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__HEADERS));
		printCountingMap.put("headers", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__HYPERLINKS));
		printCountingMap.put("hyperlinks", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__NUMBERING));
		printCountingMap.put("numbering", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__PACKAGE_PICTURES));
		printCountingMap.put("packagePictures", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__PARAGRAPHS));
		printCountingMap.put("paragraphs", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__PICTURES));
		printCountingMap.put("pictures", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__STYLES));
		printCountingMap.put("styles", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__TABLES));
		printCountingMap.put("tables", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Document");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_dk_itu_sdg_language_xwpf_Document_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_dk_itu_sdg_language_xwpf_Document_0(dk.itu.sdg.language.xwpf.Document element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"bodyElements"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"comments"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"endnotes"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"footers"		));
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"footnotes"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"headers"		));
		if (tempMatchCount > matches) {
			alt = 5;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"hyperlinks"		));
		if (tempMatchCount > matches) {
			alt = 6;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"numbering"		));
		if (tempMatchCount > matches) {
			alt = 7;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"packagePictures"		));
		if (tempMatchCount > matches) {
			alt = 8;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"paragraphs"		));
		if (tempMatchCount > matches) {
			alt = 9;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"pictures"		));
		if (tempMatchCount > matches) {
			alt = 10;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"styles"		));
		if (tempMatchCount > matches) {
			alt = 11;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"tables"		));
		if (tempMatchCount > matches) {
			alt = 12;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("comments");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("comments");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__COMMENTS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("comments", count - 1);
				}
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("endnotes");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("endnotes");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__ENDNOTES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("endnotes", count - 1);
				}
			}
			break;
			case 3:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("footers");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("footers");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__FOOTERS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("footers", count - 1);
				}
			}
			break;
			case 4:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("footnotes");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("footnotes");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__FOOTNOTES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("footnotes", count - 1);
				}
			}
			break;
			case 5:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("headers");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("headers");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__HEADERS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("headers", count - 1);
				}
			}
			break;
			case 6:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("hyperlinks");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("hyperlinks");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__HYPERLINKS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("hyperlinks", count - 1);
				}
			}
			break;
			case 7:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("numbering");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("numbering");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__NUMBERING));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("numbering", count - 1);
				}
			}
			break;
			case 8:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("packagePictures");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("packagePictures");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__PACKAGE_PICTURES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("packagePictures", count - 1);
				}
			}
			break;
			case 9:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("paragraphs");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("paragraphs");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__PARAGRAPHS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("paragraphs", count - 1);
				}
			}
			break;
			case 10:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("pictures");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("pictures");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__PICTURES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("pictures", count - 1);
				}
			}
			break;
			case 11:			{
				// DEFINITION PART BEGINS (EnumTerminal)
				count = printCountingMap.get("styles");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__STYLES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
					}
					printCountingMap.put("styles", count - 1);
				}
			}
			break;
			case 12:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("tables");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("tables");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__TABLES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("tables", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("bodyElements");
			out.print(" ");
			// DEFINITION PART BEGINS (CsString)
			out.print(":");
			out.print(" ");
			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("bodyElements");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.DOCUMENT__BODY_ELEMENTS));
				java.util.List<?> list = (java.util.List<?>) o;
				int index = list.size() - count;
				if (index >= 0) {
					o = list.get(index);
				} else {
					o = null;
				}
				if (o != null) {
					doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
				}
				printCountingMap.put("bodyElements", count - 1);
			}
		}
	}
	
	
	public void print_dk_itu_sdg_language_xwpf_BodyElement(dk.itu.sdg.language.xwpf.BodyElement element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("BodyElement");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	
	
	public void print_dk_itu_sdg_language_xwpf_Comment(dk.itu.sdg.language.xwpf.Comment element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__TEXT));
		printCountingMap.put("text", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__NLP_CONTENT));
		printCountingMap.put("nlpContent", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__AUTHOR));
		printCountingMap.put("author", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__IDENTIFIER));
		printCountingMap.put("identifier", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Comment");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_dk_itu_sdg_language_xwpf_Comment_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_dk_itu_sdg_language_xwpf_Comment_0(dk.itu.sdg.language.xwpf.Comment element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"text"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"author"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"identifier"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderInQuotes)
				count = printCountingMap.get("author");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__AUTHOR));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__AUTHOR), element));
						out.print(" ");
					}
					printCountingMap.put("author", count - 1);
				}
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (PlaceholderInQuotes)
				count = printCountingMap.get("identifier");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__IDENTIFIER));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__IDENTIFIER), element));
						out.print(" ");
					}
					printCountingMap.put("identifier", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("text");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__TEXT));
				if (o != null) {
					dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.COMMENT__TEXT), element));
					out.print(" ");
				}
				printCountingMap.put("text", count - 1);
			}
		}
	}
	
	
	public void print_dk_itu_sdg_language_xwpf_Footnote(dk.itu.sdg.language.xwpf.Footnote element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.FOOTNOTE__TEXT));
		printCountingMap.put("text", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.FOOTNOTE__NLP_CONTENT));
		printCountingMap.put("nlpContent", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Footnote");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_dk_itu_sdg_language_xwpf_Footnote_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_dk_itu_sdg_language_xwpf_Footnote_0(dk.itu.sdg.language.xwpf.Footnote element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("text");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.FOOTNOTE__TEXT));
			if (o != null) {
				dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.FOOTNOTE__TEXT), element));
				out.print(" ");
			}
			printCountingMap.put("text", count - 1);
		}
	}
	
	
	public void print_dk_itu_sdg_language_xwpf_Footer(dk.itu.sdg.language.xwpf.Footer element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.FOOTER__TEXT));
		printCountingMap.put("text", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.FOOTER__NLP_CONTENT));
		printCountingMap.put("nlpContent", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Footer");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_dk_itu_sdg_language_xwpf_Footer_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_dk_itu_sdg_language_xwpf_Footer_0(dk.itu.sdg.language.xwpf.Footer element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("text");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.FOOTER__TEXT));
			if (o != null) {
				dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.FOOTER__TEXT), element));
				out.print(" ");
			}
			printCountingMap.put("text", count - 1);
		}
	}
	
	
	public void print_dk_itu_sdg_language_xwpf_Header(dk.itu.sdg.language.xwpf.Header element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HEADER__TEXT));
		printCountingMap.put("text", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HEADER__NLP_CONTENT));
		printCountingMap.put("nlpContent", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Header");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_dk_itu_sdg_language_xwpf_Header_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_dk_itu_sdg_language_xwpf_Header_0(dk.itu.sdg.language.xwpf.Header element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("text");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HEADER__TEXT));
			if (o != null) {
				dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HEADER__TEXT), element));
				out.print(" ");
			}
			printCountingMap.put("text", count - 1);
		}
	}
	
	
	public void print_dk_itu_sdg_language_xwpf_Hyperlink(dk.itu.sdg.language.xwpf.Hyperlink element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HYPERLINK__IDENTIFIER));
		printCountingMap.put("identifier", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HYPERLINK__URL));
		printCountingMap.put("url", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Hyperlink");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_dk_itu_sdg_language_xwpf_Hyperlink_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	
	public void print_dk_itu_sdg_language_xwpf_Hyperlink_0(dk.itu.sdg.language.xwpf.Hyperlink element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"identifier"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"url"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderInQuotes)
				count = printCountingMap.get("url");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HYPERLINK__URL));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HYPERLINK__URL), element));
						out.print(" ");
					}
					printCountingMap.put("url", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("identifier");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HYPERLINK__IDENTIFIER));
				if (o != null) {
					dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.HYPERLINK__IDENTIFIER), element));
					out.print(" ");
				}
				printCountingMap.put("identifier", count - 1);
			}
		}
	}
	
	
	public void print_dk_itu_sdg_language_xwpf_Numbering(dk.itu.sdg.language.xwpf.Numbering element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("Numbering");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	
	
	public void print_dk_itu_sdg_language_xwpf_PictureData(dk.itu.sdg.language.xwpf.PictureData element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("PictureData");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	
	
	public void print_dk_itu_sdg_language_xwpf_Paragraph(dk.itu.sdg.language.xwpf.Paragraph element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(23);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__TEXT));
		printCountingMap.put("text", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__NLP_CONTENT));
		printCountingMap.put("nlpContent", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__RUNS));
		printCountingMap.put("runs", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__PART));
		printCountingMap.put("part", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BODY));
		printCountingMap.put("body", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__ALIGNMENT));
		printCountingMap.put("alignment", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_BOTTOM));
		printCountingMap.put("borderBottom", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_TOP));
		printCountingMap.put("borderTop", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_BETWEEN));
		printCountingMap.put("borderBetween", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_LEFT));
		printCountingMap.put("borderLeft", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_RIGHT));
		printCountingMap.put("borderRight", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__VERTICAL_ALIGNMENT));
		printCountingMap.put("verticalAlignment", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__FOOTNOTE_TEXT));
		printCountingMap.put("footnoteText", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_FST_LINE));
		printCountingMap.put("indentFstLine", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_HANGING));
		printCountingMap.put("indentHanging", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_LEFT));
		printCountingMap.put("indentLeft", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_RIGHT));
		printCountingMap.put("indentRight", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_AFTER));
		printCountingMap.put("spacingAfter", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_AFTER_LINES));
		printCountingMap.put("spacingAfterLines", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_BEFORE));
		printCountingMap.put("spacingBefore", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_BEFORE_LINES));
		printCountingMap.put("spacingBeforeLines", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_LINE_RULE));
		printCountingMap.put("spacingLineRule", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__STYLE));
		printCountingMap.put("style", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Paragraph");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_dk_itu_sdg_language_xwpf_Paragraph_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_dk_itu_sdg_language_xwpf_Paragraph_0(dk.itu.sdg.language.xwpf.Paragraph element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"text"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"runs"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"part"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"body"		));
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"alignment"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"borderBottom"		));
		if (tempMatchCount > matches) {
			alt = 5;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"borderTop"		));
		if (tempMatchCount > matches) {
			alt = 6;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"borderBetween"		));
		if (tempMatchCount > matches) {
			alt = 7;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"borderLeft"		));
		if (tempMatchCount > matches) {
			alt = 8;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"borderRight"		));
		if (tempMatchCount > matches) {
			alt = 9;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"verticalAlignment"		));
		if (tempMatchCount > matches) {
			alt = 10;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"footnoteText"		));
		if (tempMatchCount > matches) {
			alt = 11;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"indentFstLine"		));
		if (tempMatchCount > matches) {
			alt = 12;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"indentHanging"		));
		if (tempMatchCount > matches) {
			alt = 13;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"indentLeft"		));
		if (tempMatchCount > matches) {
			alt = 14;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"indentRight"		));
		if (tempMatchCount > matches) {
			alt = 15;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"spacingAfter"		));
		if (tempMatchCount > matches) {
			alt = 16;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"spacingAfterLines"		));
		if (tempMatchCount > matches) {
			alt = 17;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"spacingBefore"		));
		if (tempMatchCount > matches) {
			alt = 18;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"spacingBeforeLines"		));
		if (tempMatchCount > matches) {
			alt = 19;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"spacingLineRule"		));
		if (tempMatchCount > matches) {
			alt = 20;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"style"		));
		if (tempMatchCount > matches) {
			alt = 21;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("runs");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("runs");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__RUNS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("runs", count - 1);
				}
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("part");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("part");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__PART));
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("part", count - 1);
				}
			}
			break;
			case 3:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("body");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("body");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BODY));
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("body", count - 1);
				}
			}
			break;
			case 4:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("alignment");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__ALIGNMENT));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__ALIGNMENT), element));
						out.print(" ");
					}
					printCountingMap.put("alignment", count - 1);
				}
			}
			break;
			case 5:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("borderBottom");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_BOTTOM));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_BOTTOM), element));
						out.print(" ");
					}
					printCountingMap.put("borderBottom", count - 1);
				}
			}
			break;
			case 6:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("borderTop");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_TOP));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_TOP), element));
						out.print(" ");
					}
					printCountingMap.put("borderTop", count - 1);
				}
			}
			break;
			case 7:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("borderBetween");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_BETWEEN));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_BETWEEN), element));
						out.print(" ");
					}
					printCountingMap.put("borderBetween", count - 1);
				}
			}
			break;
			case 8:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("borderLeft");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_LEFT));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_LEFT), element));
						out.print(" ");
					}
					printCountingMap.put("borderLeft", count - 1);
				}
			}
			break;
			case 9:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("borderRight");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_RIGHT));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__BORDER_RIGHT), element));
						out.print(" ");
					}
					printCountingMap.put("borderRight", count - 1);
				}
			}
			break;
			case 10:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("verticalAlignment");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__VERTICAL_ALIGNMENT));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__VERTICAL_ALIGNMENT), element));
						out.print(" ");
					}
					printCountingMap.put("verticalAlignment", count - 1);
				}
			}
			break;
			case 11:			{
				// DEFINITION PART BEGINS (PlaceholderInQuotes)
				count = printCountingMap.get("footnoteText");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__FOOTNOTE_TEXT));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__FOOTNOTE_TEXT), element));
						out.print(" ");
					}
					printCountingMap.put("footnoteText", count - 1);
				}
			}
			break;
			case 12:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("indentFstLine");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_FST_LINE));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_FST_LINE), element));
						out.print(" ");
					}
					printCountingMap.put("indentFstLine", count - 1);
				}
			}
			break;
			case 13:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("indentHanging");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_HANGING));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_HANGING), element));
						out.print(" ");
					}
					printCountingMap.put("indentHanging", count - 1);
				}
			}
			break;
			case 14:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("indentLeft");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_LEFT));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_LEFT), element));
						out.print(" ");
					}
					printCountingMap.put("indentLeft", count - 1);
				}
			}
			break;
			case 15:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("indentRight");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_RIGHT));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__INDENT_RIGHT), element));
						out.print(" ");
					}
					printCountingMap.put("indentRight", count - 1);
				}
			}
			break;
			case 16:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("spacingAfter");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_AFTER));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_AFTER), element));
						out.print(" ");
					}
					printCountingMap.put("spacingAfter", count - 1);
				}
			}
			break;
			case 17:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("spacingAfterLines");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_AFTER_LINES));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_AFTER_LINES), element));
						out.print(" ");
					}
					printCountingMap.put("spacingAfterLines", count - 1);
				}
			}
			break;
			case 18:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("spacingBefore");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_BEFORE));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_BEFORE), element));
						out.print(" ");
					}
					printCountingMap.put("spacingBefore", count - 1);
				}
			}
			break;
			case 19:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("spacingBeforeLines");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_BEFORE_LINES));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_BEFORE_LINES), element));
						out.print(" ");
					}
					printCountingMap.put("spacingBeforeLines", count - 1);
				}
			}
			break;
			case 20:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("spacingLineRule");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_LINE_RULE));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__SPACING_LINE_RULE), element));
						out.print(" ");
					}
					printCountingMap.put("spacingLineRule", count - 1);
				}
			}
			break;
			case 21:			{
				// DEFINITION PART BEGINS (EnumTerminal)
				count = printCountingMap.get("style");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__STYLE));
					if (o != null) {
					}
					printCountingMap.put("style", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("text");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__TEXT));
				if (o != null) {
					dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.PARAGRAPH__TEXT), element));
					out.print(" ");
				}
				printCountingMap.put("text", count - 1);
			}
		}
	}
	
	
	public void print_dk_itu_sdg_language_xwpf_Table(dk.itu.sdg.language.xwpf.Table element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("Table");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	
	
	public void print_dk_itu_sdg_language_xwpf_Run(dk.itu.sdg.language.xwpf.Run element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(9);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__TEXT));
		printCountingMap.put("text", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__NLP_CONTENT));
		printCountingMap.put("nlpContent", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__FONT_FAMILY));
		printCountingMap.put("fontFamily", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__FONT_SIZE));
		printCountingMap.put("fontSize", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_BOLD));
		printCountingMap.put("isBold", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_ITALIC));
		printCountingMap.put("isItalic", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_STRIKE));
		printCountingMap.put("isStrike", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__COLOR));
		printCountingMap.put("color", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__TEXT_POSITION));
		printCountingMap.put("textPosition", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("isBold");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_BOLD));
			if (o != null) {
			}
			printCountingMap.put("isBold", count - 1);
		}
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("isItalic");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_ITALIC));
			if (o != null) {
			}
			printCountingMap.put("isItalic", count - 1);
		}
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("isStrike");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__IS_STRIKE));
			if (o != null) {
			}
			printCountingMap.put("isStrike", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("Run");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_dk_itu_sdg_language_xwpf_Run_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_dk_itu_sdg_language_xwpf_Run_0(dk.itu.sdg.language.xwpf.Run element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"text"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"fontFamily"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"fontSize"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"color"		));
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"textPosition"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderInQuotes)
				count = printCountingMap.get("fontFamily");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__FONT_FAMILY));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__FONT_FAMILY), element));
						out.print(" ");
					}
					printCountingMap.put("fontFamily", count - 1);
				}
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("fontSize");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__FONT_SIZE));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__FONT_SIZE), element));
						out.print(" ");
					}
					printCountingMap.put("fontSize", count - 1);
				}
			}
			break;
			case 3:			{
				// DEFINITION PART BEGINS (PlaceholderInQuotes)
				count = printCountingMap.get("color");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__COLOR));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__COLOR), element));
						out.print(" ");
					}
					printCountingMap.put("color", count - 1);
				}
			}
			break;
			case 4:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("textPosition");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__TEXT_POSITION));
					if (o != null) {
						dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__TEXT_POSITION), element));
						out.print(" ");
					}
					printCountingMap.put("textPosition", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("text");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__TEXT));
				if (o != null) {
					dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(dk.itu.sdg.language.xwpf.XwpfPackage.RUN__TEXT), element));
					out.print(" ");
				}
				printCountingMap.put("text", count - 1);
			}
		}
	}
	
	
	public void print_dk_itu_sdg_language_xwpf_Part(dk.itu.sdg.language.xwpf.Part element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("Part");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	
	
	public void print_dk_itu_sdg_language_xwpf_Body(dk.itu.sdg.language.xwpf.Body element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("Body");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	
	
}
