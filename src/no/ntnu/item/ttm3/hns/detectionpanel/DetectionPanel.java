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
				sendToBlock("DETECTED" + "_" + blockID);
			}
		});
		
		JButton button2 = new JButton();
		button2.setText("Register");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendToBlock("TEST" + "_" + blockID);
			}
		});
	
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(button, BorderLayout.WEST);
		frame.getContentPane().add(button2, BorderLayout.EAST);
	
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
		System.out.println("SETTING DETECTED MESSAGE");
		Message message = new Message("DETECTED");
		message.setPayload("DETTE ER EN TEST");
		return message;
	}

}
