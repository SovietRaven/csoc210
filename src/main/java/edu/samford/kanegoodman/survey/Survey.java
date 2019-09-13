package edu.samford.kanegoodman.survey;

import java.util.Scanner;

/**
 * Represents a survey of Questions
 * @author pc1
 */
public class Survey {
    // Attributes
    protected Question[] questions;
    protected int numquestions; //size of survey in number of questions
    
    // Default constructor
    public Survey() {
        this(10); // defaults to an array with room for 10 questions
    }
    public Survey(int size){
        this.numquestions = 0;
        questions = new Question[size];
    }
    
    /**
     * Adds a new Question to our array of questions using the given prompt
     * and all the other defaults for a question
     * @param prompt 
     */
    public void addQuestion(String prompt) {
        // 1. Create the question
        Question q = new Question(prompt);
        
            
        
        //2. Add the question to the "end" of our array
        questions[numquestions++] = q;
        
    }
    /**
     * Asks all the questions in the survey and gets answers
     * to each question and puts all the answers into a new
     * SurveyResponse object.
     * @return 
     */
    public SurveyResponse conduct() {
        //1. create the new empty SurveyResponse
        SurveyResponse response = new SurveyResponse(this.questions.length);
        
        //1.5 go ahead and create the scanner object our answer will use to get all of the answers
        Scanner stdin = new Scanner(System.in);
        //2. Repeat the following for all questions:
        //  a. Ask a question (both parts)
        //  b. Get the snaswers to both parts
        //  c. Add the answer to the survey response
        for (int i = 0; i < numquestions; i++) {
            Question question = questions[i];
            question.display(); //tell the question to display prompt
            Answer answer = new Answer(question);
            answer.getScaleResponse(stdin);
            question.displaySecond();
            answer.getSecondScaleResponse(stdin);
            response.addAnswer(answer);
            
        }
        //3. Return the now-completed response
        return response;
    }
}
