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
		int dp[][] = new int[501][501];
		   for(int i =0;i<=500;i++){
		       dp[i][0] =  Integer.MAX_VALUE;
		       dp[0][i] = Integer.MAX_VALUE;
		   }
		    for(int i =1;i<=500;i++){
		        for(int j =1;j<=500;j++){
		            if(i == 1 && j == 1){
		                continue;
		            }
		            int m = Integer.MAX_VALUE;
		            int g = gcd(i,j);
		            if(g != 1){
		             
		                m = Math.min(m,dp[i/g][j/g]+1);
		            }            
               m = Math.min(m,(Math.min(dp[i][j-1],dp[i-1][j])+1));
               dp[i][j] = m;   
		        }
		    }
		while(test-->0){
		    int n = input.nextInt();
		    int m = input.nextInt();
		   System.out.println(dp[n][m]);
		    
		}
	}
	public static int gcd(int a,int b){
	    if(b == 0){
	        return a;
	    }
	    return gcd(b,a%b);
	}
}
