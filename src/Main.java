import Views.AuthenticationForm;
import Views.EmailForm;
import io_operations.ReadFromFile;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.*;
import java.io.IOException;

/**
 * Main created by Borislav S. on 7/3/2015 @ 1:29 PM.
 */
public class Main {

   public static void main(String args[]) throws AddressException, MessagingException {

      /*
      TODO: refactor to be called upon successful authentication
      EmailForm myEmailForm = new EmailForm();  //creates the email form window
      myEmailForm.setSize(800, 500);            //sets the size of the email form

      myEmailForm.setEmailForm(myEmailForm);
      */

      AuthenticationForm loginScreen = new AuthenticationForm();
      loginScreen.setSize(500,400);
//      loginScreen.setExtendedState(JFrame.MAXIMIZED_BOTH);
//      loginScreen.setUndecorated(true);

      ReadFromFile rf = new ReadFromFile(".\\flatFiles\\userAuthenticationRepository.txt");
      try
      {
         rf.OpenFile();
      } catch (IOException e) {
         System.out.printf("IO Exception on reading file...");
      }

   }  //end main
}  //end class Main
