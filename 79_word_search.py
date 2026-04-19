
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        # if len(word) > len(board) * len(board[0]) or not board:
        #     return False

        directions = ((1, 0), (-1, 0), (0, 1), (0, -1))

        def dfs(r, c, idx):
            if idx == len(word)-1:
                return True
            
            for cr, cc in directions:
                nr, nc = r + cr, c + cc

                if 0 <= nr < len(board) and 0 <= nc < len(board[0]) and board[nr][nc] == word[idx+1]:
                    board[nr][nc] = "1"
                    if dfs(nr, nc, idx+1):
                        return True
                    board[nr][nc] = word[idx+1]

            return False

        count = Counter(word)
        
        if count[word[0]] > count[word[-1]]:
            word = word[::-1]

        for row in range(len(board)):
            for col in range(len(board[0])):
                if board[row][col] != word[0]:
                    continue
        
                board[row][col] = "1"
                if dfs(row, col, 0):
                    return True
                board[row][col] = word[0]
        
        return False



                

        