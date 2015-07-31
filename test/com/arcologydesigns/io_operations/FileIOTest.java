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

   @Test
   public void testWriteOperation() throws Exception {
      FileIO testfile = new FileIO("test.txt");
      testfile.WriteOperation("This is a test");
      assertFalse(FileIO.appendCheck());
   }

   @Test
   public void testReadOneLine() throws Exception {

   }
}