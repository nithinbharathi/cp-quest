
import java.util.*;
import java.lang.*;
import java.io.*;

class Knapsack
{
	public static void main (String[] args) throws java.lang.Exception
	{
	        Scanner input = new Scanner(System.in);
	        
	        System.out.println("enter the capacity of knapsack");
	        int c = input.nextInt();
	        System.out.println("enter the number of objects");
	        int n = input.nextInt();
	        int w[][] = new int[n][2];
	        System.out.println("enter the weight and value");
	        for(int i =0;i<n;i++){
	            w[i][0] = input.nextInt();
	            w[i][1] = input.nextInt();
	        }
	        int dp[][] = new int[n][c+1];
	        for(int i=1;i<=c;i++){
	            if(w[0][0]<=i){
	                dp[0][i] = w[0][1];
	            }
	        }
	        for(int i=1;i<n;i++){
	            int we = w[i][0];
	            int val = w[i][1];
	            for(int j =1;j<=c;j++){
	                if(we<=j){
	                    dp[i][j] = Math.max(dp[i-1][j-we]+val,dp[i-1][j]);
	                }else{
	                    dp[i][j] = dp[i-1][j];
	                }
	            }
	        }
	        System.out.println(dp[n-1][c]);
	        
	}
}
