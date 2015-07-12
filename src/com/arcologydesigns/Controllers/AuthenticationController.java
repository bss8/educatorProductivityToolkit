package com.arcologydesigns.Controllers;

import com.arcologydesigns.GoogleIntegration.SpreadsheetIntegration;
import java.util.ArrayList;

/**
 * AuthenticationController created by Borislav S. on 7/10/2015 @ 5:59 PM.
 * This class serves to validate a user based on existing username and password
 * TODO: create encryption algorithm for storing and retrieving user data
 */
public class AuthenticationController {
   private boolean isUserValid;
   private ArrayList<SpreadsheetIntegration.UserNode> userData;

   public AuthenticationController() {
      isUserValid = false;
   }

   public boolean authenticateUser(String username, char[] password) {
      String strPwd = "";

      // convert array password to a string
      for(char c : password) {
         strPwd += c;
      }

      userData = SpreadsheetIntegration.UserData.getUserData();

      for (SpreadsheetIntegration.UserNode currentNode : userData) {
         if ( (currentNode.username.equals(username) && (currentNode.password.equals(strPwd))) ) {
            isUserValid = true;
         }
      }

      return isUserValid;

   }  // end authenticateUser()
}  // end class AuthenticationController
