package com.arcologydesigns.emailService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * MailTest created by Borislav S. on 7/10/2015 @ 6:31 PM.
 */
public class MailTest extends Mail {
    private Mail mail;

   @Before
   public void setUp() throws Exception {
      /*
         The below code is not needed as the method we are testing is static:*/


   }

   @After
   public void tearDown() throws Exception {

   }

   @Test
   public void testGenerateAndSendEmail() throws Exception {
      assert(this.mail.generateAndSendEmail("bss64@txstate.edu", "bss64@txstate.edu", "Test_Subject_001", "Test_Message_001"));
   }
}