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
      this.grade = 0.0;
   }

   @Override
   public int compareTo(Student student) {
      return (this.grade < student.grade ? -1 : this.grade > student.grade ? 1 : 0);
   }

   public String toString() {
      return (Double.toString(this.grade));
   }

   public String fullStringRep() {
      return (getUserName()  + ": " + Double.toString(this.grade));
   }
}
