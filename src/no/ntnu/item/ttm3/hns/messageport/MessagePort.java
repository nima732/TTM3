package no.ntnu.item.ttm3.hns.messageport;


import no.ntnu.item.ttm3.hns.Address;
import no.ntnu.item.ttm3.hns.Message;
import no.ntnu.item.ttm3.hns.router.Router;
import no.ntnu.item.ttm3.hns.router.Router.MessageListener;
import no.ntnu.item.arctis.runtime.Block;


public class MessagePort extends Block {

	public java.lang.String portSessionID;

	public void send(Message message) {
		System.out.println("SEND METHOD IN MESSAGE PORT");
		assert message.getReceiver()!=null;
		Address local = ((Address)getProperty("local-address")).getCopy();
		local.setSessionID(portSessionID);
		message.setSender(local);
		Router.send(message);
	}

	public void subscribe() {
		Router.register(portSessionID, new MessageListener() {
			@Override
			public void receive(Message message) {
				sendToBlock("RECEIVE", message);
			}
		});
	}

	public void unsubscribe() {
		Router.deregister(portSessionID);
	}

	public Message test(Message message) {
		System.out.println("WTF INSIDE THE MESSAGEPORT");
		return message;
	}

}
