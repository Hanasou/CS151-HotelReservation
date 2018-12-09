package hotelApp;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

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
		this.acc = db.getAccountByUserName(acc.getUsername());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		JLabel label = new JLabel("Here are your current Reservations.\nClicking the reservation will delete it!");
		ArrayList<JButton> reservationsB = new ArrayList<>();
		JButton goBack = new JButton("Done");
		
		for (Reservation r : acc.getReservations()) {
			reservationsB.add(new JButton(r.toStringShort()));
		}
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountSelectionPanel asp = new AccountSelectionPanel(db, 500);
			}
		});
		panel.add(label);

		for (JButton b : reservationsB)
		{
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) throws NullPointerException {
					Reservation deleteMe = null;
					for (Reservation r : acc.getReservations()) {
						if (b.getText().equals(r.toStringShort())) {
							deleteMe = r;
						}
					}
					try {
						db.deleteReservationFromAccount(acc, deleteMe);
						deleteMe.getRoom().getReservations().remove(deleteMe);
					}
					catch (NullPointerException npe) {
						JOptionPane.showMessageDialog(panel, "Reservation not found");
					}
					b.setVisible(false);
				}
			});
		}
		for (JButton b : reservationsB)
		{
			panel.add(b);
		}
		panel.add(goBack);
		add(panel);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
	}
}
