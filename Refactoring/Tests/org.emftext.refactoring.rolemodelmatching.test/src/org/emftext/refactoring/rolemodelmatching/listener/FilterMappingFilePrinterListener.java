package org.emftext.refactoring.rolemodelmatching.listener;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

public class FilterMappingFilePrinterListener extends SequenceListener {

	private AtomicInteger unfilteredCount;
	private FilterMappingListener filterMappingListener;
	private FileWriter writer;
	
	public FilterMappingFilePrinterListener(FilterMappingListener filterMappingListener, AtomicInteger unfilteredCount, FileWriter writer) {
		super(Arrays.asList(new INodeListener[]{filterMappingListener}));
		this.unfilteredCount = unfilteredCount;
		this.filterMappingListener = filterMappingListener;
		this.writer = writer;
	}

	@Override
	public void executeAfterOthers(MatchNode<?, ?> node) {
		StringBuffer buffer = filterMappingListener.getFilteredMatchesString();
		buffer.append("(" + unfilteredCount.get() + ")\n");
		try {
			writer.append(buffer.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
