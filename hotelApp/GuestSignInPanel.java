package hotelApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Panel for having a guest sign in
 * @author
 * Date created: 11/13/2018
 */
public class GuestSignInPanel extends JFrame
{
	private JTextField username;
	private JTextField password;
	private JLabel user;
	private JLabel pass;
	private JLabel title;
	private JButton logInButton;
	private JButton backButton;
	private DataStorage db;
	private JPanel panel;
	
	public GuestSignInPanel(DataStorage db, int width)
	{
		this.db = db;
		setTitle("Guest Login");
		username = new JTextField(15);
		password = new JTextField(15);
		user = new JLabel("Username");
		pass = new JLabel("Password");
		title = new JLabel("Guest Log In");
		logInButton = new JButton("Log In");
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = username.getText();
				String passw = password.getText();
				if (db.guestValidate(login, passw)) {
					System.out.println("validated");
				}
				else {
					System.out.println("nope");
				}
			}
		});
		//TODO: Add this button to frame
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				AccountSelectionPanel accSel = new AccountSelectionPanel(db, width);
			}
		});

		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
		labelPanel.add(Box.createVerticalStrut(10));
		labelPanel.add(title);
		labelPanel.add(Box.createVerticalStrut(30));
		labelPanel.add(user);
		labelPanel.add(Box.createVerticalStrut(2));
		labelPanel.add(pass);
		
		JPanel textFieldPanel = new JPanel();
		textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.PAGE_AXIS));
		textFieldPanel.add(Box.createVerticalStrut(90));
		textFieldPanel.add(username);
		textFieldPanel.add(Box.createVerticalStrut(0));
		textFieldPanel.add(password);
		textFieldPanel.add(Box.createVerticalStrut(0));
		textFieldPanel.add(logInButton);
		panel.add(labelPanel);
		panel.add(textFieldPanel);
		add(panel);
//		setLocation(250,250);
		
	    
	    /**
	    title.setBounds(width/2 - width/12,width/8,150,20);
	    username.setBounds(width/2 - 75,width/3 - 20,150,20);
	    password.setBounds(width/2 - 75,width/3 + 20,150,20);
	    user.setBounds(width/2 - 150,width/3 - 20,150,20);
	    pass.setBounds(width/2 - 150,width/3 + 20,150,20);
	    logInButton.setBounds(width/2 - width/12,width/3 + 60,75,20);
	    */
	    
	    setSize(width, width);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
	}
	
}
