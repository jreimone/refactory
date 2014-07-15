package org.modelrefactoring.incquery.fail;

import org.modelrefactoring.incquery.PatternLoadQueryInvocationHandler;
import org.modelrefactoring.incquery.Util;

public class PatternWithoutJavaImportHandler extends PatternLoadQueryInvocationHandler {

	@Override
	protected String getPatternPath() {
		return Util.NON_IMPORT_PATTERN_PATH;
	}

	@Override
	protected int getExpectedMatchesCount() {
		return 3;
	}

}
