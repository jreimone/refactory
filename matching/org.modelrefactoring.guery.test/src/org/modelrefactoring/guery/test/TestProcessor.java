package org.modelrefactoring.guery.test;

import org.modelrefactoring.guery.graph.EObjectVertex;
import org.modelrefactoring.guery.graph.EReferenceEdge;

import nz.ac.massey.cs.guery.GraphAdapter;
import nz.ac.massey.cs.guery.Processor;

public class TestProcessor implements Processor<EObjectVertex, EReferenceEdge> {

	@Override
	public void process(GraphAdapter<EObjectVertex, EReferenceEdge> g) {
		System.out.println(TestProcessor.class.getName() + " resolved successfully");		
	}

}
