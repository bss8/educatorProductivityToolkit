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
 */
public class BST< T extends Comparable<T> > {

   private TreeNode ROOT;
   private static final int MEGABYTE = (1024*1024);
   private MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
   private String inOrderBST;
   private double minTreeValue;
   private double maxTreeValue;

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
      minTreeValue = 0.0;
      maxTreeValue = 0.0;
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


   public void makeEmpty() {
      this.ROOT = null;
   }

   public boolean isEmpty() {
      return (this.ROOT == null);
   }

   public boolean isFull() {
      try
      {
         TreeNode a = new TreeNode();
         return false;
      }
      catch (OutOfMemoryError e)
      {
         MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
         long maxMemory = heapUsage.getMax() / MEGABYTE;
         long usedMemory = heapUsage.getUsed() / MEGABYTE;
         out.println("Memory Use :" + usedMemory + "M/" + maxMemory + "M");
         return true;
      }
   }

   private void insertItem(TreeNode t, T newItem) {
      if (t == null)
      {
         t = new TreeNode(newItem);
         ROOT = t;
      }
      else if (newItem.compareTo(t.data) < 0 && t.left == null)
      {
         t.left = new TreeNode(newItem);
         //t.left.parent = t;
      }
      else if (newItem.compareTo(t.data) >= 0 && t.right == null)
      {
         t.right = new TreeNode(newItem);
         //t.right.parent = t;
      }
      else
      {
         if (newItem.compareTo(t.data) < 0)
         {
            insertItem(t.left, newItem);
         }
         else
         {
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

   public int countNodes()
   {
      return countNodes(ROOT);
   }

   private void preOrderTraversal(TreeNode t) {
      if (t != null)
      {
         out.printf("%s, ", t.data);
         preOrderTraversal(t.left);
         preOrderTraversal(t.right);
      }
   }

   public void preOrderTraversal() {
      inOrderBST = null;
      preOrderTraversal(ROOT);
   }

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

   private void postOrderTraversal(TreeNode t) {
      if (t != null) {
         postOrderTraversal(t.left);
         postOrderTraversal(t.right);
         out.printf ("%s, ", t.data);
      }
   }

   public void postOrderTraversal() {
      this.inOrderBST = "";
      postOrderTraversal(ROOT);
   }

   private boolean breadthFirstSearch(TreeNode t, T item)
   {
      if (t == null) return false;  //if t is null, list is empty and the item will not be found

      //create a queue to store tree nodes and enqueue the first item, the root, to begin the search
      Queue<TreeNode> q = new Queue<>();

      q.enQueue(t);

      //while the queue is not empty, create a temporary tree node and set it to the first item in the queue;
      //check if that is the item we are looking for - if yes, return true and stop searching,
      //if no, enqueue the child elements of the dequeued node
      while (!q.isEmpty())
      {
         TreeNode tmp = q.deQueue();

         if (tmp.data.equals(item))
            return true;
         else
         {
            //enqueue the node's child elements, if they exist (check if not null)
            if (tmp.left != null)
               q.enQueue(tmp.left);
            if (tmp.right != null)
               q.enQueue(tmp.right);
         }
      }

      //if the if-condition above is not reached, the item is not found - return false
      return false;
   }

   public boolean breadthFirstSearch(T item)
   {
      //we call the private method from the exposed public function and pass in
      //the root (beginning of tree) and searched-for item
      return breadthFirstSearch(ROOT, item);
   }

   private ArrayList<Double> convertTreeToList(String treeValues) {
      String[] split = treeValues.split(",");
      ArrayList<Double> list = new ArrayList<>();

      for(String s : split) {
         double d = Double.parseDouble(s);
         list.add(d);
      }
      return list;
   }

   private int findMin(List<Double> treeList) {
      minTreeValue = treeList.get(0);
      int minIndex = 0;
      for(int i = 1; i < treeList.size(); i++) {
         if(treeList.get(i) < minTreeValue) {
            minTreeValue = treeList.get(i);
            minIndex = i;
         }
      }
      return minIndex;
   }

   private int findMax(List<Double> treeList) {
      maxTreeValue = treeList.get(0);
      int maxIndex = 0;
      for(int i = 1; i < treeList.size(); i++) {
         if(treeList.get(i) > maxTreeValue) {
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
      ArrayList<Double> list = convertTreeToList(listTraversal);
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

   public double getMinTreeValue() {
      return this.minTreeValue;
   }

   public double getMaxTreeValue() {
      return this.maxTreeValue;
   }
}
