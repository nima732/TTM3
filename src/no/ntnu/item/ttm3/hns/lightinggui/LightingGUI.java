package no.ntnu.item.ttm3.hns.lightinggui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm3.hns.button.Button;

public class LightingGUI extends Block {

	public void createView() {
		JFrame frame = new JFrame("Lightingapp");
		BoxLayout buttonLayout;
		GridLayout roomLayout = new GridLayout(3,3);
		JButton start;
		JLabel room1,room2,room3,room4,room5,room6,room7,room8,room9;
		JList sensorList;
		DefaultListModel<String> listModel  = new DefaultListModel<String>();
		
		JPanel roomPanel = new JPanel();
		roomPanel.setLayout(roomLayout);
		
		for (int i = 1; i < 10; i++) {
			System.out.println("Adding labels "+i);
			JLabel room = new JLabel("room"+i);
			room.setMinimumSize(new Dimension(100, 100));
			room.setBorder(BorderFactory.createLineBorder(Color.black));
			roomPanel.add(room);
			listModel.addElement("room"+i);
		}
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.LINE_AXIS));
		
		start = new JButton("Start");
		
		sensorList = new JList<String>(listModel);
		sensorList.setVisibleRowCount(5);
		JScrollPane scrollPane = new JScrollPane(sensorList);

		buttonPanel.add(scrollPane);
		buttonPanel.add(start);
		
		

		
		frame.add(roomPanel,BorderLayout.WEST);
		frame.getContentPane().add(new JSeparator(JSeparator.VERTICAL));
		frame.add(buttonPanel,BorderLayout.EAST);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
	}

}
