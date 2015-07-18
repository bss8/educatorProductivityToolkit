package com.arcologydesigns;

import com.arcologydesigns.DataStructures.BST;
import com.arcologydesigns.GoogleIntegration.SpreadsheetIntegration;
import com.arcologydesigns.Views.AuthenticationForm;
import com.arcologydesigns.Views.StudentInfoForm;
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

      BST<Integer> bst = new BST();
      bst.insertItem(20);
      bst.insertItem(10);
      bst.insertItem(30);
      for(int i = 0; i < 8; i++) {
         bst.insertItem(i);
      }


      System.out.print("IN ORDER TRAVERSAL: \n");
      bst.inOrderTraversal();
      System.out.print("\n");
      System.out.print("PRE ORDER TRAVERSAL: \n");
      bst.preOrderTraversal();
      System.out.print("\n");
      System.out.print("POST ORDER TRAVERSAL: \n");
      bst.postOrderTraversal();
      System.out.print("\n");

      System.out.printf("%s, \n", bst.countNodes());

      System.out.printf("%b, ", bst.breadthFirstSearch(7));

      System.out.printf("%b, ", bst.isEmpty());
      bst.makeEmpty();
      System.out.printf("%b, ", bst.isEmpty());
   }  //end main
}  //end class com.arcologydesigns.Main
