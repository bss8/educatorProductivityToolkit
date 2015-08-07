package com.arcologydesigns.Controllers;

import com.arcologydesigns.GoogleIntegration.SpreadsheetIntegration;
import com.arcologydesigns.ept.users.Student;
import com.arcologydesigns.ept.users.User;
import com.sun.org.apache.regexp.internal.CharacterArrayCharacterIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * AuthenticationControllerTest created by Borislav S. on 7/10/2015 @ 6:30 PM.
 * Tests attempted by arnissim on 7/30/2015
 */
public class AuthenticationControllerTest extends AuthenticationController {

   @Before
   public void setUp() throws Exception {

   }

   @After
   public void tearDown() throws Exception {

   }

   @Test
   public void testAuthenticateUser() throws Exception {
      SpreadsheetIntegration s = new SpreadsheetIntegration();
      AuthenticationController a = new AuthenticationControllerTest();
      char[] foo= new char[]{'t', 'e', 's', 't', '1', '2', '3'};
      a.authenticateUser("bss64", foo);
      assertFalse(this.authenticateUser(String.valueOf("bss64"), foo));

      /* Comment made by ARI:
         Can't figure out how to create a "UserNode" to set the passwords.  It won't let me set the password because I'm trying to set it
         static and inside an "inner class".  Very stuck :(
         Added some setters and getters into the SpreadsheetIntegration Classes but still no good.
         Boris check here!  */


      /*
      Adam:
      Ran into the same problem, attempted to make a fake student user, and just manually set it to accept it as a
      valid student but it was too well protected. Good for security though, so not necessarily a bad thing.

      Edited, and commented out, the above assert due to it throwing a java.lang.NullPointerException upon compiling.

      Student Foo = new Student();

      Foo.setUserName("Ted");
      Foo.setUserID("007");
      Foo.setPhone("555-867-5309");
      Foo.setAddress("1600 Pennsylvania Avenue ");
      Foo.setEmail("Anonymous@Lasersharks.com");
      AuthenticationController bar = new AuthenticationControllerTest();
      char[] password = new char[] {'p','a','s','s','w','o','r','d'};
      bar.authenticateUser(Foo.getUserName(),password);
      */
   }

   @Test
   public void testAuthenticateUser1() throws Exception {
      SpreadsheetIntegration s = new SpreadsheetIntegration();
      AuthenticationController a = new AuthenticationControllerTest();
      char[] foo= new char[]{'t', 'e', 's', 't', '0', '0', '1'};
      a.authenticateUser("bss64", foo);
      assertTrue(this.authenticateUser(String.valueOf("bss64"), foo));
   }

   @Test
   public void testAuthenticateUser2() throws Exception {
      SpreadsheetIntegration s = new SpreadsheetIntegration();
      AuthenticationController a = new AuthenticationControllerTest();
      char[] foo= new char[]{'c', 'o', 'm', 'p', 's', 'c', 'i'};
      a.authenticateUser("rp31", foo);
      assertTrue(this.authenticateUser(String.valueOf("rp31"), foo));
   }

   @Test
   public void testAuthenticateUser3() throws Exception {
      SpreadsheetIntegration s = new SpreadsheetIntegration();
      AuthenticationController a = new AuthenticationControllerTest();
      char[] foo= new char[]{'t', 'e', 's', 't', '0', '0', '1'};
      a.authenticateUser("nope", foo);
      assertFalse(this.authenticateUser(String.valueOf("nope"), foo));
   }

   @Test
   public void testAuthenticateUser4() throws Exception {
      SpreadsheetIntegration s = new SpreadsheetIntegration();
      AuthenticationController a = new AuthenticationControllerTest();
      char[] foo= new char[]{'T', 'E', 's', 't', '0', '0', '1'};
      a.authenticateUser("bss64", foo);
      assertFalse(this.authenticateUser(String.valueOf("Bss64"), foo));
   }

   public void run() throws Exception {
      try {
         this.testAuthenticateUser();
         this.testAuthenticateUser1();
         this.testAuthenticateUser2();
         this.testAuthenticateUser3();
         this.testAuthenticateUser4();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}