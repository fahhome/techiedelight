package techiedelight;

import techiedelight.Node;

public class DiameterLinear {
    public static int fd(Node root, int[] ans) {
        if (root == null)
            return 0;

        int lh = fd(root.left, ans);
        int rh = fd(root.right, ans);

        int diameter = 1 + lh + rh;

        if (diameter > ans[0])
            ans[0] = diameter;

        return 1 + Math.max(lh, rh);

    }

    public static int findDiameter(Node root) {
        // Write your code here...
        int[] ans = new int[1];
        ans[0] = 0;
        fd(root, ans);
        return ans[0];
    }
}
