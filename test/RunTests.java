import com.arcologydesigns.Controllers.AuthenticationControllerTest;
import com.arcologydesigns.DataStructures.BSTTest;
import com.arcologydesigns.DataStructures.QueueTest;
import com.arcologydesigns.emailService.MailTest;
import com.arcologydesigns.ept.users.StudentTest;
import com.arcologydesigns.io_operations.FileIOTest;

/**
 * Created by Boris on 8/6/2015.
 * It is strongly recommended that the tests are ran from each class independently using IntelliJ; results may not display
 * appropriately or as desired if using this class.
 */
public class RunTests {

   public static void main(String[] args) throws Exception {
      BSTTest bstTest = new BSTTest();
      QueueTest queueTest = new QueueTest();
      AuthenticationControllerTest authenticationControllerTest = new AuthenticationControllerTest();
      MailTest mailTest = new MailTest();
      StudentTest studentTest = new StudentTest();
      FileIOTest fileIOTest = new FileIOTest();

      try {
         bstTest.run();
         queueTest.run();
         authenticationControllerTest.run();
         mailTest.run();
         studentTest.run();
         fileIOTest.run();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}
