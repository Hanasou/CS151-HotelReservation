import java.util.ArrayList;

/**
 * Class that stores all accounts in memory
 * @author
 * Date created: 11/13/2018
 */
public class AccountDB
{
    private ArrayList<Account> accounts;

    public AccountDB()
    {
        accounts = new ArrayList<>();
    }

    public void add(Account a) {
    	accounts.add(a);
    }
    
    public boolean validate(String username, String password) {
    	for (Account a : accounts) {
    		if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
    			return true;
    		}
    	}
    	return false;
    }
}
