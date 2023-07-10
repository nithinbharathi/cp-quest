//Codeforces DIV 2D FLOWERS


import java.util.*;
import java.lang.*;
import java.io.*;

class Flowers
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
	    long prefix[] = new long[max];
	    dp = new long[max];
	    for(int i=1;i<max;i++){
	        prefix[i] = (prefix[i-1]+solve(i))%mod;
	    }
	    while(test-->0){
	        int a = input.nextInt();
	        int b = input.nextInt();
	        System.out.println((prefix[b]-prefix[a-1]+mod)%mod);
	    }
	}
	public static long solve(int n){
	    if(n == 0)return 1;
	    if(dp[n] != 0)return dp[n];
	    long ans =0;
	    if(n-k>=0){
	        ans= (ans+solve(n-k))%mod;
	    }
	    ans= (ans +solve(n-1))%mod;
	    dp[n]  =ans;
	    return dp[n];
	}
}
