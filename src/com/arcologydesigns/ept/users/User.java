package com.arcologydesigns.ept.users;

/**
 * User created by Borislav S. on 7/12/2015 @ 5:06 PM.
 * NO METHODS TO TEST - ALL SETTERS OR GETTERS
 * This abstract class is a blueprint for what constitutes a user of this application and what objects will be used
 * on the GUI. For instance, student data is read in to create student instances, which then populate the analysis table.
 */
public abstract class User {
   private String userID;
   private String name;
   private String phone;
   private String address;
   private String email;

   public void setUserID(String userID) {
      this.userID = userID;
   }

   public String getUserID() {
      return userID;
   }

   public void setUserName(String name) {
      this.name = name;
   }

   public String getUserName() {
      return name;
   }

   public String getPhone() {
      return phone;
   }

   public String getAddress() {
      return address;
   }

   public String getEmail() {
      return email;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
