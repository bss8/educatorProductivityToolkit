package com.arcologydesigns.DataStructures;

/**
 * Queue created by Borislav S. on 7/17/2015 @ 4:02 PM.
 */

public class Queue< T > {

   private int maxQue;  //will be one bigger than the size in the constructor
   private int front;
   private int rear;
   private Object[] items;
   private static final int MAX_ITEMS = 1000;

   //Default constructor will default to MAX_ITEMS in queue
   public Queue() {
      maxQue = MAX_ITEMS + 1;  //default value if none provided
      front = maxQue - 1;
      rear = maxQue - 1;

      items = new Object[maxQue];  //dynamically allocated
   }

   //Constructor with size of queue
   public Queue(int max) {
      maxQue = max + 1;  //max provided by user
      front = maxQue - 1;
      rear = maxQue - 1;

      items = new Object[maxQue];
   }

   /****************************
    makeEmpty

    Function: Removes all the items from the queue.
    Preconditions: queue has been initialized
    Postconditions: All the items have been removed
    *****************************/
    public void makeEmpty() {
       while (!this.isEmpty()) {
          this.deQueue();
       }
    }

   /****************************
    isEmpty

    Function: Checks to see if there are any items on the queue.
    Preconditions: queue has been initialized
    Postconditions: Returns true if there are no items on the queue, else false.
    *****************************/
    public boolean isEmpty() {
      return (front == rear);
   }

   /****************************
    isFull

    Function: Determines if you have any more room to add items to the queue
    Preconditions: queue has been initialized
    Postconditions: Returns true if there is no more room to add items, else false
    *****************************/
    public boolean isFull() {
       // Queue is full if rear has wrapped around to location of front
       return ((rear - MAX_ITEMS) == front);
    }

   /****************************
    push

    Function: Adds newItem to the top of the queue.
    Preconditions: queue has been initialized and is not full.
    Postconditions: newItem is at the top of the queue.
    *****************************/
   public void enQueue(T newItem) {
      assert(!isFull());

      rear++;
      items[rear % MAX_ITEMS] = newItem;
   }

   /****************************
    pop

    Function: Removes first item from queue and returns it.
    Preconditions: queue has been initialized and is not empty.
    Postconditions: First element has been removed from queue and is returned.
    *****************************/
   @SuppressWarnings("unchecked")
   public T deQueue() {
      front++;
      return (T) items[front % MAX_ITEMS];
   }
}
