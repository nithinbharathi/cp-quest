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
	  int z =1;
	  while(test-->0){
	      int l1 = input.nextInt();
	      int l2 = input.nextInt();
	      String s1 = input.next();
	      String s2 = input.next();
	      int dp[][] = new int[l1+1][l2+1];
	      for(int i =1;i<=l1;i++){
	          dp[i][0] = i;
	      }
	      for(int j =1;j<=l2;j++){
	          dp[0][j] = j;
	      }
	      for(int i =1;i<=l1;i++){
	          for(int j =1;j<=l2;j++){
	              if(s1.charAt(i-1) == s2.charAt(j-1)){
	                  dp[i][j] = dp[i-1][j-1]+1;
	              }else{
	                  dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+1;
	              }
	          }
	      }
	      System.out.println("Case "+z+": "+dp[s1.length()][s2.length()]);
	      z++;
	  }
	}
}
