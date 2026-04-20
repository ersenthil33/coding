class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        leftSubtree = self.maxDepth(root.left)
        RightSubtree = self.maxDepth(root.right)
        return max(leftSubtree, RightSubtree) + 1