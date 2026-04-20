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
    HashMap<Integer,Integer> map;
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        int n = postorder.length;
        postIndex = n-1;

        // store inorder index
        for(int i = 0;i < n ; i++){
            map.put(inorder[i],i);
        }

        return helper(postorder,0,n-1);    
    }

    private TreeNode helper(int[] postorder, int left ,int right){
        if(left > right ) return null;

        // pick root (last element)
        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

        // find root in inorder
        int mid = map.get(rootValue);

        // IMPORTANT: build right first
        root.right = helper(postorder , mid+1 , right);
        root.left = helper(postorder , left , mid-1);

        return root;
    }
}