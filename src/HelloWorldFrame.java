/**
 * HelloWorldFrame created by Borislav S. on 7/3/2015 @ 1:34 PM.
 */
import javax.swing.JFrame;
import javax.swing.JLabel;

//FOR TESTING PURPOSES ONLY
public class HelloWorldFrame extends JFrame {


   HelloWorldFrame() {
      JLabel jlbHelloWorld = new JLabel("Hello World");
      add(jlbHelloWorld);
      this.setSize(100, 100);
      // pack();
      setVisible(true);
   }
}