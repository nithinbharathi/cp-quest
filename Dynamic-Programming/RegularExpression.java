
import java.util.*;
import java.lang.*;
import java.io.*;

class RegularExpression
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    String pattern ="c*a*b";
	    String text = "aab";
	    boolean dp[][] = new boolean[text.length()+1][pattern.length()+1];
	    dp[0][0] = true;
	    for(int i=1;i<=pattern.length();i++){
	        if(i ==1 && pattern.charAt(i-1) == '*'){
	               dp[0][i] = true;
	        }else{
	            dp[0][i] = pattern.charAt(i-1) == '*'?dp[0][i-2]:false;
	        }
	    }
	    for(int i=1;i<=text.length();i++){
	        for(int j =1;j<=pattern.length();j++){
	              if(pattern.charAt(j-1) == '.' || pattern.charAt(j-1) == text.charAt(i-1)){
	                   dp[i][j] = dp[i-1][j-1];
	              }else if(pattern.charAt(j-1) == '*'){
	                  dp[i][j] = dp[i][j-2];
	                  if(text.charAt(i-1) == pattern.charAt(j-2) || pattern.charAt(j-2) == '.'){
	                      dp[i][j] = dp[i][j] || dp[i-1][j];
	                  }
	              }
	        }
	    }
	    System.out.println(dp[text.length()][pattern.length()]);

	}
}
