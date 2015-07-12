package com.arcologydesigns.GoogleIntegration;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * SpreadsheetIntegration created by Borislav S. on 7/10/2015 @ 7:06 PM.
 */
public class SpreadsheetIntegration {

   private ArrayList<UserNode> userData = new ArrayList<UserNode>();

   public class UserNode {
      public String username;
      public String password;
   }

   public static class UserData {
      private static ArrayList<UserNode> users;

      public static ArrayList<UserNode> getUserData() {
         return users;
      }

      public static void setUserData(ArrayList<UserNode> userNode) {
         users = userNode;
      }
   }

   public SpreadsheetIntegration() throws IOException {
      URL googleSpreadsheet = new URL("https://docs.google.com/spreadsheets/d/1uJVvxDvBN-pvjwuSWcTjdmX9DePW0a3y1JByMMIzpIM/pub?output=csv");
      BufferedReader in = new BufferedReader(new InputStreamReader(googleSpreadsheet.openStream()));

      fetchUserData(in);
   }

   private void fetchUserData(BufferedReader in) throws IOException {
      String inputLine;
      int numRows = 0;
      in.readLine(); // skip headers

      while ((inputLine = in.readLine()) != null) {

         System.out.printf("%s\n%n", inputLine);
         UserNode uNode = new UserNode();

         final String split[] = inputLine.split(",");
         if (split.length > 1) {
            uNode.username = split[0];
            uNode.password = split[1];
         }

         if(uNode.username != null && uNode.password != null) {
            userData.add(numRows, uNode);
         }
         numRows++;
      }

      UserData.setUserData(userData);

      in.close();
   }  // end fetchUserData()
}  //end class SpreadsheetIntegration
