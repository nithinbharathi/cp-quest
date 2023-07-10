/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{   static long dp[][][];
	public static void main (String[] args) throws java.lang.Exception
	{
	    
	    long result = nth_fib(4);
	    System.out.println(result);
	    
	} 
	public static long nth_fib(int n){
	    if(n<0){
	        System.out.println("Enter a valid n value!");
	    }else if(n == 0 || n == 1){
	        return 1;
	    }
	     dp = new long[64][2][2];
	    dp[0] = new long[][]{{1,1},{1,0}};
	    for(int i =1;i<64;i++){
	        dp[i] = power(dp[i-1]);
	    }
	    
	    long ans = binary_exponenciation(n-1);
	    return ans;
	}
	public static long[][] power(long m[][]){
	    return multiply(m,m);
	}
	private static long[][] multiply(long[][] matrix1, long[][] matrix2) {

        final long[][] result = new long[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[i].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                    
                }
            }
        }
        return result;
    }
	public static long binary_exponenciation(int n){
	    long[][] result = new long[][]{{1, 0}, {0, 1}};
        for (int i = 31; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                result = multiply(result, dp[i]);
            }
        }
        
	    return result[0][0]+result[0][1];
	}
}
