
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static int c =0;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int arr[] = {10,12,20};
        int f[] = {34, 8, 50};
        int dp[][] = new int[arr.length][arr.length];

        for(int i=0;i<arr.length;i++)dp[i][i] = f[i];
		for(int l = 1;l<arr.length;l++){
		    for(int i =0;i<arr.length-l;i++){
		        int j = i+l;
		        dp[i][j]  =Integer.MAX_VALUE;
		        int sum = getSum(i,j,f);
		        for(int k = i;k<=j;k++){
		            int val = sum+(k-1<i?0:dp[i][k-1])+(k+1>j?0:dp[k+1][j]);
		            if(val<dp[i][j]){
		                dp[i][j] = val;
		            }
		        }
		    }
		}
		System.out.println(dp[0][arr.length-1]);
		
	}
	public static int getSum(int l,int r,int arr[]){
	    int sum =0;
	    for(int i=l;i<=r;i++){
	        sum+=arr[i];
	    }
	    return sum;
	}
		
}
