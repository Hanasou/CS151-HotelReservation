package hotelApp;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Panel that allows a manager to sign in
 * @author
 * Date created: 11/13/2018
 */
public class ManagerSignInPanel extends JFrame
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
    /**
 	 *Constructs a sign in panel
 	 *@param db the data storage
 	 *@param width the width of panel
 	 */
	public ManagerSignInPanel(DataStorage db, int width)
	{
		this.db = db;
		setTitle("Manager Login");
		username = new JTextField(15);
		password = new JTextField(15);
		user = new JLabel("Username");
		pass = new JLabel("Password");
		title = new JLabel("Manager Log In");
		logInButton = new JButton("Log In");
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = username.getText();
				String passw = password.getText();
				if (db.managerValidate(login, passw)) {
					System.out.println("validated");
				}
				else {
					JOptionPane.showMessageDialog(panel, "Credentials not found. Please try again.");
				}
			}
		});
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
		textFieldPanel.add(backButton);
		panel.add(labelPanel);
		panel.add(textFieldPanel);
		add(panel);
//		setLocation(250,250);
		
	    
	    /*
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
