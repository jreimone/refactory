package org.modelrefactoring.guery.test;

import java.util.List;

public interface AdditionalListenerInvocator {

	public void addListener(AdditionalResultListener listener);
	
	public boolean removeListener(AdditionalResultListener listener);
	
	public List<AdditionalResultListener> getAdditionalListeners();
}
