/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.kanegoodman.iterators;

/**
 *
 * @author pc1
 */
public class ArrayInteratorDemo {
    public static void main(String[] args) {
        //int highs[] = new int[5];
       int highs[] = new int[] {100, 95, 96, 97, 98};
       //goes through everything
        for (int high : highs) {
            System.out.println(high);
        }
        System.out.println(highs[4]);
         System.out.println(highs[5]); //Will throw IndexOutOfBoundsEception
       
    }//END PSVM
}//END CLASS
