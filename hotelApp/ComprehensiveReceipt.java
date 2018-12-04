package hotelApp;

/**
 * Class that gives an in-depth version of any given receipt, more verbose than SimpleReceipt
 * @author Nicholas Papano
 * Date created: 11/13/2018
 */
public class ComprehensiveReceipt implements Receipt
{
    Account account;

    public ComprehensiveReceipt(Account a)
    {
        account = a;
    }

    @Override
    public String header()
    {
        return "Receipt for: " + account.getName();
    }

    @Override
    public String receiptList()
    {
        StringBuilder list = new StringBuilder();
        double totalCost = 0;
        for (Reservation r : account.getReservations())
        {
            long dayAmt = r.getTime().amountOfDays();
            double cost = r.getRoom().getPrice()*dayAmt;
            list.append(r.getTime().toString() + ", Room " + r.getRoom().getRoomNumber() + " Cost:  " + cost + "\n");
            totalCost += cost;
        }
        list.append("Total cost: " + totalCost);
        return list.toString();
    }
}
