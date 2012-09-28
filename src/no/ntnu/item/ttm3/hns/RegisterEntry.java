package no.ntnu.item.ttm3.hns;

import no.ntnu.item.ttm3.hns.Address;

public class RegisterEntry {
	
	private Address address;
	private String service;
	public Address getAddress() {
		return address;
	}
	public String getService() {
		return service;
	}
	public RegisterEntry(Address address, String service) {
		super();
		this.address = address;
		this.service = service;
	}
	
	public String toString(){
		return "RegisterEntry"+"-"+address.getSessionID().concat("-").concat(address.getIP()).concat("-").concat(address.getPort()).concat("-").concat(service);
	}

}
