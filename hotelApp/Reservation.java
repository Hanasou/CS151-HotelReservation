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

}
