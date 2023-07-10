
import java.util.*;
import java.lang.*;
import java.io.*;

class LongestPalindromicSubsequence
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    String s = "agbdba";
	    int dp[][] = new int[s.length()][s.length()];
	    int max = 1;
	    for(int i=0;i<s.length();i++){
	        dp[i][i] = 1;
	    }
	    for(int i=1;i<s.length();i++){
	        for(int j =0;j<s.length()-i;j++){
	            int k =j+i;
	            if(i == 1 && s.charAt(j) == s.charAt(k)){
	                dp[j][k] = 2;
	            }else if(s.charAt(j) == s.charAt(k)){
	                dp[j][k] = 2+dp[j+1][k-1];
	            }else{
	                dp[j][k] = Math.max(dp[j+1][k],dp[j][k-1]);
	            }
	        }
	    }
	    System.out.println(dp[0][s.length()-1]);
	}
}
