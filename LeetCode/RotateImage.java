class Solution {
    public void rotate(int[][] matrix) {
        int temp;
        int size = matrix[0].length;
        for(int i= 0;i<size/2;i++){
            for(int j=i;j<size-i-1;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[size-1-j][i];
                matrix[size-j-1][i] = matrix[size-i-1][size-j-1];
                matrix[size-i-1][size-j-1] = matrix[j][size-1-i] ;
                matrix[j][size-1-i] = temp;
            }
        }
    }
}
