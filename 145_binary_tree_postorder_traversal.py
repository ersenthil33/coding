class Solution:
    def postorderTraversal(self, root: TreeNode) -> list[int]:
        result = []
        
        def dfs(node):
            if not node:
                return
            dfs(node.left)            # Traverse left subtree
            dfs(node.right)           # Traverse right subtree
            result.append(node.val)   # Visit root
        
        dfs(root)
        return result