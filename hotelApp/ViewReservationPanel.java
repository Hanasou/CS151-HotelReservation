package hotelApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Frame for viewing reservations made on an account. Guest inputs the reservation to delete it.
 * @author Roy
 *
 */
public class ViewReservationPanel extends JFrame {

	private DataStorage db;
	private Account acc;
    /**
 	 *Constructs a view reservation panel
 	 *@param acc the account
 	 *@param db the data storage
 	 */
	public ViewReservationPanel(Account acc, DataStorage db) {
		this.db = db;
		this.acc = acc;
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		JTextArea reservations = new JTextArea("Current Reservations" + "\n", 10, 21);
		JTextField insertReservation = new JTextField(15);
		JLabel label = new JLabel("Input reservation you want to delete. Format must match what is shown below.");
		JButton delete = new JButton("Delete Reservation");
		JButton goBack = new JButton("Done");
		
		for (Reservation r : acc.getReservations()) {
			reservations.append(r.stringView() + "\n");
		}
		panel.add(label);
		panel.add(reservations);
		panel.add(insertReservation);
		panel.add(delete);
		panel.add(goBack);
		add(panel);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
	}
}
