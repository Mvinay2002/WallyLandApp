/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * In the Ticketing booth class, users will be able to see what events are 
 * available for a party of their size. With that knowledge, the can purchase tickets
 * for their group. They can also cancel an order 
 * @author Maddie
 */
public class TicketingBooth {
    
    //fields
    final ArrayList<Events> eventList= new ArrayList<>();//list that houses the names of all events
    final Map<String, Integer> orders = new HashMap<>();//to track pre existing orders
    private boolean isPaid = false; //makes sure that user has completed payment
    
    //constructor to initialize fields
    public TicketingBooth()
    {
        /*hardcoded events so that the user (who is a visitor), can see 
        what is available to view, but does not have to add any information themselves
        */
        eventList.add(new Events("Animal Circus",25));//int for all = # of available tickets  
        eventList.add(new Events("Water Works and Fireworks", 100));
        eventList.add(new Events("Magic Show", 10));
        eventList.add(new Events("Comedy Show", 0));
    }
    
   
    /**
     * lets user see list of all events, available or not
     * @return list of events offered by the amusement park
     */
    public ArrayList<Events> getEvents()
    {
        return eventList;
    }
    
    /**
     * This method allows the user to view the price for an order of tickets
     * @param partySize is the number of people they will be buying tickets for
     * @param eventName is the event they will be purchasing the tickets for
     * @return the total price
     */
    public String orderTickets (int partySize, String eventName)
    {
        for (Events event : eventList)
        {
            if(event.getEventName().equals(eventName))
            {
            if(event.getAvailability()>= partySize)
            {
                event.reduceAvailability(partySize);//removes tickets from availability
                orders.put(eventName, partySize);
                isPaid = false;
                double totalPrice = partySize * 17.5; //calculating price using standard ticket price
                String formattedPrice = String.format("%.2f", totalPrice);
                return "Total price for " + partySize + " tickets to " + eventName
                        + ": $" + formattedPrice;
            }else{
            return "Not enough tickets available for " + eventName; //if the user requests a higher number of tickets than available
            }
            }
        }
        return eventName;//generic... will never be reached because the dropdown menu only has existing events
    }
    
    /**
     * Here, the user will pay the fee for the order described above
     * @param price is the total fee
     * @return a payment confirmation
     */
    public String payFee (double price)
    {
        if(price <= 0)
        {
            return "Error. Total price must be greater than zero.";
        }
        isPaid = true;
        return "Thank you for your purchase, enjoy the show!";
    }
   
    
    
    /**
     * With this method, users can cancel an order that they have previously made
     * @param partySize is the number of tickets they are cancelling
     * @param eventName is the event that they are cancelling for
     * @return confirmation of the cancellation
     * use of this method also resets the amount fo tickets that are available, 
     * so other users can go in and purchase those tickets again
     */
    public String cancelOrder (int partySize, String eventName)
    {
        if(!isPaid)
        {
            return "You have no orders to cancel for " + eventName + ".";
        }
       if(orders.containsKey(eventName))
       {
           int orderedTickets = orders.get(eventName);
           if(partySize <= orderedTickets)
           {
           for (Events event : eventList)
            {
            if(event.getEventName().equals(eventName))
            {
                event.increaseAvailability(partySize);
                if(partySize== orderedTickets)
                {
                    orders.remove(eventName);
                }else{
                orders.put(eventName, orderedTickets - partySize);
                }
                return "Your order for " + partySize + " tickets to " + 
                        eventName + " has been canceled. \n A full refund"
                        + " has been provided.";
                    }
                }
           } 
           else{
           return "You are trying to cancel more tickets than you ordered.";
                }
       }
      
        return "You have no orders to cancel for " + eventName + ".";
    }
}
