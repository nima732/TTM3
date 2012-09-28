package no.ntnu.item.ttm3.hns.button;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import no.ntnu.item.arctis.runtime.Block;


public class Button extends Block {

	// Parameter defined by UML. Do not edit.
	public final java.lang.String title ;

	private JFrame frame;

	public void show() {
		frame = new JFrame(title);

		JButton button = new JButton();
		button.setText("Request");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendToBlock("PUSHED" + "_" + blockID);
			}
		});

		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(button, BorderLayout.CENTER);
		frame.getContentPane().add(button, BorderLayout.SOUTH);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				sendToBlock("CLOSED" + "_" + blockID);
			}
		});

		frame.setVisible(true);
		frame.pack();
	}

	public void hide() {
		frame.setVisible(false);
	}

	// Do not edit this constructor.
	public Button(java.lang.String title) {
		this.title = title;
	}
}