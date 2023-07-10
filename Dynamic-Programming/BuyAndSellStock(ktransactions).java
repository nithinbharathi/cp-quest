//Time COmplexity: O(N*K)
//Space Complexity: O(N*K)

class Solution {
    public int maxProfit(int k, int[] arr) {
        if(k == 0 || arr.length == 0)return 0;
        int dp[][] = new int[k+1][arr.length];
        int max =0;
        for(int i=1;i<=k;i++){
            max = dp[i-1][0]-arr[0];
            for(int j = 1;j<arr.length;j++){
                dp[i][j] = Math.max(dp[i][j-1],max+arr[j]);
                max = Math.max(max,dp[i-1][j]-arr[j]);
            }
        }
        return dp[k][arr.length-1];
    }
}


//Optimised
//Space Complexity: O(N)
//Time Complexity: O(N*K)

class Solution {
    public int maxProfit(int k, int[] arr) {
        if(k == 0 || arr.length == 0)return 0;
        if (k >=  arr.length/2) {
		int maxPro = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i-1])
				maxPro += arr[i] - arr[i-1];
		}
		return maxPro;
	}
        int odd_dp[] = new int[arr.length];
        int even_dp[] = new int[arr.length];
        int max =0;
        int curr_dp[] = new int[arr.length];
        int prev_dp[] = new int[arr.length];
        for(int i=1;i<=k;i++){
            max = Integer.MIN_VALUE;
            if(i%2 == 1){
                curr_dp = odd_dp;
                prev_dp = even_dp;
            }else{
                curr_dp = even_dp;
                prev_dp = odd_dp;
            }
            for(int j = 1;j<arr.length;j++){
                max = Math.max(max,prev_dp[j-1]-arr[j-1]);
                curr_dp[j] = Math.max(curr_dp[j-1],max+arr[j]);
                
            }
        }
        return k%2 == 0?even_dp[arr.length-1]:odd_dp[arr.length-1];
    }
}
