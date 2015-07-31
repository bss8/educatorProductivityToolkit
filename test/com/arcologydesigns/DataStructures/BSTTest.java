package com.arcologydesigns.DataStructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * BSTTest created by Borislav S. on 7/24/2015 @ 7:44 PM.
 */
public class BSTTest {

   @Before
   public void setUp() throws Exception {


   }

   @After
   public void tearDown() throws Exception {

   }

   @Test
   public void testMakeEmpty() throws Exception {
   }

   @Test
   public void testIsEmpty() throws Exception {

   }

   @Test
   public void testIsFull() throws Exception {


   }

   @Test
   public void testInsertItem() throws Exception {

   }

   @Test
   public void testCountNodes() throws Exception {

   }

   @Test
   public void testPreOrderTraversal() throws Exception { //need to physically check these are in order in a bit.
       BST<Integer> testTree = new BST<>();
       testTree.insertItem(1);
       testTree.insertItem(3);
       testTree.insertItem(5);
       testTree.insertItem(6);
       testTree.insertItem(4);
       testTree.insertItem(2);
       assertEquals(String.valueOf("1,3,2,5,4,6,"), testTree.preOrderTraversal());//trailing comma

   }

   @Test
   public void testInOrderTraversal() throws Exception {
       BST<Integer> testTree = new BST<>();
       testTree.insertItem(1);
       testTree.insertItem(3);
       testTree.insertItem(5);
       testTree.insertItem(6);
       testTree.insertItem(4);
       testTree.insertItem(2);
       assertEquals(String.valueOf("1,2,3,4,5,6,"), testTree.inOrderTraversal());//trailing comma

   }

   @Test
   public void testPostOrderTraversal() throws Exception {
       BST<Integer> testTree = new BST<>();
       testTree.insertItem(1);
       testTree.insertItem(3);
       testTree.insertItem(5);
       testTree.insertItem(6);
       testTree.insertItem(4);
       testTree.insertItem(2);
       //System.out.println(testTree.postOrderTraversal()); //useful to check traversals.
       assertEquals(String.valueOf("2,4,6,5,3,1,"), testTree.postOrderTraversal());//trailing comma
   }

   @Test
   public void testBreadthFirstSearch() throws Exception {

   }

   @Test
   public void testBalanceRecursive() throws Exception {

   }

   @Test
   public void testGetMinTreeValue() throws Exception {

   }

   @Test
   public void testGetMaxTreeValue() throws Exception {

   }
}