package hotelApp;

import java.time.LocalDate;

/**
 * Class that represents an interval of time. Keeps two LocalDateTime objects and assumes the event exists.
 * Taken and adjusted from Nicholas' command line calendar project (programming assignment 1)
 * @author Nicholas Papano
 * @version 1.1
 * Date Created: 9/1/18
 */
public class TimeInterval
{
    private LocalDate startTime, endTime;

    /**
     * Constructor taking in two times and initializes instance variables to these values
     *
     * @param start the starting time of the event
     * @param end the ending time of the event
     */
    public TimeInterval(LocalDate start, LocalDate end)
    {
        startTime = start;
        endTime = end;
    }

    /**
     * Compares two TimeIntervals, looking to see if the inputted TimeInterval overlaps this TimeInterval in any way
     *
     * @param that the TimeInterval to be comparing to this
     * @return True of the events overlap, false otherwise
     */
    public boolean overlap(TimeInterval that)
    {
        if (this.startTime.compareTo(that.startTime) > 0 && this.startTime.compareTo(that.endTime) < 0) // start time exists in event
        {
            return true;
        }
        else if (this.endTime.compareTo(that.startTime) > 0 && this.endTime.compareTo(that.endTime) < 0) // end time exists in event
        {
            return true;
        }
        else if (this.startTime.compareTo(that.startTime) < 0 && this.endTime.compareTo(that.endTime) > 0) // this completely overlaps that
        {
            return true;
        }
        return false;
    }

    /**
     * Gets the starting time of the TimeInterval
     *
     * @return the starting time of the TimeInterval
     */
    public LocalDate getStartTime()
    {
        return startTime;
    }

    /**
     * Gets the ending time of the TimeInterval
     *
     * @return the ending time of the TimeInterval
     */
    public LocalDate getEndTime()
    {
        return endTime;
    }

    /**
     * Sets the start time to the new inputted start time <BR>
     *
     * Postcondition: the start time is adjusted to the new start time
     *
     * @param t the new starting time for the event
     */
    public void setStartTime(LocalDate t)
    {
        startTime = t;
    }

    /**
     * Sets the end time to the new inputted end time <BR>
     *
     * Postcondition: the end time is adjusted to the new end time
     *
     * @param t the new ending time for the event
     */
    public void setEndTime(LocalDate t)
    {
        endTime = t;
    }

    /**
     * Calculates the amount of days in the interval, including both endpoints  (ex. Jan 1 - Jan 2 is 2 days)
     * @return the integer amount of days that have passed
     */
    public long amountOfDays()
    {
        return endTime.toEpochDay() - startTime.toEpochDay() + 1;
    }

    /**
     * Provides a format for the time of the event, defaulting to yyyy-MM-dd <BR>
     * For printing a specific format of the date, grab the start or end time and use the format method in LocalDate
     * @return a string containing the start and end times, separated by a hyphen
     */
    @Override
    public String toString()
    {
        return startTime.toString() + " - " + endTime.toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof TimeInterval)
        {
            TimeInterval that = (TimeInterval) obj;
            return startTime.equals(that.startTime) && endTime.equals(that.endTime);
        }
        return false;
    }
}
