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

    public SimpleReceipt(Account a, ArrayList<Reservation> res)
    {
        account = a;
        reservations = res;
    }

    @Override
    public String header()
    {
        return account.getName();
    }

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
        list.append("Total cost: " + totalCost);
        return list.toString();
    }
}
