
import java.util.*;
import java.lang.*;
import java.io.*;

class RodCutting
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int t = 8;
		int arr[][] = {{1,1}, {2,5},{3,8},{4,9},{5,10},{6,17},{7,17},{8,20}};
	    int dp[] = new int[t+1];
	    for(int i=1;i<=t;i++){
	        for(int  j =0;j<arr.length;j++){
	            int l = arr[j][0];
	            int v = arr[j][1];
	            if(i>=l){
	                dp[i] = Math.max(dp[i],dp[i-l]+v);
	            }
	        }
	    }
	    System.out.println(dp[t]);
	}
}
