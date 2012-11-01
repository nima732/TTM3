package no.ntnu.item.ttm3.hns.responder;

import no.ntnu.item.ttm3.hns.Message;
import no.ntnu.item.ttm3.hns.RegisterEntry;
import no.ntnu.item.ttm3.hns.Address;
import no.ntnu.item.arctis.runtime.Block;



public class Responder extends Block {

	public java.lang.String serviceSessionID;
	// Instance parameter. Edit only in overview page.
	public java.lang.String service;
	
	
	public RegisterEntry createRegisterEntry() {
		System.out.println("is this null "+getProperty("local-address"));
		Address serviceAddress = ((Address)getProperty("local-address")).getCopy();
		serviceAddress.setSessionID(serviceSessionID);
		RegisterEntry entry = new RegisterEntry(serviceAddress, service);
		return entry;
	}

	public void createServiceSessionID(java.lang.String service) {
		this.service = service;
		if(service==null || service.trim().length()==0) {
			log("A service description must be given. Current value is empty.");
		}
		//this.serviceSessionID = sessionID + "_" + service;
		this.serviceSessionID = service;
	}

	// Do not edit this constructor.
	public Responder(java.lang.String service) {
	    this.service = service;
	}

	public Message test(Message message) {
		System.out.println("GOT INTO RESPONDER");
		return message;
	}

}

