package no.ntnu.item.ttm3.hns;

public class Address {
	
	private String sessionID;
	private String port;
	private String IP;
	
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	
	
	public Address getCopy() {
		Address copy =  new Address();
		copy.IP = this.IP;
		copy.port = this.port;
		copy.sessionID = this.sessionID;
		return copy;
	}

	@Override
	public String toString(){
		return sessionID+"-"+IP+"-"+port;
	}
	
	
}
