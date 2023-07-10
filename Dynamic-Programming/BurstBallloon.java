//Problem Link: https://leetcode.com/problems/burst-balloons/

//Time Complexity: O(N*N*N)
//Space Complexity: O(N*N);
class Solution {
    public int maxCoins(int[] nums) {
        int arr[] = new int[nums.length+2];
        arr[0]  =1;
        arr[arr.length-1] = 1;
        for(int i=1;i<=nums.length;i++){
            arr[i] = nums[i-1];
        }
        int dp[][] = new int[arr.length][arr.length];
        for(int l =1;l<=nums.length;l++){
            for(int i=1;i<=arr.length-l-1;i++){
                int j = i+l-1;
                for(int window = i;window<=j;window++){
    dp[i][j] = Math.max(dp[i][j],(dp[i][window-1]+arr[i-1]*arr[window]*arr[j+1]+dp[window+1][j]));
                }
            }
        }
        return dp[1][nums.length];
    }
}
