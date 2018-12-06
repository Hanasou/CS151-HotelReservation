package hotelApp;
/**
 * Panel for having a guest sign in
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
