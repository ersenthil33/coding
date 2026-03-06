class Solution {
    
    public String convert(String s, int numRows) {
        
        if (numRows == 1) {
            return s;
        }
        
        String[] rows = new String[numRows];
        
        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }
        
        int currentRow = 0;
        boolean goingDown = true;
        
        for (int i = 0; i < s.length(); i++) {
            
            rows[currentRow] = rows[currentRow] + s.charAt(i);
            
            if (goingDown) {
                currentRow++;
                if (currentRow == numRows - 1) {
                    goingDown = false;
                }
            } else {
                currentRow--;
                if (currentRow == 0) {
                    goingDown = true;
                }
            }
        }
        
        String result = "";
        
        for (int i = 0; i < numRows; i++) {
            result = result + rows[i];
        }
        
        return result;
    }
}