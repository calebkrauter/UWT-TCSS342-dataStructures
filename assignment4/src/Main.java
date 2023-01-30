// Java program to demonstrate

// insert operation in binary
// search tree
// BST code provided by https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
class BinarySearchTree {

    /* Class containing left
    and right child of current node
    * and key value*/
    class Node {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() { root = null; }

    BinarySearchTree(int value) { root = new Node(value); }

    // This method mainly calls insertRec()
    void insert(int key) { root = insertRec(root, key); }

    /* A recursive function to
    insert a new key in BST */
    Node insertRec(Node root, int key)
    {

		/* If the tree is empty,
		return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        else if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() { inorderRec(root); }

    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

		/* Let us create following BST
			50
		/	 \
		30	 70
		/ \ / \
	20 40 60 80
	            \
	              89*/

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // print inorder traversal of the BST
        tree.inorder();

        System.out.println(countNullPointers(tree.root));
    }

    /**
     * Counts null pointers in a given Binary Search Tree.
     * @param root of the tree
     * @return sum of all null pointers.
     */
    public static int countNullPointers(Node root) {

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
// This code is contributed by Ankur Narain Verma
