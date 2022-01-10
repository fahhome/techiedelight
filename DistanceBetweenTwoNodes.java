package techiedelight;

/*

Given the root of a binary tree and two tree nodes, x and y, return the distance between x and y in the binary tree. The distance between two nodes is defined as the total number of edges in the shortest path from one node to other.

For example, consider the following binary tree.

		  1
		/   \
	   /	 \
	  2		  3
	   \	 / \
		4   5   6
		   /	 \
		  7		  8

Input: x = Node 7, y = Node 6
Output: 3

Input: x = Node 4, y = Node 8
Output: 5

Input: x = Node 5, y = Node 5
Output: 0

Note: The solution should return a negative value if either x or y is not the actual node in the tree.

*/

class DistanceBetweenTwoNodes {
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

    // O(n) solution 
    public static int fd(Node root, Node x, Node y, int[] ans) {

        if (root == null)
            return -10;

        int hh = (root == x || root == y) ? 0 : -10;
        int lh = 1 + fd(root.left, x, y, ans);
        int rh = 1 + fd(root.right, x, y, ans);
        
        // If  hh == 0 , then only one of lh and rh > 0 
        if (hh == 0 && (lh > 0 || rh > 0)) {
            if (ans[0] < 0) {
                ans[0] = Math.max(lh, rh);
            }
        }

        if (lh > 0 && rh > 0) {
            if (ans[0] < 0) {
                ans[0] = lh + rh;
            }
        }

        if (hh == 0)
            return 0;

        if (lh > 0)
            return lh;

        return rh; // Either rh is positive( either x or y is found in the right tree) or -ve(x & y are not found in the entire tree from this current root)

    }

    public static int findDistance(Node root, Node x, Node y) {
        // Write your code here...
        int[] ans = new int[1];
        ans[0] = -1;
        if (x == y)
            return 0;
        fd(root, x, y, ans);
        return ans[0];
    }
}
