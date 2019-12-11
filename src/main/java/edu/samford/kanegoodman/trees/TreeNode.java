/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.kanegoodman.trees;

/**
 *
 * @author kanegoodman
 */
    public interface TreeNode<T> {
    public T element(); // Returns reference to the data we are storing
    public TreeNode<T> parent(); // Returns the reference to the parent NODE
    public TreeNode<T>[] children(); // returns an array of child Node references (multiple nodes)
    public boolean isLeaf(); // Returns true if this is a leaf node
    }
