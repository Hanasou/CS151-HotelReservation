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
     * @param n the number
     * @param p the price
     */
    public Room (int n, double p) {
    	this.number = n;
    	this.price = p;
    }
    /**
     * @return number
     */
    public int getRoomNumber()
    {
        return number;
    }
    /**
     * @return price
     */
    public double getPrice()
    {
        return price;
    }
    /**
     * @return "Room: " + number + " Price: $" + price
     */
    public String toString()
    {
        return "Room: " + number + " Price: $" + price;
    }

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
