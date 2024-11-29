package model;
/**
* This class represents Emergency Services in WallyLand.
* It allows users to request a missing child report and provides the appropriate emergency contact information.
*/
public class EmergencyServices {
   private String emergencyPhoneNumber;  // Phone number for emergency contact
 
   /**
    * Constructor for the EmergencyServices class.
    * Initializes the emergency phone number.
    *
    * @param emergencyPhoneNumber The phone number to contact for missing child reports
    */
   public EmergencyServices(String emergencyPhoneNumber) {
       this.emergencyPhoneNumber = emergencyPhoneNumber;
   }
 
   /**
    * This method allows a user to request a missing child report.
    * It provides the user with the contact phone number to report the missing child.
    *
    * @param childName The name of the missing child
    * @return The emergency contact phone number for reporting missing children
    */
   public String requestMissingChildReport(String childName) {
       System.out.println("A missing child report has been requested for: " + childName);
       System.out.println("Please contact the following number for further assistance: " + emergencyPhoneNumber);
       return emergencyPhoneNumber;
   }
 
   /**
    * This method returns the emergency phone number.
    *
    * @return The emergency contact number
    */
   public String getEmergencyPhoneNumber() {
       return emergencyPhoneNumber;
   }
 
   /**
    * This method sets a new emergency phone number.
    *
    * @param emergencyPhoneNumber The new emergency contact number
    */
   public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
       this.emergencyPhoneNumber = emergencyPhoneNumber;
   }}
