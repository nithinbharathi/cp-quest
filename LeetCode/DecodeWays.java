class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 ){
            return 0;
        }
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s,0,dp);
    }
    public int helper(String str,int index,int dp[]){
       if(index == str.length()){
           return 1;
       }
        if(dp[index] != -1){
            return dp[index];
        }
       boolean one_digit = str.charAt(index) != '0';
       boolean two_digit = false;
       int ways = 0;
       if(index+1 < str.length()){
           int num = Integer.parseInt(str.substring(index,index+2));
           if(num>9 && num<27){
               two_digit = true;
           }
       }
       if(one_digit){
            ways += helper(str,index+1,dp);
       } 
       if(two_digit){
            ways += helper(str,index+2,dp);
       }
       dp[index] = ways; 
      return ways;
        
    }
}
