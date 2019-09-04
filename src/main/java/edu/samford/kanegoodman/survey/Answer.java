package edu.samford.kanegoodman.survey;

import java.util.Scanner;

/**
 * Represents the answer to a survey question.
 *
 * @author pc1
 */
public class Answer {

    //Attributes
    Question q;        // reference to the question being answered
    int scaleResponse; // user selected response ... should be within q's range
    protected String additionalResponse; //user commments

    /**
     * Convenience constructor that provides meaningful defaults
     */
    public Answer(Question q) {
        this.q = q;
        this.scaleResponse = q.minScale;
        this.additionalResponse = "N/A";
    }//end Public Answer(Question q)

    /**
     * Retrieve the anser to the scale question from stdin (i.e., the keyboard
     * and store the answer scaleResponse attribute
     * @param stdin 
     */
    public void getScaleResponse(Scanner stdin) {
        //1. Get the user response (for the scale prompt)
        //2. Check the response to make sure it is within the question's range
        //3. If not, display error message and go back tro step 1
        do{
           scaleResponse = Integer.parseInt(stdin.nextLine());
           if (!q.checkResponse(scaleResponse)){
               System.out.println("Please try again. Outside valid range.");
           }
        } while (!q.checkResponse(scaleResponse));
    }//End Public void getResponses(Scanner stdin)
    /**
     * Stores the second responce in the additionalResponse attribute.
     * @param stdin 
     */
    public void getSecondScaleResponse (Scanner stdin){
        additionalResponse = stdin.nextLine();
    }//end public void getSecondScaleResponse (Scanner stdin)
}//End public class Answer
