package techiedelight;

/*

Given the root of a binary tree, check if it is height-balanced or not. In a height-balanced tree, the absolute difference between the height of the left and right subtree for every node is 0 or 1.

Input:
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

Output: true

Input:
		   1
		 /   \
		/	  \
	   2	   3
			  / \
			 /	 \
			5	  6
		   / \
		  /   \
		 7	   8

Output: false

*/

class CheckIfHeightBalanced {
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

    public static int ishb(Node root, int[] ans) {
        if (root == null)
            return 0;

        int lh = 1 + ishb(root.left, ans);
        int rh = 1 + ishb(root.right, ans);

        if (Math.abs(lh - rh) > 1)
            ans[0] = 0;

        return Math.max(lh, rh);

    }

    public static boolean isHeightBalanced(Node root) {
        // Write your code here...
        int[] ans = new int[1];
        ans[0] = 1;

        ishb(root, ans);

        return ans[0] == 1 ? true : false;

    }
}
