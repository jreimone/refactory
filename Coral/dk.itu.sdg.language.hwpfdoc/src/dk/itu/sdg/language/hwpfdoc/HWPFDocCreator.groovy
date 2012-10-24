package dk.itu.sdg.language.hwpfdoc

import org.apache.poi.hwpf.HWPFDocument as POIDocument
import org.apache.poi.hwpf.model.StyleSheet as POIStyleSheet
import org.apache.poi.hwpf.usermodel.Range as POIRange
import org.apache.poi.hwpf.usermodel.Paragraph as POIParagraph
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.core.internal.resources.File


import dk.itu.sdg.language.hwpfdoc.resource.hwpfdoc.mopp.HwpfdocResourceFactory

class HWPFDocCreator {
	
//	public static void main(String[] args) {
	
	def uri
	def File file
	
	public HWPFDocCreator(File file) {
		this.file = file 
	}
	
	public EObject convertDocToModel() {
		
		this.uri = file.getLocationURI()
		
//		def wordDocument = new POIDocument(new FileInputStream("/Users/ropf/Documents/eclipse/indigo_dresden/dk.itu.sdg.language.hwpfdoc/example/report.doc"))
		def wordDocument = new POIDocument(new FileInputStream(file.getLocation().toString()))
		
				
//		wordDocument.getParagraphTable().getParagraphs()
		
		def POIRange headerRange = wordDocument.getHeaderStoryRange()
		def POIRange footerRange = wordDocument.getFootnoteRange()
		def POIRange innerRange = wordDocument.getRange()
		def POIRange commentsRange = wordDocument.getCommentsRange()
		def ranges = []
		ranges.add(headerRange)
		ranges.add(footerRange)
		ranges.add(innerRange)
		ranges.add(commentsRange)
				
		def POIStyleSheet styleSheet = wordDocument.getStyleSheet()

		
		
		def HwpfdocFactory factory = HwpfdocFactory.eINSTANCE;
		def Document modelDocument = factory.createDocument()
		
		def Range modelRange
		
		def HeaderStoryRange modelHeaderRange = factory.createHeaderStoryRange()
		modelRange = convertRange(headerRange, (Range)modelHeaderRange, factory)
		addRanges(modelDocument, modelRange)
		
		def FootnoteRange modelFooterRange = factory.createFootnoteRange()
		modelRange = convertRange(footerRange, (Range)modelFooterRange, factory)
		addRanges(modelDocument, modelRange)
		
		def InnerRange modelInnerRange = factory.createInnerRange()
		modelRange = convertRange(innerRange, (Range)modelInnerRange, factory)
		addRanges(modelDocument, modelRange)
		
		def CommentsRange modelCommentsRange = factory.createCommentsRange()
		modelRange = convertRange(commentsRange, (Range)modelCommentsRange, factory)
		addRanges(modelDocument, modelRange)
		
		return modelDocument
	}
	
	private Range convertRange(POIRange range, Range modelRange, HwpfdocFactory factory) {
		def int numberOfHeaderParagraphs = range.numParagraphs()
		
		for (int i = 0; i < numberOfHeaderParagraphs; i++) {
			def POIParagraph headerParagraph = range.getParagraph(i)
			def String contentText = headerParagraph.text()
			
			if(!contentText.isEmpty()) {
				def Paragraph modelParagraph = factory.createParagraph()
				modelParagraph.setText(contentText)
				writePlainText(contentText)
				addParagraphs(modelRange, modelParagraph)
			}
		}
		return modelRange
	}
	
	private void addParagraphs(Range range, Paragraph paragraph) {
		if (range.paragraphs == null) {
			range.paragraphs = []
		}
		range.paragraphs.add(paragraph)
	}
	
	private void addParagraphs(Range range, Collection<Paragraph> paragraphs) {
		if (range.paragraphs == null) {
			range.paragraphs = []
		}
		range.paragraphs.addAll(paragraphs)
	}
	
	private void addRanges(Document document, Range range) {
		if (document.ranges == null) {
			document.ranges = []
		}
		document.ranges.add(range)
	}
	
	private void addRanges(Document document, Collection<Range> ranges) {
		if (document.ranges == null) {
			document.ranges = []
		}
		document.ranges.addAll(ranges)
	}
	
	public void saveModel(Document modelDocument) {
		
		
		Resource.Factory.Registry resourceRegistry = Resource.Factory.Registry.INSTANCE
		Map<String, Object> m = resourceRegistry.getExtensionToFactoryMap()
		m.put("hwpfdoc", new HwpfdocResourceFactory())
//		m.put("hwpfdoc", new XMIResourceFactoryImpl())
	
		ResourceSet resourceSet = new ResourceSetImpl()
		Resource resource = resourceSet.createResource(URI.createURI("myDoc.hwpfdoc"))
		
		resource.getContents().add(modelDocument)
	
		try {
			resource.save(m)
		} catch (IOException e) {
			e.printStackTrace()
		}
	}
	
	private void writePlainText(String text) {
		println(text)
	}
}
