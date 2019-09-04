package edu.samford.kanegoodman.survey;

/**
 * Represents a Question in our Survey.
 * @author pc1
 */
public class Question {
    protected String firstPrompt; //the message displayed to the user when the question is asked
    protected int minScale; //the minimum responce value Inclusive
    protected int maxScale; //the manimum responce value Inclusive
    protected String secondPrompt; //the prompt in front of the "open-ended" part of question
    
    // Constuctors (same name as class and no return type)
    /**
     * Initialize to some meaningful defaults
     */
    public Question() {
        // This is the defult constructor b/c it takes no parameters
        firstPrompt = "Please enter something:";
                minScale = 1;
                maxScale = 10;
                secondPrompt = "Additional comments:";
    }//default constructor
    /**
     * Use the given prompt with all the other default attributes. 
     */
    public Question(String firstPrompt) {
        this(); //Calling method (defualt constuctor) that takes no parameters
        this.firstPrompt = firstPrompt;
        //or public Question(String p) and firstPrompt = p
    }//convience constructor
    
    /**
     * Construct a question with these specific attributes.
     */
    public Question(String firstPrompt, int minScale, int maxScale, String secondPrompt){
        this.firstPrompt = firstPrompt;
        this.minScale = minScale;
        this.maxScale = maxScale;
        this.secondPrompt = secondPrompt;
    }//end public Question
    /**
     * Displays the prompt for the main question
     */
    
    public void display() {
        System.out.println(firstPrompt + "[" + minScale + "-" + maxScale + "]");
    }//end public void display
    
    public void displaySecond() {
        System.out.println(secondPrompt);
    }//end public void displaySecond
/**
 * Returns true if the given response is within the range
 * @param scaleResponse - the user supplied response 
 * @return true if scaleResponce between Min and Max
 */
    public boolean checkResponse(int scaleResponse) {
        return scaleResponse>=minScale && scaleResponse<=maxScale;
    }
}//end class Question
