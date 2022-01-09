package techiedelight;
import java.util.*;

public class SymmetricStructure {

    public static boolean issymdfs(Node r1, Node r2) {
        if (r1 == null && r2 != null)
            return false;
        if (r1 != null && r2 == null)
            return false;
        if (r1 == null && r2 == null)
            return true;

        return issymdfs(r1.left, r2.right) && issymdfs(r1.right, r2.left);
    }

    public static boolean isSymmetric(Node root) {
        // Write your code here...
        if (root == null)
            return true;
        return issymdfs(root.left, root.right);
    }

    public static void main(String[] args) {
        
    }

}
