// Basic node stored in AVL trees
// Note that this class is not accessible outside
// of package DataStructures

class AvlNode {

    static int nodeCounter = 0;
    // Constructors
    AvlNode( Comparable theElement ) {
        this( theElement, null, null );
        nodeCounter++;
    }

    AvlNode( Comparable theElement, AvlNode lt, AvlNode rt ) {
        nodeCounter++;
        element  = theElement;
        left     = lt;
        right    = rt;
        height   = 0;
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
    AvlNode    left;         // Left child
    AvlNode    right;        // Right child
    int        height;       // Height
}
