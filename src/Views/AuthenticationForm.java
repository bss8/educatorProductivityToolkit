package Views;

import javax.swing.*;

/**
 * Authentication created by Borislav S. on 7/8/2015 @ 9:44 PM.
 */
public class AuthenticationForm extends JFrame {
   private JPanel authenticationPanel;

   public AuthenticationForm() {
      super("Login");
      setContentPane(authenticationPanel);
      pack();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setExtendedState(JFrame.MAXIMIZED_BOTH);

      setVisible(true);
   }


}
