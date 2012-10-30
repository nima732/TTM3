package no.ntnu.item.ttm3.hns.detectionpanel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm3.hns.Message;

public class DetectionPanel extends Block {

	private JFrame frame;

	public void gui() {
		frame = new JFrame("Detector");
		frame.getContentPane().setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.insets = new Insets(10, 10, 10, 10);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, c);
		
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createLoweredBevelBorder());
		panel.setBackground(Color.BLACK);
		
		JButton button = new JButton();
		button.setText("Detected");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendToBlock("PUSHED" + "_" + blockID);
			}
		});
		
		JButton button2 = new JButton();
		button2.setText("Register");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendToBlock("TEST");// + "_" + blockID);
			}
		});
	
		frame.getContentPane().add(button);
		frame.getContentPane().add(button2);
	
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
