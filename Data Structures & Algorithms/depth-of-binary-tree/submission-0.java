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
    public int maxDepth(TreeNode root) {
        int maxLen = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root == null) return 0;
        q.add(root);
        while(!q.isEmpty()) {
            int len = q.size();
            while(len > 0) {
                TreeNode item = q.poll();
                if(item.left != null) q.offer(item.left);
                if(item.right != null) q.offer(item.right);
                len--;
            }
            maxLen++;
        }
        return maxLen;

    }
}