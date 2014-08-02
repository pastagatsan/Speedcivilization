package org.fountanio.juancode.out;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Console extends JFrame {

	private JTextArea output = new JTextArea("Speed Civilization Console\n");
	private JScrollPane sp = new JScrollPane(output);
	private JTextField input = new JTextField();
	private boolean timeFlag = true;
	
	public Console() {
		super("SpeedCivilization Console");
		output.setEditable(false);
		setLayout(new BorderLayout()); // no gaps needed
		add(sp, BorderLayout.CENTER);
		add(input, BorderLayout.SOUTH);
		setSize(new Dimension(400, 400));
		output.setWrapStyleWord(true); 
	}
	/** Allow insertion of time before new line **/
	public void insertTimeBeforeOutput(boolean timeFlag) {
		this.timeFlag = timeFlag;
	}
	
	public void println(String t) {
		if (timeFlag) { 
			output.append("\n" + Calendar.getInstance().getTime() + "> " + t); 
		} else {
			output.append("\n" + t);
		}
		t = null; // stop the printing
	}
	
	public void print(String t) {
		output.append(t);
		t = null; // stop the printing
	}
	
	public void clear() {
		output.setText("Speed Civilization Console\n");
	}
	
	public void clearInput() {
		in = "";
	}
	
	private String in = "Could Not Get Input"; // default
	
	public String getInput() { 
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				in = input.getText();
			}
		});
		return in;
	}
	
	public void errorln(String s) {
		if (isVisible()) {
			println(s);
		} else {
			setVisible(true);
			println(s);
		}
		s = null;
	}
	
}
