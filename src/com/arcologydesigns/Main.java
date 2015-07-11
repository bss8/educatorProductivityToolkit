package com.arcologydesigns;

import com.arcologydesigns.Views.AuthenticationForm;
import com.arcologydesigns.io_operations.ReadFromFile;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

/**
 * com.arcologydesigns.Main created by Borislav S. on 7/3/2015 @ 1:29 PM.
 */
public class Main {

   public static void main(String args[]) throws AddressException, MessagingException {

      /*
      TODO: refactor to be called upon successful authentication
      EmailForm myEmailForm = new EmailForm();  //creates the email form window
      myEmailForm.setSize(800, 500);            //sets the size of the email form

      myEmailForm.setEmailForm(myEmailForm);
      */

      AuthenticationForm.main();

//      loginScreen.setExtendedState(JFrame.MAXIMIZED_BOTH);
//      loginScreen.setUndecorated(true);

      ReadFromFile rf = new ReadFromFile(".\\resources\\flatFiles\\userAuthenticationRepository.txt");
      try
      {
         rf.OpenFile();
      } catch (IOException e) {
         System.out.printf("IO Exception on reading file...");
      }

   }  //end main
}  //end class com.arcologydesigns.Main
