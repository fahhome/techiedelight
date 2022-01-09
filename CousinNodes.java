package techiedelight;
import java.util.*;

import techiedelight.Node;

// Assume that the nodes have different values
public class CousinNodes {
    public static void filldatas(Node root, Node x, Node y, List<Integer> xdata, List<Integer> ydata, int par,
            int lev) {
        if (root == null)
            return;

        if (root == x) {
            xdata.add(par);
            xdata.add(lev);
        }

        if (root == y) {
            ydata.add(par);
            ydata.add(lev);
        }

        filldatas(root.left, x, y, xdata, ydata, root.data, lev + 1);
        filldatas(root.right, x, y, xdata, ydata, root.data, lev + 1);
    }

    public static boolean isCousin(Node root, Node x, Node y) {
        // Write your code here...
        List<Integer> xdata = new LinkedList<>();
        List<Integer> ydata = new LinkedList<>();

        filldatas(root, x, y, xdata, ydata, -1, 0);

        if (xdata.size() == 0 || ydata.size() == 0)
            return false;

        if ((xdata.get(0) != ydata.get(0)) && (xdata.get(1) == ydata.get(1)))
            return true;

        return false;

    }
    public static void main(String[] args) {
        
    }
}
