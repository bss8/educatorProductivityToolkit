package com.arcologydesigns.emailService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * MailTest created by Borislav S. on 7/10/2015 @ 6:31 PM.
 */
public class MailTest extends Mail {


   @Before
   public void setUp() throws Exception {
      /* The below code is not needed as the method we are testing is static:*/
   }

   @After
   public void tearDown() throws Exception {

   }

   @Test
   public void testGenerateAndSendEmail() throws Exception {
      assertTrue(Mail.generateAndSendEmail("bss64@txstate.edu", "bss64@txstate.edu", "Test_Subject_001", "Test_Message_001"));
   }

   @Test
   public void testGenerateAndSendEmail_2() throws Exception {
      assertTrue(Mail.generateAndSendEmail("bss64@txstate.edu", "-", "Test_Subject_002", "Test_Message_002"));
   }

   @Test
   public void testGenerateAndSendEmail_3() throws Exception {
      assertTrue(!Mail.generateAndSendEmail("rp31@txstate.edu", "bss64@txstate.edu", "Test_Subject_003", "Test_Message_003"));
   }

   public void run() throws Exception {
      try {
         this.testGenerateAndSendEmail();
         this.testGenerateAndSendEmail_2();
         this.testGenerateAndSendEmail_3();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}