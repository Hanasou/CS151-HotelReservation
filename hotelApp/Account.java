package hotelApp;

import java.util.ArrayList;

/**
 * Class that contains the information regarding any individual account
 * @author
 * Date created: 11/13/2018
 */
public abstract class Account implements Comparable
{
    private String name, username, password;
    private boolean isManager;
    private int accID;
    private ArrayList<Reservation> reservations;
    
    public Account (String name, String username, String password, boolean isManager, int accountID) {
    	this.name = name;
    	this.username = username;
    	this.password = password;
    	this.isManager = isManager;
    	this.accID = accountID;
    	reservations = new ArrayList<>();
    }


    /**
     * CompareTo method to satisfy Comparable interface implementation
     * Compares fist by name, then by username
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

    public void addReservation(Reservation r)
    {
        reservations.add(r);
    }

    //TODO: Decide on what parameter to pass in
    /*
    public boolean removeReservation(? ?)
    {

    }
    */

    @Override
    public boolean equals(Object that)
    {
        return this.compareTo(that) == 0;
    }

    @Override
    public String toString()
    {

        return "name: " + name +  " username: " + username + " manager: " + isManager + " account ID: " + accID;
    }

    public boolean isManager()
    {
        return isManager;
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
    public ArrayList<Reservation> getReservations()
    {
        return reservations;
    }
}
