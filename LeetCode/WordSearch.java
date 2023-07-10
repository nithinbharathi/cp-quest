class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
          for(int j =0;j<board[0].length;j++){
              if(board[i][j] == word.charAt(0)){
                  boolean result= helper(board,word,i,j,0);
                  if(result){
                      return true;
                  }
              }
          }
        }
        return false;
    }
    public static boolean helper(char board[][],String word,int i ,int j,int index){
        if(index == word.length()){
            return true;
        }
        if(i<0||i>=board.length|| j<0 || j>=board[i].length||board[i][j] != word.charAt(index)){
            return false;
        }
        board[i][j] +=60;
        boolean result = helper(board,word,i,j+1,index+1)||
               helper(board,word,i+1,j,index+1)||
               helper(board,word,i,j-1,index+1)||
               helper(board,word,i-1,j,index+1);
        board[i][j] -=60;
        return result;
            
    }
}
