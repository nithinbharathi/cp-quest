
import java.util.*;
import java.lang.*;
import java.io.*;

class Subset
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   int arr[] = new int[]{2,3,7,8,10};
	   int target = 11;
	   boolean dp[][] = new boolean[arr.length+1][target+1];
	   dp[0][0] = true;
	    for(int i=1;i<=arr.length;i++){
	        dp[i][0] = true;
	   }
	   for(int i = 1;i<=arr.length;i++){
	       for(int j =1;j<=target;j++){
	             if(j>=arr[i-1]){
	                 dp[i][j] = dp[i-1][j] | dp[i-1][j-arr[i-1]];
	             }else{
	                 dp[i][j] = dp[i-1][j];
	            }
	       }
	   }
	   System.out.println(dp[arr.length][target]);
	}
}
