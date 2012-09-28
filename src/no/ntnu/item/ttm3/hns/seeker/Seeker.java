package no.ntnu.item.ttm3.hns.seeker;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm3.hns.Message;


public class Seeker extends Block {

	public Message createSpeechMessage(String text) {
		Message m = new Message("speak");
		m.setPayload(text);
		return m;
	}

	public void found() {
	}

	public void notfound() {
		log("Could not find speech service.");
	}

}

