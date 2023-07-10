
import java.util.*;
import java.lang.*;
import java.io.*;

class Min_Coin
{
	public static void main (String[] args) throws java.lang.Exception
	{
	
		int arr[] = new int[]{5};
		int target = 11;
		int dp[] = new int[target+1];
		for(int i=1;i<=target;i++){
		    dp[i] = target+1;      // filling each cell(subproblem) with a max value
		    
		}
		for(int i=1;i<=target;i++){
		    for(int j =0;j<arr.length;j++){       //iterating throught each coin and checking if the target can be made out of the coin chosen
		         if(i>=arr[j]){
		             
		             dp[i] = Math.min(dp[i],dp[i-arr[j]]+1);   //updating the min value
		             
		         }
		    }
		}
		int result = dp[target]>target?-1:dp[target];   // checking if the target can be made with the coins given
		System.out.println(result);
	}
}
