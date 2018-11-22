package hotelApp;

import java.util.ArrayList;

/**
 * Tester class where any testing can be done to confirm code is working.
 * Final implmentation of project will be in HotelSystem
 * @see HotelSystem
 * @author Nicholas Paapno
 * Date created: 11/13/2018
 */
public class HotelSystemTester
{
    public static void main(String[] args)
    {
        DataStorage db = new DataStorage();
        System.out.println(db.addAccount(new GuestAccount("asdf", "123", "uipqro", 27)));

        if (!db.addAccount(new GuestAccount("NPSG", "TESTUN", "hi", 38)))
        {
            System.out.println("FAILED");
        }
        else
        {
            System.out.println("Success");
        }


        db.saveToFile();
    }
}
