/**
 * Class that represents a reservation. Reservations know the account that created them, the room, and the time for which they are booked
 * @author
 * Date created: 11/13/2018
 */
public class Reservation
{
    Account attachedAccount;
    Room room;
    TimeInterval time;
}
