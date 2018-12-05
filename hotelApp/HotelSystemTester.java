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
    	Account jim = new GuestAccount("jim", "jim", "swordfish", 49492);
    	db.addAccount(jim);
    	GuestSignInPanel gsp = new GuestSignInPanel(db, 300);
    }
}
