package hotelApp;

/**
 * Class that represents a reservation. Reservations know the account that created them, the room, and the time for which they are booked
 * @author Nicholas Papano
 * Date created: 11/13/2018
 */
public class Reservation
{
    private Account attachedAccount;
    private Room room;
    private TimeInterval time;

    /**
     * Constructs a reservation with the instance variables as parameters
     * @param a the account the reservation is attached to
     * @param r the room of the reservation
     * @param t the TimeInterval the reservation is booked for
     */
    public Reservation (Account a, Room r, TimeInterval t)
    {
    	this.attachedAccount = a;
    	this.room = r;
    	this.time = t;
    	r.getReservations().add(this);
    }
    /**
     * Returns the attached account
 	 * @return the account the reservation belongs to
 	 */
    public Account getAttachedAccount()
    {
        return attachedAccount;
    }
    /**
     * Returns the room attached to the reservation
     * @return Room for reservation
     */
    public Room getRoom()
    {
        return room;
    }
    /**
     * returns the TimeInterval for the reservation
     * @return the TimeInterval that the reservation is booked over
     */
    public TimeInterval getTime()
    {
        return time;
    }
    /**
     * Returns the string representation of the Reservation
     * @return a String displaying all instance variables
     */
    public String toString()
    {
        return "Attached account username: " + attachedAccount.getUsername() + " room: " + room + " time: " + time;
    }

    /**
     * Returns a smaller string without the username
     * @return a shortened String displaying the room and time only
     */
    public String toStringShort() {
    	return "Room " + room.getRoomNumber() + ", " + time;
    }
    /**
     * Overriden equals method that compares for equality
     * @param other the object to compare to
     * @return true if equal, false otherwise
     */
    public boolean equals(Object other)
    {
        if (other instanceof Reservation)
        {
            Reservation that = (Reservation) other;
            return attachedAccount.equals(that.attachedAccount) && room.equals(that.room) && time.equals(that.time);
        }
        return false;
    }

}
