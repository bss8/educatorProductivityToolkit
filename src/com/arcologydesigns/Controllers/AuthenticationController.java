package com.arcologydesigns.Controllers;

import com.arcologydesigns.GoogleIntegration.SpreadsheetIntegration;
import com.arcologydesigns.ept.users.Instructor;
import com.arcologydesigns.ept.users.Student;

import java.util.ArrayList;

/**
 * AuthenticationController created by Borislav S. on 7/10/2015 @ 5:59 PM.
 * This class serves to validate a user based on existing username and password
 * TODO: create encryption algorithm for storing and retrieving user data
 */
public class AuthenticationController {
   private boolean isUserValid;
   private ArrayList<SpreadsheetIntegration.UserNode> userData;
   private char globalUserType;

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
         if ( (currentNode.getUsername().equals(username) && (currentNode.getPassword().equals(strPwd))) ) {

            isUserValid = true;

            char userType = currentNode.userType.charAt(0);

            switch (userType) {
               case 'S':
                  Student student = new Student();
                  student.setUserID(currentNode.getUsername());
                  globalUserType = userType;
                  break;
               case 'I':
                  Instructor instructor = new Instructor();
                  instructor.setUserID(currentNode.getUsername());
                  globalUserType = userType;
                  break;
               case 'G':
                  globalUserType = userType;
                  break;
               default:
                  System.out.print("Invalid user type!");
                  break;

            }
            break;
         }

      }

      return isUserValid;

   }  // end authenticateUser()


   public char getUserType() {
      return this.globalUserType;
   }

}  // end class AuthenticationController
