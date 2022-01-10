package techiedelight;
import java.util.*;
/*

Given the root of a binary tree and a tree node x, return values of all ancestors of x in the binary tree. Two nodes of a binary tree are cousins of each other if they have different parents, but they are at the same level.

For example, consider the following binary tree.

			 1
		   /   \
		 /		 \
		2		  3
	  /  \		 /  \
	 /	  \		/	 \
	4	   5   6	  7
			  /		   \
			 /			\
			8			 9

Input: x = Node 9
Output: [7, 3, 1]

Input: x = Node 6
Output: [3, 1]

Input: x = Node 5
Output: [2, 1]

The returned nodes should follow the node-to-root order. The solution should return an empty list if x is not the actual node in the tree.

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

    public static boolean fa(Node root, Node x, List<Integer> ans) {
        if (root == null)
            return false;

        if (root == x)
            return true;

        boolean isFL = fa(root.left, x, ans);
        boolean isFR = fa(root.right, x, ans);

        if (isFL || isFR) {
            ans.add(root.data);
            return true;

        }

        return false;
    }

    public static List<Integer> findAncestors(Node root, Node x) {
        // Write your code here...
        List<Integer> ans = new LinkedList<>();
        fa(root, x, ans);
        return ans;
    }
}
