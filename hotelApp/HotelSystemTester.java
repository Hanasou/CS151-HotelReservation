package hotelApp;

import java.awt.*;
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
	public static int width = 500;
	
    public static void main(String[] args)
    {
    	DataStorage db = new DataStorage();
    	db.addAccount(new GuestAccount("jim", "jim123", "swordfish", 99231));
    	db.addAccount(new ManagerAccount("jim", "james123", "swordfish", 99230));
    	//ReservationPanel rp = new ReservationPanel(db.getAccountByUserName("jim123"), db);
    	//ViewReservationPanel vrp = new ViewReservationPanel(db.getAccountByUserName("SteveS"), db);
    	//AccountSelectionPanel a = new AccountSelectionPanel(db, 300);
    	GuestSignInPanel b  = new GuestSignInPanel(db, width);
    	
    }
}
