package hotelApp;

public class ManagerAccount extends Account
{
    /**
 	 *Constructs a manager account.
 	 *@param name the name of manager account
 	 *@param username the manager account username
 	 *@param password the manager account password 	
 	 *@param accID the manager account id
 	 */
	public ManagerAccount (String name, String username, String password, int accID) {
		super(name, username, password, true, accID);
	}
}
