
package edu.samford.kanegoodman.lists;

/**
 *
 * @author pc1
 */
public class SNode<T> {
    
    // Attributes
    protected T e; // the "element" (i.e., data) stored at this node
    protected SNode<T> next; // the "link" (i.e., reference) to the next node
    
    public SNode(T e, SNode<T> next){
        this.e = e;
        this.next = next;
        
    }//End public SNode(String e, SNode next)
    
    public SNode getNext(){
        return next;
    }// End public SNode getNext()
    
    public void setNext(SNode<T> next){
        this.next = next;
    }//End public void setNext(SNode next)
    
    public T element() {
        return e;
    }//End public String element()
    
    public void setElement(T e){
        this.e = e;
    }//public void setElement(String e)
    
}//End public class SNode
