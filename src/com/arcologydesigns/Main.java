package com.arcologydesigns;

import com.arcologydesigns.DataStructures.BST;
import com.arcologydesigns.GoogleIntegration.SpreadsheetIntegration;
import com.arcologydesigns.Views.AuthenticationForm;
import com.arcologydesigns.Views.StudentInfoForm;
import com.arcologydesigns.ept.users.Student;
import com.arcologydesigns.io_operations.FileIO;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

/**
 * com.arcologydesigns.Main created by Borislav S. on 7/3/2015 @ 1:29 PM.
 */
public class Main {

   public static void main(String args[]) throws MessagingException, IOException {

      AuthenticationForm.main();  // initialize by prompting user for credentials

      StudentInfoForm studentInfoForm = new StudentInfoForm();
      String student;

      FileIO rf = new FileIO(".\\resources\\flatFiles\\studentData.txt");
      try {
         student = rf.ReadOneLine();
         final String split[] = student.split(",");
         if (split.length > 1) {
            studentInfoForm.setStudentNameLabel(split[0]);
         }

      } catch (IOException e) {
         System.out.printf("IO Exception on reading file: " + e + "\n");
      }

      // Get user data on initial load
      SpreadsheetIntegration mySheet = new SpreadsheetIntegration();

      BST<Double> intTree = new BST<>();
      intTree.insertItem(10.0);

      intTree.insertItem(20.0);

      intTree.insertItem(30.0);


      for(int i = 0; i < 10; i++) {
         intTree.insertItem((double) i);

      }
      String test = intTree.inOrderTraversal();
      System.out.print("\n");
      System.out.printf("%s", test);

      intTree.balanceRecursive();

      String test1 = intTree.inOrderTraversal();
      System.out.print("\n");
      System.out.printf("%s", test1);



   }  //end main
}  //end class com.arcologydesigns.Main
