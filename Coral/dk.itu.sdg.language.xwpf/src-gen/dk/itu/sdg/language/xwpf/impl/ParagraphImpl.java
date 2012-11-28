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
package dk.itu.sdg.language.xwpf.impl;

import dk.itu.sdg.language.xwpf.Body;
import dk.itu.sdg.language.xwpf.Paragraph;
import dk.itu.sdg.language.xwpf.Part;
import dk.itu.sdg.language.xwpf.Run;
import dk.itu.sdg.language.xwpf.Style;
import dk.itu.sdg.language.xwpf.XwpfPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Paragraph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getRuns <em>Runs</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getPart <em>Part</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getBody <em>Body</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getAlignment <em>Alignment</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getBorderBottom <em>Border Bottom</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getBorderTop <em>Border Top</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getBorderBetween <em>Border Between</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getBorderLeft <em>Border Left</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getBorderRight <em>Border Right</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getVerticalAlignment <em>Vertical Alignment</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getFootnoteText <em>Footnote Text</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getIndentFstLine <em>Indent Fst Line</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getIndentHanging <em>Indent Hanging</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getIndentLeft <em>Indent Left</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getIndentRight <em>Indent Right</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getSpacingAfter <em>Spacing After</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getSpacingAfterLines <em>Spacing After Lines</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getSpacingBefore <em>Spacing Before</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getSpacingBeforeLines <em>Spacing Before Lines</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getSpacingLineRule <em>Spacing Line Rule</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.ParagraphImpl#getStyle <em>Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParagraphImpl extends ContentImpl implements Paragraph {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2012 \r\nRolf-Helge Pfeiffer (IT University Copenhagen)\r\nJan Reimann (TU Dresden, Software Technology Group)\r\nMirko Seifert (DevBoost GmbH)\r\n\r\nLicensed under the Apache License, Version 2.0 (the \"License\");\r\nyou may not use this file except in compliance with the License.\r\nYou may obtain a copy of the License at\r\n\r\n  http://www.apache.org/licenses/LICENSE-2.0\r\n\r\nUnless required by applicable law or agreed to in writing, software\r\ndistributed under the License is distributed on an \"AS IS\" BASIS,\r\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\r\nSee the License for the specific language governing permissions and\r\nlimitations under the License.";

	/**
	 * The cached value of the '{@link #getRuns() <em>Runs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuns()
	 * @generated
	 * @ordered
	 */
	protected EList<Run> runs;

	/**
	 * The cached value of the '{@link #getPart() <em>Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected Part part;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected Body body;

	/**
	 * The default value of the '{@link #getAlignment() <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlignment()
	 * @generated
	 * @ordered
	 */
	protected static final int ALIGNMENT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAlignment() <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlignment()
	 * @generated
	 * @ordered
	 */
	protected int alignment = ALIGNMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorderBottom() <em>Border Bottom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderBottom()
	 * @generated
	 * @ordered
	 */
	protected static final int BORDER_BOTTOM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBorderBottom() <em>Border Bottom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderBottom()
	 * @generated
	 * @ordered
	 */
	protected int borderBottom = BORDER_BOTTOM_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorderTop() <em>Border Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderTop()
	 * @generated
	 * @ordered
	 */
	protected static final int BORDER_TOP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBorderTop() <em>Border Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderTop()
	 * @generated
	 * @ordered
	 */
	protected int borderTop = BORDER_TOP_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorderBetween() <em>Border Between</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderBetween()
	 * @generated
	 * @ordered
	 */
	protected static final int BORDER_BETWEEN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBorderBetween() <em>Border Between</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderBetween()
	 * @generated
	 * @ordered
	 */
	protected int borderBetween = BORDER_BETWEEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorderLeft() <em>Border Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderLeft()
	 * @generated
	 * @ordered
	 */
	protected static final int BORDER_LEFT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBorderLeft() <em>Border Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderLeft()
	 * @generated
	 * @ordered
	 */
	protected int borderLeft = BORDER_LEFT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorderRight() <em>Border Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderRight()
	 * @generated
	 * @ordered
	 */
	protected static final int BORDER_RIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBorderRight() <em>Border Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderRight()
	 * @generated
	 * @ordered
	 */
	protected int borderRight = BORDER_RIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getVerticalAlignment() <em>Vertical Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerticalAlignment()
	 * @generated
	 * @ordered
	 */
	protected static final int VERTICAL_ALIGNMENT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVerticalAlignment() <em>Vertical Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerticalAlignment()
	 * @generated
	 * @ordered
	 */
	protected int verticalAlignment = VERTICAL_ALIGNMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFootnoteText() <em>Footnote Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFootnoteText()
	 * @generated
	 * @ordered
	 */
	protected static final String FOOTNOTE_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFootnoteText() <em>Footnote Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFootnoteText()
	 * @generated
	 * @ordered
	 */
	protected String footnoteText = FOOTNOTE_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndentFstLine() <em>Indent Fst Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndentFstLine()
	 * @generated
	 * @ordered
	 */
	protected static final int INDENT_FST_LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndentFstLine() <em>Indent Fst Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndentFstLine()
	 * @generated
	 * @ordered
	 */
	protected int indentFstLine = INDENT_FST_LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndentHanging() <em>Indent Hanging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndentHanging()
	 * @generated
	 * @ordered
	 */
	protected static final int INDENT_HANGING_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndentHanging() <em>Indent Hanging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndentHanging()
	 * @generated
	 * @ordered
	 */
	protected int indentHanging = INDENT_HANGING_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndentLeft() <em>Indent Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndentLeft()
	 * @generated
	 * @ordered
	 */
	protected static final int INDENT_LEFT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndentLeft() <em>Indent Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndentLeft()
	 * @generated
	 * @ordered
	 */
	protected int indentLeft = INDENT_LEFT_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndentRight() <em>Indent Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndentRight()
	 * @generated
	 * @ordered
	 */
	protected static final int INDENT_RIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndentRight() <em>Indent Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndentRight()
	 * @generated
	 * @ordered
	 */
	protected int indentRight = INDENT_RIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpacingAfter() <em>Spacing After</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpacingAfter()
	 * @generated
	 * @ordered
	 */
	protected static final int SPACING_AFTER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSpacingAfter() <em>Spacing After</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpacingAfter()
	 * @generated
	 * @ordered
	 */
	protected int spacingAfter = SPACING_AFTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpacingAfterLines() <em>Spacing After Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpacingAfterLines()
	 * @generated
	 * @ordered
	 */
	protected static final int SPACING_AFTER_LINES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSpacingAfterLines() <em>Spacing After Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpacingAfterLines()
	 * @generated
	 * @ordered
	 */
	protected int spacingAfterLines = SPACING_AFTER_LINES_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpacingBefore() <em>Spacing Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpacingBefore()
	 * @generated
	 * @ordered
	 */
	protected static final int SPACING_BEFORE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSpacingBefore() <em>Spacing Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpacingBefore()
	 * @generated
	 * @ordered
	 */
	protected int spacingBefore = SPACING_BEFORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpacingBeforeLines() <em>Spacing Before Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpacingBeforeLines()
	 * @generated
	 * @ordered
	 */
	protected static final int SPACING_BEFORE_LINES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSpacingBeforeLines() <em>Spacing Before Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpacingBeforeLines()
	 * @generated
	 * @ordered
	 */
	protected int spacingBeforeLines = SPACING_BEFORE_LINES_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpacingLineRule() <em>Spacing Line Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpacingLineRule()
	 * @generated
	 * @ordered
	 */
	protected static final int SPACING_LINE_RULE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSpacingLineRule() <em>Spacing Line Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpacingLineRule()
	 * @generated
	 * @ordered
	 */
	protected int spacingLineRule = SPACING_LINE_RULE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStyle() <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyle()
	 * @generated
	 * @ordered
	 */
	protected static final Style STYLE_EDEFAULT = Style.UNRECOGNIZED;

	/**
	 * The cached value of the '{@link #getStyle() <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyle()
	 * @generated
	 * @ordered
	 */
	protected Style style = STYLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParagraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XwpfPackage.Literals.PARAGRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Run> getRuns() {
		if (runs == null) {
			runs = new EObjectContainmentEList<Run>(Run.class, this, XwpfPackage.PARAGRAPH__RUNS);
		}
		return runs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part getPart() {
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPart(Part newPart, NotificationChain msgs) {
		Part oldPart = part;
		part = newPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__PART, oldPart, newPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPart(Part newPart) {
		if (newPart != part) {
			NotificationChain msgs = null;
			if (part != null)
				msgs = ((InternalEObject)part).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XwpfPackage.PARAGRAPH__PART, null, msgs);
			if (newPart != null)
				msgs = ((InternalEObject)newPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XwpfPackage.PARAGRAPH__PART, null, msgs);
			msgs = basicSetPart(newPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__PART, newPart, newPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Body getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(Body newBody, NotificationChain msgs) {
		Body oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(Body newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XwpfPackage.PARAGRAPH__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XwpfPackage.PARAGRAPH__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAlignment() {
		return alignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlignment(int newAlignment) {
		int oldAlignment = alignment;
		alignment = newAlignment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__ALIGNMENT, oldAlignment, alignment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBorderBottom() {
		return borderBottom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderBottom(int newBorderBottom) {
		int oldBorderBottom = borderBottom;
		borderBottom = newBorderBottom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__BORDER_BOTTOM, oldBorderBottom, borderBottom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBorderTop() {
		return borderTop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderTop(int newBorderTop) {
		int oldBorderTop = borderTop;
		borderTop = newBorderTop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__BORDER_TOP, oldBorderTop, borderTop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBorderBetween() {
		return borderBetween;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderBetween(int newBorderBetween) {
		int oldBorderBetween = borderBetween;
		borderBetween = newBorderBetween;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__BORDER_BETWEEN, oldBorderBetween, borderBetween));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBorderLeft() {
		return borderLeft;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderLeft(int newBorderLeft) {
		int oldBorderLeft = borderLeft;
		borderLeft = newBorderLeft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__BORDER_LEFT, oldBorderLeft, borderLeft));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBorderRight() {
		return borderRight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderRight(int newBorderRight) {
		int oldBorderRight = borderRight;
		borderRight = newBorderRight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__BORDER_RIGHT, oldBorderRight, borderRight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVerticalAlignment() {
		return verticalAlignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerticalAlignment(int newVerticalAlignment) {
		int oldVerticalAlignment = verticalAlignment;
		verticalAlignment = newVerticalAlignment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__VERTICAL_ALIGNMENT, oldVerticalAlignment, verticalAlignment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFootnoteText() {
		return footnoteText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFootnoteText(String newFootnoteText) {
		String oldFootnoteText = footnoteText;
		footnoteText = newFootnoteText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__FOOTNOTE_TEXT, oldFootnoteText, footnoteText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndentFstLine() {
		return indentFstLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndentFstLine(int newIndentFstLine) {
		int oldIndentFstLine = indentFstLine;
		indentFstLine = newIndentFstLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__INDENT_FST_LINE, oldIndentFstLine, indentFstLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndentHanging() {
		return indentHanging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndentHanging(int newIndentHanging) {
		int oldIndentHanging = indentHanging;
		indentHanging = newIndentHanging;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__INDENT_HANGING, oldIndentHanging, indentHanging));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndentLeft() {
		return indentLeft;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndentLeft(int newIndentLeft) {
		int oldIndentLeft = indentLeft;
		indentLeft = newIndentLeft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__INDENT_LEFT, oldIndentLeft, indentLeft));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndentRight() {
		return indentRight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndentRight(int newIndentRight) {
		int oldIndentRight = indentRight;
		indentRight = newIndentRight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__INDENT_RIGHT, oldIndentRight, indentRight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSpacingAfter() {
		return spacingAfter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpacingAfter(int newSpacingAfter) {
		int oldSpacingAfter = spacingAfter;
		spacingAfter = newSpacingAfter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__SPACING_AFTER, oldSpacingAfter, spacingAfter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSpacingAfterLines() {
		return spacingAfterLines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpacingAfterLines(int newSpacingAfterLines) {
		int oldSpacingAfterLines = spacingAfterLines;
		spacingAfterLines = newSpacingAfterLines;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__SPACING_AFTER_LINES, oldSpacingAfterLines, spacingAfterLines));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSpacingBefore() {
		return spacingBefore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpacingBefore(int newSpacingBefore) {
		int oldSpacingBefore = spacingBefore;
		spacingBefore = newSpacingBefore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__SPACING_BEFORE, oldSpacingBefore, spacingBefore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSpacingBeforeLines() {
		return spacingBeforeLines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpacingBeforeLines(int newSpacingBeforeLines) {
		int oldSpacingBeforeLines = spacingBeforeLines;
		spacingBeforeLines = newSpacingBeforeLines;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__SPACING_BEFORE_LINES, oldSpacingBeforeLines, spacingBeforeLines));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSpacingLineRule() {
		return spacingLineRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpacingLineRule(int newSpacingLineRule) {
		int oldSpacingLineRule = spacingLineRule;
		spacingLineRule = newSpacingLineRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__SPACING_LINE_RULE, oldSpacingLineRule, spacingLineRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Style getStyle() {
		return style;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStyle(Style newStyle) {
		Style oldStyle = style;
		style = newStyle == null ? STYLE_EDEFAULT : newStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.PARAGRAPH__STYLE, oldStyle, style));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XwpfPackage.PARAGRAPH__RUNS:
				return ((InternalEList<?>)getRuns()).basicRemove(otherEnd, msgs);
			case XwpfPackage.PARAGRAPH__PART:
				return basicSetPart(null, msgs);
			case XwpfPackage.PARAGRAPH__BODY:
				return basicSetBody(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XwpfPackage.PARAGRAPH__RUNS:
				return getRuns();
			case XwpfPackage.PARAGRAPH__PART:
				return getPart();
			case XwpfPackage.PARAGRAPH__BODY:
				return getBody();
			case XwpfPackage.PARAGRAPH__ALIGNMENT:
				return getAlignment();
			case XwpfPackage.PARAGRAPH__BORDER_BOTTOM:
				return getBorderBottom();
			case XwpfPackage.PARAGRAPH__BORDER_TOP:
				return getBorderTop();
			case XwpfPackage.PARAGRAPH__BORDER_BETWEEN:
				return getBorderBetween();
			case XwpfPackage.PARAGRAPH__BORDER_LEFT:
				return getBorderLeft();
			case XwpfPackage.PARAGRAPH__BORDER_RIGHT:
				return getBorderRight();
			case XwpfPackage.PARAGRAPH__VERTICAL_ALIGNMENT:
				return getVerticalAlignment();
			case XwpfPackage.PARAGRAPH__FOOTNOTE_TEXT:
				return getFootnoteText();
			case XwpfPackage.PARAGRAPH__INDENT_FST_LINE:
				return getIndentFstLine();
			case XwpfPackage.PARAGRAPH__INDENT_HANGING:
				return getIndentHanging();
			case XwpfPackage.PARAGRAPH__INDENT_LEFT:
				return getIndentLeft();
			case XwpfPackage.PARAGRAPH__INDENT_RIGHT:
				return getIndentRight();
			case XwpfPackage.PARAGRAPH__SPACING_AFTER:
				return getSpacingAfter();
			case XwpfPackage.PARAGRAPH__SPACING_AFTER_LINES:
				return getSpacingAfterLines();
			case XwpfPackage.PARAGRAPH__SPACING_BEFORE:
				return getSpacingBefore();
			case XwpfPackage.PARAGRAPH__SPACING_BEFORE_LINES:
				return getSpacingBeforeLines();
			case XwpfPackage.PARAGRAPH__SPACING_LINE_RULE:
				return getSpacingLineRule();
			case XwpfPackage.PARAGRAPH__STYLE:
				return getStyle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XwpfPackage.PARAGRAPH__RUNS:
				getRuns().clear();
				getRuns().addAll((Collection<? extends Run>)newValue);
				return;
			case XwpfPackage.PARAGRAPH__PART:
				setPart((Part)newValue);
				return;
			case XwpfPackage.PARAGRAPH__BODY:
				setBody((Body)newValue);
				return;
			case XwpfPackage.PARAGRAPH__ALIGNMENT:
				setAlignment((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__BORDER_BOTTOM:
				setBorderBottom((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__BORDER_TOP:
				setBorderTop((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__BORDER_BETWEEN:
				setBorderBetween((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__BORDER_LEFT:
				setBorderLeft((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__BORDER_RIGHT:
				setBorderRight((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__VERTICAL_ALIGNMENT:
				setVerticalAlignment((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__FOOTNOTE_TEXT:
				setFootnoteText((String)newValue);
				return;
			case XwpfPackage.PARAGRAPH__INDENT_FST_LINE:
				setIndentFstLine((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__INDENT_HANGING:
				setIndentHanging((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__INDENT_LEFT:
				setIndentLeft((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__INDENT_RIGHT:
				setIndentRight((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__SPACING_AFTER:
				setSpacingAfter((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__SPACING_AFTER_LINES:
				setSpacingAfterLines((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__SPACING_BEFORE:
				setSpacingBefore((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__SPACING_BEFORE_LINES:
				setSpacingBeforeLines((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__SPACING_LINE_RULE:
				setSpacingLineRule((Integer)newValue);
				return;
			case XwpfPackage.PARAGRAPH__STYLE:
				setStyle((Style)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case XwpfPackage.PARAGRAPH__RUNS:
				getRuns().clear();
				return;
			case XwpfPackage.PARAGRAPH__PART:
				setPart((Part)null);
				return;
			case XwpfPackage.PARAGRAPH__BODY:
				setBody((Body)null);
				return;
			case XwpfPackage.PARAGRAPH__ALIGNMENT:
				setAlignment(ALIGNMENT_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__BORDER_BOTTOM:
				setBorderBottom(BORDER_BOTTOM_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__BORDER_TOP:
				setBorderTop(BORDER_TOP_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__BORDER_BETWEEN:
				setBorderBetween(BORDER_BETWEEN_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__BORDER_LEFT:
				setBorderLeft(BORDER_LEFT_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__BORDER_RIGHT:
				setBorderRight(BORDER_RIGHT_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__VERTICAL_ALIGNMENT:
				setVerticalAlignment(VERTICAL_ALIGNMENT_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__FOOTNOTE_TEXT:
				setFootnoteText(FOOTNOTE_TEXT_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__INDENT_FST_LINE:
				setIndentFstLine(INDENT_FST_LINE_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__INDENT_HANGING:
				setIndentHanging(INDENT_HANGING_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__INDENT_LEFT:
				setIndentLeft(INDENT_LEFT_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__INDENT_RIGHT:
				setIndentRight(INDENT_RIGHT_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__SPACING_AFTER:
				setSpacingAfter(SPACING_AFTER_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__SPACING_AFTER_LINES:
				setSpacingAfterLines(SPACING_AFTER_LINES_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__SPACING_BEFORE:
				setSpacingBefore(SPACING_BEFORE_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__SPACING_BEFORE_LINES:
				setSpacingBeforeLines(SPACING_BEFORE_LINES_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__SPACING_LINE_RULE:
				setSpacingLineRule(SPACING_LINE_RULE_EDEFAULT);
				return;
			case XwpfPackage.PARAGRAPH__STYLE:
				setStyle(STYLE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XwpfPackage.PARAGRAPH__RUNS:
				return runs != null && !runs.isEmpty();
			case XwpfPackage.PARAGRAPH__PART:
				return part != null;
			case XwpfPackage.PARAGRAPH__BODY:
				return body != null;
			case XwpfPackage.PARAGRAPH__ALIGNMENT:
				return alignment != ALIGNMENT_EDEFAULT;
			case XwpfPackage.PARAGRAPH__BORDER_BOTTOM:
				return borderBottom != BORDER_BOTTOM_EDEFAULT;
			case XwpfPackage.PARAGRAPH__BORDER_TOP:
				return borderTop != BORDER_TOP_EDEFAULT;
			case XwpfPackage.PARAGRAPH__BORDER_BETWEEN:
				return borderBetween != BORDER_BETWEEN_EDEFAULT;
			case XwpfPackage.PARAGRAPH__BORDER_LEFT:
				return borderLeft != BORDER_LEFT_EDEFAULT;
			case XwpfPackage.PARAGRAPH__BORDER_RIGHT:
				return borderRight != BORDER_RIGHT_EDEFAULT;
			case XwpfPackage.PARAGRAPH__VERTICAL_ALIGNMENT:
				return verticalAlignment != VERTICAL_ALIGNMENT_EDEFAULT;
			case XwpfPackage.PARAGRAPH__FOOTNOTE_TEXT:
				return FOOTNOTE_TEXT_EDEFAULT == null ? footnoteText != null : !FOOTNOTE_TEXT_EDEFAULT.equals(footnoteText);
			case XwpfPackage.PARAGRAPH__INDENT_FST_LINE:
				return indentFstLine != INDENT_FST_LINE_EDEFAULT;
			case XwpfPackage.PARAGRAPH__INDENT_HANGING:
				return indentHanging != INDENT_HANGING_EDEFAULT;
			case XwpfPackage.PARAGRAPH__INDENT_LEFT:
				return indentLeft != INDENT_LEFT_EDEFAULT;
			case XwpfPackage.PARAGRAPH__INDENT_RIGHT:
				return indentRight != INDENT_RIGHT_EDEFAULT;
			case XwpfPackage.PARAGRAPH__SPACING_AFTER:
				return spacingAfter != SPACING_AFTER_EDEFAULT;
			case XwpfPackage.PARAGRAPH__SPACING_AFTER_LINES:
				return spacingAfterLines != SPACING_AFTER_LINES_EDEFAULT;
			case XwpfPackage.PARAGRAPH__SPACING_BEFORE:
				return spacingBefore != SPACING_BEFORE_EDEFAULT;
			case XwpfPackage.PARAGRAPH__SPACING_BEFORE_LINES:
				return spacingBeforeLines != SPACING_BEFORE_LINES_EDEFAULT;
			case XwpfPackage.PARAGRAPH__SPACING_LINE_RULE:
				return spacingLineRule != SPACING_LINE_RULE_EDEFAULT;
			case XwpfPackage.PARAGRAPH__STYLE:
				return style != STYLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (alignment: ");
		result.append(alignment);
		result.append(", borderBottom: ");
		result.append(borderBottom);
		result.append(", borderTop: ");
		result.append(borderTop);
		result.append(", borderBetween: ");
		result.append(borderBetween);
		result.append(", borderLeft: ");
		result.append(borderLeft);
		result.append(", borderRight: ");
		result.append(borderRight);
		result.append(", verticalAlignment: ");
		result.append(verticalAlignment);
		result.append(", footnoteText: ");
		result.append(footnoteText);
		result.append(", indentFstLine: ");
		result.append(indentFstLine);
		result.append(", indentHanging: ");
		result.append(indentHanging);
		result.append(", indentLeft: ");
		result.append(indentLeft);
		result.append(", indentRight: ");
		result.append(indentRight);
		result.append(", spacingAfter: ");
		result.append(spacingAfter);
		result.append(", spacingAfterLines: ");
		result.append(spacingAfterLines);
		result.append(", spacingBefore: ");
		result.append(spacingBefore);
		result.append(", spacingBeforeLines: ");
		result.append(spacingBeforeLines);
		result.append(", spacingLineRule: ");
		result.append(spacingLineRule);
		result.append(", style: ");
		result.append(style);
		result.append(')');
		return result.toString();
	}

} //ParagraphImpl
