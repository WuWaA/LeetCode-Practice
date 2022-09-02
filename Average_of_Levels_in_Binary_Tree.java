import java.util.*;

public class Average_of_Levels_in_Binary_Tree {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Average of Levels in Binary Tree.
     * Memory Usage: 44.4 MB, less than 86.31% of Java online submissions for Average of Levels in Binary Tree.
     */
    public static List<Double> averageOfLevels(TreeNode root) {
        // maximum nodes 10000 = log(10000) = 13.2 = maximum hight 14
        // but thats for full binary tree
        // maximum hight for singly-linked-list-liked binary tree is 10000
        // doubled extra indexes for counter
        Double average[] = new Double[2000];
        average[0] = Traversal(root, 1, average);
        int size = 0;
        for (int i = 1; i < 1000; i++) {
            if (average[i] == null) {
                size = i;
                break;
            }
            average[i] /= average[i + 1000];
            average[i + 1000] = null;
        }
        List<Double> r = new ArrayList<Double>(Arrays.asList(average).subList(0, size));
        // r.removeAll(Collections.singleton(null));
        return r;
    }

    public static Double Traversal(TreeNode root, int level, Double[] average) {
        if (root == null)
            return null;
        Double l = Traversal(root.left, level + 1, average);
        Double r = Traversal(root.right, level + 1, average);
        if (l != null && r != null) {
            average[level] = average[level] == null ? (l + r) : (average[level] + l + r);
            average[level + 1000] = average[level + 1000] == null ? 2 : (average[level + 1000] + 2);
        } else if (l != null) {
            average[level] = average[level] == null ? l : (average[level] + l);
            average[level + 1000] = average[level + 1000] == null ? 1 : (average[level + 1000] + 1);
        } else if (r != null) {
            average[level] = average[level] == null ? r : (average[level] + r);
            average[level + 1000] = average[level + 1000] == null ? 1 : (average[level + 1000] + 1);
        }
        return (double) root.val;
    }

    /**
     * 我犯了一个超级愚蠢的数学错误
     * I made a stupid math mistake
     * avg(82-57+45-52+3-22) = -0.16667
     * avg(avg(avg(82-57)+avg(45-52))+avg(3-22)) = avg(avg(12.5-3.5)-9.5) = avg(4.5-9.5) = -2.5
     * THEY ARE NOT EQUAL!!!
     */
    public static void main(String[] args) {
        // int arr[] = {-40,0,-37,17,-87,-13,62,82,-57,45,-52,3,-22,-55,-54};
        TreeNode root = new TreeNode(-40, new TreeNode(0), new TreeNode(-37));
        root.left.left = new TreeNode(17);
        root.left.right = new TreeNode(-87);
        root.right.left = new TreeNode(-13);
        root.right.right = new TreeNode(62);
        root.left.left.left = new TreeNode(82);
        root.left.left.right = new TreeNode(-57);
        root.left.right.left = new TreeNode(45);
        root.left.right.right = new TreeNode(-52);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(-22);
        System.out.println(averageOfLevels(root));
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
