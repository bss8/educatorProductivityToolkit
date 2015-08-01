package com.arcologydesigns.io_operations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.Writer;

import static org.junit.Assert.*;

/**
 * FileIOTest created by Borislav S. on 7/14/2015 @ 11:40 PM.
 */
public class FileIOTest {

   @Before
   public void setUp() throws Exception {

   }

   @After
   public void tearDown() throws Exception {

   }


   //Not sure what this operation does?  Does it write a line on the screen?  Or does it write a line on the file?

   @Test
   public void testWriteOperation() throws Exception {
      FileIO testfile = new FileIO("C:\\Users\\Ari\\Desktop\\CS4398\\educatorProductivityToolkit\\resources\\flatFiles\\test.txt");
      testfile.WriteOperation("This is a test");
      String file = testfile.ReadOneLine();
   }

   //This test appears to be working fine.

   @Test
   public void testReadOneLine() throws Exception {
      FileIO testfile = new FileIO("C:\\Users\\Ari\\Desktop\\CS4398\\educatorProductivityToolkit\\resources\\flatFiles\\studentData.txt");
      String file = testfile.ReadOneLine();
   }
}