/*
 * This code was generated automatically.
 * Do NOT edit this file, changes will be lost.
 * Instead, change and commit the underlying schema.
 */

package de.uni_koblenz.jgralab.demo.schema;

import de.uni_koblenz.jgralab.GraphIO;
import de.uni_koblenz.jgralab.exception.GraphIOException;

import de.uni_koblenz.jgralab.schema.impl.SchemaImpl;

import de.uni_koblenz.jgralab.schema.EdgeClass;
import de.uni_koblenz.jgralab.schema.EnumDomain;
import de.uni_koblenz.jgralab.schema.GraphClass;
import de.uni_koblenz.jgralab.schema.VertexClass;

import java.lang.ref.WeakReference;

/**
 * The schema GraphSchema is implemented following the singleton pattern.
 * To get the instance, use the static method <code>instance()</code>.
 */
public class GraphSchema extends SchemaImpl {

	/**
	 * reference to the singleton instance
	 */
	static WeakReference<GraphSchema> theInstance = new WeakReference<GraphSchema>(null);
	
	/**
	 * @return the singleton instance of GraphSchema
	 */
	public static synchronized GraphSchema instance() {
		GraphSchema s = theInstance.get();
		if (s != null) {
			return s;
		}
		s = new GraphSchema();
		theInstance = new WeakReference<GraphSchema>(s);
		return s;
	}
	
	/**
	 * Creates a GraphSchema and builds its schema classes.
	 * This constructor is private. Use the <code>instance()</code> method
	 * to access the schema.
	 */
	private GraphSchema() {
		super("GraphSchema", "de.uni_koblenz.jgralab.demo.schema");

		{
			EnumDomain dom = createEnumDomain("ConnectionType");
			dom.addConst("AGGREGATION");
			dom.addConst("ASSOCIATION");
		}

		{
			GraphClass gc = createGraphClass("GraphModel");

			VertexClass vc_Node = gc.createVertexClass("Node");
			vc_Node.setAbstract(false);
			vc_Node.createAttribute("name", getDomain("String"), null);

			EdgeClass ec_Connection = gc.createEdgeClass("Connection",
				vc_Node, 0, 2147483647, "source", de.uni_koblenz.jgralab.schema.AggregationKind.NONE,
				vc_Node, 0, 2147483647, "target", de.uni_koblenz.jgralab.schema.AggregationKind.NONE);
			ec_Connection.setAbstract(false);
			ec_Connection.createAttribute("connectionType", getDomain("ConnectionType"), null);
			ec_Connection.createAttribute("name", getDomain("String"), null);
			ec_Connection.createAttribute("source", getDomain("String"), null);
			ec_Connection.createAttribute("target", getDomain("String"), null);
		}

		finish();
	}

	@Override
	public de.uni_koblenz.jgralab.GraphFactory createDefaultGraphFactory(de.uni_koblenz.jgralab.ImplementationType implementationType) {
		switch(implementationType) {
			case GENERIC:
				return new de.uni_koblenz.jgralab.impl.generic.GenericGraphFactoryImpl(this);
			case STANDARD:
				return new de.uni_koblenz.jgralab.demo.schema.impl.std.GraphModelFactoryImpl();
		}
		throw new UnsupportedOperationException("No " + implementationType + " support compiled.");
	}

	/**
	 * Creates a new GraphModel graph.
	*/
	public GraphModel createGraphModel(de.uni_koblenz.jgralab.ImplementationType implType) {
		return createGraphModel(implType, null, 100, 100);
	}

	/**
	 * Creates a new GraphModel graph with initial vertex and edge counts <code>vMax</code>, <code>eMax</code>.
	 *
	 * @param vMax initial vertex count
	 * @param eMax initial edge count
	*/
	public GraphModel createGraphModel(de.uni_koblenz.jgralab.ImplementationType implType, String id, int vMax, int eMax) {
		de.uni_koblenz.jgralab.GraphFactory factory = createDefaultGraphFactory(implType);
		return factory.createGraph(getGraphClass(), id, vMax, eMax);
	}

	/**
	 * Creates a new GraphModel graph.
	*/
	public GraphModel createGraphModel(de.uni_koblenz.jgralab.GraphFactory factory) {
		return factory.createGraph(getGraphClass(), null, 100, 100);
	}

	/**
	 * Creates a new GraphModel graph.
	*/
	public GraphModel createGraphModel(de.uni_koblenz.jgralab.GraphFactory factory, String id, int vMax, int eMax) {
		return factory.createGraph(getGraphClass(), id, vMax, eMax);
	}

	public GraphModel loadGraphModel(String filename) throws GraphIOException {
		de.uni_koblenz.jgralab.GraphFactory factory = createDefaultGraphFactory(de.uni_koblenz.jgralab.ImplementationType.STANDARD);
		return loadGraphModel(filename, factory, null);
	}

	public GraphModel loadGraphModel(String filename, de.uni_koblenz.jgralab.ProgressFunction pf) throws GraphIOException {
		de.uni_koblenz.jgralab.GraphFactory factory = createDefaultGraphFactory(de.uni_koblenz.jgralab.ImplementationType.STANDARD);
		return loadGraphModel(filename, factory, pf);
	}

	public GraphModel loadGraphModel(String filename, de.uni_koblenz.jgralab.ImplementationType implType) throws GraphIOException {
		de.uni_koblenz.jgralab.GraphFactory factory = createDefaultGraphFactory(implType);
		return loadGraphModel(filename, factory, null);
	}

	
	public GraphModel loadGraphModel(String filename, de.uni_koblenz.jgralab.ImplementationType implType, de.uni_koblenz.jgralab.ProgressFunction pf) throws GraphIOException {
		de.uni_koblenz.jgralab.GraphFactory factory = createDefaultGraphFactory(implType);
		return loadGraphModel(filename, factory, pf);
	}

	public GraphModel loadGraphModel(String filename, de.uni_koblenz.jgralab.GraphFactory factory) throws GraphIOException {
		return GraphIO.loadGraphFromFile(filename, factory, null);
	}

	public GraphModel loadGraphModel(String filename, de.uni_koblenz.jgralab.GraphFactory factory, de.uni_koblenz.jgralab.ProgressFunction pf) throws GraphIOException {
		return GraphIO.loadGraphFromFile(filename, factory, pf);
	}
	
	@Override
	public boolean reopen() {
		throw new UnsupportedOperationException("Cannot reopen a compiled Schema.");
	}
}