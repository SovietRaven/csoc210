/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.kanegoodman.stacksandqueues;

/**
 *Interface for a FIFO data structure
 * @author kanegoodman
 */
public interface Queue<T> {
    public void enqueue(T data);
    public T dequeue();
    public T front();
    public boolean isEmpty();
    public int size();
}//End public interface Queue
