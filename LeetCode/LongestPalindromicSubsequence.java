class Solution {
    public int longestPalindromeSubseq(String s) {
        int dp[][]  = new int[s.length()][s.length()];
        int max =1;
        
        //filling for palindromes of lengths 1
        for(int i =0;i<s.length();i++){
            dp[i][i] = 1;
        }
        
        //filling for palindromes of size 2;
        for(int i =0;i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 2;
                max =2;
            }else{
                dp[i][i+1] = 1;
            }
        }
        
        //fro palindromes of size>=3
        for(int i =2;i<s.length();i++){
            for(int j =0;j<s.length();j++){
               int k = j+i;
                if(k<s.length() && s.charAt(j) == s.charAt(k)){
                    dp[j][k] = dp[j+1][k-1]+2;
                }else{
                    
                    if(k<s.length())dp[j][k] = Math.max(dp[j][k-1],dp[j+1][k]);
                }
            }
        }
        return Math.max(max,dp[0][s.length()-1]);
    }
}
