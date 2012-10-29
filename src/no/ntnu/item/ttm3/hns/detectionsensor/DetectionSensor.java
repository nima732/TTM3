package no.ntnu.item.ttm3.hns.detectionsensor;

import no.ntnu.item.arctis.runtime.Block;

public class DetectionSensor extends Block {

	public String createServiceName() {
		return "detectionSensor";
	}

	public void systemOut() {
		System.out.println("REGISTERED HARDCORE");
	}
}
