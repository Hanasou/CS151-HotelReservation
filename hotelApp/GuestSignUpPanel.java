package hotelApp;

import javax.swing.*;

/**
 * Panel that allows a guest to create a new GuestAccount
 * @author
 * Date created: 11/13/2018
 */
public class GuestSignUpPanel extends JPanel
{
   //TODO: Make sure when signing up that they must have a unique username!
	
	private JTextField username;
	private JTextField password;
	private JLabel user;
	private JLabel pass;
	private JLabel title;
	private JButton signUpButton;
	public static int width = 500;
	
	GuestSignUpPanel()
	{
		username = new JTextField(15);
		password = new JTextField(15);
		title = new JLabel("Guest Sign Up");
		user = new JLabel("Username");
		pass = new JLabel("Password");
		signUpButton = new JButton("Sign Up");
		add(user);
		add(pass);
		add(username);
		add(password);
		add(signUpButton);
		add(title);
//		setLocation(250,250);
		
	    setLayout (null); 
	    
	    title.setBounds(width/2 - width/12,width/8,150,20);
	    username.setBounds(width/2 - 75,width/3 - 20,150,20);
	    password.setBounds(width/2 - 75,width/3 + 20,150,20);
	    user.setBounds(width/2 - 150,width/3 - 20,150,20);
	    pass.setBounds(width/2 - 150,width/3 + 20,150,20);
	    signUpButton.setBounds(width/2 - width/12,width/3 + 60,80,20);
	}
	
    public static void main(String[] args)
    {
    	//tester
    	JFrame frame = new JFrame();
    	GuestSignUpPanel a  = new GuestSignUpPanel();

    	frame.setSize(width, width);
    	
    	frame.add(a);
    	frame.setVisible(true);
    }

}
