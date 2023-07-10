

import java.util.*;
import java.lang.*;
import java.io.*;

class LongestCommonSubstring
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
	    String str1  = input.nextLine();
	    String str2 = input.nextLine();
	    int dp[][] = new int[str1.length()][str2.length()];
	    int max =0;
	    for(int i=0;i<str1.length();i++){
	        for(int j =0;j<str2.length();j++){
	            if(str1.charAt(i) == str2.charAt(j)){
	                if(i ==0 || j ==0){
	                    dp[i][j] = 1;
	                }else{
	                    dp[i][j] = dp[i-1][j-1]+1;
	                }
	            }
	            if(dp[i][j]>max){
	                max = dp[i][j];
	            }
	        }
	    }
	    System.out.println(max);
	    
	}
}
