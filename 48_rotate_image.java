class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;

        // reversing the diagonals of the array
        for(int i=0;i<row;i++) {
            for(int j=i+1;j<col;j++) {
                // swapping diagonal elements
                int dummy = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = dummy;
            }
        }
        // swapping corner elements of row with each others
        for(int i=0;i<row;i++) {
            for(int j=0;j<col/2;j++) {
                int dummy = matrix[i][col-1-j];
                matrix[i][col-1-j] = matrix[i][j];
                matrix[i][j] = dummy;               
            }
        }        
    }
}