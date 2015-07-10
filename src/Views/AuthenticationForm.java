package Views;

import emailService.Mail;

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
   private JTextField passwordTextField;
   private JButton submitButton;
   private JButton cancelButton;
   private JButton requestAccessButton;

   public AuthenticationForm() {
      createAndShowGUI();
      addButtonEventListeners();
   }

   private void createAndShowGUI()
   {
      // Set title and default close operation
      setTitle("Transparent Panel");
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      // Set a background for JFrame
      setContentPane(new JLabel(new ImageIcon(".\\resources\\images\\desert.jpg")));

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
   }

   private void addButtonEventListeners() {
      requestAccessButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            EmailForm e = new EmailForm();
            e.setSize(700,400);
            setVisible(false);
         }
      });
   }

   public static void main()
   {
      // Run in the EDT
      SwingUtilities.invokeLater(new Runnable(){
         public void run()
         {
            new AuthenticationForm();
         }
      });
   }


}
