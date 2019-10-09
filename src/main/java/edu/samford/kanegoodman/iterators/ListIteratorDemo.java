/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.kanegoodman.iterators;

import edu.samford.kanegoodman.lists.DLinkedList;
import java.util.Iterator;
/**
 *
 * @author pc1
 */
public class ListIteratorDemo {
    public static void main(String[] args) {
        DLinkedList<Integer> highs = new DLinkedList<>();//HOW TO CREATE A DLINKED LIST
        highs.insertLast(100);
        highs.insertLast(99);
        highs.insertLast(102);
        highs.insertLast(95);
        highs.insertLast(97);
        Iterator<Integer> it = highs.iterator();
        int total = 0;
        while(it.hasNext()) {
            Integer temp = it.next();
            total += temp;
            
        }
        double average = (double) total / highs.size();
        total = 0;
        for (Integer high : highs) {
            total += high;
            
        }//END for (Integer high : highs)
        double average2 = total / highs.size(); //Incorrect because both int throw away non int endings
        System.out.println("Avg: " + average);
        System.out.println("Avg2: " + average2);
    }
}
