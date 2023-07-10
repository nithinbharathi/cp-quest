//Problem Link: https://codeforces.com/problemset/problem/474/D

import java.util.*;
import java.lang.*;
import java.io.*;
 
public Flowers 
{
    static int mod = (int)1e9+7;
    static int max = (int)1e5+1;
    static long dp[];
    static int k =0;
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner input = new Scanner(System.in);
	    int test = input.nextInt();
	    k = input.nextInt();
	    dp = new long[max];
	    dp[0] = 1;
	    long prefix[]= new long[max];
	    for(int i=1;i<max;i++){
	       if(i-k>=0){
	           dp[i]=(dp[i]+dp[i-k])%mod;
	       }
	       dp[i]=(dp[i]+dp[i-1])%mod;
	    }
	    for(int i=1;i<max;i++){
	        prefix[i] = (prefix[i-1]+dp[i])%mod;
	    }
	    while(test-->0){
	        int a = input.nextInt();
	        int b = input.nextInt();
	        System.out.println((prefix[b]-prefix[a-1]+mod)%mod);
	    }
	}
	
}
