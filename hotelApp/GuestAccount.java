package hotelApp;

/**
 * Subclass of Account that represents a guest account that has admin actions restricted
 * @author
 * Date created: 11/13/2018
 */
public class GuestAccount extends Account
{
    /**
 	 *Constructs a guest account.
 	 *@param name the name of guest account
 	 *@param username the guest account username
 	 *@param password the guest account password 	
 	 *@param accID the guest account id
 	 */
	public GuestAccount (String name, String username, String password, int accID) {
		super(name, username, password, false, accID);
	}
}
