/**
 */
package oo.OO;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link oo.OO.Operation#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see oo.OO.OOPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends Feature {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link oo.OO.Parameter}.
	 * It is bidirectional and its opposite is '{@link oo.OO.Parameter#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see oo.OO.OOPackage#getOperation_Parameters()
	 * @see oo.OO.Parameter#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

} // Operation
