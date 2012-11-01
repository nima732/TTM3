package no.ntnu.item.ttm3.hns.lightingapp;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm3.hns.Address;

public class LightingApp extends Block {

	public Address sysout() {
		System.err.println("FAILED LOOKUP");
		Address address = new Address();
		address.setSessionID("failed");
		return address;
	}

	public Address sysOutAddress(Address address) {
		System.out.println("ADDRESSE TOSRTING "+address.toString());
		System.out.println("ADDRESSE SESSIONID "+address.getSessionID());
		System.out.println("ADDRESSE PROT "+address.getPort());
		System.out.println("ADDRESSE PROT "+address);
		return address;

	}

}
