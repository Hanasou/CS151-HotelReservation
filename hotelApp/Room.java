package hotelApp;

/**
 * Class that contains information related to the room, such as a number and price
 * @author
 * Date created: 11/13/2018
 */
public class Room
{
    private int number;
    private double price;
    
    public Room (int n, double p) {
    	this.number = n;
    	this.price = p;
    }

    public int getRoomNumber()
    {
        return number;
    }

    public double getPrice()
    {
        return price;
    }

    public String toString()
    {
        return "Room: " + number + " Price: $" + price;
    }
}
