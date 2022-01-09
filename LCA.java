package techiedelight;

/*

Given the root of a binary tree and two tree nodes, x and y, return the lowest common ancestor (LCA) of x and y in the binary tree.

The lowest common ancestor (LCA) of two nodes x and y in a binary tree is the lowest (i.e., deepest) node that has both x and y as descendants, where each node can be a descendant of itself (so if x is reachable from w, w is the LCA). In other words, the LCA of x and y is the shared ancestor of x and y that is located farthest from the root.

For example, consider the following binary tree.

		   1
		 /   \
		/	  \
	   2	   3
	   \	  / \
		\	 /	 \
		 4	5	  6
		   / \
		  /   \
		 7	   8

Input: x = Node 6, y = Node 7
Output: Node 3
Explanation: The common ancestors of nodes 6 and 7 are 1 and 3. Out of nodes 1 and 3, the LCA is 3 as it is farthest from the root.

Input: x = Node 5, y = Node 8
Output: Node 5
Explanation: Node 8 itself is descendant of node 5 (and node 5 can be a descendant of itself).

Input: x = Node 2, y = Node 5
Output: Node 1

Note: The solution should return null if either x or y is not the actual node in the tree.

*/

class LCA {
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

    public static boolean flca(Node root, Node x, Node y, Node[] ans) {
        if (root == null)
            return false;

        boolean isFH = ((x == root) || (y == root)) ? true : false; //Is Found Here?
        boolean isFL = flca(root.left, x, y, ans); // Is Found in left?
        boolean isFR = flca(root.right, x, y, ans); // Is found in right subtree?

        int count = 0;
        if (isFH == true)
            count++;
        if (isFL == true)
            count++;
        if (isFR == true)
            count++;

        if (count >= 2) {
            // If condition, since it is recursive calls, the below lines will execute first
            // for
            // a node at a lower level and hence it need not be updated by a node at a
            // higher level
            // since we are looking for the LCA
            if (ans[0] == null)
                ans[0] = root;
        }

        // The condition where x & y == 1
        if (x == y && count >= 1) {
            if (ans[0] == null)
                ans[0] = root;
        }

        // The return logic is different from the meat(line 67 to line 81) logic
        return isFL || isFH || isFR;

    }

    public static Node findLCA(Node root, Node x, Node y) {
        // Write your code here...
        Node[] ans = new Node[1];
        ans[0] = null;
        flca(root, x, y, ans);
        return ans[0];
    }
}
