
import java.util.*;
import java.lang.*;
import java.io.*;

class Longest
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    int s1[] = new int[]{2,5,1,8,3};
	    int dp[] = new int[s1.length];
	    for(int i=0;i<s1.length;i++){
	        for(int j =i+1;j<s1.length;j++){
	             if(s1[j]>s1[i]){
	                 dp[i] = Math.max(dp[i],dp[i]+1);
	             }
	        }
	    }
	    int max = Integer.MIN_VALUE;
	    for(int i =0;i<s1.length;i++){
	        if(dp[i]>max){
	            max = dp[i];
	        }
	    }
	    System.out.println(max);
	    
	}
}
