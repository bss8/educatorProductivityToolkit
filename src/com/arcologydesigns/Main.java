package com.arcologydesigns;

import com.arcologydesigns.GoogleIntegration.SpreadsheetIntegration;
import com.arcologydesigns.Views.AuthenticationForm;
import com.arcologydesigns.Views.EducatorMainForm;
import com.arcologydesigns.Views.StudentInfoForm;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * com.arcologydesigns.Main created by Borislav S. on 7/3/2015 @ 1:29 PM.
 *
 * DO NOT CHECK IN MODIFICATIONS FOR THIS FILE!
 * MODIFY ONLY FOR LOCAL TESTING
 *
 */
public class Main {

   public static void main(String args[]) throws MessagingException, IOException {

      AuthenticationForm.main();  // initialize by prompting user for credentials

      // Get user data on initial load
      SpreadsheetIntegration mySheet = new SpreadsheetIntegration();

      //EducatorMainForm e = new EducatorMainForm('S');

      /*
      *  DO NOT CHECK IN MODIFICATIONS FOR THIS FILE!
      * MODIFY ONLY FOR LOCAL TESTING
      * */

   }  //end main
}  //end class com.arcologydesigns.Main
