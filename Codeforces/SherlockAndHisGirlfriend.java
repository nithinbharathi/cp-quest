/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Sherlock
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int dp[] = new int[n+2];
		for(int i =2;i<=n+1;i++){
		    if(dp[i] == 0){
    		    for(int j =2;i*j<=n+1;j++){
    		        dp[i*j] = 2;
    		    }
    		    dp[i] = 1;
		    }
		}
		if(n>2){
		    System.out.println("2");
		}else{
		    System.out.println("1");
		}
		for(int i=2;i<=n+1;i++){
		    System.out.print(dp[i]+" ");
		}
	}
}
