package hotelApp;

import java.util.ArrayList;

/**
 * Class that contains the information regarding any individual account
 * @author Nicholas Papano
 * Date created: 11/13/2018
 */
public abstract class Account implements Comparable
{
    private String name, username, password;
    private boolean isManager;
    private int accID;
    private ArrayList<Reservation> reservations;
    
    /**
 	 *Constructs an account with the given parameters
 	 *@param name the account owner
 	 *@param username the user id
 	 *@param password the pass id
 	 *@param isManager the manager key
 	 *@param accountID the id of account
    */
    public Account (String name, String username, String password, boolean isManager, int accountID) {
    	this.name = name;
    	this.username = username;
    	this.password = password;
    	this.isManager = isManager;
    	this.accID = accountID;
    	reservations = new ArrayList<>();
    }


    /**
     * CompareTo method to satisfy Comparable interface implementation <BR>
     * Compares fist by name, then by username
     * @param other the object to be compared to
     * @return int specifying if other should be before, is equal to, or after this
     */
    @Override
    public int compareTo(Object other)
    {
        if (other instanceof Account)
        {
            Account that = (Account) other;
            int nameComp = name.compareTo(that.name);
            if (nameComp != 0)
            {
                return nameComp;

            }
            int unComp = username.compareTo(that.username);
            if (unComp != 0)
            {
                return unComp;
            }
        }
        return 0;
    }
    /**
     * adds a reservation to the account's list of reservations
     * @param r the reservation to be added
     */
    public void addReservation(Reservation r)
    {
        reservations.add(r);
    }


    /**
     * Overridden equals method to compare using the criteria specified in the CompareTo method
     * @param that the object to be compared to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object that)
    {
        return this.compareTo(that) == 0;
    }


    /**
     * Overridden toString method to display the instance variables in the account
     * @return A string displaying all instance variables
     */
    @Override
    public String toString()
    {

        return "name: " + name +  " username: " + username + " manager: " + isManager + " account ID: " + accID;
    }

    /**
     * Returns the boolean stating if the account is a manager account or not
     * @return true if account is a manager, false if not
     */
    public boolean isManager()
    {
        return isManager;
    }    
    /**
     * Returns the username of the account
     * @return the String username
     */
    public String getUsername() {
    	return username;
    }
    /**
     * Returns the password of the account
     * @return the String password
     */
    public String getPassword() {
    	return password;
    }
    /**
     * Returns the name of the account
     * @return the String name
     */
    public String getName() {
    	return name;
    }
    /**
     * Returns the list of reservations attached to this account
     * @return the arraylist of reservations
     */
    public ArrayList<Reservation> getReservations()
    {
        return reservations;
    }

}
