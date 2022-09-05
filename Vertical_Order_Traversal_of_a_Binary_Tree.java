import java.util.*;

public class Vertical_Order_Traversal_of_a_Binary_Tree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        LinkedList<Pair<TreeNode, Pair<Integer, Integer>>> c = new LinkedList<Pair<TreeNode, Pair<Integer, Integer>>>();
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> q = new ArrayDeque<Pair<TreeNode, Pair<Integer, Integer>>>();
        Pair<Integer, Integer> r = new Pair<Integer, Integer>(Integer.MAX_VALUE, Integer.MIN_VALUE); // (min, max)

        BFS(root, q, r, c);

        int range = (int) r.b - (int) r.a + 1;
        int shift = Math.abs((int) r.a);
        for (int i = 0; i < range; i++)
            l.add(new ArrayList<Integer>());

        // 要么先对行列进行排序再添加，要么添加的时候找到正确的位置
        // 由于最终要返回的结果不带坐标，所以应该先排序，否则没办法跟已添加的元素比较位置
        while (!c.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> p = c.removeFirst();
            List<Integer> column = l.get(shift + p.b.b);
            // System.out.print(p.a.val + " ");
            column.add(p.a.val);
        }

        return l;
    }

    /**
     * O(N^2)
     * @param root Root node of TreeNode
     * @param q Queue for BFS
     * @param range Range of column index
     * @param collection All results with coordination
     */
    void BFS(TreeNode root, Queue<Pair<TreeNode, Pair<Integer, Integer>>> q, Pair<Integer, Integer> range,
            List<Pair<TreeNode, Pair<Integer, Integer>>> collection) {
        q.add(new Pair<TreeNode, Pair<Integer, Integer>>(root, new Pair<Integer, Integer>(0, 0)));
        while (!q.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> t = q.poll();
            TreeNode node = t.a;
            if (t.a != null) {
                // System.out.println(t.b.a);
                int column = t.b.b;
                boolean flag = true;
                for (int i = 0; i < collection.size(); i++) {
                    Pair<TreeNode, Pair<Integer, Integer>> temp = collection.get(i);
                    if (temp.b.a == t.b.a && temp.b.b == t.b.b) // same coordination
                        if (temp.a.val > t.a.val) {
                            collection.add(i, t);
                            flag = false;
                            break;
                        }
                }
                if (flag)
                    collection.add(t);
                q.add(new Pair<TreeNode, Pair<Integer, Integer>>(node.left,
                        new Pair<Integer, Integer>(t.b.a + 1, column - 1)));
                q.add(new Pair<TreeNode, Pair<Integer, Integer>>(node.right,
                        new Pair<Integer, Integer>(t.b.a + 1, column + 1)));
                if (column < range.a)
                    range.a = column;
                if (column > range.b)
                    range.b = column;
            }
        }
        /* Old try */
        // Traversal(n.left, i - 1, q, range);
        // Traversal(n.right, i + 1, q, range);
    }

    class Pair<T, E> {
        T a;
        E b;

        Pair(T a, E b) {
            this.a = a;
            this.b = b;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Vertical_Order_Traversal_of_a_Binary_Tree t = new Vertical_Order_Traversal_of_a_Binary_Tree();
        TreeNode root = t.new TreeNode(1, t.new TreeNode(2), t.new TreeNode(3));
        root.left.left = t.new TreeNode(4);
        root.left.right = t.new TreeNode(6);
        root.right.left = t.new TreeNode(5);
        root.right.right = t.new TreeNode(7);
        // root.left.left.left = new TreeNode(8);
        // root.left.left.right = new TreeNode(9);
        // root.left.right.left = new TreeNode(10);
        // root.left.right.right = new TreeNode(11);
        // root.right.left.left = new TreeNode(12);
        // root.right.left.right = new TreeNode(13);
        // System.out.println(t.verticalTraversal(root));

        // Small test about TreeMap
        TreeMap<Integer, String> m = new TreeMap<>();
        m.put(1, "A");
        m.put(1, "B");
        m.put(1, "C");
        m.put(1, "D");
        for (int k : m.keySet())
            System.out.println(m.get(k)); // "D"
        System.out.println(m.values().size()); // 1
    }
}