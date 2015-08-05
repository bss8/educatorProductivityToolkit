package com.arcologydesigns.GoogleIntegration;

import com.arcologydesigns.DataStructures.BST;
import com.arcologydesigns.DataStructures.Queue;
import com.arcologydesigns.ept.schoolItems.Assignment;
import com.arcologydesigns.ept.schoolItems.Classes;
import com.arcologydesigns.ept.schoolItems.DataContainer;
import com.arcologydesigns.ept.users.Instructor;
import com.arcologydesigns.ept.users.Student;

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
      private String username;
      private String password;
      public String userType;

      public String getPassword() { return password; }
      public void setPassword(String password) { this.password = password; }
      public String getUsername() { return username; }
      public void setUsername(String username) { this.username = username; }
   } // end class UserNode

   /** A static class to fetch user data and maintain a single copy */
   public static class UserData {
      private static ArrayList<UserNode> users;
      public static ArrayList<UserNode> getUserData() { return users; }
      public static void setUserData(ArrayList<UserNode> userNode) { users = userNode; }
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
      }

      //studentBST.balanceRecursive();
      DataContainer.DataContainerInst.setStudentsData(studentBST);
   }

   private void fetchAssignmentData(BufferedReader in) throws IOException {
      String inputLine = "";
      int numRows = 0;
      //TODO: replace the below test with implementation; class data to use Queue
      //System.out.print(in.readLine() + "\n"); // skip headers
      in.readLine();
      Queue<Assignment> assignmentQueue = new Queue<>();

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
      }
      DataContainer.DataContainerInst.setAssignmentData(assignmentQueue);
   }
}  //end class SpreadsheetIntegration