// Basic node stored in unbalanced binary search trees
// Note that this class is not accessible outside
// of package DataStructures

class BinaryNode {

    static int nodeCounter = 0;

    // Constructors
    BinaryNode( Comparable theElement ) {
        this( theElement, null, null );
        nodeCounter++;
    }

    BinaryNode( Comparable theElement, BinaryNode lt, BinaryNode rt ) {
        nodeCounter++;
        element  = theElement;
        left     = lt;
        right    = rt;
    }

    // Method implemented by Caleb Krauter
    public void incrementNodeCounter() {
        nodeCounter++;
    }

    // Method implemented by Caleb Krauter
    public int getNodeCount() {
        return nodeCounter;
    }

    // Friendly data; accessible by other package routines
    Comparable element;      // The data in the node
    BinaryNode left;         // Left child
    BinaryNode right;        // Right child
}
