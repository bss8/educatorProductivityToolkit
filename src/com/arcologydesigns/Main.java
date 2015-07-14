package com.arcologydesigns;

import com.arcologydesigns.GoogleIntegration.SpreadsheetIntegration;
import com.arcologydesigns.Views.AuthenticationForm;
import com.arcologydesigns.io_operations.ReadFromFile;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

/**
 * com.arcologydesigns.Main created by Borislav S. on 7/3/2015 @ 1:29 PM.
 */
public class Main {

   public static void main(String args[]) throws AddressException, MessagingException, IOException {

      AuthenticationForm.main();  // initialize by prompting user for credentials

      ReadFromFile rf = new ReadFromFile(".\\resources\\flatFiles\\studentData.txt");
      try {
         rf.ReadOneLine();
      } catch (IOException e) {
         System.out.printf("IO Exception on reading file: " + e + "\n");
      }

      // Get user data on initial load
      SpreadsheetIntegration mySheet = new SpreadsheetIntegration();

   }  //end main
}  //end class com.arcologydesigns.Main
