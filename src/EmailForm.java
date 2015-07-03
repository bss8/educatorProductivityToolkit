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

   public EmailForm() {
      super("Hello World!");
      setContentPane(emailPanel);
      pack();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      sendEmailButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            JOptionPane.showConfirmDialog(EmailForm.this, "Hello World!");
         }
      });

      setVisible(true);
   }
}
