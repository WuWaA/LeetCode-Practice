import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<Integer>();
        Recursion(root, l);
        return l;
    }

    void Recursion(TreeNode n, List<Integer> l) {
        if (n == null)
            return;
        Recursion(n.left, l);
        l.add(n.val);
        Recursion(n.right, l);
    }

    public List<Integer> inorderTraversalIteration(TreeNode root) {
        List<Integer> l = new LinkedList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode c = root;
        while (c != null || !s.isEmpty()) {
            while (c != null) {
                s.add(c);
                c = c.left;
            }
            c = s.pop();
            l.add(c.val);
            c = c.right;
        }
        return l;
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
}
