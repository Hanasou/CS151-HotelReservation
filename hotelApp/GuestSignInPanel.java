package hotelApp;

import javax.swing.*;

/**
 * Panel for having a guest sign in
 * @author
 * Date created: 11/13/2018
 */
public class GuestSignInPanel extends JPanel
{
	private JTextField username;
	private JTextField password;
	private JLabel user;
	private JLabel pass;
	private JLabel title;
	private JButton logInButton;
	public static int width = 500;
	
	GuestSignInPanel()
	{
		username = new JTextField(15);
		password = new JTextField(15);
		title = new JLabel("Guest Sign In");
		user = new JLabel("Username");
		pass = new JLabel("Password");
		logInButton = new JButton("Log In");
		add(user);
		add(pass);
		add(username);
		add(password);
		add(logInButton);
		add(title);
//		setLocation(250,250);
		
	    setLayout (null); 
	    
	    title.setBounds(width/2 - width/12,width/8,150,20);
	    username.setBounds(width/2 - 75,width/3 - 20,150,20);
	    password.setBounds(width/2 - 75,width/3 + 20,150,20);
	    user.setBounds(width/2 - 150,width/3 - 20,150,20);
	    pass.setBounds(width/2 - 150,width/3 + 20,150,20);
	    logInButton.setBounds(width/2 - width/12,width/3 + 60,75,20);
	}
	
    public static void main(String[] args)
    {
    	//tester
    	JFrame frame = new JFrame();
    	GuestSignInPanel a  = new GuestSignInPanel();

    	frame.setSize(width, width);
    	
    	frame.add(a);
    	frame.setVisible(true);
    	
    	
    	
    }
}
