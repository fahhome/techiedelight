package techiedelight;
import java.util.*;

/*

Given an integer array representing a binary tree, where the parent-child relationship is defined by (A[i], i) for every index i in the array A, build a binary tree out of it. The root node's value is i if -1 is present at index i in the array.

Input: [-1, 0, 0, 1, 2, 2, 4, 4]

Output:

		   0
		 /   \
		/	  \
	   1	   2
	  /		  / \
	 /	  	 /	 \
	3		4	  5
		   / \
		  /   \
		 6	   7

Explanation:

• -1 is present at index 0, which implies that the binary tree root is node 0.
• 0 is present at index 1 and 2, which implies that the left and right children of node 0 are 1 and 2.
• 1 is present at index 3, which implies that the left or the right child of node 1 is 3.
• 2 is present at index 4 and 5, which implies that the left and right children of node 2 are 4 and 5.
• 4 is present at index 6 and 7, which implies that the left and right children of node 4 are 6 and 7.

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

    public static void build(Node root, HashMap<Integer, int[]> pcmap) {
        if (root == null)
            return;

        System.out.println(root.data);
        if (!pcmap.containsKey(root.data))
            return;

        int[] childs = pcmap.get(root.data);
        System.out.println("The children of " + root.data + " are : " + childs[0] + ", " + childs[1]);

        if (childs[0] != -2) {
            root.left = new Node(childs[0]);
        }

        if (childs[1] != -2) {
            root.right = new Node(childs[1]);
        }

        build(root.left, pcmap);
        build(root.right, pcmap);

    }

    public static Node constructBinaryTree(int[] parent) {
        // Write your code here...
        int len = parent.length;
        HashMap<Integer, int[]> pcmap = new HashMap<>();
        Node root = null;
        for (int i = 0; i < len; i++) {

            if (pcmap.containsKey(parent[i])) {
                int[] oldarr = pcmap.get(parent[i]);
                oldarr[1] = i;
                if (parent[i] == -1)
                    root = new Node(i);
            } else {
                int[] narr = new int[2];
                narr[0] = -2;
                narr[1] = -2;
                narr[0] = i;
                pcmap.put(parent[i], narr);
                if (parent[i] == -1)
                    root = new Node(i);
            }
        }

        build(root, pcmap);

        return root;

    }
}
