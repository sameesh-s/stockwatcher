package com.sameesh.stockwatcher.util;

import java.util.Iterator;

/**
 * LIFO Generic stack which supports operations push, pop, peek, isEmpty
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item> {

    private int N;
    private Node first;

    //linked list nod for stack construction
    private class Node{
        private Item item;
        private Node next;
    }

    /**
     * Creates an Empty Stack
     */
    public Stack(){
        first = null;
        N = 0;
    }

    /**
     * @return Is the stack is empty or not
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * @return Number of items in the stack
     */
    public int size(){
        return N;
    }

    /**
     * Add an item to the stack
     * @param item
     */
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    /**
     * Delete and return the top item from stack and throws exception if the stack is empty
     * @return
     */
    public Item pop(){
        if(isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    /**
     * Returns the most recently added item from the stack, not deleting it from stack.
     * @return
     */
    public Item peek(){
        if(isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    /**
     * @return String representation
     */
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Item item: this){
            s.append(item+" ");
        }
        return s.toString();
    }
}
