class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        if (board.length < 2 || board[0].length < 2)
		return;
        int m = board.length, n = board[0].length;
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1){
                    helper(board,i,j);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
             
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                   if(board[i][j] == 'V'){
                    board[i][j] = 'O';
                }
            }
        }
    }
   public static void helper(char[][] board , int i,int j){
 if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1 || board[i][j] == 'X' || board[i][j] == 'V'){
		return;
       }
        board[i][j] = 'V';
       
		helper(board, i-1, j);

		helper(board, i+1, j);

		helper(board, i, j-1);
	
		helper(board, i, j+1);
       
   }
}
