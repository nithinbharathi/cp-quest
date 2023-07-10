
import java.util.*;
import java.lang.*;
import java.io.*;

class MaxSumIncreasingSequence
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    int arr[] = {4,6,1,3,8,4,6};
	    int dp[]  = new int[arr.length];
	    for(int i=0;i<arr.length;i++){
	        dp[i] = arr[i];
	    }
	    int max = Integer.MIN_VALUE;
	    for(int i=0;i<arr.length;i++){
	        for(int j =0;j<i;j++){
	            if(arr[i]>arr[j]){
	                dp[i] = Math.max(arr[i]+dp[j],dp[i]);
	            }
	        }
	        if(dp[i]>max){
	            max = dp[i];
	        }
	    }
	    System.out.println(max);
	    
	}
}
