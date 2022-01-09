package techiedelight;
import java.util.*;
/*

Given an array of single-digit positive integers, return all possible combinations of words formed by replacing the continuous digits with corresponding character in the English alphabet, i.e., subset [1] can be replaced by A, [2] can be replaced by B, [1, 0] can be replaced by J, [2, 1] can be replaced by U, etc.

Input: [1, 2, 2]
Output: ["ABB", "AV", "LB"]
Explanation:

[1, 2, 2] = "ABB"
[1, 22] = "AV"
[12, 2] = "LB"

Input: [1, 2, 2, 1]
Output: ["ABBA", "ABU", "AVA", "LBA", "LU"]
Explanation:

[1, 2, 2, 1] = "ABBA"
[1, 2, 21] = "ABU"
[1, 22, 1] = "AVA"
[12, 2, 1] = "LBA"
[12, 21] = "LU"

*/

class Combinations {
    static Map<Integer, Character> values = new HashMap<>();

    static {
        values.put(1, 'A');
        values.put(2, 'B');
        values.put(3, 'C');
        values.put(4, 'D');
        values.put(5, 'E');
        values.put(6, 'F');
        values.put(7, 'G');
        values.put(8, 'H');
        values.put(9, 'I');
        values.put(10, 'J');
        values.put(11, 'K');
        values.put(12, 'L');
        values.put(13, 'M');
        values.put(14, 'N');
        values.put(15, 'O');
        values.put(16, 'P');
        values.put(17, 'Q');
        values.put(18, 'R');
        values.put(19, 'S');
        values.put(20, 'T');
        values.put(21, 'U');
        values.put(22, 'V');
        values.put(23, 'W');
        values.put(24, 'X');
        values.put(25, 'Y');
        values.put(26, 'Z');
    }

    public static void combine(int curidx, StringBuilder sb, int[] digits, int len, List<String> ans) {
        if (curidx >= len) {
            if (sb.length() > 0)
                ans.add(new String(sb));
            return;
        }

        int num1 = digits[curidx];
        Character ch1 = values.get(num1);
        sb.append(ch1);
        combine(curidx + 1, sb, digits, len, ans);
        sb.deleteCharAt(sb.length() - 1);
        if (curidx + 1 < len) {
            int num2 = digits[curidx] * 10 + digits[curidx + 1];
            if (num2 <= 26) {
                Character ch2 = values.get(num2);
                sb.append(ch2);
                combine(curidx + 2, sb, digits, len, ans);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

    public static List<String> findCombinations(int[] digits) {
        // Write your code here...

        int len = digits.length;
        List<String> ans = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        combine(0, sb, digits, len, ans);
        return ans;
    }
}
