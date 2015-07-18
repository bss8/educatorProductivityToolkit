package com.arcologydesigns.DataStructures;

import sun.reflect.generics.tree.Tree;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * BST created by Borislav S. on 7/14/2015 @ 7:07 PM.
 * This class allows for the implementation of a binary search tree
 */
public class BST< T extends Comparable<T> > {

   TreeNode ROOT;
   private static final int MEGABYTE = (1024*1024);
   MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();


   private class TreeNode  {
      T data;
      TreeNode parent;
      TreeNode left;
      TreeNode right;

      private TreeNode(T data) {
         this.data = data;
         this.parent = null;
         this.left = null;
         this.right = null;
      }

      private TreeNode() {
      }


   }

   public BST() {
      ROOT = null;
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
         System.out.println("Memory Use :" + usedMemory + "M/" + maxMemory + "M");
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
         t.left.parent = t;
      }
      else if (newItem.compareTo(t.data) >= 0 && t.right == null)
      {
         t.right = new TreeNode(newItem);
         t.right.parent = t;
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
         System.out.printf("%s, ", t.data);
         preOrderTraversal(t.left);
         preOrderTraversal(t.right);
      }
   }

   public void preOrderTraversal() {
      preOrderTraversal(ROOT);
   }

   private void inOrderTraversal(TreeNode t) {
      if (t != null) {
         inOrderTraversal(t.left);
         System.out.printf("%s, ", t.data);
         inOrderTraversal(t.right);
      }
   }

   public void inOrderTraversal() {
      inOrderTraversal(ROOT);
   }

   private void postOrderTraversal(TreeNode t) {
      if (t != null) {
         postOrderTraversal(t.left);
         postOrderTraversal(t.right);
         System.out.printf ("%s, ", t.data);
      }
   }

   public void postOrderTraversal() {
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
}
