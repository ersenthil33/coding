# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        k = []
        self.max = -1
        def collectNodes(temp, pos):
            if not temp:
                return
            self.max = max(self.max, pos)
            k.append([pos, temp.val])
            left = collectNodes(temp.left, pos + 1)
            right = collectNodes(temp.right, pos + 1)
        collectNodes(root, 0)
        res = [[] for _ in range(self.max + 1)]
        for i in k:
            res[i[0]].append(i[1])
        return res