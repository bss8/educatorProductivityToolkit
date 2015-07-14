package com.arcologydesigns.Views;

import javax.swing.*;
import java.awt.*;

/**
 * EducatorMainForm created by Borislav S. on 7/11/2015 @ 9:57 PM.
 */
public class EducatorMainForm extends JFrame {

   private ImageIcon img;
   private JPanel educatorMainPanel;
   private JLabel userIdLabel;
   private JTable table1;
   private java.net.URL imageURL;
   private String imgUrl;

   public EducatorMainForm(char userType) {

      /*
         hotfix for null panel when user is not a student. This does not seem right, something is not being
         instantiated or referenced properly
      */
      educatorMainPanel.setSize(300,300);

      switch (userType) {
         case 'S':
            imgUrl = "images/educator_logo_student.jpg";
            break;
         case 'I':
            imgUrl = "images/educator_logo_instructor.jpg";
            break;
         case 'G':
            imgUrl = "images/educator_logo_guest.jpg";
            break;
         default:
            imgUrl = "images/educator_logo_guest.jpg";
            System.out.print("Invalid user type.");
            break;
      }

      createAndShowGUI();
   }

   private void createAndShowGUI() {

      // Set title and default close operation
      setTitle("Educator Productivity Toolkit - EPT v0.1");
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      // Set a background for JFrame
      ClassLoader cldr = this.getClass().getClassLoader();

      imageURL = cldr.getResource(imgUrl);
      if (imageURL != null) {
         img = new ImageIcon(imageURL);
      }

      setContentPane(new JLabel(img));

      // Set some layout, say FlowLayout
      setLayout(new FlowLayout());

      // Set the background, black with 125 as alpha value
      // This is less transparent
//      if(educatorMainPanel != null) {
         educatorMainPanel.setBackground(new Color(10, 50, 30, 165));

         // Set some size to the panels
         educatorMainPanel.setPreferredSize(new Dimension(600, 500));
         //p2.setPreferredSize(new Dimension(250,150));

         // Add the panels to the JFrame
         add(educatorMainPanel);
//      }
      // Set the size of the JFrame and make it visible
      setExtendedState(JFrame.MAXIMIZED_BOTH);  // set to full screen
      setVisible(true);

   } // end createAndShowGUI()

   public void setUserIdLabel(String _userIdLabel) {
      this.userIdLabel.setText(_userIdLabel);
   }
   public void setImageURL(String _imageURL) {
      imgUrl = _imageURL;
   }

} // end class EducatorMainForm
