class Solution:
    def numDecodings(self, s: str) -> int:
        memo = {}

        def dfs(index):
            if index in memo:
                return memo[index]
            if index == len(s):
                return 1
            if s[index] == '0':
                return 0
            
            
            res = dfs(index + 1)
            
            
            if index + 1 < len(s):
                if s[index] == '1' or (s[index] == '2' and s[index + 1] in "0123456"):
                    res += dfs(index + 2)
            
            memo[index] = res
            return res
            
        return dfs(0)