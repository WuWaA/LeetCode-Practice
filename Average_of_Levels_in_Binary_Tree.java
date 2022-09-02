import java.util.*;

public class Average_of_Levels_in_Binary_Tree {
    public List<Double> averageOfLevels(TreeNode root) {
        Double average[] = new Double[10000];
        average[0] = Traversal(root, 1, average);
        List<Double> r = new ArrayList<Double>(Arrays.asList(average));
        r.removeAll(Collections.singleton(null));
        return r;
    }

    public Double Traversal(TreeNode root, int level, Double[] average) {
        if (root == null)
            return null;
        Double l = Traversal(root.left, level + 1, average);
        Double r = Traversal(root.right, level + 1, average);
        if (l != null && r != null)
            average[level] = average[level] == null ? ((l + r) / 2) : ((average[level] + ((l + r) / 2)) / 2);
        else if (l != null)
            average[level] = average[level] == null ? l : ((average[level] + l) / 2);
        else if (r != null)
            average[level] = average[level] == null ? r : ((average[level] + r) / 2);
        return (double) root.val;
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
