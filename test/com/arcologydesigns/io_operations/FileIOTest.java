package com.arcologydesigns.io_operations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.FileWriter;
import java.io.Writer;

import static java.nio.file.Files.delete;
import static java.nio.file.Files.deleteIfExists;
import static org.junit.Assert.*;

import java.io.*;
import java.nio.file.Files;

/**
 * FileIOTest created by Borislav S. on 7/14/2015 @ 11:40 PM.
 * Modified and co by arnissim on 7/31/2015
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

      FileIO testfile = new FileIO(".\\resources\\flatfiles\\test.txt");
      testfile.WriteOperation("This is a test");
      assertNotNull(testfile);
      File file = new File(".\\resources\\flatfiles\\test.txt");
      try {
         if (file.delete()) {
            System.out.println(file.getName() + " is deleted!");
            assertTrue(true);
         } else {
            assertTrue(false);
         }
      }catch(Exception e){
         e.printStackTrace();
      }

   }

   @Test
   public void testReadOneLine() throws Exception {
      FileIO testfile = new FileIO(".\\resources\\flatfiles\\studentData.txt");
      String testfile2 = testfile.ReadOneLine();
      assertNotNull(testfile2);
   }
}