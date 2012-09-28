package no.ntnu.item.ttm3.hns.sessionport;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm3.hns.Address;
import no.ntnu.item.ttm3.hns.Message;
import no.ntnu.item.ttm3.hns.router.Router;
import no.ntnu.item.ttm3.hns.router.Router.MessageListener;


public class SessionPort extends Block {

	public no.ntnu.item.ttm3.hns.Address remote;
// Instance parameter. Edit only in overview page.
	public final java.lang.String manualSessionID;
	// Instance parameter. Edit only in overview page.
	public final java.lang.String manualSessionSuffix;
	
	public void send(Message message) {
		assert remote!=null;
		if(message.getReceiver()==null) {
			message.setReceiver(remote);
				System.err.println("The address was not set but now it is to:" + remote);
			}
		Address local = ((Address) getProperty("local-address")).getCopy();
		local.setSessionID(getProxySessionID());
		message.setSender(local);
		System.err.println("The local address is:" + local);
			System.err.println("the msg payload is:" + message.getPayload());
		Router.send(message);
	}

	public void subscribe() {
		Router.register(getProxySessionID(), new MessageListener() {
			@Override
			public void receive(Message message) {
				sendToBlock("RECEIVE", message);
			}
		});
	}

	public void unsubscribe() {
		Router.deregister(getProxySessionID());
	}
	
	private String getProxySessionID() {
		if(manualSessionID!=null && manualSessionID.trim().length()>0) {
			return manualSessionID;
		} else if (manualSessionSuffix!=null && manualSessionSuffix.trim().length()>0) {
			return sessionID + "_" + manualSessionSuffix;
		}
		return sessionID + "_" + blockID;
	}

	// Do not edit this constructor.
	public SessionPort(java.lang.String manualSessionID, java.lang.String manualSessionSuffix) {
	    this.manualSessionID = manualSessionID;
	    this.manualSessionSuffix = manualSessionSuffix;
	}

}
