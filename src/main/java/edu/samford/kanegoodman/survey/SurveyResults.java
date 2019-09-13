/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.kanegoodman.survey;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author pc1
 */
public class SurveyResults {
//Attributes
protected Survey survey;
protected SurveyResponse responses[];
protected int numresponses;
public static int MAXFILES = 100; //assume that will will never have more than 100 files to parse

   public SurveyResults(Survey survey) {
this.survey = survey;
this.numresponses = 0;        
this.responses = new SurveyResponse[MAXFILES];
    }//end public SurveyResults(Survey survey)
/**
*Read all the responses from text files in the given directory
*@path the relative path where all the responses are stored
*/

public void readResponses(String path) throws FileNotFoundException{
    File dir = new File(path);
    File files[] = dir.listFiles();
    for (File file : files){
        if (file.isFile()) {
            Scanner filein = new Scanner(file);
            SurveyResponse response = new SurveyResponse(survey.numquestions);
            int qi=0; //current question number (index)
            while(filein.hasNextLine()){
                String line = filein.nextLine();
               
                String parts[] = line.split("\\|");
                 if (parts.length!=2){
                    continue;
                }
                int scaleResponse = Integer.parseInt(parts[0]);
                Answer answer = new Answer(survey.questions[qi], scaleResponse, parts[1]);
                qi++; //advance to the next question
                response.addAnswer(answer);
                
            }//End while(filein.hasNextLine())
            responses[numresponses++] = response;
        }//End if (file.isFile())
    }//End for (File file : files)

}//End public void readResponses(String path)
/**
 * Process all the responses by calculating the averages and joining all of the freeform responses by pipes and displays everything
 */
public void processResponses(){
    //Data we need for the calculations
    double totals[] = new double[survey.numquestions];
    double averages[] = new double[survey.numquestions];
    String comments[] = new String[survey.numquestions];
    
    for (SurveyResponse response : responses){
        if (response!=null)
        for (int qi=0; qi<response.numanswers; qi++){
            totals[qi] += response.answers[qi].scaleResponse;
            comments[qi] += response.answers[qi].additionalResponse;
            
        }//End for (int qi=0; qi<response.numanswers; qi++)
    }//End for (SurveyResponse response : responses)
    
    //Calculate the averages by dividing all of the totals by the number of averages
    for (int ti=0; ti< totals.length; ti++){
        totals[ti] = totals[ti] / numresponses;
    }//End for (int ti=0; ti< totals.length; ti++)
    
    for (int qi=0; qi<survey.numquestions; qi++){
        Question q = survey.questions[qi];
        System.out.println(q.firstPrompt + " - " + totals[qi] + " - " + comments[qi]);
        
    }   
}//End public void processResponses()
}//End public class SurveyResults 
