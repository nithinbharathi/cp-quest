
import java.util.*;
import java.lang.*;
import java.io.*;

class MinCostPath
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    int arr[][] = {{1,3,5,8},{4,2,1,7},{4,3,2,3}};
	    int dp[][] = new int[arr.length][arr[0].length];
	    dp[0][0] = arr[0][0];
	    for(int i=1;i<3;i++){
	        dp[i][0] = dp[i-1][0]+arr[i][0];
	    }
	    for(int i=1;i<arr[0].length;i++){
	        dp[0][i] = dp[0][i-1]+arr[0][i];
	    }
    	    for(int i=1;i<arr.length;i++){
    	        for(int j =1;j<arr[0].length;j++){
    	                  dp[i][j] = arr[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
    	        }
    	    }
    	    System.out.println(dp[arr.length-1][arr[0].length-1]);
	    }
}
