
import java.util.*;
import java.lang.*;
import java.io.*;

//Also called as Catalan number

class NumberOfBinaryTrees
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner input = new Scanner(System.in);
	    int n = input.nextInt();
	    int dp[] = new int[n+1];
	    dp[0] = dp[1] = 1;
	    for(int i=2;i<=n;i++){
	        for(int j=0;j<i;j++){
	            dp[i] +=dp[j]*dp[i-j-1];
	        }
	    }
	    System.out.println(dp[n]);   
	}
}
