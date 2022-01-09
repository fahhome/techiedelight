package techiedelight;

/*

Given the root of a binary tree, convert the binary tree into its mirror.

Input:
		   1
		 /   \
		/	  \
	   2	   3
	  / \	  / \
	 /	 \	 /	 \
	4	  5	6	  7

Output:

		   1
		 /   \
		/	  \
	   3	   2
	  / \	  / \
	 /	 \	 /	 \
	7	  6	5	  4

Explanation:
						|
						|
		   1			|		   1
		 /   \			|		 /   \
		/	  \			|		/	  \
	   2	   3		|	   3	   2
	  / \	  / \		|	  / \	  / \
	 /	 \	 /	 \		|	 /	 \	 /	 \
	4	  5	6	  7		|	7	  6	5	  4
						|
						|
*/

class Solution {
    /*
     * A binary tree node is defined as:
     * 
     * class Node
     * {
     * int data; // data field
     * Node left, right; // pointer to the left and right child
     * 
     * Node() {}
     * Node(int data) { this.data = data; this.left = this.right = null; }
     * }
     */

    public static Node ctm(Node root) {
        if (root == null)
            return null;

        Node lt = ctm(root.left);
        Node rt = ctm(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;

    }

    public static void convertToMirror(Node root) {
        // Write your code here...

        ctm(root);
    }
}
