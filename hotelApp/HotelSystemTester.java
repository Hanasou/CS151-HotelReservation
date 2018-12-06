package hotelApp;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;
import java.time.LocalDate;
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
    	CalendarPanel cp = new CalendarPanel(db);
    	JFrame frame = new JFrame();
    	frame.add(cp);
    	
    	frame.pack();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    }
}
