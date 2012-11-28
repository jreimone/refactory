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

public enum EXwpfDebugMessageTypes {
	
	// An enumeration of all commands that can be sent to the debug server from debug
	// clients (i.e., interpreters or other processes).
	STARTED,
	RESUMED,
	TERMINATED,
	SUSPENDED,
	
	// An enumeration of all commands that can be sent by the debug server to debug
	// clients (i.e., interpreters or other processes).
	GET_FRAME_VARIABLES,
	GET_VARIABLES,
	GET_STACK,
	STEP_RETURN,
	STEP_INTO,
	STEP_OVER,
	RESUME,
	EXIT,
	
	ADD_LINE_BREAKPOINT,
	REMOVE_LINE_BREAKPOINT,
	
	GET_STACK_RESPONSE,
	GET_FRAME_VARIABLES_RESPONSE,
	GET_VARIABLES_RESPONSE,
}
