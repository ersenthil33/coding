class Solution {
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        if(root == null)
        {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();

        list.addAll(inorderTraversal(root.left));

        list.add(root.val);

        list.addAll(inorderTraversal(root.right));

        return list;
    }
}