public class Construct_String_from_Binary_Tree {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Construct String from Binary Tree.
     * Memory Usage: 41.5 MB, less than 100.00% of Java online submissions for Construct String from Binary Tree.
     * @param root
     * @return
     */
    public String tree2str(TreeNode root) {
        StringBuilder s = new StringBuilder();
        DFS(root, s);
        return s.toString();
    }

    void DFS(TreeNode r, StringBuilder s) {
        if (r == null)
            return;

        s.append(r.val);

        if (r.left != null) {
            DFS(r.left, s.append("("));
            s.append(")");
        }

        // If node has right child, then left parenthesis are necessary
        if (r.left == null && r.right != null)
            s.append("()");

        if (r.right != null) {
            DFS(r.right, s.append("("));
            s.append(")");
        }
    }

    public class TreeNode {
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
