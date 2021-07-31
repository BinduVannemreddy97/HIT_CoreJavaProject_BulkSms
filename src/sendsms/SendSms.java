package sendsms;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SendSms {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) throws Exception{
        
    	Set<String> phoneNumbers = new HashSet<String>();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of contacts");
        int count =sc.nextInt();
        
        for(int i=1; i<=count; i++) {
        	
        	System.out.println("Enter Phone number "+i);
        	String phoneNumber=sc.next();
        	phoneNumbers.add(phoneNumber);
        }
        
        System.out.println(phoneNumbers);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
             
             for(String number:phoneNumbers) {
            	 Message message = Message.creator(
                         new com.twilio.type.PhoneNumber("+91"+number),
                         new com.twilio.type.PhoneNumber("+13474275698"),
                         "Greeting from HIT for succesfull completion of SMS project.........")
                     
                     .create();
            	 System.out.println(message.getSid());
            	 System.out.println("Message sent succesfully to "+number);
            	 }
        	 }
}