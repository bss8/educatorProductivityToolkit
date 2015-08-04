package com.arcologydesigns.ept.schoolItems;

import com.arcologydesigns.DataStructures.BST;
import com.arcologydesigns.DataStructures.Queue;
import com.arcologydesigns.ept.users.Instructor;
import com.arcologydesigns.ept.users.Student;

import java.util.ArrayList;

/**
 * Created by Terrence on 8/3/2015.
 */
public class DataContainer {
   public static class DataContainerInst {
      private BST<Student> studentsData;
      private ArrayList<Class> classesData;
      private ArrayList<Instructor> instructorsData;
      private Queue<Assignment> assignmentData;

      public void setStudentsData(BST<Student> studentsData) {
         this.studentsData = studentsData;
      }

      public void setClassesData(ArrayList<Class> classesData) {
         this.classesData = classesData;
      }

      public void setInstructorsData(ArrayList<Instructor> instructorsData) {
         this.instructorsData = instructorsData;
      }

      public void setAssignmentData(Queue<Assignment> assignmentData) {
         this.assignmentData = assignmentData;
      }

      public BST<Student> getStudentsData() {
         return studentsData;
      }

      public ArrayList<Class> getClassesData() {
         return classesData;
      }

      public ArrayList<Instructor> getInstructorsData() {
         return instructorsData;
      }

      public Queue<Assignment> getAssignmentData() {
         return assignmentData;
      }
   }
}
