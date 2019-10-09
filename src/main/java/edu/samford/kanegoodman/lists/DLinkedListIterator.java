/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.kanegoodman.lists;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author kanegoodman
 */
public class DLinkedListIterator<T> implements Iterator<T> {
    protected DLinkedList<T> theList;
    protected DNode<T> cur;
    public DLinkedListIterator(DLinkedList<T> theList){
        this.theList = theList;
        cur = theList.first();//returns reference to first REAL node in list NULL if empty
    }
//**
// * Check to see if there are any nodes left to visit.
// * @return
// */
    @Override
    public boolean hasNext() {
        return cur!=null;//Makes sure has node?
    }
/**
 * next() should only ever be called after hasNext() has returned true
 * @return 
 */
    @Override
    public T next() {
        T theData = cur.element();
        cur = theList.next(cur);
        return theData;
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        Iterator.super.forEachRemaining(action); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * Remove the node that was returned last time next() was called
 */
    @Override
    public void remove() {
        if(cur==null){
            theList.remove(theList.last());
        }else {
      DNode<T> doomed = theList.prev(cur);
      theList.remove(doomed);
        }
    }
    
}
