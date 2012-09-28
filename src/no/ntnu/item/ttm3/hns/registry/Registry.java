package no.ntnu.item.ttm3.hns.registry;

import no.ntnu.item.arctis.runtime.Block;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import no.ntnu.item.ttm3.hns.RegisterEntry;
import no.ntnu.item.ttm3.hns.Address;
import no.ntnu.item.ttm3.hns.Message;


public class Registry extends Block {

	private Map<String, Address> registry = new HashMap<String, Address>();
	public no.ntnu.item.ttm3.hns.Message message;
	
	//
	private Map<String, Boolean> availableServices = new HashMap<String, Boolean>();
	
	
	private Address getAvailableService(String tomatch){
		Address result=null;		
		Iterator itr = registry.keySet().iterator();
		while(itr.hasNext()){
			String keyEntry = (String) itr.next();
			if(keyEntry.contains(tomatch)){
				if(availableServices.get(keyEntry)){
					result = registry.get(keyEntry);
					
					if(!(keyEntry.contains("login") | keyEntry.contains("grouppositioning"))){
						availableServices.put(keyEntry, false);
					}
					return result;
				}
			}
		}
		return result;
	}
	
	public Message lookup(Message message) {
		//Address service = registry.get(message.getPayload());
		
		Address service = getAvailableService(message.getPayload().toString());
		if(service!=null) {
			Message response = new Message("ok");
			response.setReceiver(message.getSender());
			response.setPayload(service);
			
			System.out.println("discovered service instance.."+ service.getSessionID());
			
			return response;
		} else {
			log("Could not find service '" + message.getPayload() + "'.");
			Message response = new Message("failed");
			response.setReceiver(message.getSender());
			return response;
		}
	}
	
	public Message register(Message message) {
		Object o = message.getPayload();
		
		System.out.println("payload of message.."+ o);
		
		//if(o instanceof RegisterEntry) 
		if (message.getPayload().toString().split("-")[0].equalsIgnoreCase("RegisterEntry")){
		
			RegisterEntry entry = toRegistryEntry(message.getPayload().toString()); //(RegisterEntry) o;
			
			log("Register service '" + entry.getService() + "' at address " + entry.getAddress().getSessionID());
			//registry.put(entry.getService(), entry.getAddress());
			registry.put(entry.getAddress().getSessionID(), entry.getAddress());
			Message response = new Message("ok");
			response.setReceiver(message.getSender());
					
			//
			availableServices.put(entry.getAddress().getSessionID(), true);
			//
			
			return response;
		} else {
			log("Service register tried without registry entry as payload.");
			Message response = new Message("failed");
			response.setReceiver(message.getSender());
			return response;
		}
	}

	public Message deregister(Message message) {
		Object o = message.getPayload();
		if(o instanceof RegisterEntry) {
			RegisterEntry entry = (RegisterEntry) o;
			// we deregister only if the service description and the registered addresses match
			Address registeredAddress = registry.get(entry.getService());
			if(registeredAddress.getSessionID().equals(entry.getAddress().getSessionID())) {
				registry.remove(entry.getService());
			}
			Message response = new Message("ok");
			response.setReceiver(message.getSender());
			return response;
		} else {
			Message response = new Message("failed");
			response.setReceiver(message.getSender());
			return response;
		}
	}

	public java.lang.String getSignalID() {
		return message.getSignalID();
	}

	public String getRegistrySessionID() {
		return "registry";
	}
	
	public void unexpectedSignal(Message message) {
		log("Unexpected signal in service registry: " + message.getSignalID());
	}
	
	// method to create RegisterEntry from payload string message
	private RegisterEntry toRegistryEntry(String payload){
		
		String payloadStr[] = payload.split("-");
		Address addr = new Address();
		addr.setSessionID(payloadStr[1]);
		addr.setIP(payloadStr[2]);
		addr.setPort(payloadStr[3]);
		
		String service = payloadStr[4];
		RegisterEntry entry = new RegisterEntry(addr, service);
		
		return entry;
	}
}

