
import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumSquare
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    int arr[][] = {{0,1,1,0,1},{1,1,1,0,0},{1,1,1,1,0},{1,1,1,0,1}};
	    int dp[][] = new int[arr.length][arr[0].length];
		int max =0;
	    for(int i=0;i<arr.length;i++){
	        if(arr[i][0] == 1){
	            dp[i][0] = 1;
			max =1;
	        }
	    }
	    for(int i=0;i<arr[0].length;i++){
	        if(arr[0][i] == 1){
	            dp[0][i] = 1;
			max =1;
	        }
	    }
	    for(int i=1;i<arr.length;i++){
	        for(int j =1;j<arr[0].length;j++){
	            if(arr[i][j] == 1){
	                dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
	            }
	            if(dp[i][j]>max){
	                max = dp[i][j];
	            }
	        }
	    }
	    System.out.println(max);
	}
}
