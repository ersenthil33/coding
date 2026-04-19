class Solution(object):
    def minPathSum(self, grid):
        m = len(grid)
        n = len(grid[0])
        
        # Create a dp table to store the minimum sum path to each cell
        dp = [[0 for j in range(n)] for i in range(m)]
        
        # Fill the first row
        dp[0][0] = grid[0][0]
        for i in range(1, n):
            dp[0][i] = dp[0][i-1] + grid[0][i]
        
        # Fill the first column
        for i in range(1, m):
            dp[i][0] = dp[i-1][0] + grid[i][0]
        
        # Fill the rest of the dp table
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
        
        return dp[m-1][n-1]

