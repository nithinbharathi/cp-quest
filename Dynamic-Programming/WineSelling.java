//Problem Statement:https://www.geeksforgeeks.org/maximum-profit-sale-wines/

//Brute Force
//Time Complexity: O(2^n)
//Space compleixty: O(n)

import java.util.*;
import java.lang.*;
import java.io.*;

class WineSelling
{
	public static void main (String[] args) throws java.lang.Exception
	{
    	Scanner input = new Scanner(System.in);
    	int arr[] = {2,4,6,2,5};
    	System.out.println(solve(arr,0,arr.length-1,arr.length));
	}
	public static int solve(int arr[],int l,int h,int n){
	    int y = n-(h-l);
	    if(l == h)return y*arr[l];
	    int left = y*(arr[l])+solve(arr,l+1,h,n);
	    int right = y*(arr[h])+solve(arr,l,h-1,n);
	    return Math.max(left,right);
	}
}


//Dp Top Down
//Time Complexity = O(N*N)
//Space = O(N*N)


import java.util.*;
import java.lang.*;
import java.io.*;

class WineSellingTopDown
{
  static int dp[][];
	public static void main (String[] args) throws java.lang.Exception
	{
    	Scanner input = new Scanner(System.in);
    	int arr[] = {2,4,6,2,5};
    	dp= new int[arr.length][arr.length];
    	System.out.println(solve(arr,0,arr.length-1,arr.length));
	}
	public static int solve(int arr[],int l,int h,int n){
	    if(dp[l][h] != 0)return dp[l][h];
	    int y = n-(h-l);
	    if(l == h)return y*arr[l];
	    int left = y*(arr[l])+solve(arr,l+1,h,n);
	    int right = y*(arr[h])+solve(arr,l,h-1,n);
	    dp[l][h] = Math.max(left,right);
	    return dp[l][h];
	}
}


//Dp Bottom Up
//Time Complexity = O(N*N)
//Space = O(N*N)



