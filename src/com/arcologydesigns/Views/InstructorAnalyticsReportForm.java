package com.arcologydesigns.Views;

import javax.swing.*;

/**
 * InstructorAnalyticsReportForm created by Borislav S. on 7/14/2015 @ 7:25 PM.
 */
public class InstructorAnalyticsReportForm extends JDialog {
   private JPanel instructorAnalyticsPanel;
   private JLabel analysisScreenTitle;

   public InstructorAnalyticsReportForm() {

      createGUI();
   }

   private void createGUI() {
      // Set title and default close operation
      setTitle("Class Analysis Report");
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

      // Add the panels to the JFrame
      add(instructorAnalyticsPanel);

      // Set the size of the JFrame and make it visible
      setSize(1200, 1000);
      setVisible(true);
   }
}
