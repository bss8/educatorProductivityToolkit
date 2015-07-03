import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 * Main created by Borislav S. on 7/3/2015 @ 1:29 PM.
 */
public class Main {

   public static void main(String args[]) throws AddressException, MessagingException {
//      Mail.generateAndSendEmail();
//      System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");

      //FOR TESTING PURPOSES OF JAVA SWING
      //new HelloWorldFrame();

      ButtonFrame frame = new ButtonFrame("Send email button test");

      frame.setSize(400, 500);
      frame.setVisible( true );

      EmailForm myEmailForm = new EmailForm();
      myEmailForm.setSize(400, 500);
   }

}
