import java.util.*;

public class Numbers_With_Same_Consecutive_Differences {
    /**
     * LinkedList & HashSet clear duplicates
     * 
     * Runtime: 10 ms, faster than 16.56% of Java online submissions for Numbers With Same Consecutive Differences.
     * Memory Usage: 44.2 MB, less than 7.19% of Java online submissions for Numbers With Same Consecutive Differences.
     * @param n
     * @param k
     * @return
     */
    public int[] numsSameConsecDiff(int n, int k) {
        // Initialize
        List<Integer> cur = new LinkedList<Integer>();
        for (int i = 1; i < 10; i++) // 1 to 9
            cur.add(i);

        // Deal with every digit
        for (int i = 1; i < n; i++) {
            List<Integer> pre = cur;
            cur = new LinkedList<Integer>();
            for (int j = 0; j < pre.size(); j++) {
                // Get last digit of pre -> t % 10
                // Calculate new digit -> t % 10 + k and t % 10 - k
                int p = pre.get(j);
                int l = p % 10;
                int n1 = l + k;
                if (n1 < 10)
                    cur.add(p * 10 + n1);
                int n2 = l - k;
                if (n2 >= 0)
                    cur.add(p * 10 + n2);
            }
        }

        // Is there repeated number?
        // HashSet<Integer> s = new HashSet<Integer>(cur);

        return cur.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * HashSet only
     * 
     * Runtime: 7 ms, faster than 36.56% of Java online submissions for Numbers With Same Consecutive Differences.
     * Memory Usage: 42.9 MB, less than 57.81% of Java online submissions for Numbers With Same Consecutive Differences.
     * @param n
     * @param k
     * @return
     */
    public int[] numsSameConsecDiff2(int n, int k) {
        // Initialize
        HashSet<Integer> cur = new HashSet<Integer>();
        for (int i = 1; i < 10; i++) // 1 to 9
            cur.add(i);

        // Deal with every digit
        for (int i = 1; i < n; i++) {
            Set<Integer> pre = cur;
            cur = new HashSet<Integer>();
            for (int p : pre) {
                // Get last digit of pre -> (t % 10)
                // Calculate new digit -> (t % 10 + k) and (t % 10 - k)
                int l = p % 10;
                int n1 = l + k;
                if (n1 < 10)
                    cur.add(p * 10 + n1);
                int n2 = l - k;
                if (n2 >= 0)
                    cur.add(p * 10 + n2);
            }
        }

        return cur.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * BinaryTree
     * @param n
     * @param k
     * @return
     */
    public int[] numsSameConsecDiff3(int n, int k) {
        List<Integer> l = new LinkedList<Integer>();
        for (int i = 1; i < 10; i++) {
            BinaryTree t = new BinaryTree(i);
            recursion(t, k, n - 1, l);
        }
        return l.stream().mapToInt(i -> i).toArray();
    }

    void recursion(BinaryTree n, int k, int d, List<Integer> l) {
        if (n == null || d == 0)
            return;
        if (k != 0) {
            if (n.val % 10 - k >= 0) {
                n.l = new BinaryTree(n.val * 10 + (n.val % 10 - k));
                if (d == 1)
                    l.add(n.l.val);
            }
            if (n.val % 10 + k < 10) {
                n.r = new BinaryTree(n.val * 10 + (n.val % 10 + k));
                if (d == 1)
                    l.add(n.r.val);
            }
        } else {
            n.r = new BinaryTree(n.val * 10 + n.val % 10);
            if (d == 1)
                l.add(n.r.val);
        }
        recursion(n.l, k, d - 1, l);
        recursion(n.r, k, d - 1, l);
    }

    class BinaryTree {
        int val;
        BinaryTree l, r;

        BinaryTree(int v) {
            val = v;
        }
    }

    public static void main(String[] args) {
        Numbers_With_Same_Consecutive_Differences t = new Numbers_With_Same_Consecutive_Differences();
        System.out.println(t.numsSameConsecDiff3(3, 7));
    }
}
