class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        #if root is None: return [] 
        ans, stack = [], [] 
        while stack or root:
            while root: 
                stack.append(root) 
                ans.append(root.val)
                root = root.left 
            root = stack.pop() 
            root = root.right 
        return ans 