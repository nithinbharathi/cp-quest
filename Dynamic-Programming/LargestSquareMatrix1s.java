/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
           int arr[][]= {{0, 1, 1, 0, 1},  
                         {1, 1, 0, 1, 0},  
                         {0, 1, 1, 1, 0},  
                         {1, 1, 1, 1, 0},  
                         {1, 1, 1, 0, 1},  
                         {0, 0, 0, 0, 0}};
                         
            int dp[][] = new int[arr.length][arr[0].length];
            int max =0;
            for(int i=0;i<arr.length;i++){
                for(int j =0;j<arr[0].length;j++){
                    if(i == 0 || j ==0){
                        dp[i][j] = arr[i][j];
                        continue;
                    }
                    if(arr[i][j] == 0){
                        dp[i][j] = 0;
                    }
                    else{
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                if(max <dp[i][j]){
                    max = dp[i][j];
                    }
                }
            }
            System.out.println(max);
	    
	}
}
