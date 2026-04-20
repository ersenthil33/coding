class Solution {
    public void pathSum(TreeNode root, int targetSum, int curSum, List<Integer> prevList, List<List<Integer>> ans) {
        if(root == null){
            return;
        }
        curSum+=root.val;
        prevList.add(root.val);
        if(curSum==targetSum && root.left==null && root.right==null){
            ans.add(new ArrayList<>(prevList));
        }
        pathSum(root.left,targetSum,curSum,prevList,ans);
        pathSum(root.right,targetSum,curSum,prevList,ans);
        prevList.remove(prevList.size()-1);
        return;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        pathSum(root,targetSum,0,prev,ans);
        return ans;
    }
}