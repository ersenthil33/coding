# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def another(self , root , level , output):
        if root is None:
            return
        if len(output) <= level:
            output.append([])
        if level%2==0:
            output[level].append(root.val)
        else:
            output[level].insert(0 , root.val)
        self.another(root.left , level + 1 , output)
        self.another(root.right , level + 1 , output)
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        output=[]
        self.another(root , 0 , output)
        return output