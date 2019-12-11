/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.kanegoodman;

/**
 *
 * @author kanegoodman
 */
class FinalExam {
  public static void main(String args[]) {
    printAnswer(3, 4);
    int output = printAnswer(3, 4);
    System.out.println(output);
  }

    public static int printAnswer(int x, int y) {
        if (x >= y){
        int ans = (x - y);
        return ans;
        } else {
         int ans = (x + y);
         return ans;   
        }
        
    }

}