/**
 * Class that contains information related to the room, such as a number and price
 * @author
 * Date created: 11/13/2018
 */
public class Room
{
    private int number;
    private double price;
    private boolean reserved;
    
    public Room (int n, double p) {
    	this.number = n;
    	this.price = p;
    	this.reserved = false;
    }
}
