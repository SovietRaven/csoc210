package edu.samford.kanegoodman.lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author KaneGoodman
 */
public class PreformanceComparison {
    public static final int MAX = 1_000_000;
    
    public static void main(String[] args) throws FileNotFoundException {
        //0. set aside a couple of longs for instrumentation
        long start = 0;
        long finish = 0;
        long arraytime = 0;
        long listtime= 0;

        // 1. generate a lot of data
        try{
        generateData();
        } catch(Exception e){
            e.printStackTrace();
        }
        
        //2. prepare output for excel
        System.out.println("operation,array,linkedlist");
        
        // 3. start measuring ... construction first
        start = System.currentTimeMillis();
        double nums[] = new double[MAX];
        finish = System.currentTimeMillis();
        arraytime = finish - start;
        start = System.currentTimeMillis();
        DLinkedList<Double> numlist = new DLinkedList<>();
        
        finish = System.currentTimeMillis();
        listtime = finish - start;
        System.out.println("construction,"+arraytime+","+listtime);
        File f = new File("randomnums.txt");
        Scanner filein = new Scanner(f);
        int i = 0;
        arraytime = 0;
        listtime = 0;
        //inserted at the end
        while(filein.hasNextDouble()){
            double d = filein.nextDouble();
            
            start = System.nanoTime();
            numlist.insertLast(d);
            finish = System.nanoTime();
            listtime += (finish-start);
            
            start = System.nanoTime();
            nums[i++] = d;
            finish = System.nanoTime();
            arraytime += (finish-start);
           
        }//End while(filein.hasNextLine()
        System.out.println("populating,"+arraytime/1_000_000+","+listtime/1_000_000);
        
        // inseting an item at the beginning of each data structure
        double newItem = Math.random();
        start = System.nanoTime();
        numlist.insertFirst(newItem);
        finish = System.nanoTime();
        listtime = finish-start;
        
        start = System.nanoTime();
        double tmp[] = new double[nums.length+1];
        for (int j = 1; j < tmp.length; j++) {
           tmp[j] = nums[j-1];
            
        }//End forj
        nums = tmp;
        nums[0] = newItem;
        finish = System.nanoTime();
        arraytime = finish-start;
        System.out.println("insert beginning,"+arraytime/1_000_000+","+listtime/1_000_000);
        
        //inserting an item in the middle of each data structure
        newItem = Math.random();
         start = System.nanoTime();
         tmp = new double[nums.length+1];
         for(int k = 0; k<tmp.length/2; k++){
             tmp[k] = nums[k];
         }
        for (int j = 1+tmp.length/2; j < tmp.length; j++) {
           tmp[j] = nums[j-1];
            
        }//End forj
        nums = tmp;
        nums[tmp.length/2] = newItem;
        finish = System.nanoTime();
        arraytime = finish-start;
        
        start = System.nanoTime();
        int theMiddle = numlist.size()/2;
        DNode cur = numlist.first();
        i = 0;
        while(i<theMiddle){
            cur = cur.getNext();
            i++;
        }//End while(i<theMiddle)
        numlist.insertAfter(cur, newItem);
        finish = System.nanoTime();
        listtime = finish-start;
         System.out.println("insert middle,"+arraytime/1_000_000+","+listtime/1_000_000);
        
        //Removing from Beginning
  
        start = System.nanoTime();

        tmp = new double[nums.length-1];
        for (int j = 1; j < tmp.length; j++) {
        tmp[j] = nums[j+1];
        }
        finish = System.nanoTime();
        arraytime = finish-start;
        
        
        
        start = System.nanoTime();
        numlist.remove(numlist.first());
        finish = System.nanoTime();
        listtime = finish-start;
        System.out.println("Remove Beginning,"+arraytime/1_000_000+","+listtime/1_000_000);
    
        //Remove from Middle
        //list first
        start = System.nanoTime();
        theMiddle = numlist.size()/2;
        cur = numlist.first();
        i = 0;
        while(i<theMiddle){
            cur = cur.getNext();
            i++;
        }//End while(i<theMiddle)
        numlist.remove(cur);
        finish = System.nanoTime();
        listtime = finish-start;
        
        start = System.nanoTime();
        
         tmp = new double[nums.length-1];
         for(int k = 0; k<tmp.length/2; k++){
             tmp[k] = nums[k];
         }//gives first half before the middle?
        for (int k = 1+tmp.length/2; k < tmp.length; k++) {
           tmp[k] = nums[k+1];
            
        }//End forj gives second half after middle?
        
        finish = System.nanoTime();
        arraytime = finish-start;
        System.out.println("Remove Middle,"+arraytime/1_000_000+","+listtime/1_000_000);
        
//Remove from End

        start = System.nanoTime();
        tmp = new double[nums.length-1];
        for (int l = 0; l < tmp.length-1; l++) {
        tmp[l] = nums[l];
        }
        finish = System.nanoTime();
        arraytime = finish-start;
        
        start = System.nanoTime();
        numlist.remove(numlist.last());
        finish = System.nanoTime();
        listtime = finish-start;
        System.out.println("Remove End,"+arraytime/1_000_000+","+listtime/1_000_000);
        
//replacing at any position(pick one and can hard code)

        start = System.nanoTime();
        nums[nums.length/2] = Math.random();
        finish = System.nanoTime();
        arraytime = finish-start;
        
        
        start = System.nanoTime();
        theMiddle = numlist.size()/2;
        cur = numlist.first();
        i = 0;
        while(i<theMiddle){
            cur = cur.getNext();
            i++;
        }//End while(i<theMiddle)
        numlist.replace(cur, Math.random());
        finish = System.nanoTime();
        listtime = finish-start;
        System.out.println("Replace middle,"+arraytime/1_000_000+","+listtime/1_000_000);
//to add in excell drag control c and open excell paste contol v use [DO NOT WANT SPACE BUT WANT COMMAS and CHART using data ] text import wizard next comma finish
    }//End psvm

    private static void generateData() throws FileNotFoundException {
        File f = new File("randomnums.txt");
        PrintWriter out = new PrintWriter(f);
        for(int i=0; i<MAX; i++)
        out.println(Math.random());
        out.close();
        
    }//End  private static void generateData()
    
}//End public class PreformanceComparison
