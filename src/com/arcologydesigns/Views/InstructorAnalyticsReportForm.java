package com.arcologydesigns.Views;

import com.arcologydesigns.DataStructures.*;
import com.arcologydesigns.ept.schoolItems.Assignment;
import com.arcologydesigns.ept.schoolItems.Classes;
import com.arcologydesigns.ept.schoolItems.DataContainer;
import com.arcologydesigns.ept.users.Instructor;
import com.arcologydesigns.ept.users.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * InstructorAnalyticsReportForm created by Borislav S. on 7/14/2015 @ 7:25 PM.
 */
public class InstructorAnalyticsReportForm extends JDialog {
   private JPanel instructorAnalyticsPanel;
   private JButton emailAllGradesButton;
   DefaultTableModel model;
   JTable table;
   String col[] = {"Name", "ID", "Avg Grade", "Class Grade", "Assig_1", "Assig_2", "Assig_3",
           "Assig_4", "Assig_5"};
   String allEmails;

   public static void main(String args[]) {
      new InstructorAnalyticsReportForm().start();
   }

   public void start() {
      // Set title and default close operation
      setTitle("Class Analysis Report");
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

      // Add the panels to the JFrame
      //add(instructorAnalyticsPanel, BorderLayout.NORTH);
      model = new DefaultTableModel(col, 50);
      table = new JTable(model) {
         @Override
         public boolean isCellEditable(int arg0, int arg1) {
            return false;
         }
      };
      table.setSize(1000, 700);
      JScrollPane pane = new JScrollPane(table);
      pane.setPreferredSize(new Dimension(1000, 700));

      BST<Student> studentBST = DataContainer.DataContainerInst.getStudentsData();
      ArrayList<Student> studentArrayList = DataContainer.DataContainerInst.getStudentList();
      Queue<Assignment> assignmentQueue = DataContainer.DataContainerInst.getAssignmentData();
      ArrayList<Assignment> assignmentArrayList = DataContainer.DataContainerInst.getAssignmentArrayList();
      final ArrayList<Instructor> instructorArrayList = DataContainer.DataContainerInst.getInstructorsData();
      ArrayList<Classes> classesArrayList = DataContainer.DataContainerInst.getClassesData();

      String studentList = studentBST.inOrderTraversal();
      final String[] split1 = studentList.split(";");
      int index = 0;
      int index2 = 0;
      int index3 = 0;
      int index4 = 0;
      int rowInd = 0;
      int gradeTotal = 0;
      int numAssignments = 0;
      double avgGrade = 0.0;

      for (int i = 0; i < studentArrayList.size(); i++) {
         for (int j = 0; j < assignmentArrayList.size(); j++) {
            if (studentArrayList.get(i).getUserID().equals(assignmentArrayList.get(j).getStudentId())) {
               table.setValueAt(studentArrayList.get(i).getUserName(), index, 0);
               table.setValueAt(studentArrayList.get(i).getUserID(), index, 1);
               if (studentArrayList.get(i).getEmail() != null && !studentArrayList.get(i).getEmail().equals(null)) {
                  allEmails += studentArrayList.get(i).getEmail() + ";";
               }
               index++;
               break;
            }
         }
      }

      for (Student aStudentArrayList : studentArrayList) {
         for (Assignment anAssignmentArrayList : assignmentArrayList) {
            while (anAssignmentArrayList.getStudentId().equals(aStudentArrayList.getUserID())) {
               int aId = Integer.parseInt(anAssignmentArrayList.getAssignmentId());
               if (aId > 1) {
                  table.setValueAt(anAssignmentArrayList.getAssignmentScore(), index2, 3 + aId);
                  index2++;
               } else {
                  table.setValueAt(anAssignmentArrayList.getAssignmentScore(), index2, 3 + aId);
                  index3++;
               }
               break;
            }
         }
      }

      for (Student aStudentArrayList : studentArrayList) {
         for (Assignment anAssignmentArrayList : assignmentArrayList) {
            while (anAssignmentArrayList.getStudentId().equals(aStudentArrayList.getUserID())) {
               gradeTotal += anAssignmentArrayList.getAssignmentScore();
               index4++;
               break;
            }
         }
         avgGrade = gradeTotal / index4;
         table.setValueAt(avgGrade, rowInd, 2);
         rowInd++;
         index4 = 0;
         gradeTotal = 0;
      }

      //table.setValueAt("csanuragjain", 0, 0);

      emailAllGradesButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            EmailForm eForm = new EmailForm("Email all student grades!");
            eForm.setCcTextField(instructorArrayList.get(0).getEmail());
            eForm.setToText(allEmails);
            eForm.setSubjectText("Grades distribution list");
            String s = "";
            for (int i = 0; i < 10; i++) {
               s += table.getValueAt(i, 0).toString() + ": " + table.getValueAt(i, 2).toString() + "\n";
            }
            eForm.setMessageText(s);
         }
      });


      add(pane, BorderLayout.SOUTH);
      add(emailAllGradesButton);
      // Set the size of the JFrame and make it visible
      setSize(1200, 1000);
      setVisible(true);
      setLayout(new FlowLayout());
   }

   public InstructorAnalyticsReportForm() {

   }

   {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
      $$$setupUI$$$();
   }

   /**
    * Method generated by IntelliJ IDEA GUI Designer
    * >>> IMPORTANT!! <<<
    * DO NOT edit this method OR call it in your code!
    *
    * @noinspection ALL
    */
   private void $$$setupUI$$$() {
      instructorAnalyticsPanel = new JPanel();
      instructorAnalyticsPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
      instructorAnalyticsPanel.setBackground(new Color(-14596236));
      emailAllGradesButton = new JButton();
      emailAllGradesButton.setText("Email All Grades");
      instructorAnalyticsPanel.add(emailAllGradesButton, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
      final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
      instructorAnalyticsPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
      final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
      instructorAnalyticsPanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
   }

   /**
    * @noinspection ALL
    */
   public JComponent $$$getRootComponent$$$() {
      return instructorAnalyticsPanel;
   }
}
