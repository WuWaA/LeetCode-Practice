/**
 * Runtime: 2 ms, faster than 100.00% of Java online submissions for Count Good Nodes in Binary Tree.
 * Memory Usage: 60.1 MB, less than 29.75% of Java online submissions for Count Good Nodes in Binary Tree.
 */
class Solution {

    int counter = 0;

    public int goodNodes(TreeNode root) {
        recursion(root, Integer.MIN_VALUE);
        return counter;
    }

    void recursion(TreeNode node, int max) {
        if (node == null)
            return;
        if (node.val > max)
            max = node.val;
        if (node.val >= max)
            counter += 1;
        recursion(node.left, max);
        recursion(node.right, max);
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