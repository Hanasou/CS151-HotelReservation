package hotelApp;

public class HotelSystem
{
    public static void main(String[] args)
    {
        DataStorage db = new DataStorage();
        AccountSelectionPanel accSele = new AccountSelectionPanel(db, 500);
    }
}
