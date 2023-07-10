class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        solve(board);
    }
    public boolean solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                    if(board[i][j] == '.'){
                         for(char c= '1'; c<='9';c++){
                            if(valid(board,i,j,c)){
                                board[i][j] = c;
                                if(solve(board))return true;
                                else{
                                    board[i][j] = '.';
                                }
                            }
                        }
                        return false;
                    }
                }
            }
        return true;
    }
    public boolean valid(char arr[][],int row,int col,char c){
        for(int check = 0;check<9;check++){
            if(arr[check][col] != '.' && arr[check][col] == c){
                return false;
            }
            if(arr[row][check] != '.' && arr[row][check] == c){
                return false;
            }
            if(arr[3*(row/3)+check/3][3*(col/3)+check%3] != '.' &&arr[3*(row/3)+check/3][3*(col/3)+check%3] == c){
                return false;
            }
        }
            return true;
    }
}
