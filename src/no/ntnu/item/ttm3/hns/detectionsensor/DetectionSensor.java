package no.ntnu.item.ttm3.hns.detectionsensor;

import no.ntnu.item.arctis.runtime.Block;

public class DetectionSensor extends Block {

	public String createServiceName() {
		System.out.println("CREATING SERVICE NAME");
		return "detectionSensor";
	}

	public void systemOut() {
		System.out.println("REGISTERED HARDCORE");
	}

	public void test() {
		System.err.println("out of panel");
	}
}
