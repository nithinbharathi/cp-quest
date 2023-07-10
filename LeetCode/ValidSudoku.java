class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0)return false;
        int colCache[][] = new int[10][10];
        int gridCache[][] = new int[10][10];
        for(int i=0;i<board.length;i++){
                int rowCache[] = new int[10];
            for(int j = 0;j<board[0].length;j++){
                int val = board[i][j]-'0';
                if(board[i][j] =='.')continue;
                if(rowCache[val] != 0)return false;
                if(colCache[j][val] != 0)return false;
                if(gridCache[3*(i/3) + (j/3)][val] != 0)return false;
                    
                rowCache[val]++;
                colCache[j][val]++;
                gridCache[3*(i/3) + (j/3)][val]++;
            }
        }
        return true;
    }
}
