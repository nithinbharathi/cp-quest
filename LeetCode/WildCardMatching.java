class Solution {
    public boolean isMatch(String s, String p) {
        int string_size = s.length();
        int pattern_size = p.length();
        boolean dp[][] = new boolean[string_size+1][pattern_size+1];
        dp[0][0] = true;
        for(int i =1;i<=pattern_size;i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i =1;i<=string_size;i++){
            for(int j =1;j<=pattern_size;j++){
                 if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                     dp[i][j] = dp[i][j-1] ||  dp[i-1][j];
                 }
            }
        }
        return dp[string_size][pattern_size]; 
    }
}
