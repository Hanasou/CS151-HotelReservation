import java.util.ArrayList;

/**
 * Class that contains the information regarding any individual account
 * @author
 * Date created: 11/13/2018
 */
public abstract class Account
{
    private ArrayList<Reservation> reservations;
    private String name, username, password;
    
    public Account (String name, String username, String password) {
    	this.name = name;
    	this.username = username;
    	this.password = password;
    	this.reservations = new ArrayList<Reservation>();
    }
    
    public String getUsername() {
    	return username;
    }
    public String getPassword() {
    	return password;
    }
    public String getName() {
    	return name;
    }
    public void addReservation(Reservation r) {
    	reservations.add(r);
    }
}
