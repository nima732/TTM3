package no.ntnu.item.ttm3.hns.detectionsensor;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm3.hns.Message;

public class DetectionSensor extends Block {

	public java.lang.String alias;

	public String createServiceName() {
//		System.out.println(alias);
//		return alias;
		return "detectionSensor1";
	}

	public void systemOut() {
		System.out.println("REGISTERED HARDCORE");
	}

	public void sendToSignal() {
		System.out.println("SEND TO BLOCK REGISTER");
		sendToBlock("Register");
	}
	
	public static String getAlias(String alias) {
		return alias;
	}

	public Message gotSend(Message message) {
		System.err.println("GOT OUT OF FRIKKEN PANEL");
		return message;
	}
}
