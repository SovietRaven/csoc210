/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.kanegoodman.stacksandqueues;

import edu.samford.kanegoodman.lists.DLinkedList;

/**
 *
 * @author kanegoodman
 */
public class ListQueue<T> implements Queue<T> {

    protected DLinkedList<T> theQueue = new DLinkedList<>();
    
    @Override
    public void enqueue(T data) {
        theQueue.insertLast(data);
    }

    @Override
    public T dequeue() {
        if (theQueue.isEmpty()){
            throw new Error("Cannot remove from an empty queue. Did you check to see if the program is empty");
        }
        T data = theQueue.first().element();
        theQueue.remove(theQueue.first());
        return data;
    }

    @Override
    public T front() {
if (theQueue.isEmpty()){
            throw new Error("This method does not work with an empty queue");
        }
        T data = theQueue.first().element();
        return data;    
    }

    @Override
    public boolean isEmpty() {
        return theQueue.isEmpty();
    }

    @Override
    public int size() {
        return theQueue.size();
    }

    @Override
    public String toString() {
        String strval = theQueue.toString();
        return strval;
    }
    
}
