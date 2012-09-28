package no.ntnu.item.ttm3.hns.router;

import no.ntnu.item.arctis.runtime.Block;


import java.util.HashMap;
import java.util.Map;

import no.ntnu.item.ttm3.hns.Message;

public class Router extends Block {
	
	static Router instance;

	public static interface MessageListener {
		public void receive(Message message);
	}

	private static Map<String,MessageListener> listeners = new HashMap<String, Router.MessageListener>();
	// Instance parameter. Edit only in overview page.
	public final java.lang.String type;
	public no.ntnu.item.ttm3.hns.Message message;
	public no.ntnu.item.ttm3.hns.Address local;
	
	public static final void register(String sessionID, MessageListener listener) {
		if(listeners.containsKey(sessionID)) {
			// TODO warn
		}
		System.err.println("register listener on " + sessionID);
		listeners.put(sessionID, listener);
	}
	
	public static final void send(Message message) {
		assert instance!=null;
		assert message.getReceiver()!=null;
		assert message.getSender()!=null;
		System.err.println("send message: " + message.getSignalID());
		instance.sendToBlock("OUTBOUND", message);
	}
	
	public void receive(Message message) {
		System.err.println("route message: " + message.getSignalID());
		MessageListener listener = listeners.get(message.getReceiver().getSessionID());
		if(listener!=null) {
			listener.receive(message);
		} else {
			System.err.println("Message discarded!" + message.getSignalID() + " " + message.getReceiver().getSessionID());
		}
	}

	public static void deregister(String sessionID) {
		listeners.remove(sessionID);
	}

	
	public void stop() {
		listeners.clear();
	}

	// Do not edit this constructor.
	public Router(java.lang.String type) {
	    this.type = type;
	    instance = this;
	}

}

