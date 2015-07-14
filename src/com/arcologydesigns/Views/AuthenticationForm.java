package com.arcologydesigns.Views;

import com.arcologydesigns.Controllers.AuthenticationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Authentication created by Borislav S. on 7/8/2015 @ 9:44 PM.
 */
public class AuthenticationForm extends JFrame {
   private JPanel authenticationPanel, p2;
   private JTextField usernameTextField;
   private JPasswordField passwordTextField;
   private JButton loginButton;
   private JButton requestIDButton;
   private ImageIcon img = null;

   public AuthenticationForm() {
      createAndShowGUI();
      addButtonEventListeners();
   }

   /** Creates a form with a background image and a semi-transparent overlay for displaying login content */
   private void createAndShowGUI() {

      // Set title and default close operation
      setTitle("User Authentication");
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      // Set a background for JFrame
      ClassLoader cldr = this.getClass().getClassLoader();
      java.net.URL imageURL   = cldr.getResource("images/desert.jpg");

      assert imageURL != null;  //used during debugging

      if (imageURL != null) {
         img = new ImageIcon(imageURL);
      }
      setContentPane(new JLabel(img));

      /*
         EXAMPLE OF BAD CODE: the below code. To fetch a resource, use the absolute reference path and invoke
         getClassLoader() then getResource() to set a resource. Otherwise, the resource will not show when running
         the application from a JAR file.

            setContentPane(new JLabel(new ImageIcon(".\\resources\\desert.jpg")));
      */

      // Set some layout, say FlowLayout
      setLayout(new FlowLayout());

      // Set the background, black with 125 as alpha value
      // This is less transparent
      authenticationPanel.setBackground(new Color(0,0,0,125));

      // Set some size to the panels
      authenticationPanel.setPreferredSize(new Dimension(500,300));
      //p2.setPreferredSize(new Dimension(250,150));

      // Add the panels to the JFrame
      add(authenticationPanel);
      //add(p2);

      // Set the size of the JFrame and make it visible
      setSize(600,400);
      setVisible(true);
   } // end createAndShowGUI()

   private void addButtonEventListeners() {
      requestIDButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            EmailForm e = new EmailForm();
            e.setSize(700,400);
            setVisible(false);
         }
      });

      loginButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            AuthenticationController authenticate = new AuthenticationController();
            boolean isUserValid = authenticate.authenticateUser(getUsernameTextField(), getPasswordTextField());

            if(isUserValid) {
               char userType = authenticate.getUserType();

               EducatorMainForm educator = new EducatorMainForm(userType);
               educator.setUserIdLabel(getUsernameTextField());



               setVisible(false);
            } else {
               JOptionPane.showMessageDialog(getParent(),
                  "Invalid user ID or password!\nPlease try again or submit an access request.",
                  "Authentication Error!",
                  JOptionPane.ERROR_MESSAGE);
            }
         }
      });
   } // end addButtonListeners()

   public static void main() {
      // Run in the Event Dispatch Thread (EDT)
      SwingUtilities.invokeLater(new Runnable(){
         public void run()
         {
            new AuthenticationForm();
         }
      });
   } // end main()

   public char[] getPasswordTextField() {
      return passwordTextField.getPassword();
   }

   public String getUsernameTextField() {
      return usernameTextField.getText();
   }

} // end class AuthenticationForm
