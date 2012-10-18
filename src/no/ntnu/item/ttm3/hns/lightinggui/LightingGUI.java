package no.ntnu.item.ttm3.hns.lightinggui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm3.hns.button.Button;

public class LightingGUI extends Block {

	public void createView() {
		JFrame frame = new JFrame("Lightingapp");
		GridLayout buttonLayout = new GridLayout(3,2);
		GridLayout roomLayout = new GridLayout(3,3);
		JButton start;
		JLabel room1,room2,room3,room4,room5,room6,room7,room8,room9;
		
		JPanel roomPanel = new JPanel();
		roomPanel.setLayout(roomLayout);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(buttonLayout);
		
		start = new JButton("Start");
		buttonPanel.add(start);
		
		for (int i = 1; i < 10; i++) {
			JLabel room = new JLabel("room"+i);
			roomPanel.add(room);
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
	}

}
