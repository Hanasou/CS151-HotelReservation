package hotelApp;

import javax.swing.*;
import java.awt.event.*;
/**
 * Panel that allows selection between guest and manager accounts
 * @author Roy Zhang
 * Date created: 12/03/2018
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
			reservations.append(r.toStringShort() + "\n");
		}
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws NullPointerException {
				Reservation deleteMe = null;
				for (Reservation r : acc.getReservations()) {
					if (insertReservation.getText().equals(r.toStringShort())) {
						deleteMe = r;
					}
				}
				try {
				db.deleteReservationFromAccount(acc, deleteMe);
				deleteMe.getRoom().getReservations().remove(deleteMe);
				reservations.setText("Current Reservations" + "\n");
				for (Reservation r : acc.getReservations()) {
					reservations.append(r.toStringShort() + "\n");
				}
				}
				catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(panel, "Reservation not found");
				}
			}
		});
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountSelectionPanel asp = new AccountSelectionPanel(db, 500);
			}
		});
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
