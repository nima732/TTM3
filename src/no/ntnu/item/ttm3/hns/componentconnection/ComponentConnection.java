package no.ntnu.item.ttm3.hns.componentconnection;

import java.util.ArrayList;
import java.util.HashMap;

import no.ntnu.item.arctis.runtime.Block;

public class ComponentConnection extends Block {

	public ArrayList<String> components;
	public java.lang.String component1;

	public String setComponent1() {
		return "detectionSensor1";
	}

	public ArrayList<String> gatherComponents() {
		components = new ArrayList<String>();
		components.add(component1);
		return components;
	}

	public ArrayList<String> noticeOfFail() {
		ArrayList<String> empty = new ArrayList<String>();
		return empty;
	}
}