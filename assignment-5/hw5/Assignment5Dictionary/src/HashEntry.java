// The basic entry stored in ProbingHashTable

class HashEntry {
    Hashable element;   // the element
    boolean  isActive;  // false is deleted

    // Field added by Caleb Krauter
    static int myNodeCount = 0;

    public HashEntry( Hashable e ) {
        this( e, true );
    }

    public HashEntry( Hashable e, boolean i ) {
        incrementNodeCounter();
        element   = e;
        isActive  = i;
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
}
