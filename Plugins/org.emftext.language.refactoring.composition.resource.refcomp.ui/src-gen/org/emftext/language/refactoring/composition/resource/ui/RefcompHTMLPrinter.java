/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.ui;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.FontData;

/**
 * This class is copied from org.eclipse.jface.internal.text.html.HTMLPrinter.
 */
public class RefcompHTMLPrinter {
	
	/**
	 * <p>
	 * Reads the text contents from a reader of HTML contents and translates the tags
	 * or cut them out.
	 * </p>
	 * <p>
	 * <p>Moved into HTMLPrinter as inner class from
	 * <code>org.eclipse.jface.internal.text.html</code>.</p>
	 * </p>
	 */
	private static final class HTML2TextReader extends Reader {
		
		private static final String EMPTY_STRING= "";
		private Map<String, String> fgEntityLookup;
		private Set<String> fgTags;
		
		private int fCounter= 0;
		private TextPresentation fTextPresentation;
		private int fBold= 0;
		private int fStartOffset= -1;
		private boolean fInParagraph= false;
		private boolean fIsPreformattedText= false;
		private boolean fIgnore= false;
		private boolean fHeaderDetected= false;
		
		protected final String LINE_DELIM= System.getProperty("line.separator", "\n");
		
		private Reader fReader;
		protected boolean fWasWhiteSpace;
		private int fCharAfterWhiteSpace;
		
		/**
		 * Tells whether white space characters are skipped.
		 */
		private boolean fSkipWhiteSpace= true;
		
		private boolean fReadFromBuffer;
		private StringBuffer fBuffer;
		private int fIndex;
		
		/**
		 * <p>
		 * Transforms the HTML text from the reader to formatted text.
		 * </p>
		 * 
		 * @param reader the reader
		 * @param presentation If not <code>null</code>, formattings will be applied to
		 * the presentation.
		 */
		public HTML2TextReader(Reader reader, TextPresentation presentation) {
			
			fReader= reader;
			fBuffer= new StringBuffer();
			fIndex= 0;
			fReadFromBuffer= false;
			fCharAfterWhiteSpace= -1;
			fWasWhiteSpace= true;
			
			fgTags= new LinkedHashSet<String>();
			fgTags.add("b");
			fgTags.add("br");
			fgTags.add("br/");
			fgTags.add("br /");
			fgTags.add("div");
			fgTags.add("h1");
			fgTags.add("h2");
			fgTags.add("h3");
			fgTags.add("h4");
			fgTags.add("h5");
			fgTags.add("p");
			fgTags.add("dl");
			fgTags.add("dt");
			fgTags.add("dd");
			fgTags.add("li");
			fgTags.add("ul");
			fgTags.add("pre");
			fgTags.add("head");
			
			fgEntityLookup= new LinkedHashMap<String, String>(7);
			fgEntityLookup.put("lt", "<");
			fgEntityLookup.put("gt", ">");
			fgEntityLookup.put("nbsp", " ");
			fgEntityLookup.put("amp", "&");
			fgEntityLookup.put("circ", "^");
			fgEntityLookup.put("tilde", "~");
			fgEntityLookup.put("quot", "\"");
			fTextPresentation= presentation;
		}
		
		public int read() throws IOException {
			int c;
			do {
				
				c= nextChar();
				while (!fReadFromBuffer) {
					String s= computeSubstitution(c);
					if (s == null)					break;
					if (s.length() > 0)					fBuffer.insert(0, s);
					c= nextChar();
				}
				
			} while (fSkipWhiteSpace && fWasWhiteSpace && (c == ' '));
			fWasWhiteSpace= (c == ' ' || c == '\r' || c == '\n');
			if (c != -1)			++ fCounter;
			return c;
		}
		
		protected void startBold() {
			if (fBold == 0)			fStartOffset= fCounter;
			++ fBold;
		}
		
		protected void startPreformattedText() {
			fIsPreformattedText= true;
			setSkipWhitespace(false);
		}
		
		protected void stopPreformattedText() {
			fIsPreformattedText= false;
			setSkipWhitespace(true);
		}
		
		protected void stopBold() {
			-- fBold;
			if (fBold == 0) {
				if (fTextPresentation != null) {
					fTextPresentation.addStyleRange(new StyleRange(fStartOffset, fCounter - fStartOffset, null, null, SWT.BOLD));
				}
				fStartOffset= -1;
			}
		}
		
		/**
		 * 
		 * @see
		 * org.eclipse.jdt.internal.ui.text.SubstitutionTextReader#computeSubstitution(int)
		 */
		protected String computeSubstitution(int c) throws IOException {
			
			if (c == '<') {
				return  processHTMLTag();
			} else if (fIgnore) {
				return EMPTY_STRING;
			} else if (c == '&') {
				return processEntity();
			} else if (fIsPreformattedText) {
				return processPreformattedText(c);
			}
			
			return null;
		}
		
		private String html2Text(String html) {
			
			if (html == null || html.length() == 0) {
				return EMPTY_STRING;
			}
			
			html= html.toLowerCase();
			
			String tag= html;
			if ('/' == tag.charAt(0)) {
				tag= tag.substring(1);
			}
			
			if (!fgTags.contains(tag)) {
				return EMPTY_STRING;
			}
			
			if ("pre".equals(html)) {
				startPreformattedText();
				return EMPTY_STRING;
			}
			
			if ("/pre".equals(html)) {
				stopPreformattedText();
				return EMPTY_STRING;
			}
			
			if (fIsPreformattedText) {
				return EMPTY_STRING;
			}
			
			if ("b".equals(html)) {
				startBold();
				return EMPTY_STRING;
			}
			
			if ((html.length() > 1 && html.charAt(0) == 'h' && Character.isDigit(html.charAt(1))) || "dt".equals(html)) {
				startBold();
				return EMPTY_STRING;
			}
			
			if ("dl".equals(html)) {
				return LINE_DELIM;
			}
			
			if ("dd".equals(html)) {
				return "	";
			}
			
			if ("li".equals(html)) {
				return LINE_DELIM + "\t-\n ";
			}
			
			if ("/b".equals(html)) {
				stopBold();
				return EMPTY_STRING;
			}
			
			if ("p".equals(html)) {
				fInParagraph= true;
				return LINE_DELIM;
			}
			
			if ("br".equals(html) || "br/".equals(html)|| "br /".equals(html)  || "div".equals(html)) {
				return LINE_DELIM;
			}
			
			if ("/p".equals(html)) {
				boolean inParagraph= fInParagraph;
				fInParagraph= false;
				return inParagraph ? EMPTY_STRING : LINE_DELIM;
			}
			
			if ((html.startsWith("/h") && html.length() > 2 && Character.isDigit(html.charAt(2))) || "/dt".equals(html)) {
				stopBold();
				return LINE_DELIM;
			}
			
			if ("/dd".equals(html)) {
				return LINE_DELIM;
			}
			
			if ("head".equals(html) && !fHeaderDetected) {
				fHeaderDetected= true;
				fIgnore= true;
				return EMPTY_STRING;
			}
			
			if ("/head".equals(html) && fHeaderDetected && fIgnore) {
				fIgnore= false;
				return EMPTY_STRING;
			}
			
			return EMPTY_STRING;
		}
		
		/**
		 * A '<' has been read. Process a html tag
		 */
		private String processHTMLTag() throws IOException {
			
			StringBuffer buf= new StringBuffer();
			int ch;
			do {
				
				ch= nextChar();
				
				while (ch != -1 && ch != '>') {
					buf.append(Character.toLowerCase((char) ch));
					ch= nextChar();
					if (ch == '"') {
						buf.append(Character.toLowerCase((char) ch));
						ch= nextChar();
						while (ch != -1 && ch != '"') {
							buf.append(Character.toLowerCase((char) ch));
							ch= nextChar();
						}
					}
					if (ch == '<' && !isInComment(buf)) {
						unread(ch);
						return '<' + buf.toString();
					}
				}
				
				if (ch == -1) {
					return null;
				}
				
				if (!isInComment(buf) || isCommentEnd(buf)) {
					break;
				}
				// unfinished comment
				buf.append((char) ch);
			} while (true);
			
			return html2Text(buf.toString());
		}
		
		private boolean isInComment(StringBuffer buf) {
			return buf.length() >= 3 && "!--".equals(buf.substring(0, 3));
		}
		
		private boolean isCommentEnd(StringBuffer buf) {
			int tagLen= buf.length();
			return tagLen >= 5 && "--".equals(buf.substring(tagLen - 2));
		}
		
		private String processPreformattedText(int c) {
			if  (c == '\r' || c == '\n') {
				fCounter++;
			}
			return null;
		}
		
		
		private void unread(int ch) throws IOException {
			((PushbackReader) getReader()).unread(ch);
		}
		
		protected String entity2Text(String symbol) {
			if (symbol.length() > 1 && symbol.charAt(0) == '#') {
				int ch;
				try {
					if (symbol.charAt(1) == 'x') {
						ch= Integer.parseInt(symbol.substring(2), 16);
					} else {
						ch= Integer.parseInt(symbol.substring(1), 10);
					}
					return EMPTY_STRING + (char)ch;
				} catch (NumberFormatException e) {
				}
			} else {
				String str= (String) fgEntityLookup.get(symbol);
				if (str != null) {
					return str;
				}
			}
			return "&" + symbol; // not found
		}
		
		/**
		 * A '&' has been read. Process a entity
		 */
		private String processEntity() throws IOException {
			StringBuffer buf= new StringBuffer();
			int ch= nextChar();
			while (Character.isLetterOrDigit((char)ch) || ch == '#') {
				buf.append((char) ch);
				ch= nextChar();
			}
			
			if (ch == ';') {
				return entity2Text(buf.toString());
			}
			
			buf.insert(0, '&');
			if (ch != -1) {
				buf.append((char) ch);
			}
			return buf.toString();
		}
		
		public void close() throws IOException {
			fReader.close();
		}
		
		public int read(char[] cbuf, int off, int len) throws IOException {
			int end= off + len;
			for (int i= off; i < end; i++) {
				int ch= read();
				if (ch == -1) {
					if (i == off) {
						return -1;
					}
					return i - off;
				}
				cbuf[i]= (char)ch;
			}
			return len;
		}
		
		/**
		 * <p>
		 * Returns the internal reader.
		 * </p>
		 * 
		 * @return the internal reader
		 */
		protected Reader getReader() {
			return fReader;
		}
		
		/**
		 * <p>
		 * Returns the next character.
		 * </p>
		 * 
		 * @return the next character
		 * 
		 * @throws IOException in case reading the character fails
		 */
		protected int nextChar() throws IOException {
			fReadFromBuffer= (fBuffer.length() > 0);
			if (fReadFromBuffer) {
				char ch= fBuffer.charAt(fIndex++);
				if (fIndex >= fBuffer.length()) {
					fBuffer.setLength(0);
					fIndex= 0;
				}
				return ch;
			}
			
			int ch= fCharAfterWhiteSpace;
			if (ch == -1) {
				ch= fReader.read();
			}
			if (fSkipWhiteSpace && Character.isWhitespace((char)ch)) {
				do {
					ch= fReader.read();
				} while (Character.isWhitespace((char)ch));
				if (ch != -1) {
					fCharAfterWhiteSpace= ch;
					return ' ';
				}
			} else {
				fCharAfterWhiteSpace= -1;
			}
			return ch;
		}
		/**
		 * 
		 * @see Reader#ready()
		 */
		public boolean ready() throws IOException {
			return fReader.ready();
		}
		
		
		/**
		 * 
		 * @see Reader#reset()
		 */
		public void reset() throws IOException {
			fReader.reset();
			fWasWhiteSpace= true;
			fCharAfterWhiteSpace= -1;
			fBuffer.setLength(0);
			fIndex= 0;
		}
		
		protected final void setSkipWhitespace(boolean state) {
			fSkipWhiteSpace= state;
		}
		
		/**
		 * <p>
		 * Returns the readable content as string.
		 * </p>
		 * 
		 * @return the readable content as string
		 * 
		 * @throws IOException in case reading fails
		 */
		public String getString() throws IOException {
			StringBuffer buf= new StringBuffer();
			int ch;
			while ((ch= read()) != -1) {
				buf.append((char)ch);
			}
			return buf.toString();
		}
	}
	
	private static final String UNIT;
	// See: https://bugs.eclipse.org/bugs/show_bug.cgi?id=155993
	// if the platform is a mac the UNIT is set to "px"
	static {
		String platform = SWT.getPlatform();
		UNIT = (platform.equals("carbon")||platform.equals("cocoa")) ? "px" : "pt";
	}
	
	public static void addParagraph(StringBuffer buffer, String paragraph) {
		if (paragraph != null) {
			buffer.append("<p>");
			buffer.append(paragraph);
		}
	}
	
	public static void insertPageProlog(StringBuffer buffer, int position, String styleSheet) {
		
		StringBuffer pageProlog= new StringBuffer(300);
		
		pageProlog.append("<html>");
		
		if (styleSheet == null)		return;
		
		buffer.append("<head><style CHARSET=\"ISO-8859-1\" TYPE=\"text/css\">");
		buffer.append(styleSheet);
		buffer.append("</style></head><body>");
		
		buffer.insert(position,  pageProlog.toString());
	}
	
	public static void addPageEpilog(StringBuffer buffer) {
		buffer.append("</body></html>");
	}
	
	public static void addSmallHeader(StringBuffer buffer, String header) {
		if (header != null) {
			buffer.append("<h5>");
			buffer.append(header);
			buffer.append("</h5>");
		}
	}
	
	public static String convertTopLevelFont(String styles, FontData fontData) {
		boolean bold = (fontData.getStyle() & SWT.BOLD) != 0;
		boolean italic = (fontData.getStyle() & SWT.ITALIC) != 0;
		String size = Integer.toString(fontData.getHeight()) + UNIT;
		String family = "'" + fontData.getName() + "',sans-serif";
		
		styles = styles.replaceFirst("(html\\s*\\{.*(?:\\s|;)font-size:\\s*)\\d+pt(\\;?.*\\})", "$1" + size + "$2");
		styles = styles.replaceFirst("(html\\s*\\{.*(?:\\s|;)font-weight:\\s*)\\w+(\\;?.*\\})", "$1" + (bold ? "bold" : "normal") + "$2");
		styles = styles.replaceFirst("(html\\s*\\{.*(?:\\s|;)font-style:\\s*)\\w+(\\;?.*\\})", "$1" + (italic ? "italic" : "normal") + "$2");
		styles = styles.replaceFirst("(html\\s*\\{.*(?:\\s|;)font-family:\\s*).+?(;.*\\})", "$1" + family + "$2");
		return styles;
	}
	
	public static void insertStyles(StringBuffer buffer, String[] styles) {
		if (styles == null || styles.length == 0) {
			return;
		}
		
		StringBuffer styleBuf= new StringBuffer(10 * styles.length);
		for (int i= 0; i < styles.length; i++) {
			styleBuf.append(" style=\"");
			styleBuf.append(styles[i]);
			styleBuf.append('"');
		}
		
		// Find insertion index
		// a) within existing body tag with trailing space
		int index= buffer.indexOf("<body ");
		if (index != -1) {
			buffer.insert(index+5, styleBuf);
			return;
		}
		
		// b) within existing body tag without attributes
		index= buffer.indexOf("<body>");
		if (index != -1) {
			buffer.insert(index+5, ' ');
			buffer.insert(index+6, styleBuf);
			return;
		}
	}
	
	public static String html2text(StringReader stringReader, TextPresentation presentation) throws IOException {
		HTML2TextReader html2TextReader = new HTML2TextReader(stringReader, presentation);
		String text = html2TextReader.getString();
		html2TextReader.close();
		return text;
	}
	
}
