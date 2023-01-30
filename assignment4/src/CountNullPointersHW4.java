public class CountNullPointersHW4 {
    /**
     * Counts null pointers in a given Binary Search Tree.
     * @param root of the tree
     * @return sum of all null pointers.
     */
    public static int countNullPointers(BinarySearchTree.Node root) {

        // Check if the root is a leaf. If it is, return 2 for the two null pointers.
        if (root.left == null && root.right == null) {
            return 2;

            // Check if left of root is null, if it is, return a call on the function
            // and add 1 for the null pointer.
        } else if (root.left == null) {
            return countNullPointers(root.right) + 1;

            // Check if right of root is null, if it is, return a call on the function
            // and add 1 for the null pointer.
        } else if (root.right == null) {
            return countNullPointers(root.left) + 1;

            // If the node has two children check the subtrees for null pointers and add
            // the sum of the null pointers.
        } else {
            return countNullPointers(root.left) + countNullPointers(root.right);
        }
    }
}
