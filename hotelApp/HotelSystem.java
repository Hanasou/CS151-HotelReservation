package hotelApp;
/**
 * Deploys the Hotel Reservation System. Constructs a DataStorge object and an AccountSelectionPanel. All other functions can be accessed from these.
 * @author 
 * Date created: 11/13/2018
 */
public class HotelSystem
{
    public static void main(String[] args)
    {
        DataStorage db = new DataStorage();
        AccountSelectionPanel accSele = new AccountSelectionPanel(db, 500);
    }
}
