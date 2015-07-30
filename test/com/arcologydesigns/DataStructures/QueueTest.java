package com.arcologydesigns.DataStructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * QueueTest created by Borislav S. on 7/24/2015 @ 7:39 PM.
 */
public class QueueTest {

   @Before
   public void setUp() throws Exception {

   }

   @After
   public void tearDown() throws Exception {

   }


   @Test
   public void testEnQueue() throws Exception {
      Queue<String> myQ1 = new Queue<>();
      myQ1.enQueue("Test");
      assertEquals("Test",myQ1.deQueue());

      Queue<Integer> myQ2 = new Queue<>();
      myQ2.enQueue(14);
      assertEquals(Integer.valueOf(14),myQ2.deQueue());

      Queue<Double> myQ3 = new Queue<>();
      myQ3.enQueue(5.4);
      assertEquals(Double.valueOf(5.4),myQ3.deQueue());

   }

   @Test
   public void testDeQueue() throws Exception {
      Queue<Integer> myQ = new Queue<>();
      myQ.enQueue(10);
      myQ.enQueue(7);
      myQ.enQueue(1);

      assertEquals(Integer.valueOf(10) , myQ.deQueue());
      assertNotSame(10, myQ.deQueue());
      assertEquals(Integer.valueOf(1)  , myQ.deQueue());
   }

   @Test
   public void testIsEmpty() throws Exception {
      Queue<Integer> myQ = new Queue<>();
      assert(myQ.isEmpty());
      myQ.enQueue(10);
      assert(!myQ.isEmpty());
   }

   @Test
   public void testMakeEmpty() throws Exception {
      Queue<String> myQ = new Queue<>();
      myQ.enQueue("Test");
      assert(!myQ.isEmpty());
      myQ.makeEmpty();
      assert(myQ.isEmpty());

   }


   @Test
   public void testIsFull() throws Exception {
      Queue<Integer> myQ = new Queue<>();
      int i=0;
      while( i<1000) {
         myQ.enQueue(i);
         i++;
      }
      assert(myQ.isFull());
      myQ.makeEmpty();
      assert(!myQ.isFull());
   }

}