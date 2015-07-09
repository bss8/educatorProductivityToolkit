package Views;

import emailService.Mail;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Test created by Borislav S. on 7/3/2015 @ 5:53 PM.
 */
public class EmailForm extends JFrame {
   private JPanel emailPanel;
   private JLabel emailLabel;
   private JButton sendEmailButton;
   private JTextArea messageTextArea;
   private JLabel emailBodyLabel;
   private JTextField ccTextField;
   private JTextField toTextField;
   private JTextField subjectTextField;

   static final int MY_MIN = 0;
   static final int MY_MAX = 100;
   private EmailForm emailForm;

   public EmailForm() {
      super("Hello World!");
      setContentPane(emailPanel);
      pack();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      sendEmailButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            //JOptionPane.showConfirmDialog(EmailForm.this, "Hello World!");

            try {
               Mail.generateAndSendEmail(getToTextField(),getCcTextField(),getSubjectTextField(),getMessageTextArea(),emailForm);

               Mail.generateAndSendEmail(getToTextField(), getCcTextField(), getSubjectTextField(),
                       getMessageTextArea(), emailForm);
               System.out.println("\n\n ===> Your Java Program just sent an email successfully. Check your email...");
            } catch (MessagingException e) {
               System.out.print("messaging exception");
            }
         }
      });

      setVisible(true);
   }

   public String getToTextField()      { return toTextField.getText(); }
   public String getMessageTextArea()  { return messageTextArea.getText(); }
   public String getCcTextField()      { return ccTextField.getText(); }
   public String getSubjectTextField() { return subjectTextField.getText(); }
   public EmailForm setEmailForm(EmailForm _emailForm) { return emailForm = _emailForm; }

}
