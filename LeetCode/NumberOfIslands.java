class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid == null){
            return 0;
        }
        int count = 0; 
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    helper(grid,i,j);
                }
            }
        }
        return count;
    }
    public static void helper(char arr[][],int i,int j){
        
    if(  i<0 ||  i>arr.length-1 || j<0 || j>arr[0].length-1 || arr[i][j] == '0'){
        return;
    }
    arr[i][j]='0';
    helper(arr,i-1,j);
    helper(arr,i+1,j);

    helper(arr,i,j-1);
    helper(arr,i,j+1);

    }
}
