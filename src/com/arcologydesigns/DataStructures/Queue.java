package com.arcologydesigns.DataStructures;

/**
 * Queue created by Borislav S. on 7/17/2015 @ 4:02 PM.
 */

public class Queue< T > {

   private int front;
   private int rear;
   private Object[] items;
   private int maxQue;
   private static final int MAX_ITEMS = 1000;

   public Queue() {
      maxQue = MAX_ITEMS + 1;
      front = maxQue - 1;
      rear = maxQue - 1;

      items = new Object[maxQue];
   }

   void makeEmpty() {
      while (!this.isEmpty())
      {
         this.deQueue();
      }
   }

   boolean isEmpty() {
      return (front == rear);
   }

   boolean isFull() {
      // Queue is full if rear has wrapped around to location of front
      return ((rear - MAX_ITEMS) == front);
   }

   public void enQueue(T newItem) {
      assert(!isFull());

      rear++;
      items[rear % MAX_ITEMS] = newItem;
   }

   @SuppressWarnings("unchecked")
   public T deQueue() {
      front++;

      return (T) items[front % MAX_ITEMS];

   }
}
