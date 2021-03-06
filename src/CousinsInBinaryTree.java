import java.util.HashMap;

/*
    In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
    Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
    We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
    Return true if and only if the nodes corresponding to the values x and y are cousins.

    Example 1:
    Input: root = [1,2,3,4], x = 4, y = 3
    Output: false
    Example 2:

    Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
    Output: true
    Example 3:

    Input: root = [1,2,3,null,4], x = 2, y = 3
    Output: false

    Note:
    The number of nodes in the tree will be between 2 and 100.
    Each node has a unique integer value from 1 to 100.
    */

class CousinsInBinaryTree {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        return traverse(root, x, y, 0);
    }

    private boolean traverse(TreeNode node, int x, int y, int level) {

        if (node == null)
            return false;

        if (node.val == x) {
            hashMap.put(x, level);
        }
        if (node.val == y)
            hashMap.put(y, level);
        traverse(node.left, x, y, level + 1);
        traverse(node.right, x, y, level + 1);
        return hashMap.containsKey(x) && hashMap.containsKey(y) && hashMap.get(x) == hashMap.get(y);
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
