package hotelApp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Panel that allows selection between guest and manager accounts
 * @author Roy Zhang
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
				//dispose();
				//GuestSignInPanel b = new GuestSignInPanel(db, width);
				JFrame guestAction = new JFrame("Sign up or Sign in?");
				JPanel layout = new JPanel(new BorderLayout());
				JButton signUp = new JButton("Sign Up");
				signUp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						guestAction.dispose();
						GuestSignUpPanel signup = new GuestSignUpPanel(db, width);
					}
				});
				JButton signIn = new JButton("Sign In");
				signIn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						guestAction.dispose();
						GuestSignInPanel signin = new GuestSignInPanel(db, width);
					}
				});
				JLabel accountAction = new JLabel("Don't have an account? Sign up!");
				
				layout.add(accountAction, BorderLayout.NORTH);
				layout.add(signUp, BorderLayout.WEST);
				layout.add(signIn, BorderLayout.EAST);
				guestAction.add(layout);
				
				guestAction.setLayout(new FlowLayout());
				guestAction.pack();
				guestAction.setVisible(true);
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