/**
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 */

class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int level = 0;
        int result = dfs(root, level);
        return result;
    }

    public int dfs(TreeNode root, int level) {
        // Pre Recursion Compute
        level++;
        if (root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null) return level;
        
        // recursion call
        int left = dfs(root.left, level);
        int right = dfs(root.right, level);
        
        // analyze data
        int minLevel = Math.min(left, right);
        return minLevel;
    }
}