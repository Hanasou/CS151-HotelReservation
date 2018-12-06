import java.io.File;

/**
 * Class that stores reservations in memory for faster access/usage. Uses the reservations.txt file for long-term storage
 * @author
 * Date created: 11/13/2018
 */
public class ReservationDB
{
    private File dbFile;

    public ReservationDB()
    {
        dbFile = new File("src/reservations.txt");
    }
}
