package techiedelight;
import java.util.*;

public class DeleteLeavesWithGivenValue {
    public TreeNode dfs(TreeNode root, int target) {

        if (root == null)
            return null;

        // if(root.left == null && root.right == null && root.val == target)
        // return null; // We don't need this but works with this also

        root.right = dfs(root.right, target);
        root.left = dfs(root.left, target);

        if (root.right == null && root.left == null && root.val == target)
            return null;

        return root;

    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root, target);
    }


}
