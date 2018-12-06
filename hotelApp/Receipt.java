package hotelApp;

/**
 * Interface that defines requirements for receipts when they need to be displayed
 * @author Nicholas Papano
 * Date created: 11/13/2018
 */
public interface Receipt
{
    /**
     * The header for the receipt
     * @return a string for the very top part of the receipt, with the user's name and other relevant information displayed
     */
    String header();

    /**
     * The list of all the reservations that should be included in the receipt, including a total cost at the bottom
     * @return a string representation of all reservations with a total cost
     */
    String receiptList();

}
