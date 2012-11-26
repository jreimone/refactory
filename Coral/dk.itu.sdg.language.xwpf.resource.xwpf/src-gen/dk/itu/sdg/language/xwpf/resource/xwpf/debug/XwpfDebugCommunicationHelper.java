/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.debug;

public class XwpfDebugCommunicationHelper {
	
	public void sendEvent(dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage message, java.io.PrintStream stream) {
		synchronized (stream) {
			stream.println(message.serialize());
		}
	}
	
	/**
	 * Sends a message using the given stream and waits for an answer.
	 * 
	 * @param messageType the type of message to send
	 * @param stream the stream to send the message to
	 * @param reader the reader to obtain the answer from
	 * @param parameters additional parameter to send
	 * 
	 * @return the answer that is received
	 */
	public dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage sendAndReceive(dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage message, java.io.PrintStream stream, java.io.BufferedReader reader) {
		synchronized (stream) {
			sendEvent(message, stream);
			dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage response = receive(reader);
			return response;
		}
	}
	
	/**
	 * Receives a message from the given reader. This method block until a message has
	 * arrived.
	 * 
	 * @param reader the read to obtain the message from
	 * 
	 * @return the received message
	 */
	public dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage receive(java.io.BufferedReader reader) {
		try {
			String response = reader.readLine();
			if (response == null) {
				return null;
			}
			dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage receivedMessage = dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage.deserialize(response);
			return receivedMessage;
		} catch (java.io.IOException e) {
			return null;
		}
	}
	
}
