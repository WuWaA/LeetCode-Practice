import java.util.*;

public class Nary_Tree_Level_Order_Traversal {

    /**
    * Runtime: 4 ms, faster than 64.45% of Java online submissions for N-ary Tree Level Order Traversal.
    * Memory Usage: 43 MB, less than 99.21% of Java online submissions for N-ary Tree Level Order Traversal.
    */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> l = new LinkedList<List<Integer>>();
        Queue<Pair<Node, Integer>> q = new LinkedList<Pair<Node, Integer>>();
        q.add(new Pair<Node, Integer>(root, 0));
        while (!q.isEmpty()) {
            Pair<Node, Integer> current = q.poll();
            if (current.node != null) {
                if (l.size() <= current.level)
                    l.add(new LinkedList<Integer>());
                l.get(current.level).add(current.node.val);
                for (Node n : current.node.children)
                    q.add(new Pair<Node, Integer>(n, current.level + 1));
            }
        }
        return l;
    }

    class Pair<K, V> {
        K node;
        V level;

        Pair(K k, V v) {
            node = k;
            level = v;
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
