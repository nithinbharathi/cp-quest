//Approach
// Time Complexity: O(row*col) & Space Complexity: O(row+col)   row-> number of rows col-> number of columns

class Solution {
    public void setZeroes(int[][] matrix) {
       
        int col_cache[] = new int[matrix[0].length];
        int row_cache[] = new int[matrix.length];
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    col_cache[j] = 1;
                    row_cache[i] = 1;
                }
            }
        }
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0 || col_cache[j] == 1 || row_cache[i] == 1){
                   matrix[i][j] = 0;
                }
            }
        }
    }
}
---------------------------------------------------------------------------------------------------------------------------------

//Better Approach: To replace the row & column values with a special number -999 in this case and then changeing them to 0

//Time Complexity: O(row*col*(row+col)) & Space Complexity: O(1)

class Solution {
    public void setZeroes(int[][] matrix) {
       
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                  for(int r=0;r<matrix.length;r++){
                      if(matrix[r][j] != 0){
                          matrix[r][j] = -999;
                      }
                  }
                    
                    for(int c=0;c<matrix[0].length;c++){
                        if(matrix[i][c] != 0){
                            matrix[i][c] = -999;
                        }
                    }
                }
            }
        }
         for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j] == -999){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
--------------------------------------------------------------------------------------------------------------------------------

//Efficient Approach:  Use the row and column of for setting the flags of if the row or column that we are on contains a 0 or not
//Time Complexity: O(row*col) Space Complexity: O(1)


class Solution {
    public void setZeroes(int[][] matrix) {
       boolean col_change = false;
        for(int i =0;i<matrix.length;i++){
             if(matrix[i][0] == 0){
                 col_change = true;
             }
            for(int j =1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    
                }
            }

        }
        for(int i =1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0 ){
            for(int i =0;i<matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }
        if(col_change){
            for(int i =0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
    }
}
