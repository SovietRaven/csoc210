
package edu.samford.kanegoodman.lists;

/**
 *@param <T> type param for this class
 * @author pc1
 */
public class SLinkedList<T> {
    
    //Attributrs
    protected int size; //how many items are in the list
    protected SNode<T> head;
    protected SNode<T> tail;
    
    public SLinkedList(){
        size = 0;
        head = null;
        tail = null;
    }//End public SLinkedList()
    
    public void addFirst(SNode<T> newnode){
        //First before we forget increment the size
        size++;
        
        //Now, order matters, tell the new node that its next should be head
        newnode.setNext(head);
        
        //update the head to reference the newly "added" node
        head= newnode;
        
        //Lastly, do something with the tail
        if (size==1){
            tail = newnode;
        }//End if (size==1)
    }//End public void add(SNode newnode)
    
    public void addLast(SNode<T> newnode){
        //First before we forget increment the size
        size++;
        
        //Now, order matters, tell the new node that its next should be head
        tail.setNext(newnode);
        
        //update the head to reference the newly "added" node
        tail = newnode;
        
        //Lastly, do something with the tail
        if (size==1){
            head = newnode;
        }//End if (size==1)
    }//End public void addLast(SNode newnode)
        
public SNode<T> addFirst(T newdata){
    //Create the new SNode to store our data
    SNode<T> newnode = new SNode<>(newdata, null);
    addFirst (newnode);
    return newnode;
}//End public SNode addFirst(String newdata)    
    
public SNode<T> addLast(T newdata){
    //Create the new SNode to store our data
    SNode<T> newnode = new SNode<>(newdata, null);
    addLast (newnode);
    return newnode;
}//End public SNode addFirst(String newdata) 

/**
 * Adds newnode to our list AFTER the pos node
 * @param pos
 * @param newnode 
 */
public void addAfter(SNode<T> pos, SNode<T> newnode){
    //Setnewnode to next node, then link pos node to newnode
    size++;
    newnode.setNext(pos.getNext());
    pos.setNext(newnode);if (pos==tail){
        tail = newnode;
    }
    
}//End public void addAfter(SNode pos, SNode newnode)

public SNode<T> addAfter(SNode<T> pos, T newdata){
    SNode<T> newnode = new SNode<T>(newdata, null);
    addAfter(pos, newnode);
    return newnode;
}//End public SNode addAfter(SNode pos, String newdata)
/**
 * Searches the entire linked list until the data is found.
 * @return  the SNode containing the search data or null if not found
 */
public SNode<T> find(T searchdata){
    SNode<T> cur = head;
    while(cur!=null){
        if (cur.element().equals(searchdata)){
        return cur;
    }//END if
    }//End While(cur!=null)
    return null;
    
    
    
}//End public SNode<T> find(T searchdata)
/**
     * Finds and removes first occourence of the given data
     * @param searchdata
     * @reutn the reoved node if found otherwise null
     */
public SNode<T> remove(T searchdata) {
    SNode<T> doomed = find(searchdata);
    if (doomed !=null) {
        remove(doomed);
    }//END if(doomed!=null)
    return doomed;
}//END public SNode<T> remove(T searchdata)

public int size() {
    return size;
}//End public int size()
    public boolean isEmpty(){
        return size==0;
    }//End public boolean isEmpty()
    
    @Override
public String toString(){
String out = "";
SNode<T> cur = head;
while(cur!=null){
   out += cur.element();
   cur = cur.getNext();
   if(cur!=null){
       out += ',';
   }//End if(i!=null)
}//End whilewhile(i!=null)
return out;
}//End public String toString()

    private void remove(SNode<T> doomed) {
       //difficult to impilment (need to references to current node and node before)
    }

}//End public class SLinkedList


