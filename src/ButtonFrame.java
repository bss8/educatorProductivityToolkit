/**
 * ButtonFrame created by Borislav S. on 7/3/2015 @ 1:39 PM.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.mail.MessagingException;
import javax.swing.*;

class ButtonFrame extends JFrame {
   JButton bChange ; // reference to the button object

   // constructor for ButtonFrame
   ButtonFrame(String title) {
      super( title );                   // invoke the JFrame constructor
      setLayout(new FlowLayout());      // set the layout manager

      bChange = new JButton("Send Email"); // construct a JButton
      bChange.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent actionEvent) {

            //using try catch block because we need to catch MessagingException
            //thrown by the generateAndSendEmail method
            try {
               Mail.generateAndSendEmail();
               System.out.println("\n\n ===> Your Java Program just sent an email successfully. Check your email...");
            } catch (MessagingException e) {
               System.out.print("messaging exception");
            }
         }
      });

      add(bChange);   // add the button to the JFrame
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } //end constructor
} //end class ButtonFrame


