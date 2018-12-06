package hotelApp;

/**
 * Class that represents a reservation. Reservations know the account that created them, the room, and the time for which they are booked
 * @author
 * Date created: 11/13/2018
 */
public class Reservation
{
    private Account attachedAccount;
    private Room room;
    private TimeInterval time;
    
    public Reservation (Account a, Room r, TimeInterval t)
    {
    	this.attachedAccount = a;
    	this.room = r;
    	this.time = t;
    }
    /**
 	* @return attachedAccount
 	*/
    public Account getAttachedAccount()
    {
        return attachedAccount;
    }
    /**
     * @return room
     */
    public Room getRoom()
    {
        return room;
    }
    /**
     * @return time
     */
    public TimeInterval getTime()
    {
        return time;
    }
    /**
     * @return "Attached account username: " + attachedAccount.getUsername() + " room: " + room + " time: " + time
     */
    public String toString()
    {
        return "Attached account username: " + attachedAccount.getUsername() + " room: " + room + " time: " + time;
    }
    /**
     * @return room.getRoomNumber() + " " + time
     */
    public String stringView() {
    	return room.getRoomNumber() + " " + time;
    }
    /**
     * @param other
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
