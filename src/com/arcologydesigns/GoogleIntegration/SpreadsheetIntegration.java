package com.arcologydesigns.GoogleIntegration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static java.lang.System.*;

/**
 * SpreadsheetIntegration created by Borislav S. on 7/10/2015 @ 7:06 PM.
 */
public class SpreadsheetIntegration {

   private ArrayList<UserNode> userData = new ArrayList<UserNode>();

   public class UserNode {
      public String username;
      public String password;
      public String userType;
   } // end class UserNode

   /** A static class to fetch user data and maintain a single copy */
   public static class UserData {
      private static ArrayList<UserNode> users;

      public static ArrayList<UserNode> getUserData() {
         return users;
      }

      public static void setUserData(ArrayList<UserNode> userNode) {
         users = userNode;
      }
   } // end class UserData

   /** This default constructor is used exclusively for user authentication */
   public SpreadsheetIntegration() throws IOException {
      URL googleSpreadsheet = new URL("https://docs.google.com/spreadsheets/d/1uJVvxDvBN-pvjwuSWcTjdmX9DePW0a3y1JByMMIzpIM/pub?output=csv");
      BufferedReader in = new BufferedReader(new InputStreamReader(googleSpreadsheet.openStream()));

      fetchUserLoginData(in);
   } // end SpreadSheetIntegration()

   public SpreadsheetIntegration(String myURL, char dataType)  throws MalformedURLException, IOException {
      URL googleSpreadsheet = null;

      try {
         googleSpreadsheet = new URL(myURL);
      } catch (MalformedURLException e) {
         e.printStackTrace();
      }

      try {
         assert googleSpreadsheet != null;
         BufferedReader readIn = new BufferedReader(new InputStreamReader(googleSpreadsheet != null ? googleSpreadsheet.openStream() : null));

         switch (dataType) {
            case 'A':
               fetchAssignmentData(readIn);
               break;
            case 'I':
               fetchInstructorData(readIn);
               break;
            case 'S':
               fetchStudentData(readIn);
               break;
            case 'C':
               fetchClassData(readIn);
               break;
            default:
               out.printf("Invalid data type; unable to read in...");
               break;
         }

      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private void fetchUserLoginData(BufferedReader in) throws IOException {
      String inputLine;
      int numRows = 0;
      in.readLine(); // skip headers

      while ((inputLine = in.readLine()) != null) {

         out.printf("%s\n%n", inputLine);
         UserNode uNode = new UserNode();

         final String split[] = inputLine.split(",");
         if (split.length > 1) {
            uNode.username = split[0];
            uNode.password = split[1];
            uNode.userType = split[2];
         }

         if(uNode.username != null && uNode.password != null) {
            userData.add(numRows, uNode);
         }
         numRows++;
      }

      UserData.setUserData(userData);
      in.close();
   }  // end fetchUserLoginData()

   private void fetchClassData(BufferedReader in) throws IOException {

   }

   private void fetchInstructorData(BufferedReader in) throws IOException {

   }

   private void fetchStudentData(BufferedReader in) throws IOException {

   }

   private void fetchAssignmentData(BufferedReader in) throws IOException {

   }
}  //end class SpreadsheetIntegration
