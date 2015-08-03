package com.arcologydesigns.io_operations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.FileWriter;
import java.io.Writer;

import static org.junit.Assert.*;

/**
 * FileIOTest created by Borislav S. on 7/14/2015 @ 11:40 PM.
 * Modified by arnissim on 7/31/2015
 */
public class FileIOTest {

   @Before
   public void setUp() throws Exception {

   }

   @After
   public void tearDown() throws Exception {

   }

   @Test
   public void testWriteOperation() throws Exception {
      /*
      * Remember when I showed you guys how to pull data and I showed how in AuthenticatorForm I kept the commented out
      * method as a caveat? Take a look at AuthenticationForm.java for how to import resources, text or otherwise.
      * For example:

         ClassLoader cldr = this.getClass().getClassLoader();
         java.net.URL imageURL   = cldr.getResource("images/desert.jpg");

         assert imageURL != null;  //used during debugging

         if (imageURL != null) {
            img = new ImageIcon(imageURL);
         }

      */

      /*
         EXAMPLE OF BAD CODE: the below code. To fetch a resource, use the absolute reference path and invoke
         getClassLoader() then getResource() to set a resource. Otherwise, the resource will not show when running
         the application from a JAR file.

            setContentPane(new JLabel(new ImageIcon(".\\resources\\desert.jpg")));
      */
   }

   @Test
   public void testReadOneLine() throws Exception {
      FileIO testfile = new FileIO(".\\resources\\flatfiles\\studentData.txt");
      String testfile2 = testfile.ReadOneLine();
      assertNotNull(testfile2);
   }
}