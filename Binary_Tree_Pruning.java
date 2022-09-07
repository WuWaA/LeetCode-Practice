public class Binary_Tree_Pruning {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Pruning.
     * Memory Usage: 41.8 MB, less than 49.73% of Java online submissions for Binary Tree Pruning.
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode l = pruneTree(root.left);
        if (l == null)
            root.left = null;
        TreeNode r = pruneTree(root.right);
        if (r == null)
            root.right = null;
        if (root.left == null && root.right == null && root.val == 0)
            return null;
        return root;
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
