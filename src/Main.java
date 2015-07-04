import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 * Main created by Borislav S. on 7/3/2015 @ 1:29 PM.
 */
public class Main {

   public static void main(String args[]) throws AddressException, MessagingException {

      EmailForm myEmailForm = new EmailForm();  //creates the email form window
      myEmailForm.setSize(800, 500);            //sets the size of the email form

   }  //end main
}  //end class Main
