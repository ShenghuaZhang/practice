package tree.binarysearchtree;

/*******************************************************************************
Main Class File:  AddressBook.java 
File:             BST.java

Author:           Justin Goetz jgoetz@mhub.doit.wisc.edu
Collaborators:    None

Due Date:         Monday, Nov 18, 2002
Completion Date:  11/18/02

Course:           CS367, Fall 2002, Section 2
Assignment:       Programming Assignment 4

Editor:           emacs
Compiler:         javac
Platform:         Windows XP (SecureCRT)
*******************************************************************************/
// A ruler to help you keep your code within 80 columns:
//345678 112345678 212345678 312345678 412345678 512345678 612345678 712345678 8

/**
 * This class implements a Binary Search Tree for the AddressBook 
 * application.
 *
 *@author Justin Goetz
 **/
public class AddressBookBST implements Dictionary {

    public BSTNode root; // Pointer to root node of the tree

    /**
     * This is the default constructor for the BST class
     **/
    public AddressBookBST() {
	root = null;
    }

     /**
     * Adds the given item to the dictionary.  If the item is already in
     * the dictionary, a <code>DuplicateException</code> is thrown.
     *
     * @param item the key/data for the item to add to the dictionary
     * @throws <code>DuplicateException</code> if the item is already in the
     * dictionary
     **/
    public void insert(Comparable item) {
	// If there is no root, create one, otherwise insert into the tree
	if(root == null)
	    root = new BSTNode(item);
	else
	    insert(root,item);
    }

    /**
     * Adds the given item into the dictionary, if it is already in the
     * Dictionary, a DuplicateException is thown
     * 
     * @param n the node to try and insert under
     * @param item the item to insert
     * @throws duplicate exception
     **/
    private void insert(BSTNode n,Comparable item) {
	// Check to see if item is already in the tree
	if(n.key.compareTo(item) == 0) {
	}
	// Try to insert into left or right subtree
	if(item.compareTo(n.key) < 0) {
	    if(n.left == null)
		n.left = new BSTNode(item);
	    else
		insert(n.left,item);
	}
	else {
	    if(n.right == null) 
		n.right = new BSTNode(item);
	    else
		insert(n.right,item);
	}
    }

     /**
     * Determines if the given item is in the dictionary and returns it
     * if present.
     *
     * @param item the key/data for the item desired
     * @return the key/data if the item is found and null if not found
     **/
    public Object lookup(Comparable item) {
	if( item == null )
	    return  null;
	return lookup(root,item);
    }

    /**
     * Determines if the given item is in the dictionary and returns
     * it if present.
     *
     * @param n the node to check
     * @param item the key to look for
     * @return the object if it is found, else null
     **/
    private Object lookup( BSTNode n, Comparable item ) {
	if(n == null)
	    return null;
	if(n.key.compareTo(item) == 0) 
	    return n.key;
	if(item.compareTo(n.key) < 0)
	    return lookup(n.left,item);
	return lookup(n.right,item);
    }

     /**
     * Removes and returns the given item from the dictionary.
     *
     * @param item the key/data for the item to remove from the dictionary
     * @return the item removed from the dictionary if it was found, null
     *         otherwise
     **/
    public Comparable delete(Comparable item) {
	Comparable tmp;

	if(item == null)
	    return null;
	
	tmp = (Comparable) lookup(root,item);
	if(tmp != null)
	   root = delete(root,tmp);
	return tmp;
    }
    
    /**
     * Removes the item and returns the correct Binary tree node
     * in order to keep the tree structure
     *
     * @param n the node to check
     * @param item the item to remove
     * @return the correct BST node
     **/
    private BSTNode delete(BSTNode n,Comparable item) {
	// If tree is null, do no work
	if(n == null)
	    return n;
	
	// If found, see what can be performed on tree
	if(n.key.compareTo(item) == 0) {
	    if(n.left == null && n.right == null)
		return null;
	    if(n.left == null)
		return n.right;
	    if(n.right == null)
		return n.left;
	    // Node has two children, find inorder successor
	    n.key = smallestKey(n.right);
	    n.right = delete(n.right,n.key);
	    return n;
	}
	else if(item.compareTo(n.key) < 0) {
	    n.left = delete(n.left,item);
	    return n;
	}
	else {
	    n.right = delete(n.right,item);
	    return n;
	}
    }

    /**
     * This method finds the smallest node in a binary search tree
     *
     * @param n the root of the tree to check for
     * @return the smallest key in the tree
     **/
    private Comparable smallestKey(BSTNode n) {
        if(n.left == null)
	    return n.key;
        return smallestKey(n.left);
    }

     /**
     * Prints all the key/data items in the specified range in sorted order
     * from smallest to largest to the PrintWriter given.  When an item is 
     * printed the key/data is output by converting it to a String.
     * 
     * @param begin the minimum key/data value.  Only items in the ordered 
     *        list that are greater than or equal to begin (according to the
     *        compareTo method) will be printed.
     * @param end the maximum key/data value.  Only items in the ordered 
     *        list that are less than or equal to end (according to the
     *        compareTo method) will be printed.
     * @param p the PrintWriter to which to send the output
     **/
    public void printRange(Comparable begin, Comparable end, 
			   java.io.PrintWriter p) {
       	printRange(root,begin,end,p);
    }

    /**
     * This method prints all of the data that is between the specified
     * beginning and end keys (inclusive)
     *
     * @param n the root of the tree to try and print from
     * @param begin the beginning key to print from
     * @param end the ending key to print from
     * @param p the printwriter to print to
     **/
    private void printRange(BSTNode n, Comparable begin, Comparable end,
			    java.io.PrintWriter p) {
       	// if there is no node or begin node is greater than end node,
	// do nothing
	if(n == null || (begin.compareTo(end) > 0)) {
	    return;
	}
	
	// If the current node is greater than the begin node, check it's
	// left subtree for values to print
        if(begin.compareTo(n.key) < 0) 
		printRange(n.left,begin,end,p);
	
	// If the node is between the begin and end node and or equal
	// to one or both, print this node
	if(n.key.compareTo(begin) >= 0 && n.key.compareTo(end) <= 0) 
		p.println(n.key);

	// If the current node is less than the end node, check it's right
	// subtree for values to print
	if(end.compareTo(n.key) > 0) 
		printRange(n.right,begin,end,p);
    }

     /**
     * Prints all the key/data items in the ordered list in sorted order from 
     * smallest to largest to the PrintWriter given.  When an item is printed 
     * the key/data is output by converting it to a String.
     *
     * @param p the PrintWriter to which to send the output
     **/
    public void printAll(java.io.PrintWriter p) {
	printAll(root,p);
    }

    /**
     * This method prints all of the keys in the tree in order
     *
     * @param n the root node of the tree
     * @param p the printwriter to print to
     **/
    private void printAll(BSTNode n, java.io.PrintWriter p) {
	if(n == null) 
	    return;
	printAll(n.left,p);
	p.println(n.key);
        printAll(n.right,p);
    }

} // end of BST class


/**
 * This class is used to create the Binary Search Tree Nodes
 *
 * <p>Bugs: none known
 * @author Justin Goetz
 **/
class BSTNode {

    Comparable key;      // Holds the key of each node
    BSTNode left,right;  // Holds the pointers for left and right child

    /**
     * Constructor used for node with null child pointers
     *
     * @param k the key for the node
     **/
    public BSTNode( Comparable k ) {
	this(k,null,null);
    }

    /**
     * The main constructor for the BSTNode class
     *
     * @param k the node's key
     * @param l the nodes left child pointer
     * @param r the nodes right child pointer
     **/
    public BSTNode( Comparable k, BSTNode l, BSTNode r) {
        key = k;
        left = l;
	right = r;
    }
}