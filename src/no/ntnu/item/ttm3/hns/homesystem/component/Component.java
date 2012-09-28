package no.ntnu.item.ttm3.hns.homesystem.component;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm3.hns.Address;

public class Component extends Block {

	public void setRegistryAddress() {
		Address registry = new Address();
		registry.setPort("52000");
		registry.setIP("localhost");
		registry.setSessionID("registry");
		setProperty("register-address", registry);
	}
	
	public Address getLocalAddress() {
	Address local = new Address();
		local.setPort("52000");
		local.setIP("localhost");
		setProperty("local-address", local);
		return local;
	}

}