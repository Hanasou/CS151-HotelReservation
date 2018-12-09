package hotelApp;

/**
 * Class that gives an in-depth version of any given receipt, more verbose than SimpleReceipt
 * @author Nicholas Papano
 * Date created: 11/13/2018
 */
public class ComprehensiveReceipt implements Receipt
{
    private Account account;
    /**
 	 *Constructs a receipt.
 	 *@param a the account to create the receipt for
     */
    public ComprehensiveReceipt(Account a)
    {
        account = a;
    }

    /**
     * The header for the receipt, where the user's name is displayed
     * @return a string containing the user's name
     */
    @Override
    public String header()
    {
        return "Comprehensive receipt for: " + account.getName();
    }

    /**
     * Constructs and returns a list of all reservations, and their costs with a total cost at the bottom
     * @return a list of all reservations attached to the account, with a total cost at the bottom
     */
    @Override
    public String receiptList()
    {
        StringBuilder list = new StringBuilder();
        double totalCost = 0;
        for (Reservation r : account.getReservations())
        {
            long dayAmt = r.getTime().amountOfDays();
            double cost = r.getRoom().getPrice()*dayAmt;
            list.append(r.getTime().toString() + ", Room " + r.getRoom().getRoomNumber() + ". Cost:  " + cost + "\n");
            totalCost += cost;
        }
        list.append("Total cost: $" + totalCost);
        return list.toString();
    }
}
