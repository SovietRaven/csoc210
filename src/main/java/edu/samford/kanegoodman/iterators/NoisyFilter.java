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
 * @author kanegoodman
 */

public class NoisyFilter {

    static DLinkedList<Integer> temps = new DLinkedList<>();

    /**
     * Checking to see what %noiseprob must be to create a greater than 1%
     * difference on avg2. Take averages of mutiple runtime averages with loop
     * and check if grater than 1%
     */
    public static void main(String[] args) {
        double avgOfAverages = 0;
        double prob = 0.01;
        while (avgOfAverages<1.0) {
            double tempX = 0;
            for (int i=0; i<20; i++) {
                temps = new DLinkedList<>();
                generateNoisyData(90, 110, prob);//generates data(low,high,outofbounds prob)
                double avg1 = calculateAverage();//calcs average
                System.out.println("average with noisey data" + avg1);
                filterNoisyData(90, 110);//filters through noisy data (range low and high)
                double avg2 = calculateAverage();//calc data again
                System.out.println("average without noisey data" + avg2);
                double diff = (Math.abs(avg2-avg1) / avg1 * 100);//gives percent error of 1 run
                tempX += diff;//adds up all %errors runs
            }//runs program 20 times
            avgOfAverages = tempX/20;//finds averages of averages
            System.out.println("average of averages: " + avgOfAverages);
            prob = prob + 0.03;//increases prob of error until avgofavg is > 1%
        }//End while < 1% avgofavg
        System.out.println("The average percent of having noisy data required to make at least "
                + "1% error in our overall data is: " + prob*100 + "%");
    }//END public static void main(String[] args)

    /**
     * Generate data between low and high with 1-noisepob probability. Otherwise
     * generate something anomolous
     *
     * @param low
     * @param high
     * @param noiseprob
     */
    private static void generateNoisyData(int low, int high, double noiseprob) {
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < 1000; i++) {
            if (Math.random() < noiseprob) {
                //GENERATE NOISY READING
                //Investigate this number (currently 1%)
                temps.insertLast(r.nextInt(200));//generates # 0-200

            } else {
                //Generate typical summer Alabama reading
                temps.insertLast(low + r.nextInt(high - low));
            }//end else
        }//END for
    }//END private static void generateNoisyData()

    private static double calculateAverage() {
        double total = 0;
        for (Integer temp : temps) {

            total += temp;
        }//Enhansed for loop (fore) works on any for loop that has an iterable
        double average = total / temps.size();
        return average;
    }//END private static void calculateAverage()

    /**
     * Remove any data outside the expected range
     * Note: how the special case of removing the last node in the list is handled.
     * "cur" will be null after next() is called for the last node
     * of if cur==null what the programmer was trying to fo was remove the last node
     * so we fo that for them manually
     */
    private static void filterNoisyData(int low, int high) {
        Iterator<Integer> it = temps.iterator();
        while (it.hasNext()) {
            int temp = it.next();
            if (temp < low || temp > high) {
                it.remove();
            }//Removes noise

        }//End while

    }//END private static void filterNoisyData()

}//END public class NoisyFilterf
