package model;
/**
     * This class allows all events to be captured in a list. This list is then
     * accessed in the TicketingBooth class to alow users to buy tickets to 
     * an event that can accommodate their party size
     */
public class Events
{
    
    //fields
    
    public String eventName;//name of the event
    public int availability;//how many people it can accomodate

    /**
     * constructor
     * @param eventName name of event
     * @param availability amount of tickets available for the event
     */
    public Events (String eventName, int availability)
    {
        this.eventName=eventName;
        this.availability = availability;
    }

    /**
     * event name getter
     * @return name event name
     */
    public String getEventName() {
        return eventName;
    }
    /**
     * availability getter
     * @return int availability
     */
    public int getAvailability()
    {
    return availability;
    }
    
    /**
     * Reduce availability when tickets are purchased
     * @param amount is the number of tickets purchased
     */
    public void reduceAvailability(int amount)
    {
        if(amount<= availability)
        {
        availability = availability - amount;
        }
    }
    
    /**
     * increase availability when ticket purchases are cancelled, 
     * replenishing the available tickets
     * @param amount is the number of tickets returned/cancelled
     */
    public void increaseAvailability(int amount)
    {
    availability = availability + amount;
    }
}