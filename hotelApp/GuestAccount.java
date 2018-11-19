package hotelApp;

/**
 * Subclass of Account that represents a guest account that has admin actions restricted
 * @author
 * Date created: 11/13/2018
 */
public class GuestAccount extends Account
{
	public GuestAccount (String name, String username, String password, int accID) {
		super(name, username, password, false, accID);
	}
}
