package com.arcologydesigns.GoogleIntegration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;


/**
 * SpreadsheetIntegration created by Borislav S. on 7/10/2015 @ 7:06 PM.
 */
public class SpreadsheetIntegration {

   public class UserNode {
      public String username;
      public String password;
   }

   private ArrayList<UserNode> userData = new ArrayList<UserNode>();

   public SpreadsheetIntegration() throws IOException {
      URL googleSpreadsheet = new URL("https://docs.google.com/spreadsheets/d/1uJVvxDvBN-pvjwuSWcTjdmX9DePW0a3y1JByMMIzpIM/pub?output=csv");
      BufferedReader in = new BufferedReader(new InputStreamReader(googleSpreadsheet.openStream()));
      fetchUserData(in);
   }

   private void fetchUserData(BufferedReader in) throws IOException {
      String inputLine;
      int numRows = 0;

      while ((inputLine = in.readLine()) != null) {
         System.out.printf("%s\n%n", inputLine);
         UserNode uNode = new UserNode();

         final String split[] = inputLine.split(",");
         uNode.username = split[0];
         uNode.password = split[1];

         userData.add(numRows, uNode);
         numRows++;
      }

      in.close();
   }

   public ArrayList<UserNode> getUserData() {
      return userData;
   }
}
