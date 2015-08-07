package com.arcologydesigns.ept.schoolItems;

import com.arcologydesigns.DataStructures.BST;
import com.arcologydesigns.DataStructures.Queue;
import com.arcologydesigns.ept.users.Instructor;
import com.arcologydesigns.ept.users.Student;

import java.util.ArrayList;

/**
 * Created by Boris on 8/3/2015.
 * This static class ensures there is only one copy of imported data during runtime to prevent passing copies around, thus
 * improving performance. It contains setters and getters to access data imported from external sources.
 */
public class DataContainer {
   public static class DataContainerInst {
      private static BST<Student> studentsData;
      private static ArrayList<Classes> classesData;
      private static ArrayList<Instructor> instructorsData;
      private static Queue<Assignment> assignmentData;
      private static ArrayList<Student> studentList;
      private static ArrayList<Assignment> assignmentArrayList;

      public static void setStudentsData(BST<Student> _studentsData) {
         DataContainerInst.studentsData = _studentsData;
      }

      public static void setClassesData(ArrayList<Classes> classesData) {
         DataContainerInst.classesData = classesData;
      }

      public static void setInstructorsData(ArrayList<Instructor> instructorsData) {
         DataContainerInst.instructorsData = instructorsData;
      }

      public static void setAssignmentData(Queue<Assignment> assignmentData) {
         DataContainerInst.assignmentData = assignmentData;
      }

      public static void setStudentList(ArrayList<Student> studentList) {
         DataContainerInst.studentList = studentList;
      }

      public static void setAssignmentArrayList(ArrayList<Assignment> assignmentArrayList) {
         DataContainerInst.assignmentArrayList = assignmentArrayList;
      }

      public static BST<Student> getStudentsData() {
         return studentsData;
      }

      public static ArrayList<Classes> getClassesData() {
         return classesData;
      }

      public static ArrayList<Instructor> getInstructorsData() {
         return instructorsData;
      }

      public static Queue<Assignment> getAssignmentData() {
         return assignmentData;
      }

      public static ArrayList<Student> getStudentList() {
         return studentList;
      }

      public static ArrayList<Assignment> getAssignmentArrayList() {
         return assignmentArrayList;
      }
   }
}