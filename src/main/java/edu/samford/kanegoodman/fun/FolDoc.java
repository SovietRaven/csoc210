/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.kanegoodman.fun;

import edu.samford.kanegoodman.lists.DLinkedList;
import edu.samford.kanegoodman.trees.BST;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author KaneGoodman
 */
public class FolDoc {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner filein = new Scanner(new File("Dictionary.txt"));
        String currentTerm = "";
        String currentDefinition = "";
        DLinkedList<FolDocTerm> list = new DLinkedList<>();
        BST<FolDocTerm> bst = new BST<>();
        while (filein.hasNextLine()) {
            String nextLine = filein.nextLine();
            if (nextLine.trim().equals("")) {
                // we must have a blank line ... lets add it to the def
                currentDefinition += "\n";
            } else if (nextLine.charAt(0) == '\t') {
                //we must be still going with the current definition

                currentDefinition += nextLine.trim() + "\n";
            } else {
                // we must have encountered a new term
                // so ...
                // 1. Add the old term (if there was one) to the data scructure(s)
                if (!currentTerm.equals("")) {
                    FolDocTerm newterm = new FolDocTerm(currentTerm.trim(), currentDefinition.trim());
                    list.insertLast(newterm);
                    bst.add(newterm);
                }
                // 2. Grab the new term
                currentTerm = nextLine.trim();
                // 3. reset the current def
                currentDefinition = "";
            }

        }
        bst.rebalance(); //TAKE THIS OUT FOR FIRST MEASUREMENTS XL 4 colmn bal unbal linkedlist term
        System.out.println("Linked list: " + list.size() + " terms.");
        System.out.println("Binary search tree: " + bst.size() + " terms.");
        Scanner stdin = new Scanner(System.in);
        while (true) {
            System.out.print("What term would you like to find? ");
            String searchstr = stdin.nextLine();  // retrieves the search term
            if (searchstr.equals("-exit-")) {
                break;   // exit out of the loop because the user must have entered -exit-
            }
            // now perform the search on both data structures, measuring how long it takes
            System.out.println("Searching for: " + searchstr);  // temporary debugging display
            FolDocTerm faketerm = new FolDocTerm(searchstr, "");

              long start = System.nanoTime();         // code to be measured
              Object listhit = list.search(faketerm);
              long finish = System.nanoTime();   
              long duration1 = finish - start;
            
            
            start = System.nanoTime(); 
            Object bsthit = bst.search(faketerm);
           finish = System.nanoTime();   
           long duration2 = finish - start;
            System.out.println(listhit + "," + bsthit);
            
            System.out.println("Time for linked list: " + duration1);
            System.out.println("Time for BST: " + duration2);
        }
    }
}
