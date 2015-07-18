package com.arcologydesigns.ept.users;

/**
 * User created by Borislav S. on 7/12/2015 @ 5:06 PM.
 */
public abstract class User {
   private String userID;
   private String name;

   public void setUserID(String userID) {
      this.userID = userID;
   }

   public String getUserID() {
      return userID;
   }
   public void setUserName(String name) { this.name = name; }
   public String getUserName() {return name;}
}
