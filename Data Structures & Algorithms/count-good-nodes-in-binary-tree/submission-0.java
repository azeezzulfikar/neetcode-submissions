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
class Solution {
    public int goodNodes(TreeNode root) {
        int goodNodes = 0;
        goodNodes = getGoodNodes(root, 0, Integer.MIN_VALUE);
        return goodNodes;
    }

    private int getGoodNodes(TreeNode root, int goodNodes, int maxValue) {
        if(root == null) return 0;
        if(root.val >= maxValue) {goodNodes++; maxValue = root.val;}
        return goodNodes + getGoodNodes(root.left, 0, maxValue) + getGoodNodes(root.right, 0, maxValue);
    }
}