package com.arcologydesigns.ept.users;

/**
 * Student created by Borislav S. on 7/12/2015 @ 5:07 PM.
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
      return (getUserName()  + ": " + Double.toString(this.grade));
   }

   public String fullStringRep() {
      return (getUserName()  + ": " + Double.toString(this.grade));
   }
}
