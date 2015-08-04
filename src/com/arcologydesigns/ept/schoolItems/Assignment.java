package com.arcologydesigns.ept.schoolItems;

/**
 * Created by Terrence on 8/3/2015.
 */
public class Assignment {
   private String assignmentId;
   private String classId;
   private String StudentId;
   private int assignmentScore;

   public String getAssignmentId() {
      return assignmentId;
   }

   public String getClassId() {
      return classId;
   }

   public String getStudentId() {
      return StudentId;
   }

   public int getAssignmentScore() {
      return assignmentScore;
   }

   public void setAssignmentId(String assignmentId) {
      this.assignmentId = assignmentId;
   }

   public void setClassId(String classId) {
      this.classId = classId;
   }

   public void setStudentId(String studentId) {
      StudentId = studentId;
   }

   public void setAssignmentScore(int assignmentScore) {
      this.assignmentScore = assignmentScore;
   }
}
