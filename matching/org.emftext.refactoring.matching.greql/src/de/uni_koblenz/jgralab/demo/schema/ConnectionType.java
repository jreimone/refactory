/*
 * This code was generated automatically.
 * Do NOT edit this file, changes will be lost.
 * Instead, change and commit the underlying schema.
 */

package de.uni_koblenz.jgralab.demo.schema;

public enum ConnectionType {

	AGGREGATION, ASSOCIATION;

	public static ConnectionType valueOfPermitNull(String val) {
		if (val.equals(de.uni_koblenz.jgralab.GraphIO.NULL_LITERAL)) {
			return null;
		}
		return valueOf(val);
	}
}
