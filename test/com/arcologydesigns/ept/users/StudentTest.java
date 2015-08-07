package com.arcologydesigns.ept.users;

import com.sun.prism.shader.Solid_ImagePattern_Loader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * StudentTest created by Borislav S. on 7/24/2015 @ 7:37 PM.
 */
public class StudentTest {

   @Before
   public void setUp() throws Exception {

   }

    @After
   public void tearDown() throws Exception {



   }

   @Test
   public void testCompareTo() throws Exception {
      Student s = new Student();
      s.setUserID("test1");
      Student s2 = new Student();
      s2.setUserID("test2");
      int i = s.compareTo(s2);
      assert(i == -1);
   }

   @Test
   public void testCompareTo_2() throws Exception {

      Student s = new Student();
      s.setUserID("test1");
      Student s2 = new Student();
      s2.setUserID("test1");
      int i = s.compareTo(s2);
      assert(i == 0);
   }

   @Test
   public void testToString() throws Exception {
      Student s = new Student();
      s.setUserID("user1");
      String studentString = s.toString();
      System.out.print(studentString);
      assert(studentString.equals("user1,null,null,null,null;"));
   }

   @Test
   public void testToString_2() throws Exception {
      Student s = new Student();
      s.setUserID("user1");
      s.setUserName("John");
      s.setEmail("John@hotmail.com");
      s.setPhone("1112223333");
      String studentString = s.toString();
      System.out.print(studentString);
      assert(studentString.equals("user1,John,1112223333,null,John@hotmail.com;"));
   }

   @Test
   public void testToString_3() throws Exception {
      Student s = new Student();
      s.setUserID("user1");
      s.setUserName("Smith");
      s.setEmail("Andrew@hotmail.com");
      s.setPhone("5555555555");
      String studentString = s.toString();
      System.out.print(studentString);
      assert(!studentString.equals("user1,John,1112223333,null,John@hotmail.com;"));
   }

   @Test
   public void testFullStringRep() throws Exception {
      Student J = new Student("John", 85);
      String test = J.fullStringRep();
      assertEquals("John: 85.0", J.fullStringRep());
      System.out.println(test);//works fine but i'm seeing an '0' character here.
   }

   public void run() throws Exception {
      try {
         this.testCompareTo();
         this.testCompareTo_2();
         this.testToString();
         this.testToString_2();
         this.testToString_3();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}