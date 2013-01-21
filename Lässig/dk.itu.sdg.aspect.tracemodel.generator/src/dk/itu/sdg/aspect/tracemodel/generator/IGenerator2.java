package dk.itu.sdg.aspect.tracemodel.generator;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

public interface IGenerator2 extends IGenerator {

	public void doGenerate(Iterable<?> input, IFileSystemAccess fsa);
}
