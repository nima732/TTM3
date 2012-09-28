package no.ntnu.item.ttm3.hns.speechservice;

import no.ntnu.item.arctis.runtime.Block;

import no.ntnu.item.ttm3.hns.Message;


public class SpeechService extends Block {

	public String extractText(Message message) {
		return (String) message.getPayload();
	}

	
	public java.lang.String createServiceName() {
	
	return "speech";
	}

}
