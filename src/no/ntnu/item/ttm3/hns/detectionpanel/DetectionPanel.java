package no.ntnu.item.ttm3.hns.detectionpanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm3.hns.Message;

public class DetectionPanel extends Block {

	private JFrame frame;

	public void gui() {
		frame = new JFrame("Detector");
		
		JButton button = new JButton();
		button.setText("Detected");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendToBlock("PUSHED" + "_" + blockID);
			}
		});
		
		JButton button2 = new JButton();
		button.setText("Something");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendToBlock("PUSHED" + "_" + blockID);
			}
		});
	
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(button, BorderLayout.CENTER);
		frame.getContentPane().add(button, BorderLayout.SOUTH);
		frame.getContentPane().add(button2, BorderLayout.CENTER);
		frame.getContentPane().add(button2, BorderLayout.SOUTH);
	
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			}
		});
	
		frame.setVisible(true);
		frame.pack();
	}
	
	public void hide() {
			frame.setVisible(false);
	}
	
	public Message setDetectedMessage() {
		return new Message("DETECTED");
	}

	public Message setTestMessage() {
		return new Message("TEST");
	}

}
