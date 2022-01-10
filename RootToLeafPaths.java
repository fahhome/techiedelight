package techiedelight;
import java.util.*;
/*

Given the root of a binary tree, return all paths from the root node to every leaf node in the binary tree.

Input:

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

Output: {[1, 2, 4], [1, 2, 5], [1, 3, 6, 8], [1, 3, 7, 9]}

Explanation: The binary tree has four root-to-leaf paths:

1 —> 2 —> 4
1 —> 2 —> 5
1 —> 3 —> 6 —> 8
1 —> 3 —> 7 —> 9

*/

class RootToLeafPaths {
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

    public static void frll(Node root, Set<List<Integer>> paths, LinkedList<Integer> path) {

        if (root.left == null && root.right == null) {
            paths.add(new LinkedList<>(path));
            return;
        }

        if (root.left != null) {
            path.add(root.left.data);
            frll(root.left, paths, path);
            path.removeLast();
        }

        if (root.right != null) {
            path.add(root.right.data);
            frll(root.right, paths, path);
            path.removeLast();
        }

    }

    public static Set<List<Integer>> findRootToLeafPaths(Node root) {
        Set<List<Integer>> paths = new HashSet<>();
        LinkedList<Integer> path = new LinkedList<>();
        // Write your code here...
        if (root == null)
            return paths;
        path.add(root.data);
        frll(root, paths, path);

        return paths;
    }
}
