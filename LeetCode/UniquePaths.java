class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]  = new int[m][n];
       
       return  helper(m,n,0,0,dp);
    }
    public static int helper(int m,int n,int i,int j,int dp[][]){
        if(i ==m-1 && j ==  n-1){
            return 1;
        }
        if(i>=m || j>=n)return 0;
        
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        dp[i][j] = helper(m,n,i,j+1,dp)+ helper(m,n,i+1,j,dp);
        return dp[i][j];
    }
}


//Bottom-Up Approach
//Time Complexity: O(m*n)
//Space Complexity: o(m*n)

class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i =0;i<n;i++){
            dp[0][i] = 1;
        }
        for(int i =0;i<m;i++){
            dp[i][0] = 1;
        }
         for(int i = 1;i<m;i++){
             for(int j =1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
             }
         }
        return dp[m-1][n-1];
        
    }
  
}
