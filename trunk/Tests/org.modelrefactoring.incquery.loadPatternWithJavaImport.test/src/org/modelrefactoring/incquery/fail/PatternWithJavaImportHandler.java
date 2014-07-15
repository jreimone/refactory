package org.modelrefactoring.incquery.fail;

import org.modelrefactoring.incquery.PatternLoadQueryInvocationHandler;
import org.modelrefactoring.incquery.Util;

public class PatternWithJavaImportHandler extends PatternLoadQueryInvocationHandler {

	@Override
	protected String getPatternPath() {
		return Util.IMPORT_PATTERN_PATH;
	}

	@Override
	protected int getExpectedMatchesCount() {
		return 2;
	}
}
