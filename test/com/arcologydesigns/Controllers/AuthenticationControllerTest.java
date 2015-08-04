package com.arcologydesigns.Controllers;

import com.arcologydesigns.GoogleIntegration.SpreadsheetIntegration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

      /*
         Can't figure out how to create a "UserNode" to set the passwords.  It won't let me set the password because I'm trying to set it
         static and inside an "inner class".  Very stuck :(

         Added some setters and getters into the SpreadsheetIntegration SchoolClass but still no good.

      */
      //assert (SpreadsheetIntegration.UserNode.username("bss64"));
      //assert (SpreadsheetIntegration.UserNode.password("test123"));
      assertFalse(this.authenticateUser("bss64", new char[]{'t', 'e', 's', 't', '1', '2', '3'}));
   }

   @Test
   public void testAuthenticateUser1() throws Exception {

   }
}