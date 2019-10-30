/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.kanegoodman.stacksandqueues;

/**
 *
 * @author kanegoodman
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> urls = new ArrayStack<>();
        //urls is currently empty, our browser is on the home page
        System.out.println("Stack size: " + urls.size());
        //User navigates to samford.edu
        //we push the homepage onto the Stack
        urls.push("home page");
        
        //user navigated to bsc.edu
        //we push samford onto the stack
        //stack size should be 2
        urls.push("samford.edu");
        System.out.println("stack size: " + urls.size());
        
        String url = urls.pop();
        System.out.println(url);
        
        url = urls.pop();
        System.out.println(url);
        
        //this next line should crash the program
        //urls.pop();
        
    }//END PSVM
}//END StackDemo
