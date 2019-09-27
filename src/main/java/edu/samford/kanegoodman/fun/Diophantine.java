
package edu.samford.kanegoodman.fun;

import java.util.Scanner;
/**
 *Attempts to solve the diophantine equation for the supplied integer
 * @author pc1
 */
public class Diophantine {
    public static void main(String[] args) {
        System.out.println("Please eneter the number you would like to solve (1-100): ");
        Scanner stdin = new Scanner(System.in);
        int num = stdin.nextInt();
        
        for (long x=-10000; x<=10000; x++)
            for (long y=-10000; y<=10000; y++)
                for (long z=-10000; z<=10000; z++)
                    if (x*x*x+y*y*y+z*z*z == num){
                        System.out.printf("Found solution: x=%d, y=%d, z=%d", x, y, z);
                        System.exit(0);
                    }//End if (x*x*x+y*y*y+z*z*z == num)
        
        System.out.println("Cannot find solution given our limited range");
    }//End public static void main(String[] args)
}//End Public Class Diophantine
