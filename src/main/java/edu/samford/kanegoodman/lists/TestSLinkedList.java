/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.kanegoodman.lists;

/**
 *
 * @author pc1
 */
public class TestSLinkedList {
    public static void main(String[] args) {
        SLinkedList<String> list = new SLinkedList<>();
        SLinkedList<Integer> ratings = new SLinkedList<>();
        
        //Test an empty list
        System.out.println("Size==0:            " + list.size());
        System.out.println("toString=''" + list.toString());
        System.out.println("Size==0:            " + ratings.size());
        System.out.println("toString=''" + ratings.toString());
        //Test a 1 item list
                list.addFirst("BHM");
                ratings.addFirst(10);
                System.out.println("Size==1:            " + list.size());
        System.out.println("toString='BHM': " + list.toString());
        System.out.println("Size==1:            " + ratings.size());
        System.out.println("toString='10': " + ratings.toString());
        
        //Test a 2 item list
        list.addLast("ATL");
        ratings.addLast(7);
        System.out.println("size==2:            " + list.size());
        System.out.println("toString=='BHM,ATL': " + list);
        System.out.println("size==2:            " + ratings.size());
        System.out.println("toString=='10,7': " + ratings);
    
    SNode<String> bhmnode = list.find("BHM");
        System.out.println(bhmnode.element());
    
    }
    
}
