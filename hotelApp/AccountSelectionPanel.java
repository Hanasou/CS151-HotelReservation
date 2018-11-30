package hotelApp;


import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Panel that allows selection between guest and manager accounts
 * @author
 * Date created: 11/13/2018
 */
public class AccountSelectionPanel extends JFrame
{

	private JButton guest;
	private JButton manager;
	public AccountSelectionPanel(DataStorage db, int width)
	{

		guest = new JButton("Guest");
		guest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GuestSignInPanel b = new GuestSignInPanel(db, width);
			}
		});
		manager = new JButton("Manager");
		manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagerSignInPanel b = new ManagerSignInPanel(db, width);
			}
		});
		JPanel buttons = new JPanel();
		buttons.add(guest);
		buttons.add(manager);
		setLayout(new BorderLayout());
		add(buttons);

		setSize(width, width);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
	}
}
