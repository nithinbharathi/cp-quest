// Problem Link: https://codeforces.com/contest/1061/problem/C
//


import java.util.*;
import java.lang.*;
import java.io.*;

class Multiplicity
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int n =  input.nextInt();
		int arr[] = new int[n+1];
		for(int i=0;i<n;i++){
		    arr[i] = input.nextInt();
		}
		int div[] = new int[1000001];
		for(int i=1;i<1000001;i++){
		    for(int j =i;j<1000001;j+=i){
		        div[j]++;
		        
		    }
		}
		int divisor[][] = new int[1000001][];
		divisor[0] = new int[1];
		for(int i=1;i<1000001;i++){
		    divisor[i] = new int[div[i]];
		}
	   int div_ptr[] = new int[1000001];
	   for(int i=1000000;i>=1;i--){
	       for(int j =i;j<1000001;j+=i){
	             divisor[j][div_ptr[j]++] = i;
	           }
	       }
	    long res=0;
	    int mod = (int)1e9+7;
	    int dp[] = new int[1000001];
	    dp[0] = 1;
	    for(int i=0;i<n;i++){
	        for(int num:divisor[arr[i]]){
	                dp[num] = (dp[num]+dp[num-1])%mod;
	        }
	    }
	    for(int i =1;i<1000001;i++){
	        res = (res+dp[i])%mod;
	    }
	    System.out.println(res);
	    
	       
	}
}
