/* Operations required for a Stack.
 * LIFO - Last in, First out
 * push - add an item to the top of the stack
 * pop - remove the item on top of the stack (pop and top should throw exceptions if empty)
 * top - returnn the item on top of the stack
 * isEmpty - return true or false weather or not there is anything in the set
 * size - return the number of items on the stack
 */
package edu.samford.kanegoodman.stacksandqueues;

/**
 *
 * @author kanegoodman
 */
public interface Stack<T> {
    public void push(T data);//takes in new data
    public T pop(); // returns top of stack and removes it
    public T top();// just returns top
    public int size();// returns # of items in the stack
    public boolean isEmpty ();// returns T/F if size is 0
}//END public interface Stack<T>
