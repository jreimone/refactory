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
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class XwpfDebugMessage {
	
	private static final char DELIMITER = ':';
	private dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes messageType;
	private String[] arguments;
	
	public XwpfDebugMessage(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public XwpfDebugMessage(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes getMessageType() {
		return messageType;
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public String serialize() {
		java.util.List<String> parts = new java.util.ArrayList<String>();
		parts.add(messageType.name());
		for (String argument : arguments) {
			parts.add(argument);
		}
		return dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfStringUtil.encode(DELIMITER, parts);
	}
	
	public static XwpfDebugMessage deserialize(String response) {
		java.util.List<String> parts = dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes type = dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes.valueOf(messageType);
		XwpfDebugMessage message = new XwpfDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(dk.itu.sdg.language.xwpf.resource.xwpf.debug.EXwpfDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfStringUtil.explode(arguments, ", ") + "]";
	}
	
}
