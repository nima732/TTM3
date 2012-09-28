package no.ntnu.item.ttm3.hns;

public class Message {
	
	private String signalID;
	
	private Address sender, receiver;
	
	private Object payload;
	
	public Message(String signalID) {
		this.signalID = signalID;
	}
	
	public String getSignalID() {
		return signalID;
	}

	/**
	 * ID of the signal, consisting of lower case letters, numbers and "_".
	 * 
	 * @param signalID
	 */
	public void setSignalID(String signalID) {
		this.signalID = signalID;
	}

	public Address getSender() {
		return sender;
	}

	public void setSender(Address sender) {
		this.sender = sender.getCopy();
	}

	public Address getReceiver() {
		return receiver;
	}

	public void setReceiver(Address receiver) {
		assert receiver!=null;
		assert this.receiver==null;
		this.receiver = receiver.getCopy();
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

}
