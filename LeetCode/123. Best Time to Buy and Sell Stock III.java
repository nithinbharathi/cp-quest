class Solution {
    public int maxProfit(int[] arr) {
        if(arr.length == 0)return 0;
        int k =2;
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
