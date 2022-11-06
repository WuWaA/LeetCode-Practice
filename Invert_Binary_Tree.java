import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Invert_Binary_Tree {
    /**
     * Wrong Thought Leads Wrong Try.
     * No Need For Two List.
     */
    static public TreeNode invertTree_WrongThought(TreeNode root) {
        LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();
        list1.add(root);
        while(!list1.isEmpty() || !list2.isEmpty()) {
            for (int i = 0; i < list1.size(); i++) {
                TreeNode current = list1.get(i);
                if (current != null) {
                    list2.add(current.left);
                    list2.add(current.right);
                    TreeNode temp = current.left;
                    current.left = current.right;
                    current.right = temp;
                }
            }
            list1 = new LinkedList<TreeNode>();
            for (int i = 0; i < list2.size(); i++) {
                TreeNode current = list2.get(i);
                if (current != null) {
                    list1.add(current.left);
                    list1.add(current.right);
                    TreeNode temp = current.left;
                    current.left = current.right;
                    current.right = temp;
                }
            }
            list2 = new LinkedList<>();
        }
        return root;
    }

    /**
     * Optimal Solution
     */
    static public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                queue.offer(current.left);
                queue.offer(current.right);
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        invertTree(new TreeNode(1, new TreeNode(2), null));
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