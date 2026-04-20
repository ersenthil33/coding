class Solution {
    public TreeNode NR=null;
    public  void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left=null;
        root.right=NR;
        NR=root;
    }
}