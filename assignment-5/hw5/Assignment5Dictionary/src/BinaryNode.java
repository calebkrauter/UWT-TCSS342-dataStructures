// Basic node stored in unbalanced binary search trees
// Note that this class is not accessible outside
// of package DataStructures

class BinaryNode {

    static int myNodeCount = 0;

    // Constructors
    BinaryNode( Comparable theElement ) {
        this( theElement, null, null );
        myNodeCount++;
    }

    BinaryNode( Comparable theElement, BinaryNode lt, BinaryNode rt ) {
        myNodeCount++;
        element  = theElement;
        left     = lt;
        right    = rt;
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
    BinaryNode left;         // Left child
    BinaryNode right;        // Right child
}
