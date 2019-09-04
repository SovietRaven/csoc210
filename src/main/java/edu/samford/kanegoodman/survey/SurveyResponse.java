package edu.samford.kanegoodman.survey;

/**
 *
 * @author pc1
 */
public class SurveyResponse {

    public SurveyResponse(int size) {
        //Attributes
    protected Answer[] answers;
    protected int numanswers;
    }
    
public SurveyResponse(int size){
this.numanswers = 0;
this.answers = new Answer[size];
}
}
