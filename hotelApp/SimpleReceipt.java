package hotelApp;

import java.util.ArrayList;

/**
 * Type of receipt that is more succinct and is less verbose than ComprehensiveReceipt
 * @author Nicholas Papano
 * Date created: 11/13/2018
 */
public class SimpleReceipt implements Receipt
{
    private Account account;
    private ArrayList<Reservation> reservations;

    /**
     * Constructs a SimpleReceipt given the instance variables
     * @param a the attached account
     * @param res the list of reservations just confirmed
     */
    public SimpleReceipt(Account a, ArrayList<Reservation> res)
    {
        account = a;
        reservations = res;
    }

    /**
     * Returns the account name as the header for the receipt
     * @return a string containing the account name
     */
    @Override
    public String header()
    {
        return "Simple receipt for: " + account.getName();
    }

    /**
     * Compiles all reservations into a string and returns them, with the final cost at the end
     * @return a string of all reservations from it's instance list, along with the final cost
     */
    @Override
    public String receiptList()
    {
        StringBuilder list = new StringBuilder();
        double totalCost = 0;
        for (Reservation r : reservations)
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
