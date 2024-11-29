## Group 3 - IST 412
Maddie Mondoil

Vinay Mallipudi

Benjamin Barone

Zachary Greene



## M04_A03_GROUP3.TXT
For our second use case, we added an Emergency Services feature. This lets users
report a missing child by entering the child’s name and retrieving the emergency contact 
number for assistance. Emergency Services fits naturally into the app and is accessible through 
the "Go to Emergency Services" button on the main menu. From there, users can log a report, view
the emergency contact information, and use a "Return to Main Menu" button to easily
go back. To make this work, we created a new EmergencyServicesView to handle the interface and expanded 
the wallyLandApp controller to connect everything. This added functionality works seamlessly with the first 
use case, offering an intuitive way for users to move between ticketing and emergency features.
The structure of our project builds on what we developed in the first use case. The view package now 
includes the new EmergencyServicesView along with the existing MainView and TicketingBoothView.
In the controller package, the wallyLandApp class now manages the Emergency Services flow and links
it back to the main menu.

In addition to the new user case, we also made adjustments to our first use case, Ticketing Booth, to fix bugs
identified in our first submission. First, we made both the main screen and the TicketBooth screen non-resizable
so that all elements on the screen can be seen at all times. We adjusted the $ formatting so that
all prices can be seen to the second decimal point. We fixed the cancel order button by ensuring that
an order has been placed before cancelling it. We did this by tracking orders with a hash map, and making sure that a 
payment has been completed before attempting to cancel anything. Lastly, we added a "Back" button so that the user can
return to the main screen.