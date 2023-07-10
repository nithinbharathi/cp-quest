class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        return helper(grid,0,0,dp);
    }
    public int helper(int grid[][],int i,int j,int dp[][]){
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        if(i>grid.length-1 || j>grid[0].length-1){
            return 9999999;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }

       dp[i][j] = Math.min(helper(grid,i,j+1,dp)+grid[i][j],helper(grid,i+1,j,dp)+grid[i][j]);
       return dp[i][j];
        
    }
}
