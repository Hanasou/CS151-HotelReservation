package hotelApp;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Tester class where any testing can be done to confirm code is working.
 * Final implementation of project will be in HotelSystem
 * @see HotelSystem
 * @author Nicholas Papano
 * Date created: 11/13/2018
 */
public class HotelSystemTester
{

    public static void main(String[] args)
    {
        DataStorage db = new DataStorage();
        ArrayList<Room> rooms = db.getAvailableRooms(new TimeInterval(LocalDate.of(2018,11,1), LocalDate.of(2018,12,31)), 0);

        for (Room r : rooms)
            System.out.println(r);
    }
}
