// Basic node stored in AVL trees
// Note that this class is not accessible outside
// of package DataStructures

class AvlNode {

    int myNodeCount = 0;

    // Constructors
    AvlNode( Comparable theElement ) {
        this( theElement, null, null );
    }

    AvlNode( Comparable theElement, AvlNode lt, AvlNode rt ) {
        incrementNodeCounter();

        element  = theElement;
        left     = lt;
        right    = rt;
        height   = 0;
    }

    // Method implemented by Caleb Krauter
    public void incrementNodeCounter() {
        setNodeCount(myNodeCount + 1);
    }

    // Method implemented by Caleb Krauter
    public void setNodeCount(int nodeCount) {
        myNodeCount = nodeCount;
    }

    // Method implemented by Caleb Krauter
    public int getNodeCount() {
        return myNodeCount;
    }

    // Friendly data; accessible by other package routines
    Comparable element;      // The data in the node
    AvlNode    left;         // Left child
    AvlNode    right;        // Right child
    int        height;       // Height
}
