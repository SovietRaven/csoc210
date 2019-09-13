package edu.samford.kanegoodman.survey;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author pc1
 */
public class SurveyResponse {

    
        //Attributes
    protected Answer[] answers;
    protected int numanswers;
   
    
public SurveyResponse(int size){
this.numanswers = 0;
this.answers = new Answer[size];
}

/**
 * Record the answer into our answers array.
 * @param answer 
 */

    public void addAnswer(Answer answer) {
        answers[numanswers++] = answer;
    }
/**
 * Writes the survey responce answers out to a file in this format:
 * 7|I know this topic pretty well.
 * 1|I have no idea what that is.
 * 10|I have done a lot of programs that do file I/O
 * @param filename
 * @throws FileNotFoundException 
 */
    public void save(String filename) throws FileNotFoundException {
        File f = new File(filename);//reference to file to print out name
        PrintWriter out = new PrintWriter(f);
        for (int i = 0; i < numanswers; i++) {
            Answer answer = answers[i];
            out.println(answer.scaleResponse + "|" + answer.additionalResponse);
        }
        out.close();
    }
}
