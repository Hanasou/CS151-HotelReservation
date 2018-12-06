package hotelApp;

/**
 * Class that contains information related to the room, such as a number and price
 * @author Nicholas Papano
 * Date created: 11/13/2018
 */
public class Room
{
    private int number;
    private double price;
    /**
     * Constructs a room given the instance variables
     * @param n the number
     * @param p the price
     */
    public Room (int n, double p) {
    	this.number = n;
    	this.price = p;
    }
    /**
     * Gets the room's number
     * @return an int that is the room number
     */
    public int getRoomNumber()
    {
        return number;
    }
    /**
     * Gets the price of the room per night
     * @return the per night price
     */
    public double getPrice()
    {
        return price;
    }
    /**
     * Returns the string representation of the room
     * @return A string of containing the states of the instance variables
     */
    public String toString()
    {
        return "Room: " + number + " Price: $" + price;
    }

    /**
     * Checks if this room is equal to the parameter passed in
     * @param obj the object to compare to
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object obj)
    {
       if (obj instanceof Room)
       {
           Room that = (Room) obj;
           return number == that.number && price == that.price;
       }
       return false;
    }
}
