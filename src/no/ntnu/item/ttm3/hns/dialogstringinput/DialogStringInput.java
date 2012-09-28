package no.ntnu.item.ttm3.hns.dialogstringinput;

import no.ntnu.item.arctis.runtime.Block;
import javax.swing.JOptionPane;



public class DialogStringInput extends Block {

	public void openDialog() {
		Runnable r = new Runnable() {
			public void run() {
				String result = JOptionPane.showInputDialog(null, "Input: ", "", 1);
				if (result != null) {
					sendToBlock("RESULT", result);
				} else {
					sendToBlock("CANCEL");
				}
			}
		};
		Thread t = new Thread(r);
		t.start();
	}

}