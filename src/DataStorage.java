import java.util.ArrayList;
import java.io.File;

/**
 * Class that stores all accounts in memory
 * @author
 * Date created: 11/13/2018
 */
public class DataStorage
{
    private ArrayList<Account> accounts;
    private ArrayList<Reservation> reservations;
    private ArrayList<Room> rooms;
    private File reservationFile;

    public DataStorage()
    {
        accounts = new ArrayList<Account>();
        reservations = new ArrayList<Reservation>();
        rooms = new ArrayList<Room>();
        reservationFile = new File("src/reservations.txt");
    }

    public void addAccount(Account a) {
    	accounts.add(a);
    }
    public void addReservation(Reservation r) {
    	reservations.add(r);
    }
    public void addRoom(Room r) {
    	rooms.add(r);
    }
    public boolean validate(String username, String password) {
    	for (Account a : accounts) {
    		if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
    			return true;
    		}
    	}
    	return false;
    }
    public ArrayList<Room> availableRooms() {
    	ArrayList<Room> available = new ArrayList<Room>();
    	for (Room r : rooms) {
    		if (!r.isReserved()) {
    			available.add(r);
    		}
    	}
    	return available;
    }
}
