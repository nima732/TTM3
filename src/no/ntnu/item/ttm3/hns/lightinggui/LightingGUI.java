package no.ntnu.item.ttm3.hns.lightinggui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

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
import no.ntnu.item.ttm3.hns.Address;
import no.ntnu.item.ttm3.hns.Message;
import no.ntnu.item.ttm3.hns.button.Button;

public class LightingGUI extends Block {
	JFrame frame = new JFrame("Lightingapp");
	BoxLayout buttonLayout;
	GridLayout roomLayout = new GridLayout(3,3);
	JButton start, refresh;
	JLabel room1,room2,room3,room4,room5,room6,room7,room8,room9;
	JList sensorList;
	DefaultListModel<String> listModel  = new DefaultListModel<String>();
	ArrayList<JLabel> rooms;

	public void createView() {
		rooms = new ArrayList<JLabel>();
		room1= new JLabel("room1");
		room2= new JLabel("room2");
		room3= new JLabel("room3");
		room4= new JLabel("room4");
		room5= new JLabel("room5");
		room6= new JLabel("room6");
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		rooms.add(room4);
		rooms.add(room5);
		rooms.add(room6);
		
		JPanel roomPanel = new JPanel();
		roomPanel.setLayout(roomLayout);
		for (int i = 1; i < 5; i++) {
			JLabel room = rooms.get(i);
			room.setMinimumSize(new Dimension(100, 100));
			room.setBorder(BorderFactory.createLineBorder(Color.black));
			roomPanel.add(room);
		}
		listModel.addElement("No components registerd");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.LINE_AXIS));
		
		start = new JButton("Start");
		refresh = new JButton("Refresh");
		
		sensorList = new JList<String>(listModel);
		sensorList.setVisibleRowCount(5);
		JScrollPane scrollPane = new JScrollPane(sensorList);
		scrollPane.setSize(50, 50);

		buttonPanel.add(scrollPane);
		buttonPanel.add(start);
		buttonPanel.add(refresh);
		
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sendToBlock("START");
			}
		});
		
		refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sendToBlock("REFRESH");
			}
		});

		
		frame.add(roomPanel,BorderLayout.WEST);
		frame.getContentPane().add(new JSeparator(JSeparator.VERTICAL));
		frame.add(buttonPanel,BorderLayout.EAST);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}

	public void refreshView(ArrayList<String> components) {
		if(!components.equals(null)||!components.isEmpty()) {
			listModel.removeAllElements();
			for (String sessionID : components) {
				listModel.addElement(sessionID);
				room2.setOpaque(true);
				room2.setBackground(Color.BLUE);
			}
		}
		else{
			listModel.addElement("No components");
		}
	}

	public void sysOutMessage(Message message) {
		System.out.println("SignalID "+message.getSignalID());
		System.out.println("PAYLOAD "+message.getPayload().toString());
		
	}

}
