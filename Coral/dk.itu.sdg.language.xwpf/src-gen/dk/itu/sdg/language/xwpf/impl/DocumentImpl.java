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

import dk.itu.sdg.language.xwpf.BodyElement;
import dk.itu.sdg.language.xwpf.Comment;
import dk.itu.sdg.language.xwpf.Document;
import dk.itu.sdg.language.xwpf.Footer;
import dk.itu.sdg.language.xwpf.Footnote;
import dk.itu.sdg.language.xwpf.Header;
import dk.itu.sdg.language.xwpf.Hyperlink;
import dk.itu.sdg.language.xwpf.Numbering;
import dk.itu.sdg.language.xwpf.Paragraph;
import dk.itu.sdg.language.xwpf.PictureData;
import dk.itu.sdg.language.xwpf.Style;
import dk.itu.sdg.language.xwpf.Table;
import dk.itu.sdg.language.xwpf.XwpfPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl#getBodyElements <em>Body Elements</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl#getEndnotes <em>Endnotes</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl#getFooters <em>Footers</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl#getFootnotes <em>Footnotes</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl#getHeaders <em>Headers</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl#getHyperlinks <em>Hyperlinks</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl#getNumbering <em>Numbering</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl#getPackagePictures <em>Package Pictures</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl#getParagraphs <em>Paragraphs</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl#getPictures <em>Pictures</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl#getStyles <em>Styles</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.impl.DocumentImpl#getTables <em>Tables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentImpl extends EObjectImpl implements Document {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2012 \r\nRolf-Helge Pfeiffer (IT University Copenhagen)\r\nJan Reimann (TU Dresden, Software Technology Group)\r\nMirko Seifert (DevBoost GmbH)\r\n\r\nLicensed under the Apache License, Version 2.0 (the \"License\");\r\nyou may not use this file except in compliance with the License.\r\nYou may obtain a copy of the License at\r\n\r\n  http://www.apache.org/licenses/LICENSE-2.0\r\n\r\nUnless required by applicable law or agreed to in writing, software\r\ndistributed under the License is distributed on an \"AS IS\" BASIS,\r\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\r\nSee the License for the specific language governing permissions and\r\nlimitations under the License.";

	/**
	 * The cached value of the '{@link #getBodyElements() <em>Body Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyElements()
	 * @generated
	 * @ordered
	 */
	protected EList<BodyElement> bodyElements;

	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> comments;

	/**
	 * The cached value of the '{@link #getEndnotes() <em>Endnotes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndnotes()
	 * @generated
	 * @ordered
	 */
	protected EList<Footnote> endnotes;

	/**
	 * The cached value of the '{@link #getFooters() <em>Footers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFooters()
	 * @generated
	 * @ordered
	 */
	protected EList<Footer> footers;

	/**
	 * The cached value of the '{@link #getFootnotes() <em>Footnotes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFootnotes()
	 * @generated
	 * @ordered
	 */
	protected EList<Footnote> footnotes;

	/**
	 * The cached value of the '{@link #getHeaders() <em>Headers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaders()
	 * @generated
	 * @ordered
	 */
	protected EList<Header> headers;

	/**
	 * The cached value of the '{@link #getHyperlinks() <em>Hyperlinks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHyperlinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Hyperlink> hyperlinks;

	/**
	 * The cached value of the '{@link #getNumbering() <em>Numbering</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumbering()
	 * @generated
	 * @ordered
	 */
	protected EList<Numbering> numbering;

	/**
	 * The cached value of the '{@link #getPackagePictures() <em>Package Pictures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackagePictures()
	 * @generated
	 * @ordered
	 */
	protected EList<PictureData> packagePictures;

	/**
	 * The cached value of the '{@link #getParagraphs() <em>Paragraphs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParagraphs()
	 * @generated
	 * @ordered
	 */
	protected EList<Paragraph> paragraphs;

	/**
	 * The cached value of the '{@link #getPictures() <em>Pictures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPictures()
	 * @generated
	 * @ordered
	 */
	protected EList<PictureData> pictures;

	/**
	 * The cached value of the '{@link #getStyles() <em>Styles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyles()
	 * @generated
	 * @ordered
	 */
	protected EList<Style> styles;

	/**
	 * The cached value of the '{@link #getTables() <em>Tables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTables()
	 * @generated
	 * @ordered
	 */
	protected EList<Table> tables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XwpfPackage.Literals.DOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BodyElement> getBodyElements() {
		if (bodyElements == null) {
			bodyElements = new EObjectContainmentEList<BodyElement>(BodyElement.class, this, XwpfPackage.DOCUMENT__BODY_ELEMENTS);
		}
		return bodyElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getComments() {
		if (comments == null) {
			comments = new EObjectContainmentEList<Comment>(Comment.class, this, XwpfPackage.DOCUMENT__COMMENTS);
		}
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Footnote> getEndnotes() {
		if (endnotes == null) {
			endnotes = new EObjectContainmentEList<Footnote>(Footnote.class, this, XwpfPackage.DOCUMENT__ENDNOTES);
		}
		return endnotes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Footer> getFooters() {
		if (footers == null) {
			footers = new EObjectContainmentEList<Footer>(Footer.class, this, XwpfPackage.DOCUMENT__FOOTERS);
		}
		return footers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Footnote> getFootnotes() {
		if (footnotes == null) {
			footnotes = new EObjectContainmentEList<Footnote>(Footnote.class, this, XwpfPackage.DOCUMENT__FOOTNOTES);
		}
		return footnotes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Header> getHeaders() {
		if (headers == null) {
			headers = new EObjectContainmentEList<Header>(Header.class, this, XwpfPackage.DOCUMENT__HEADERS);
		}
		return headers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Hyperlink> getHyperlinks() {
		if (hyperlinks == null) {
			hyperlinks = new EObjectContainmentEList<Hyperlink>(Hyperlink.class, this, XwpfPackage.DOCUMENT__HYPERLINKS);
		}
		return hyperlinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Numbering> getNumbering() {
		if (numbering == null) {
			numbering = new EObjectContainmentEList<Numbering>(Numbering.class, this, XwpfPackage.DOCUMENT__NUMBERING);
		}
		return numbering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PictureData> getPackagePictures() {
		if (packagePictures == null) {
			packagePictures = new EObjectContainmentEList<PictureData>(PictureData.class, this, XwpfPackage.DOCUMENT__PACKAGE_PICTURES);
		}
		return packagePictures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Paragraph> getParagraphs() {
		if (paragraphs == null) {
			paragraphs = new EObjectContainmentEList<Paragraph>(Paragraph.class, this, XwpfPackage.DOCUMENT__PARAGRAPHS);
		}
		return paragraphs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PictureData> getPictures() {
		if (pictures == null) {
			pictures = new EObjectContainmentEList<PictureData>(PictureData.class, this, XwpfPackage.DOCUMENT__PICTURES);
		}
		return pictures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Style> getStyles() {
		if (styles == null) {
			styles = new EDataTypeUniqueEList<Style>(Style.class, this, XwpfPackage.DOCUMENT__STYLES);
		}
		return styles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Table> getTables() {
		if (tables == null) {
			tables = new EObjectContainmentEList<Table>(Table.class, this, XwpfPackage.DOCUMENT__TABLES);
		}
		return tables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XwpfPackage.DOCUMENT__BODY_ELEMENTS:
				return ((InternalEList<?>)getBodyElements()).basicRemove(otherEnd, msgs);
			case XwpfPackage.DOCUMENT__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case XwpfPackage.DOCUMENT__ENDNOTES:
				return ((InternalEList<?>)getEndnotes()).basicRemove(otherEnd, msgs);
			case XwpfPackage.DOCUMENT__FOOTERS:
				return ((InternalEList<?>)getFooters()).basicRemove(otherEnd, msgs);
			case XwpfPackage.DOCUMENT__FOOTNOTES:
				return ((InternalEList<?>)getFootnotes()).basicRemove(otherEnd, msgs);
			case XwpfPackage.DOCUMENT__HEADERS:
				return ((InternalEList<?>)getHeaders()).basicRemove(otherEnd, msgs);
			case XwpfPackage.DOCUMENT__HYPERLINKS:
				return ((InternalEList<?>)getHyperlinks()).basicRemove(otherEnd, msgs);
			case XwpfPackage.DOCUMENT__NUMBERING:
				return ((InternalEList<?>)getNumbering()).basicRemove(otherEnd, msgs);
			case XwpfPackage.DOCUMENT__PACKAGE_PICTURES:
				return ((InternalEList<?>)getPackagePictures()).basicRemove(otherEnd, msgs);
			case XwpfPackage.DOCUMENT__PARAGRAPHS:
				return ((InternalEList<?>)getParagraphs()).basicRemove(otherEnd, msgs);
			case XwpfPackage.DOCUMENT__PICTURES:
				return ((InternalEList<?>)getPictures()).basicRemove(otherEnd, msgs);
			case XwpfPackage.DOCUMENT__TABLES:
				return ((InternalEList<?>)getTables()).basicRemove(otherEnd, msgs);
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
			case XwpfPackage.DOCUMENT__BODY_ELEMENTS:
				return getBodyElements();
			case XwpfPackage.DOCUMENT__COMMENTS:
				return getComments();
			case XwpfPackage.DOCUMENT__ENDNOTES:
				return getEndnotes();
			case XwpfPackage.DOCUMENT__FOOTERS:
				return getFooters();
			case XwpfPackage.DOCUMENT__FOOTNOTES:
				return getFootnotes();
			case XwpfPackage.DOCUMENT__HEADERS:
				return getHeaders();
			case XwpfPackage.DOCUMENT__HYPERLINKS:
				return getHyperlinks();
			case XwpfPackage.DOCUMENT__NUMBERING:
				return getNumbering();
			case XwpfPackage.DOCUMENT__PACKAGE_PICTURES:
				return getPackagePictures();
			case XwpfPackage.DOCUMENT__PARAGRAPHS:
				return getParagraphs();
			case XwpfPackage.DOCUMENT__PICTURES:
				return getPictures();
			case XwpfPackage.DOCUMENT__STYLES:
				return getStyles();
			case XwpfPackage.DOCUMENT__TABLES:
				return getTables();
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
			case XwpfPackage.DOCUMENT__BODY_ELEMENTS:
				getBodyElements().clear();
				getBodyElements().addAll((Collection<? extends BodyElement>)newValue);
				return;
			case XwpfPackage.DOCUMENT__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case XwpfPackage.DOCUMENT__ENDNOTES:
				getEndnotes().clear();
				getEndnotes().addAll((Collection<? extends Footnote>)newValue);
				return;
			case XwpfPackage.DOCUMENT__FOOTERS:
				getFooters().clear();
				getFooters().addAll((Collection<? extends Footer>)newValue);
				return;
			case XwpfPackage.DOCUMENT__FOOTNOTES:
				getFootnotes().clear();
				getFootnotes().addAll((Collection<? extends Footnote>)newValue);
				return;
			case XwpfPackage.DOCUMENT__HEADERS:
				getHeaders().clear();
				getHeaders().addAll((Collection<? extends Header>)newValue);
				return;
			case XwpfPackage.DOCUMENT__HYPERLINKS:
				getHyperlinks().clear();
				getHyperlinks().addAll((Collection<? extends Hyperlink>)newValue);
				return;
			case XwpfPackage.DOCUMENT__NUMBERING:
				getNumbering().clear();
				getNumbering().addAll((Collection<? extends Numbering>)newValue);
				return;
			case XwpfPackage.DOCUMENT__PACKAGE_PICTURES:
				getPackagePictures().clear();
				getPackagePictures().addAll((Collection<? extends PictureData>)newValue);
				return;
			case XwpfPackage.DOCUMENT__PARAGRAPHS:
				getParagraphs().clear();
				getParagraphs().addAll((Collection<? extends Paragraph>)newValue);
				return;
			case XwpfPackage.DOCUMENT__PICTURES:
				getPictures().clear();
				getPictures().addAll((Collection<? extends PictureData>)newValue);
				return;
			case XwpfPackage.DOCUMENT__STYLES:
				getStyles().clear();
				getStyles().addAll((Collection<? extends Style>)newValue);
				return;
			case XwpfPackage.DOCUMENT__TABLES:
				getTables().clear();
				getTables().addAll((Collection<? extends Table>)newValue);
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
			case XwpfPackage.DOCUMENT__BODY_ELEMENTS:
				getBodyElements().clear();
				return;
			case XwpfPackage.DOCUMENT__COMMENTS:
				getComments().clear();
				return;
			case XwpfPackage.DOCUMENT__ENDNOTES:
				getEndnotes().clear();
				return;
			case XwpfPackage.DOCUMENT__FOOTERS:
				getFooters().clear();
				return;
			case XwpfPackage.DOCUMENT__FOOTNOTES:
				getFootnotes().clear();
				return;
			case XwpfPackage.DOCUMENT__HEADERS:
				getHeaders().clear();
				return;
			case XwpfPackage.DOCUMENT__HYPERLINKS:
				getHyperlinks().clear();
				return;
			case XwpfPackage.DOCUMENT__NUMBERING:
				getNumbering().clear();
				return;
			case XwpfPackage.DOCUMENT__PACKAGE_PICTURES:
				getPackagePictures().clear();
				return;
			case XwpfPackage.DOCUMENT__PARAGRAPHS:
				getParagraphs().clear();
				return;
			case XwpfPackage.DOCUMENT__PICTURES:
				getPictures().clear();
				return;
			case XwpfPackage.DOCUMENT__STYLES:
				getStyles().clear();
				return;
			case XwpfPackage.DOCUMENT__TABLES:
				getTables().clear();
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
			case XwpfPackage.DOCUMENT__BODY_ELEMENTS:
				return bodyElements != null && !bodyElements.isEmpty();
			case XwpfPackage.DOCUMENT__COMMENTS:
				return comments != null && !comments.isEmpty();
			case XwpfPackage.DOCUMENT__ENDNOTES:
				return endnotes != null && !endnotes.isEmpty();
			case XwpfPackage.DOCUMENT__FOOTERS:
				return footers != null && !footers.isEmpty();
			case XwpfPackage.DOCUMENT__FOOTNOTES:
				return footnotes != null && !footnotes.isEmpty();
			case XwpfPackage.DOCUMENT__HEADERS:
				return headers != null && !headers.isEmpty();
			case XwpfPackage.DOCUMENT__HYPERLINKS:
				return hyperlinks != null && !hyperlinks.isEmpty();
			case XwpfPackage.DOCUMENT__NUMBERING:
				return numbering != null && !numbering.isEmpty();
			case XwpfPackage.DOCUMENT__PACKAGE_PICTURES:
				return packagePictures != null && !packagePictures.isEmpty();
			case XwpfPackage.DOCUMENT__PARAGRAPHS:
				return paragraphs != null && !paragraphs.isEmpty();
			case XwpfPackage.DOCUMENT__PICTURES:
				return pictures != null && !pictures.isEmpty();
			case XwpfPackage.DOCUMENT__STYLES:
				return styles != null && !styles.isEmpty();
			case XwpfPackage.DOCUMENT__TABLES:
				return tables != null && !tables.isEmpty();
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
		result.append(" (styles: ");
		result.append(styles);
		result.append(')');
		return result.toString();
	}

} //DocumentImpl
