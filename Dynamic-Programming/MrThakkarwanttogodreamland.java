/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner input = new Scanner(System.in);
	    int test = input.nextInt();
	    while(test-->0){
	        int target = input.nextInt();
	        int dp[] = new int[target+1];
	        dp[0] = 0;
	        for(int i =1;i<=target;i++){
	            if(i%2 == 0){
	                dp[i] = Math.min(dp[i-1]+1,dp[i-2]+2);
	            }else{
	                dp[i]  =dp[i-1]+1;
	            }
	        }
	        System.out.println(dp[target]);
	    }
	}
}
