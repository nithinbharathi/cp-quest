class Solution{ 
    public boolean canPartition(int[] nums){
        int total = 0;
        for(int n:nums){
            total +=n;
        }
        if(total%2 != 0){
            return false;
        }
        int target = total/2;
        int size = nums.length;
        boolean dp[][] = new boolean[size][target+1];
        dp[0][0] = true;
        for(int i=0;i<size;i++){
            dp[i][0] = true;
        }
        if(nums[0] <= target)dp[0][nums[0]] = true;
        for(int i=nums[0]+1;i<=target;i++){
            dp[0][i] = false;
        }
        for(int i =1;i<size;i++){
            for(int j =1;j<=target;j++){
                if(nums[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[size-1][dp[0].length-1];
        
    }
    
}
