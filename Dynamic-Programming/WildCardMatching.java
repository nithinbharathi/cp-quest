
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    String text = "xaylmz";
	    String pattern ="x?y*z";
	     boolean dp[][] = new boolean[text.length()+1][pattern.length()+1];
	    dp[0][0] = true;
	    for(int i =1;i<=pattern.length();i++){
	       if(i == 1 && pattern.charAt(i-1) == '*'){
	           dp[0][i] = true;
	       }else if(pattern.charAt(i-1) == '*'){
               dp[0][i] = dp[0][i-1];
           }
	    }
	    for(int i=1;i<=text.length();i++){
	        for(int j =1;j<=pattern.length();j++){
	            if(text.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) =='?'){
	                dp[i][j] = dp[i-1][j-1];
	            }else if(pattern.charAt(j-1) == '*'){
	                dp[i][j] = dp[i-1][j]||dp[i][j-1];
	            }
	        }
	    }
	    return dp[text.length()][pattern.length()];
	}
}
