package com.arcologydesigns.DataStructures;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

/**
 * BST created by Borislav S. on 7/14/2015 @ 7:07 PM.
 * This class allows for the implementation of a binary search tree
 * TODO: need to balance the tree using the the Stout-Warren algorithm
 * TODO: need to be able to delete a node from the tree and reorganize the tree using above
 *
 * INSTRUCTIONS: create a new instance, insert items (must be an object, i.e., Integer rather than int), make a call to
 * balance the tree, then use breadthFirstSearch to find an item. The findMin() and findMax() are called automatically
 * by the balance method and should not be used to find the min/max in the tree. The getMinTreeValue and getMaxTreeValue
 * should be used instead.
 */
public class BST< T extends Comparable<T> > {

   private TreeNode ROOT;
   private static final int MEGABYTE = (1024*1024);
   private MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
   private String inOrderBST;
   private String preOrderBST;
   private String postOrderBST;
   private T minTreeValue;
   private T maxTreeValue;

   private class TreeNode  {
      T data;
      //TreeNode parent;
      TreeNode left;
      TreeNode right;

      private TreeNode(T data) {
         this.data = data;
         //this.parent = null;
         this.left = null;
         this.right = null;
      }

      private TreeNode() {
      }
   }

   public BST() {
      ROOT = null;
      inOrderBST = "";
      minTreeValue = null;
      maxTreeValue = null;
   }

   public void copyTree(TreeNode copy, TreeNode originalTree) {
      if (originalTree == null) {
         copy = null;
      } else {
         copy = new TreeNode();
         copy.data = originalTree.data;
         copyTree(copy.left, originalTree.left);
         copyTree(copy.right, originalTree.right);
      }
   }

   /****************************
    makeEmpty

    Function: Removes all the items from the BST.
    Preconditions: BST has been initialized
    Postconditions: All the items have been removed
    *****************************/
   public void makeEmpty() {
      this.ROOT = null;
   }

   /****************************
    isEmpty

    Function: Checks to see if there are any items in the BST.
    Preconditions: BST has been initialized
    Postconditions: Returns true if there are no items in the BST, else false.
    *****************************/
   public boolean isEmpty() {
      return (this.ROOT == null);
   }

   /****************************
    isFull

    Function: Determines if you have any more room to add items to the BST
    Preconditions: BST has been initialized
    Postconditions: Returns true if there is no more room to add items, else false
    *****************************/
   public boolean isFull() {
      try {
         TreeNode a = new TreeNode();
         return false;
      }
      catch (OutOfMemoryError e) {
         MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
         long maxMemory = heapUsage.getMax() / MEGABYTE;
         long usedMemory = heapUsage.getUsed() / MEGABYTE;
         out.println("Memory Use :" + usedMemory + "M/" + maxMemory + "M");
         return true;
      }
   }

   /****************************
    insertItem

    Function: Adds newItem to the BST.
    Preconditions: BST has been initialized and is not full.
    Postconditions: newItem is in the proper position for a BST.
    *****************************/
   private void insertItem(TreeNode t, T newItem) {
      if (t == null) {
         t = new TreeNode(newItem);
         ROOT = t;
      }
      else if (newItem.compareTo(t.data) < 0 && t.left == null) {
         t.left = new TreeNode(newItem);
         //t.left.parent = t;
      }
      else if (newItem.compareTo(t.data) >= 0 && t.right == null) {
         t.right = new TreeNode(newItem);
         //t.right.parent = t;
      } else {
         if (newItem.compareTo(t.data) < 0) {
            insertItem(t.left, newItem);
         } else {
            insertItem(t.right, newItem);
         }
      }
   }

   public void insertItem(T newItem)
   {
      insertItem(ROOT, newItem);
   }

   private int countNodes(TreeNode t) {
      if (t == null)
         return 0;
      else
         return countNodes(t.left) + countNodes(t.right) + 1;
   }

   /****************************
    countNodes

    Function: Counts the number of nodes in the BST
    Preconditions: BST has been initialized.
    Postconditions: returns the number of nodes in the BST
    *****************************/
   public int countNodes()
   {
      return countNodes(ROOT);
   }

   /****************************
    preOrderTraversal

    Function: prints the preOder (Node, Left, Right) traversal to standard output
    Preconditions: BST has been initialized.
    Postconditions: none
    *****************************/
   private String preOrderTraversal(TreeNode t) {
      if (t != null) {
         preOrderBST += t.data.toString() + ",";
         preOrderTraversal(t.left);
         preOrderTraversal(t.right);
      }
      return preOrderBST;
   }

   public String preOrderTraversal() {
      this.preOrderBST = "";
      return preOrderTraversal(ROOT);
   }

   /****************************
    inOrderTraversal

    Function: prints the inOder (Left, Node, Right) traversal to standard output
    Preconditions: BST has been initialized.
    Postconditions: none
    *****************************/
   private String inOrderTraversal(TreeNode t) {

      if (t != null) {
         inOrderTraversal(t.left);
         inOrderBST += t.data.toString() + ",";
         inOrderTraversal(t.right);
      }
      return inOrderBST;
   }

   public String inOrderTraversal() {
      this.inOrderBST = "";
      return inOrderTraversal(ROOT);
   }

   /****************************
    postOrderTraversal

    Function: prints the postOder (Left, Right, Node) traversal to standard output
    Preconditions: BST has been initialized.
    Postconditions: none
    *****************************/
   private String postOrderTraversal(TreeNode t) {
      if (t != null) {
         postOrderTraversal(t.left);
         postOrderTraversal(t.right);
         postOrderBST += t.data.toString() + ",";
      }
      return postOrderBST;
   }

   public String postOrderTraversal() {
      this.postOrderBST = "";
      return postOrderTraversal(ROOT);
   }

   /****************************
    breadthFirstSearch

    Function: finds item by passing through the rows in the BST
    Preconditions: BST has been initialized
    Postcondidions: returns true if the item is found in the BST
    *****************************/
   private T breadthFirstSearch(TreeNode t, T item) {
      if (t == null) return null;  //if t is null, list is empty and the item will not be found

      //create a queue to store tree nodes and enqueue the first item, the root, to begin the search
      Queue<TreeNode> q = new Queue<>();

      q.enQueue(t);

      //while the queue is not empty, create a temporary tree node and set it to the first item in the queue;
      //check if that is the item we are looking for - if yes, return true and stop searching,
      //if no, enqueue the child elements of the dequeued node
      while (!q.isEmpty()) {
         TreeNode tmp = q.deQueue();

         if (tmp.data.equals(item))
            return tmp.data;
         else {
            //enqueue the node's child elements, if they exist (check if not null)
            if (tmp.left != null)
               q.enQueue(tmp.left);
            if (tmp.right != null)
               q.enQueue(tmp.right);
         }
      }
      //if the if-condition above is not reached, the item is not found - return false
      return null;
   }

   public T breadthFirstSearch(T item) {
      //we call the private method from the exposed public function and pass in
      //the root (beginning of tree) and searched-for item
      return breadthFirstSearch(ROOT, item);
   }

   private ArrayList<T> convertTreeToList(String treeValues) {
      String[] split = treeValues.split(",");
      ArrayList<T> list = new ArrayList<>();

      for(String s : split) {
         T value = (T) s;
         list.add(value);
      }
      return list;
   }

   private int findMin(List<T> treeList) {
      minTreeValue = treeList.get(0);
      int minIndex = 0;
      for(int i = 1; i < treeList.size(); i++) {
         if(treeList.get(i).compareTo(minTreeValue) == -1) {
            minTreeValue = treeList.get(i);
            minIndex = i;
         }
      }
      return minIndex;
   }

   private int findMax(List<T> treeList) {
      maxTreeValue = treeList.get(0);
      int maxIndex = 0;
      for(int i = 1; i < treeList.size(); i++) {
         if(treeList.get(i).compareTo(maxTreeValue) == 1) {
            maxTreeValue = treeList.get(i);
            maxIndex = i;
         }
      }
      return maxIndex;
   }

   @SuppressWarnings("unchecked")
   private void balanceRecursive(int min, int max, List list){

      if(min == max)
         return;

      int midpoint = (min + max)/2;

      T insert = (T) list.get( midpoint);
      insertItem(insert);

      balanceRecursive(midpoint+1, max, list);
      balanceRecursive(min, midpoint, list);
   }

   @SuppressWarnings("unchecked")
   public void balanceRecursive() {

      // call inOrderTraversal to obtain a string list of
      String listTraversal = inOrderTraversal();
      ArrayList<T> list = convertTreeToList(listTraversal);
      int min = findMin(list);
      int max = findMax(list);

      // need to make the tree empty to avoid replication of data
      this.makeEmpty();

      balanceRecursive(min, max, list);

      // add in the last item, which is left out by recursive call
      int listSize = list.size() - 1;
      T item = (T) list.get(listSize);
      this.insertItem(item);
   }

   public T getMinTreeValue() {
      // call inOrderTraversal to obtain a string list of
      String listTraversal = inOrderTraversal();
      ArrayList<T> list = convertTreeToList(listTraversal);
      int min = findMin(list);

      return this.minTreeValue;
   }

   public T getMaxTreeValue() {
      // call inOrderTraversal to obtain a string list of
      String listTraversal = inOrderTraversal();
      ArrayList<T> list = convertTreeToList(listTraversal);

      int max = findMax(list);
      return this.maxTreeValue;
   }
} //end class BST