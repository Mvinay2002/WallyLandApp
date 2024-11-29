## Group 3 - IST 412
Maddie Mondoil

Vinay Mallipudi

Benjamin Barone

Zachary Greene

## M03 A05 Details
For this assignment, we focused on the TicketingBooth class. In order to  create
a functional Ticketing Booth UI, we also created a TicketingBoothView class (for the UI),
a MainView class (for the default UI), and an App class (this houses the general information
needed to get the UI to function properly). We also started to build out the WallyLandApp class, 
which will work as our controller class. When running our project, you will start by 
seeing the default UI. Here, there are four buttons to choose from. For sake of this
use case, the user will click the "Go to Ticketing Booth" button. Once the button is 
clicked, the user will be brought to the Ticketing Booth UI. Here, there are multiple buttons and user input options
to choose from. In the drop down menu, the user is given the option to choose an event to learn more about.
Once an event is chosen and they have input how many tickets they are looking for (top right),
they can press the "See available tickets and prices" button to do exactly that. The text box 
in the center of the screen will provide them with the information athey are looking for.
From here, the user can choose to learn about other events, or they can go ahead and purchase their tickets for the 
event. If the number of tickets they are requesting is less than the available tickets, then their purchase will go through
successfully. If not, they will be told that the event no longer has enough tickets for their request. 
If a user places an order but changes their mind, they can press on the "cancel order" button to 
reverse the most recent purchase. Throughout this process, there are a handful of validation checks that are made 
to make sure that the user is putting in proper inputs and requests.