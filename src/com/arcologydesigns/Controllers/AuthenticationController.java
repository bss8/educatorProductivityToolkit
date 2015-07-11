package com.arcologydesigns.Controllers;

import com.arcologydesigns.GoogleIntegration.SpreadsheetIntegration;

import java.io.IOException;

/**
 * AuthenticationController created by Borislav S. on 7/10/2015 @ 5:59 PM.
 * This class serves to validate a user based on existing username and password
 * TODO: create encryption algorithm for storing and retrieving user data
 */
public class AuthenticationController {
   private boolean isUserValid;

   public AuthenticationController() {

   }

   public boolean authenticateUser(String username, String password) {

      try {
         SpreadsheetIntegration sheetData = new SpreadsheetIntegration();
         for (SpreadsheetIntegration.UserNode node : sheetData.getUserData()) {
            return (node.username.equals(username) && node.password.equals(password));
         }

      } catch (IOException e) {
         e.printStackTrace();
      }


      return false;
   }

}
