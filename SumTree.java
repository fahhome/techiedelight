package techiedelight;
import java.util.*;


/*

Given the root of a binary tree, check if the binary tree is a sum tree or not. In a sum tree, each non-leaf node's value is equal to the sum of all elements present in its left and right subtree. The value of a leaf node can be anything and the value of an empty child node is considered to be 0.

Input:

			 44
		   /	\
		  /		 \
		 9		  13
	   /   \	 /  \
	  /		\	/	 \
	 4		 5 6	  7

Output: true

Explanation: All non-leaf nodes follows the sum tree property, as shown below:

			 44 (4+5+9)+(6+7+13)
		   /	\
		  /		 \
   (4+5) 9		  13 (6+7)
	   /   \	 /  \
	  /		\	/	 \
	 4		 5 6	  7

*/
public class SumTree {
    public static int find(Node root, int[] ans) {

        if (root == null)
            return 0;

        int sumleft = find(root.left, ans);
        int sumright = find(root.right, ans);

        System.out.println("Root val is: " + root.data + ", sumleft: " + sumleft + ", sumright: " + sumright);

        if ((root.left != null || root.right != null) && root.data != (sumleft + sumright)) {
            ans[0] = 0;
        }

        return root.data + sumleft + sumright;
    }

    public static boolean isSumTree(Node root) {
        // Write your code here...
        int[] ans = new int[1];
        ans[0] = 1;
        find(root, ans);
        System.out.println(ans[0]);
        return (ans[0] == 1) ? true : false;

    }
    public static void main(String[] args) {
        
    }
}

class Node {
    int data; // data field
    Node left, right; // pointer to the left and right child

    Node() {
    }

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}