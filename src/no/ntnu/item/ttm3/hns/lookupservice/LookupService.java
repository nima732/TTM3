package no.ntnu.item.ttm3.hns.lookupservice;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm3.hns.Address;
import no.ntnu.item.ttm3.hns.Message;


public class LookupService extends Block {

	// Instance parameter. Edit only in overview page.
	public final java.lang.String service;
	public no.ntnu.item.ttm3.hns.Message message;
	public no.ntnu.item.ttm3.hns.Message createLookupMessage() {
		Message register = new Message("lookup");
		register.setPayload("speech");
		return register;
	}

	public String getSignalID(Message message) {
		return message.getSignalID().toLowerCase();
		
	}

	public Address getRegisterAddress() {
		return ((Address) getProperty("register-address")).getCopy();
	}

	// Do not edit this constructor.
	public LookupService(java.lang.String service) {
	    this.service = service;
	}

	public Address extractAddress(Message message) {
		Address address = new Address();
		System.err.println("the address payload received by seeker is:" + message.getPayload().toString());
		//if(message.getPayload() instanceof String){
			String [] str = message.getPayload().toString().split("-");
			address.setSessionID(str[0]);
			address.setIP(str[1]);
			address.setPort(str[2]);
		//}
		System.err.println("the SID received by seeker is:" + address.getSessionID());
		return address; //((Address) message.getPayload()).getCopy();
	}

	public void logTimeout() {
		log("Could not lookup service for " + service + ". Timeout during looking up.");
	}

	
}
