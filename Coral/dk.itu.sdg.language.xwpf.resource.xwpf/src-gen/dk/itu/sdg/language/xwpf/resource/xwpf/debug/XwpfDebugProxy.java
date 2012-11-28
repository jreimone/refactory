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
package dk.itu.sdg.language.xwpf.resource.xwpf.debug;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class XwpfDebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private java.io.PrintStream output;
	
	private java.io.BufferedReader reader;
	
	private dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugTarget debugTarget;
	
	private dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugCommunicationHelper communicationHelper = new dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugCommunicationHelper();
	
	public XwpfDebugProxy(dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugTarget debugTarget, int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		this.debugTarget = debugTarget;
		// give interpreter a chance to start
		try {
			Thread.sleep(STARTUP_DELAY);
		} catch (InterruptedException e) {
		}
		startSocket(requestPort);
	}
	
	private void startSocket(int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		// creating client proxy socket (trying to connect)...
		java.net.Socket client = new java.net.Socket("localhost", requestPort);
		// creating client proxy socket - done. (connected)
		try {
			java.io.BufferedInputStream input = new java.io.BufferedInputStream(client.getInputStream());
			reader = new java.io.BufferedReader(new java.io.InputStreamReader(input));
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
		try {
			output = new java.io.PrintStream(client.getOutputStream());
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
	}
	
	public void resume() {
		sendCommand(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes.EXIT);
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage getStack() {
		return sendCommandAndRead(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage message = new dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage message = new dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public org.eclipse.debug.core.model.IVariable[] getStackVariables(String stackFrame) {
		dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage response = sendCommandAndRead(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		org.eclipse.debug.core.model.IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public org.eclipse.debug.core.model.IVariable[] getVariables(String... requestedIDs) {
		dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage response = sendCommandAndRead(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugVariable[] variables  = new dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			java.util.Map<String, String> properties = dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfStringUtil.convertFromString(varString);
			
			// convert varString to variables and values
			String valueString = properties.get("!valueString");
			String valueRefType = "valueRefType";
			java.util.Map<String, Long> childVariables = new java.util.TreeMap<String, Long>(new java.util.Comparator<String>() {
				public int compare(String s1, String s2) {
					return s1.compareToIgnoreCase(s2);
				}
			});
			for (String property : properties.keySet()) {
				// ignore special properties - they are not children
				if (property.startsWith("!")) {
					continue;
				}
				childVariables.put(property, Long.parseLong(properties.get(property)));
			}
			String id = properties.get("!id");
			org.eclipse.debug.core.model.IValue value = new dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugVariable variable = new dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes command, String... parameters) {
		dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage message = new dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage sendCommandAndRead(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes command, String... parameters) {
		dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage message = new dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}
