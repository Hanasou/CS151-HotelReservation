package hotelApp;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;

/**
 * Class that stores all accounts in memory
 * @author
 * Date created: 11/13/2018
 */
public class DataStorage
{
    private TreeMap<Account, ArrayList<Reservation>> accountReservations;
    private ArrayList<Room> rooms;
    private File reservationFile, accountFile;

    public DataStorage()
    {
        accountReservations = new TreeMap<>();
        rooms = new ArrayList<>();

        // Hard coded list of rooms
        rooms.add(new Room(100, 100));
        rooms.add(new Room(110, 100));
        rooms.add(new Room(120, 100));
        rooms.add(new Room(130, 100));
        rooms.add(new Room(140, 100));
        rooms.add(new Room(150, 100));
        rooms.add(new Room(160, 100));
        rooms.add(new Room(170, 100));
        rooms.add(new Room(180, 100));
        rooms.add(new Room(190, 100));
        rooms.add(new Room(500, 300));
        rooms.add(new Room(510, 300));
        rooms.add(new Room(520, 300));
        rooms.add(new Room(530, 300));
        rooms.add(new Room(540, 300));
        rooms.add(new Room(550, 300));
        rooms.add(new Room(560, 300));
        rooms.add(new Room(570, 300));
        rooms.add(new Room(580, 300));
        rooms.add(new Room(590, 300));

        reservationFile = new File("hotelApp/reservations.txt");
        accountFile = new File("hotelApp/accounts.txt");

        populateFromFile();
    }


    /**
     * Populates local data structures from files
     * @return true if successful, false if it encounters an error
     */
    public boolean populateFromFile()
    {
        //TODO: finish/test, currently only pulls from accounts.txt
        try
        {
            Scanner accSc = new Scanner(accountFile);
            Scanner resSc = new Scanner(reservationFile);

            ArrayList<Account> accounts = new ArrayList<>();
            String nextLn;
            int lineNum = 0;

            // Get accounts from file
            while (accSc.hasNextLine())
            {
                nextLn = accSc.nextLine();
                String[] accInfo = nextLn.split(", ");
                /*
                format for account from file is:
                name, username, pw, isManager
                 */
                boolean isManager = Boolean.parseBoolean(accInfo[3]);
                if (isManager)
                    accounts.add(new ManagerAccount(accInfo[0], accInfo[1], accInfo[2], lineNum++));
                else
                    accounts.add(new GuestAccount(accInfo[0], accInfo[1], accInfo[2], lineNum++));
            }
            // get reservations from file
            while (resSc.hasNextLine())
            {
                nextLn = resSc.nextLine();

            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("FileNotFoundException while parsing files for database population");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //TODO: Finish/test
    public boolean saveToFile()
    {
        try
        {
            FileWriter accWritier = new FileWriter(accountFile);
            FileWriter resWritier = new FileWriter(reservationFile);
            for (Account a : accountReservations.keySet())
            {
                accWritier.write(a.toString() + "\n");
            }
        }
        catch (IOException e)
        {
            System.out.println("IOException while saving contents of database to file");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Account getAccountByUserName(String username)
    {
        Set<Account> accounts = accountReservations.keySet();
        for (Account a : accounts)
        {
            if (a.getUsername().equals(username))
                return a;
        }
        return null;
    }

    /**
     * Validates that the inputted username and password match an existing account
     * @param username the username of the account
     * @param password the password of the account
     * @return true if correct username/password combo, false otherwise
     */
    public boolean validate(String username, String password)
    {
    	for (Account a : accountReservations.keySet())
    	{
    		if (a.getUsername().equals(username) && a.getPassword().equals(password))
    			return true;
    	}
    	return false;
    }

    /**
     *
     * @return
     */
    public ArrayList<Room> getAvailableRooms()
    {
        //TODO: finish when TimeInterval & reservation file code is fully implemented
    	ArrayList<Room> available = new ArrayList<>();

    	return available;
    }
}
