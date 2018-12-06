package hotelApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;

/**
 * Panel that displays Reservations for the manager
 * @author Roy Zhang
 * Date created: 11/13/2018
 */
public class ReservationPanel extends JFrame
{
	private Account acc;
	private DataStorage db;
	private static DateTimeFormatter date_format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	
    /**
 	 *Constructs a Reservation panel
 	 *@param acc the account
 	 *@param db the data storage
 	 */
	public ReservationPanel (Account acc, DataStorage db) {
		this.acc = acc;
		this.db = db;
		JPanel roomSelection = new JPanel();
		roomSelection.setLayout(new BoxLayout(roomSelection, BoxLayout.PAGE_AXIS));
		JLabel checkin = new JLabel("Check in");
		JLabel checkout = new JLabel("Check out");
		JTextField checkinField = new JTextField(10);
		JTextField checkoutField = new JTextField(10);
		JButton threeHundred = new JButton("$300");
		JButton oneHundred = new JButton("$100");
		JButton showAvailableRooms = new JButton("Show Available Rooms");
		
		JPanel roomAvailability = new JPanel();
		roomAvailability.setLayout(new FlowLayout());
		JTextArea availableRooms = new JTextArea("Available Rooms", 10, 21);
		JTextField insertRoomNumber = new JTextField(15);
		JButton confirm = new JButton("Confirm");
		JButton done = new JButton("Done");
		
		JPanel finalPanel = new JPanel();
		
		//roomSelection.add(Box.createHorizontalStrut(10));
		roomSelection.add(checkin);
		roomSelection.add(checkinField);
		roomSelection.add(checkout);
		roomSelection.add(checkoutField);
		roomSelection.add(threeHundred);
		roomSelection.add(oneHundred);
		roomSelection.add(showAvailableRooms);
		roomAvailability.add(availableRooms);
		roomAvailability.add(insertRoomNumber);
		roomAvailability.add(confirm);
		roomAvailability.add(done);
		//add(roomSelection);
		//add(roomAvailability);
		
		finalPanel.setLayout(new BorderLayout());
		finalPanel.add(roomSelection, BorderLayout.NORTH);
		finalPanel.add(roomAvailability, BorderLayout.SOUTH);
		add(finalPanel);
		//setSize(width, width);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
	}
}
