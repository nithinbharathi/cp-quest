//Problem Statement : Given an Array find the miniomum increements and decreements to be made to make the array sorted

//Input: 1,2,1,4,3
//Output: 2 => increement the 1 after 2 and increement the 3 after 4
// or u can decrement 2 and decreement 4 as well
//but the solution always stays 2

//Time Complexity: O(N*M) where M is the maximum element-Minimum element+1 in the array;
//Space Complexity: O(N*M)

import java.util.*;
import java.lang.*;
import java.io.*;

class MinimumIncreementDecreement
{
    static int mod = (int)1e9+7;
    public static void main (String[] args) throws java.lang.Exception
    {
         Scanner input = new Scanner(System.in);
         int arr[] = {1,2,1,4,3};
         int min = Integer.MAX_VALUE;
         int max = Integer.MIN_VALUE;
         
         for(int i=0;i<arr.length;i++){if(arr[i]<min)min = arr[i];if(arr[i]>max)max = arr[i];}
         int dp[][] = new int[arr.length][max+1];
         for(int i=0;i<arr.length;i++){
              int minimum = Integer.MAX_VALUE;
             for(int j = min;j<=max;j++){
                 if(i == 0){
                     dp[i][j]  = Math.abs(j-arr[i]);
                 }else{
                     minimum = Math.min(dp[i-1][j],minimum);
                     dp[i][j]  = minimum+Math.abs((j-arr[i]));
                 }
             }
         }
         for(int i=min;i<=max;i++){
             System.out.println(dp[arr.length-1][i]);
            if(dp[arr.length-1][i]<ans)ans = dp[arr.length-1][i];
         }
         System.out.println(ans);
    }
}
