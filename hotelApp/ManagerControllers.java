package hotelApp;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.*;
import javax.swing.*;

/**
 * Frame that holds all the controllers for the manager to view room information by room number and by day. Also contains functions that
 * saves data to reservations.txt as well as loading information from reservations.txt.
 * @author Roy Zhang
 *
 */
public class ManagerControllers extends JFrame{

	private DataStorage db;
	
	public ManagerControllers(DataStorage db) {
		this.db = db;
		setLayout(new BorderLayout());
		JPanel buttons = new JPanel(new FlowLayout());
		JButton load = new JButton("Load");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.populateFromFile();
			}
		});
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.saveToFile();
			}
		});
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.saveToFile();
				dispose();
			}
		});
		buttons.add(load);
		buttons.add(save);
		buttons.add(quit);
		CalendarPanel cp = new CalendarPanel(db);
		RoomInfoPanel rip = new RoomInfoPanel(db);
		add(cp, BorderLayout.NORTH);
		add(rip,BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
