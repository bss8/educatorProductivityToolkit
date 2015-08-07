package com.arcologydesigns.GoogleIntegration;

import com.arcologydesigns.DataStructures.BST;
import com.arcologydesigns.DataStructures.Queue;
import com.arcologydesigns.ept.schoolItems.Assignment;
import com.arcologydesigns.ept.schoolItems.Classes;
import com.arcologydesigns.ept.schoolItems.DataContainer;
import com.arcologydesigns.ept.users.Instructor;
import com.arcologydesigns.ept.users.Student;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static java.lang.System.*;

/**
 * SpreadsheetIntegration created by Borislav S. on 7/10/2015 @ 7:06 PM.
 * NO METHODS TO TEST - ALL VOID
 * This is perhaps the most important class of this application. It is responsible for reading in authentication data using
 * the default constructor. Using the overloaded constructor, it accepts a URL to an online CSV version of a flat file
 * containing data, which must be in the required format:
 * Here is an outline of our data and how it relates logically. We are not using an RDBMS and cannot run queries with SQL.

 5 sheets (tables): APP_USERS, INSTRUCTORS, STUDENTS, CLASSES, and ASSIGNMENTS.
 The column in bold is the primary key. Multiple bold items indicate a composite key (made up of multiple columns, some of which are foreign keys used to establish a relationship).

 APP_USERS fields: USER_ID, PWD, STATUS.
 INSTRUCTORS fields: INSTRUCTOR_ID, INSTRUCTOR_NAME, PHONE, ADDRESS, EMAIL
 STUDENTS fields: STUDENT_ID, STUDENT_NAME, PHONE, ADDRESS, EMAIL
 CLASSES: CLASS_ID, INSTRUCTOR_ID, STUDENT_ID, CLASS_NAME
 ASSIGNMENTS: ASSIGNMENT_ID, CLASS_ID, STUDENT_ID, SCORE
 CLASSES table relates students and instructors to a given class. ASSIGNMENTS table relates a student in a given class to a specific assignment. This data is in 2NF/3NF (normal form), as each spreadsheet can be considered a table and therefore a set of data. Each row in the table is an independent entry - that is, each row in ASSIGNMENTS table "Is-an" assignment, each row in CLASSES table "Is-a" class and so on.

 Definitions:
 Primary Key: a value unique for each record;
 Composite Key: a compound key that consists of two or more attributes to uniquely identify a record;
 Foreign Key: a column that references the primary key of another table to establish a relationship;
 */
public class SpreadsheetIntegration {

   private ArrayList<UserNode> userData = new ArrayList<UserNode>();

   public class UserNode {
      private String username;
      private String password;
      public String userType;

      public String getPassword() {
         return password;
      }

      public void setPassword(String password) {
         this.password = password;
      }

      public String getUsername() {
         return username;
      }

      public void setUsername(String username) {
         this.username = username;
      }
   } // end class UserNode

   /** A static class to fetch user data and maintain a single copy */
   public static class UserData {
      private static ArrayList<UserNode> users;
      public static ArrayList<UserNode> getUserData() { return users; }
      public static void setUserData(ArrayList<UserNode> userNode) { users = userNode; }
   } // end class UserData

   /** This default constructor is used exclusively for user authentication; UserNode cannot be created outside of
    * this class and the URL must be the same - no option is provided for alternative authentication. For security reasons,
    * there is only one administrator - Borislav Sabotinov (bss64@txstate.edu) */
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
            uNode.setUsername(split[0]);
            uNode.setPassword(split[1]);
            uNode.userType = split[2];
         }

         if(uNode.getUsername() != null && uNode.getPassword() != null) {
            userData.add(numRows, uNode);
         }
         numRows++;
      }

      UserData.setUserData(userData);
      in.close();
   }  // end fetchUserLoginData()

   private void fetchClassData(BufferedReader in) throws IOException {
      String inputLine = "";
      int numRows = 0;
      //TODO: replace the below test with implementation; class data to use ArrayList
      //System.out.print(in.readLine() + "\n"); // skip headers
      in.readLine();

      ArrayList<Classes> classesList = new ArrayList<>();

      while(in.ready()) {
         inputLine = in.readLine();
         final String split[] = inputLine.split(",");
         Classes myClasses = new Classes();

         if (split.length > 1) {
            myClasses.setClassId(split[0]);
            myClasses.setInstructorId(split[1]);
            myClasses.setStudentId(split[2]);
            myClasses.setClassName(split[3]);
         }

         classesList.add(myClasses);
      }
      DataContainer.DataContainerInst.setClassesData(classesList);
   }

   private void fetchInstructorData(BufferedReader in) throws IOException {
      String inputLine = "";
      int numRows = 0;
      //TODO: replace the below test with implementation; Instructor data to use ArrayList
      //System.out.print(in.readLine() + "\n"); // skip headers
      in.readLine();
      ArrayList<Instructor> instructorsList = new ArrayList<>();

      while(in.ready()) {
         inputLine = in.readLine();
         final String split[] = inputLine.split(",");
         Instructor instructor = new Instructor();

         if (split.length > 1) {
            instructor.setUserID(split[0]);
            instructor.setUserName(split[1]);
            instructor.setPhone(split[2]);
            instructor.setAddress(split[3]);
            instructor.setEmail(split[4]);
         }

         instructorsList.add(instructor);
      }
      DataContainer.DataContainerInst.setInstructorsData(instructorsList);
   }

   private void fetchStudentData(BufferedReader in) throws IOException {
      String inputLine = "";
      int numRows = 0;
      //TODO: replace the below test with implementation; Student data to use BST
      //System.out.print(in.readLine() + "\n"); // skip headers
      in.readLine();
      BST<Student> studentBST = new BST<>();
      ArrayList<Student> studentArrayList = new ArrayList<>();

      while (in.ready()) {
         inputLine = in.readLine();
         final String split[] = inputLine.split(",");
         Student student = new Student();

         if (split.length > 1) {
            student.setUserID(split[0]);
            student.setUserName(split[1]);
            student.setPhone(split[2]);
            student.setAddress(split[3]);
            student.setEmail(split[4]);
         }

         studentBST.insertItem(student);
         studentArrayList.add(student);
      }

      //studentBST.balanceRecursive();
      DataContainer.DataContainerInst.setStudentsData(studentBST);
      DataContainer.DataContainerInst.setStudentList(studentArrayList);
   }

   private void fetchAssignmentData(BufferedReader in) throws IOException {
      String inputLine = "";
      int numRows = 0;
      //TODO: replace the below test with implementation; class data to use Queue
      //System.out.print(in.readLine() + "\n"); // skip headers
      in.readLine();
      Queue<Assignment> assignmentQueue = new Queue<>();
      ArrayList<Assignment> assignmentArrayList = new ArrayList<>();

       while (in.ready()) {
         inputLine = in.readLine();
         final String split[] = inputLine.split(",");
         Assignment assignment = new Assignment();

         if (split.length > 1) {
            assignment.setAssignmentId(split[0]);
            assignment.setClassId(split[1]);
            assignment.setStudentId(split[2]);
            int score = Integer.parseInt(split[3]);
            assignment.setAssignmentScore(score);
         }

         assignmentQueue.enQueue(assignment);
         assignmentArrayList.add(assignment);
      }
      DataContainer.DataContainerInst.setAssignmentData(assignmentQueue);
      DataContainer.DataContainerInst.setAssignmentArrayList(assignmentArrayList);
   }
}  //end class SpreadsheetIntegration