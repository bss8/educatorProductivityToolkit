package com.arcologydesigns.ept.users;

/**
 * Student created by Borislav S. on 7/12/2015 @ 5:07 PM.
 * While limited logic is present in this class, it is being used logically to differentiate between user types and for
 * creating instances of students as data is being red in from external sources.
 * This class inherits from the abstract user class and those particular methods are used.
 */
public class Student extends User implements Comparable<Student> {

   private double grade;


   public Student(String name, int grade) {
      setUserName(name);
      this.grade = grade;
   }

   public Student() {

   }

   @Override
   public int compareTo(Student student) {
      return this.getUserID().compareTo(student.getUserID());
   }

   @Override
   public boolean equals(Object obj) {
      if (!(obj instanceof Student))
         return false;
      if (((Student) obj).getUserID().equals(this.getUserID())) return true;
      else return false;

   }

   public String toString() {
      return (getUserID() + "," + getUserName() + "," + getPhone() + "," + getAddress() + "," + getEmail() + ";");
   }

   public String fullStringRep() {
      return (getUserName()  + ": " + Double.toString(this.grade));
   }
}
