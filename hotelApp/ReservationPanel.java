package hotelApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * Panel that displays Reservations for the manager
 * @author Roy Zhang
 * Date created: 11/13/2018
 */
public class ReservationPanel extends JFrame
{
	private Account acc;
	private DataStorage db;
	private int price;
	private static DateTimeFormatter date_format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private ArrayList<Reservation> reservations;
	
	public ReservationPanel (Account acc, DataStorage db) {
		this.acc = acc;
		this.db = db;
		this.reservations = new ArrayList<Reservation>();
		JPanel roomSelection = new JPanel();
		roomSelection.setLayout(new BoxLayout(roomSelection, BoxLayout.PAGE_AXIS));
		JLabel checkin = new JLabel("Check in");
		JLabel checkout = new JLabel("Check out");
		JTextField checkinField = new JTextField(10);
		JTextField checkoutField = new JTextField(10);
		JButton threeHundred = new JButton("$300");
		threeHundred.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				price = 300;
			}
		});
		JButton oneHundred = new JButton("$100");
		oneHundred.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				price = 100;
			}
		});
		JButton showAvailableRooms = new JButton("Show Available Rooms");
		JPanel roomAvailability = new JPanel();
		roomAvailability.setLayout(new BoxLayout(roomAvailability, BoxLayout.PAGE_AXIS));
		JTextArea availableRooms = new JTextArea("Available Rooms", 10, 15);
		JScrollPane scroll = new JScrollPane(availableRooms);
		JTextField insertRoomNumber = new JTextField(15);
		JButton confirm = new JButton("Confirm");
		JButton done = new JButton("Done");
		JLabel instruction = new JLabel("Insert room number you wish to reserve");
		
		JPanel finalPanel = new JPanel();
		showAvailableRooms.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) throws DateTimeParseException{
				try {
				TimeInterval ti = new TimeInterval(LocalDate.parse(checkinField.getText(), date_format) , LocalDate.parse(checkoutField.getText(), date_format));
				availableRooms.append(" " + checkinField.getText() + " - " + checkoutField.getText() + "\n");
				for (Room r : db.getAvailableRooms(ti, price)) {
					availableRooms.append(r.toString() + "\n");
				}
				}
				catch (DateTimeParseException dtpe) {
					JOptionPane.showMessageDialog(roomSelection, "Checkin and Checkout dates must be in MM/DD/YYYY");
				}
			}
		});
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) throws DateTimeParseException {
				try {
				TimeInterval ti = new TimeInterval(LocalDate.parse(checkinField.getText(), date_format) , LocalDate.parse(checkoutField.getText(), date_format));
				ArrayList<Room> availableRooms = new ArrayList<Room>();
				availableRooms = db.getAvailableRooms(ti, price);
				Room room = null;
				for (Room r : availableRooms) {
					Integer i = r.getRoomNumber();
					if (insertRoomNumber.getText().equals(i.toString())) {
						room = r;
					}
				}
				if (room == null) {
					JOptionPane.showMessageDialog(roomAvailability, "Invalid Room! Please try again.");
				}
				else {
				Reservation confirm = new Reservation(acc, room, ti);
				db.addReservationToAccount(acc, confirm);
				reservations.add(confirm);
				JOptionPane.showMessageDialog(roomAvailability, confirm.toString() + "\n" + "Reservation Confirmed");
				}
				}
				catch (DateTimeParseException dtpe) {
					JOptionPane.showMessageDialog(roomAvailability, "Checkin and Checkout dates must be in MM/DD/YYYY");
				}
			}
		});
		done.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame guestAction = new JFrame("Choose your Receipt");
				JPanel layout = new JPanel(new BorderLayout());
				JButton simple = new JButton("Simple");
				simple.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						guestAction.dispose();
						Receipt simple = new SimpleReceipt(acc, reservations);
						JFrame receipt = new JFrame();
						JPanel panel = new JPanel();
						JTextArea receiptArea = new JTextArea(15,10);
						receiptArea.setText(simple.receiptList());
						panel.add(receiptArea);
						receipt.add(panel);
						receipt.pack();
						receipt.setVisible(true);
					}
				});
				JButton comprehensive = new JButton("Comprehensive");
				comprehensive.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						guestAction.dispose();
						Receipt comprehensive = new ComprehensiveReceipt(acc);
						JFrame receipt = new JFrame();
						JPanel panel = new JPanel();
						JTextArea receiptArea = new JTextArea(15,10);
						receiptArea.setText(comprehensive.receiptList());
						panel.add(receiptArea);
						receipt.add(panel);
						receipt.pack();
						receipt.setVisible(true);
					}	
				});
				JLabel accountAction = new JLabel("Choose your receipt");
				
				layout.add(accountAction, BorderLayout.NORTH);
				layout.add(simple, BorderLayout.WEST);
				layout.add(comprehensive, BorderLayout.EAST);
				guestAction.add(layout);
				guestAction.setLayout(new FlowLayout());
				guestAction.pack();
				guestAction.setVisible(true);
			}
		});
		//roomSelection.add(Box.createHorizontalStrut(10));
		roomSelection.add(checkin);
		roomSelection.add(checkinField);
		roomSelection.add(checkout);
		roomSelection.add(checkoutField);
		roomSelection.add(threeHundred);
		roomSelection.add(oneHundred);
		roomSelection.add(showAvailableRooms);
		//roomAvailability.add(availableRooms);
		roomAvailability.add(scroll);
		roomAvailability.add(instruction);
		roomAvailability.add(insertRoomNumber);
		roomAvailability.add(confirm);
		roomAvailability.add(done);

		//add(roomSelection);
		//add(roomAvailability);
		
		finalPanel.setLayout(new BorderLayout());
		finalPanel.add(roomSelection, BorderLayout.NORTH);
		finalPanel.add(roomAvailability, BorderLayout.SOUTH);
		add(finalPanel);
		//setSize(500, 500);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
	}
	
	public int getPrice() {
		return price;
	}
}
