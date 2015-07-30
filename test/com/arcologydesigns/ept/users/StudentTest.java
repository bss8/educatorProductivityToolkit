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
      Student Foo = new Student("Bob", 0);
      Student Bar = new Student("", 0);

      int test = Foo.compareTo(Bar);
      System.out.printf("%s", test);
      assert (test == 0);

      Student A = new Student ( "", 1);
      Student B = new Student ( "", 0);
      test = A.compareTo(B);
      assert (test == 1);

      test = B.compareTo(A);
      assert ( test == -1);
   }

   @Test
   public void testToString() throws Exception {

      Student Foo = new Student ( "Jacob" , 94);
      String Bar = Foo.toString();
      assertEquals ("94.0", Bar);


   }

   @Test
   public void testFullStringRep() throws Exception {
      Student J = new Student("John", 85);
      String test = J.fullStringRep();
      assertEquals("John: 85.0", J.fullStringRep());
      System.out.println(test);//works fine but i'm seeing an '0' character here.

   }
}