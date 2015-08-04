package com.arcologydesigns.ept.schoolItems;

import com.arcologydesigns.DataStructures.Queue;

/**
 * Created by Boris on 8/3/2015.
 */
public class Classes {
   private Queue<Assignment> classAssignments;
   private String classId;
   private String instructorId;
   private String studentId;
   private String className;

   public String getClassId() {
      return classId;
   }

   public String getInstructorId() {
      return instructorId;
   }

   public String getStudentId() {
      return studentId;
   }

   public String getClassName() {
      return className;
   }

   public void setClassId(String classId) {
      this.classId = classId;
   }

   public void setInstructorId(String instructorId) {
      this.instructorId = instructorId;
   }

   public void setStudentId(String studentId) {
      this.studentId = studentId;
   }

   public void setClassName(String className) {
      this.className = className;
   }
}
