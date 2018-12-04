package hotelApp;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.naming.spi.ResolveResult;
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

        Account a = db.getAccountByUserName("NPSG");

        ArrayList<Reservation> res = a.getReservations();
        for (int i = 0; i < res.size(); i++)
        {
            System.out.println(res.get(i));
        }

        db.deleteReservationFromAccount(a, res.get(1));

        System.out.println("AFTER DELETE");
        for (Reservation r : res)
            System.out.println(r);

//        2018-11-20 - 2018-11-22
        Reservation toDelete = new Reservation(db.getAccountByUserName("NPSG"), db.getRoomByNumber(130), new TimeInterval(LocalDate.of(2018,11,20), LocalDate.of(2018,11,22)));
        db.deleteReservationFromAccount(a, toDelete);

        System.out.println("AFTER SECOND DELETE");
        for (Reservation r : res)
            System.out.println(r);

    }
}
