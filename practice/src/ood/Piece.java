package ood;
/**
 * http://www.bowdoin.edu/~ltoma/teaching/cs210/fall07/Labs/Tetris/tetris1/Piece.java
 * 
 */
import java.awt.*;
import java.util.*;

/**
 * An immutable representation of a Tetris piece in a particular rotation.
 * Each piece is defined by the blocks that make up its body.
 * See the Tetris-Architecture.html for an overview.
 * 
 * This is the starter file version -- a few simple things are filled in already
*/
public final class Piece {
 /*
   Implementation notes:
   -The starter code does out a few simple things for you
   -Store the body as a Point[] array
   -Do not assume there are 4 points in the body -- use array.length
   to keep the code general
 */
 
 private Point[] body;    
 // The body of the piece, each point is a coordinate specifying a block

 private int[] skirt;     
 // Each element specifies how high the piece will land in the corresponding column

 private int	width;	// The width of the piece for the current rotation

 private int	height;	// The height of the piece for the current rotation

 private Piece next;	// The "next" rotation - note this is how a "piece" is really a list
 
 static private Piece[] pieces;	// singleton array of first rotations
	
 
 /**
    Defines a new piece given the Points that make up its body.
    Makes its own copy of the array and the Point inside it.  Does
    not set up the rotations.
    
    This constructor is PRIVATE -- if a client wants a piece
    object, they must use Piece.getPieces().  getPieces() will
    therefore make all of the calls to the constructor.
    
    As with all constructors, your variables should be initialized
    here.  This means you'll need to calculate width and height as
    well as setting up the skirt (doing these things once in the
    constructor means you don't have to do them on the fly during
    game play).  The one exception to this is the "next" variable.
    You'll want to set that in the pieceRow method.
 */
 private Piece(Point[] points) {
 }	
 
 
 /**
    Returns the width of the piece measured in blocks.
 */
 public int getWidth() {
	return(width);
 }
 
 /**
    Returns the height of the piece measured in blocks.
 */
 public int getHeight() {
	return(height);
 }
 
 /**
    Returns a pointer to the piece's body. The caller
    should not modify this array.
 */
 public Point[] getBody() {
	return(body);
 }
 
 /**
    Returns a pointer to the piece's skirt. For each x value across
    the piece, the skirt gives the lowest y value in the body.
    This useful for computing where the piece will land.  The
    caller should not modify this array.
 */
 public int[] getSkirt() {
	return(skirt);
 }
 
 
 /**
    Returns a piece that is 90 degrees counter-clockwise rotated
    from the receiver.
    
    Implementation: The Piece class pre-computes all the rotations
    once.  This method just hops from one pre-computed rotation to
    the next in constant time.
 */	
 public Piece nextRotation() {
	return next;
 }
 
 
 /**
    Returns true if two pieces are the same -- their bodies contain
    the same points.  Interestingly, this is not the same as having
    exactly the same body arrays, since the points may not be in
    the same order in the bodies. Used internally to detect if two
    rotations are effectively the same.
 */
 public boolean equals(Piece other) {
	 return false;
 }
 
 /**
  *  This is where most of your work will be done.  pieceRow takes
  *  the initial rotation of a piece and should create all of the
  *  rest of the rotations in a kind of circular list.  Essentially
  *  you get the body array of the initial configuration of the
  *  Piece, you need to calculate the other body arrays.
 */
 public static Piece pieceRow(Piece starter) {
	 return null;
 }

	
 /**
    Returns an array containing the first rotation of each of the 7
    standard tetris pieces.  The next (counterclockwise) rotation
    can be obtained from each piece with {@link #nextRotation()}.  In this
    way, the client can iterate through all the rotations until
    eventually getting back to the first rotation.
 */
 public static Piece[] getPieces() {
	// Makes seven calls to pieceRow for each of the seven standard Tetris pieces.  Places
	// the results of each call into an array and returns the array.
	pieces = new Piece[] {
	    pieceRow(new Piece(parsePoints("0 0	0 1	0 2	0 3"))),	// 0
	    pieceRow(new Piece(parsePoints("0 0	0 1	0 2	1 0"))),	// 1
	    pieceRow(new Piece(parsePoints("0 0	1 0	1 1	1 2"))),	// 2
	    pieceRow(new Piece(parsePoints("0 0	1 0	1 1	2 1"))),	// 3
	    pieceRow(new Piece(parsePoints("0 1	1 1	1 0	2 0"))),	// 4
	    pieceRow(new Piece(parsePoints("0 0	0 1	1 0	1 1"))),	// 5
	    pieceRow(new Piece(parsePoints("0 0	1 0	1 1	2 0"))),	// 6
	};
	return pieces;
 }
 
 
 /**
    Given a string of x,y pairs ("0 0 0 1 0 2 1 0"), parses the
    points into a Point[] array.  (Provided code)
 */
 @SuppressWarnings("unchecked")
private static Point[] parsePoints(String string) {

	@SuppressWarnings("rawtypes")
	Vector points = new Vector();
	StringTokenizer	tok = new StringTokenizer(string);
	try {
	    while(tok.hasMoreTokens()) {
		int x = Integer.parseInt(tok.nextToken());
		int y = Integer.parseInt(tok.nextToken());
		
		points.addElement(new Point(x, y));
	    }
	}
	catch (NumberFormatException e) {
	    throw new RuntimeException("Could not parse x,y string:" + string);	
	    // cheap way to do assert
	}
	
	// Make an array out of the Vector
	Point[] array = new Point[points.size()];
	points.copyInto(array);
	return(array);
 }
 
}