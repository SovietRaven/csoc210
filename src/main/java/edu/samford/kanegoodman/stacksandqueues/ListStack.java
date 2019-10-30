/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.kanegoodman.stacksandqueues;

import edu.samford.kanegoodman.lists.DLinkedList;

/**
 *
 * @kanegoodman
 */
public class ListStack<T> implements Stack<T> {

    //underlying data structure that stores all the stack items
    //The "end" of the linked list will be the "top" of the stack
    protected DLinkedList<T> theStack = new DLinkedList<>();
    
    @Override
    public void push(T data) {
        theStack.insertLast(data);
    }

    @Override
    public T pop() {
    if(theStack.isEmpty()){
        throw new Error("You arn't supposed to call pop() on an empty stack. Did you check to see if the Stack was empty first???");
    }
    T data = theStack.last().element();
    theStack.remove(theStack.last());
    return data;
    }

    @Override
    public T top() {
if(theStack.isEmpty()){
        throw new Error("You arn't supposed to call top() on an empty stack. Did you check to see if the Stack was empty first???");
    }
T data = theStack.last().element();
    return data;
    }

    @Override
    public int size() {
    return theStack.size();
    }

    @Override
    public boolean isEmpty() {
return theStack.isEmpty();
    }

    @Override
    public String toString() {
        return theStack.toString();
    }
    
}
