/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.itu.sdg.language.xwpf.impl;

import dk.itu.sdg.language.xwpf.Run;
import dk.itu.sdg.language.xwpf.XwpfPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Run</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.RunImpl#getFontFamily <em>Font Family</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.RunImpl#getFontSize <em>Font Size</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.RunImpl#isIsBold <em>Is Bold</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.RunImpl#isIsItalic <em>Is Italic</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.RunImpl#isIsStrike <em>Is Strike</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.RunImpl#getColor <em>Color</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.RunImpl#getTextPosition <em>Text Position</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RunImpl extends ContentImpl implements Run {
	/**
	 * The default value of the '{@link #getFontFamily() <em>Font Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontFamily()
	 * @generated
	 * @ordered
	 */
	protected static final String FONT_FAMILY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFontFamily() <em>Font Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontFamily()
	 * @generated
	 * @ordered
	 */
	protected String fontFamily = FONT_FAMILY_EDEFAULT;

	/**
	 * The default value of the '{@link #getFontSize() <em>Font Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontSize()
	 * @generated
	 * @ordered
	 */
	protected static final int FONT_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFontSize() <em>Font Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontSize()
	 * @generated
	 * @ordered
	 */
	protected int fontSize = FONT_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsBold() <em>Is Bold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBold()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_BOLD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsBold() <em>Is Bold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBold()
	 * @generated
	 * @ordered
	 */
	protected boolean isBold = IS_BOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsItalic() <em>Is Italic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsItalic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ITALIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsItalic() <em>Is Italic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsItalic()
	 * @generated
	 * @ordered
	 */
	protected boolean isItalic = IS_ITALIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsStrike() <em>Is Strike</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStrike()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_STRIKE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsStrike() <em>Is Strike</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStrike()
	 * @generated
	 * @ordered
	 */
	protected boolean isStrike = IS_STRIKE_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final String COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected String color = COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getTextPosition() <em>Text Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int TEXT_POSITION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTextPosition() <em>Text Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextPosition()
	 * @generated
	 * @ordered
	 */
	protected int textPosition = TEXT_POSITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RunImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XwpfPackage.Literals.RUN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFontFamily() {
		return fontFamily;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontFamily(String newFontFamily) {
		String oldFontFamily = fontFamily;
		fontFamily = newFontFamily;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.RUN__FONT_FAMILY, oldFontFamily, fontFamily));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFontSize() {
		return fontSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontSize(int newFontSize) {
		int oldFontSize = fontSize;
		fontSize = newFontSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.RUN__FONT_SIZE, oldFontSize, fontSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsBold() {
		return isBold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsBold(boolean newIsBold) {
		boolean oldIsBold = isBold;
		isBold = newIsBold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.RUN__IS_BOLD, oldIsBold, isBold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsItalic() {
		return isItalic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsItalic(boolean newIsItalic) {
		boolean oldIsItalic = isItalic;
		isItalic = newIsItalic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.RUN__IS_ITALIC, oldIsItalic, isItalic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsStrike() {
		return isStrike;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsStrike(boolean newIsStrike) {
		boolean oldIsStrike = isStrike;
		isStrike = newIsStrike;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.RUN__IS_STRIKE, oldIsStrike, isStrike));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColor() {
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor(String newColor) {
		String oldColor = color;
		color = newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.RUN__COLOR, oldColor, color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTextPosition() {
		return textPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextPosition(int newTextPosition) {
		int oldTextPosition = textPosition;
		textPosition = newTextPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwpfPackage.RUN__TEXT_POSITION, oldTextPosition, textPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XwpfPackage.RUN__FONT_FAMILY:
				return getFontFamily();
			case XwpfPackage.RUN__FONT_SIZE:
				return getFontSize();
			case XwpfPackage.RUN__IS_BOLD:
				return isIsBold();
			case XwpfPackage.RUN__IS_ITALIC:
				return isIsItalic();
			case XwpfPackage.RUN__IS_STRIKE:
				return isIsStrike();
			case XwpfPackage.RUN__COLOR:
				return getColor();
			case XwpfPackage.RUN__TEXT_POSITION:
				return getTextPosition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XwpfPackage.RUN__FONT_FAMILY:
				setFontFamily((String)newValue);
				return;
			case XwpfPackage.RUN__FONT_SIZE:
				setFontSize((Integer)newValue);
				return;
			case XwpfPackage.RUN__IS_BOLD:
				setIsBold((Boolean)newValue);
				return;
			case XwpfPackage.RUN__IS_ITALIC:
				setIsItalic((Boolean)newValue);
				return;
			case XwpfPackage.RUN__IS_STRIKE:
				setIsStrike((Boolean)newValue);
				return;
			case XwpfPackage.RUN__COLOR:
				setColor((String)newValue);
				return;
			case XwpfPackage.RUN__TEXT_POSITION:
				setTextPosition((Integer)newValue);
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
			case XwpfPackage.RUN__FONT_FAMILY:
				setFontFamily(FONT_FAMILY_EDEFAULT);
				return;
			case XwpfPackage.RUN__FONT_SIZE:
				setFontSize(FONT_SIZE_EDEFAULT);
				return;
			case XwpfPackage.RUN__IS_BOLD:
				setIsBold(IS_BOLD_EDEFAULT);
				return;
			case XwpfPackage.RUN__IS_ITALIC:
				setIsItalic(IS_ITALIC_EDEFAULT);
				return;
			case XwpfPackage.RUN__IS_STRIKE:
				setIsStrike(IS_STRIKE_EDEFAULT);
				return;
			case XwpfPackage.RUN__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case XwpfPackage.RUN__TEXT_POSITION:
				setTextPosition(TEXT_POSITION_EDEFAULT);
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
			case XwpfPackage.RUN__FONT_FAMILY:
				return FONT_FAMILY_EDEFAULT == null ? fontFamily != null : !FONT_FAMILY_EDEFAULT.equals(fontFamily);
			case XwpfPackage.RUN__FONT_SIZE:
				return fontSize != FONT_SIZE_EDEFAULT;
			case XwpfPackage.RUN__IS_BOLD:
				return isBold != IS_BOLD_EDEFAULT;
			case XwpfPackage.RUN__IS_ITALIC:
				return isItalic != IS_ITALIC_EDEFAULT;
			case XwpfPackage.RUN__IS_STRIKE:
				return isStrike != IS_STRIKE_EDEFAULT;
			case XwpfPackage.RUN__COLOR:
				return COLOR_EDEFAULT == null ? color != null : !COLOR_EDEFAULT.equals(color);
			case XwpfPackage.RUN__TEXT_POSITION:
				return textPosition != TEXT_POSITION_EDEFAULT;
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
		result.append(" (fontFamily: ");
		result.append(fontFamily);
		result.append(", fontSize: ");
		result.append(fontSize);
		result.append(", isBold: ");
		result.append(isBold);
		result.append(", isItalic: ");
		result.append(isItalic);
		result.append(", isStrike: ");
		result.append(isStrike);
		result.append(", color: ");
		result.append(color);
		result.append(", textPosition: ");
		result.append(textPosition);
		result.append(')');
		return result.toString();
	}

} //RunImpl
