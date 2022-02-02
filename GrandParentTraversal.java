package techiedelight;
import java.util.*;

// its actually a leetcode question

// Given the root of a binary tree,return the sum of values of nodes with an even-valued grandparent.If there are no nodes with an even-valued grandparent,return 0.

// A grandparent of a node is the parent of its parent if it exists.
class Solution {

    public void dfs(TreeNode root, int par, int gpar, List<Integer> nodevals) {
        if (root == null)
            return;

        if (gpar > 0 && gpar % 2 == 0)
            nodevals.add(root.val);

        dfs(root.left, root.val, par, nodevals);
        dfs(root.right, root.val, par, nodevals);

    }

    public int sumEvenGrandparent(TreeNode root) {
        List<Integer> nodevals = new LinkedList<>();

        dfs(root.left, root.val, -1, nodevals);
        dfs(root.right, root.val, -1, nodevals);

        int sum = 0;
        for (int num : nodevals)
            sum += num;

        return sum;
    }

}
