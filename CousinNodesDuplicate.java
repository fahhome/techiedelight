package techiedelight;

import techiedelight.Node;

// Two nodes can have same values
public class CousinNodesDuplicate {
    public static void filldatas(Node root, Node x, Node y, Node[] xpar, Node[] ypar, int[] xlev, int[] ylev, Node par,
            int lev) {
        if (root == null)
            return;

        if (root == x) {
            xpar[0] = par;
            xlev[0] = lev;
        }

        if (root == y) {
            ypar[0] = par;
            ylev[0] = lev;
        }

        filldatas(root.left, x, y, xpar, ypar, xlev, ylev, root, lev + 1);
        filldatas(root.right, x, y, xpar, ypar, xlev, ylev, root, lev + 1);
    }

    public static boolean isCousin(Node root, Node x, Node y) {
        // Write your code here...
        Node[] xpar = new Node[1];
        Node[] ypar = new Node[1];
        xpar[0] = null;
        ypar[0] = null;

        Node rootpar = new Node(4);

        int[] xlev = new int[1];
        int[] ylev = new int[1];

        xlev[0] = -1;
        ylev[0] = -1;

        filldatas(root, x, y, xpar, ypar, xlev, ylev, rootpar, 0);

        if (xpar[0] == null || ypar[0] == null)
            return false;

        if ((xpar[0] != ypar[0]) && (xlev[0] == ylev[0]))
            return true;

        return false;

    }
}
