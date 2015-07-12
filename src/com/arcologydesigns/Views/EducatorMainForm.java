package com.arcologydesigns.Views;

import javax.swing.*;
import java.awt.*;

/**
 * EducatorMainForm created by Borislav S. on 7/11/2015 @ 9:57 PM.
 */
public class EducatorMainForm extends JFrame {

   private ImageIcon img = null;
   private JPanel educatorMainPanel;

   public EducatorMainForm() {
      createAndShowGUI();

   }

   private void createAndShowGUI() {

      // Set title and default close operation
      setTitle("Educator Productivity Toolkit - EPT v0.1");
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      // Set a background for JFrame
      ClassLoader cldr = this.getClass().getClassLoader();
      java.net.URL imageURL   = cldr.getResource("images/educator_logo_lowres.jpg");

      assert imageURL != null;  //used during debugging

      if (imageURL != null) {
         img = new ImageIcon(imageURL);
      }
      setContentPane(new JLabel(img));

      // Set some layout, say FlowLayout
      setLayout(new FlowLayout());

      // Set the background, black with 125 as alpha value
      // This is less transparent
      educatorMainPanel.setBackground(new Color(0,0,0,125));

      // Set some size to the panels
      educatorMainPanel.setPreferredSize(new Dimension(500,300));
      //p2.setPreferredSize(new Dimension(250,150));

      // Add the panels to the JFrame
      add(educatorMainPanel);

      // Set the size of the JFrame and make it visible
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setVisible(true);
   } // end createAndShowGUI()
}
