package techiedelight;
import java.util.*;
/*

Given the root of a binary tree, return the sum of all nodes for each diagonal having negative slope `\`. Assume that the left and right child of a node makes a 45–degree angle with the parent.

Input:
				 1
			 .		 .
		   .		   .
		 2				 3
	   .			   .	.
	 .				 .		  .
   4			   5			6
				 .   .
			   .	   .
			 7			 8

Output: [10, 15, 11]

Explanation: The binary tree has three diagonals - [1, 3, 6], [2, 5, 8], and [4, 7]. The sum of diagonals is 10, 15, and 11 respectively.

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

    // APPROACH :- like the vertical printing of nodes, here we have to group the diagonal elements somehow
    // Group based on the diagonal number, when we move left diagonal number increases by 1 and when we move right it remains same
    public static void fillmap(Node root, int diagonalno, LinkedHashMap<Integer, Integer> lhmap) {
        if (root == null)
            return;

        if (lhmap.containsKey(diagonalno)) {
            lhmap.put(diagonalno, lhmap.get(diagonalno) + root.data);
        } else {
            lhmap.put(diagonalno, root.data);
        }

        fillmap(root.right, diagonalno, lhmap);
        fillmap(root.left, diagonalno + 1, lhmap);

    }

    public static List<Integer> findDiagonalSum(Node root) {
        // Write your code here...
        List<Integer> ans = new LinkedList<>();
        LinkedHashMap<Integer, Integer> lhmap = new LinkedHashMap<>();

        fillmap(root, 0, lhmap);

        for (Map.Entry<Integer, Integer> entry : lhmap.entrySet()) {
            Integer val = entry.getValue();
            ans.add(val);
        }

        return ans;
    }
}
