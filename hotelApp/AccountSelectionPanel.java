package hotelApp;

import java.awt.BorderLayout;

import javax.swing.*;

/**
 * Panel that allows selection between guest and manager accounts
 * @author
 * Date created: 11/13/2018
 */
public class AccountSelectionPanel extends JPanel
{

	private JButton guest;
	private JButton manager;
	
	
	public AccountSelectionPanel()
	{

		guest = new JButton("Guest");
		manager = new JButton("Manager");
		add(guest);
		add(manager);

	}
	
	
    public static void main(String[] args)
    {
    	//tester
    	JFrame frame = new JFrame();
    	AccountSelectionPanel a  = new AccountSelectionPanel();

    	frame.setSize(500, 200);
    	a.setLocation(250,100);
    	frame.add(a);
    	frame.setVisible(true);
    	
    	
    	
    }
}

