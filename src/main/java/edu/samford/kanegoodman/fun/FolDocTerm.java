/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.kanegoodman.fun;

/**
 *
 * @author KaneGoodman
 */
public class FolDocTerm implements Comparable{
    // attributes
    protected String term; // the term being defined
    protected String definition;
    
    // constructors
    public FolDocTerm(String term) {
        this.term = term;
    }
    
    public FolDocTerm(String term, String definition) {
    this.term = term;
    this.definition = definition;
}
    
    public void setDefinition(String definition) {
        this.definition = definition;
    }
    
    public String getDefinition() {
        return definition;
    }
    @Override
    public String toString() {
        return term + " - " + definition.length();
    }

    @Override
    public int compareTo(Object o) {
        FolDocTerm other = (FolDocTerm) o;
        return this.term.compareTo(other.term);
    }
}
