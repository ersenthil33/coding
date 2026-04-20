class Solution:
    def hasPathSum(self, n: Optional[TreeNode], t: int) -> bool:
        return (f:=lambda n,t:bool(n) and (n.left==n.right==None and n.val==t
            or f(n.left,t-n.val) or f(n.right,t-n.val)))(n,t)