package hotelApp;

public class ManagerAccount extends Account
{
	public ManagerAccount (String name, String username, String password, int accID) {
		super(name, username, password, true, accID);
	}
}
