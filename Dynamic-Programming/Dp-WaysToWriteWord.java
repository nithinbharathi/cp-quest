/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    int mod = 1000000007;
	    long dp[][] = new long[500][500];
	    for(int i=1;i<500;i++){
	        dp[1][i] = 1;
	    }

	    for(int i = 2;i<500;i++){
	        for(int j =1;j<500;j++){
	         if(i == j){
	                dp[i][j] = 1;
	            }else{
	                for(int z =1;z<=j-i+1;z++){
	                    dp[i][j]+=dp[i-1][j-z];
	                }
	            }
	        }
	    }
	    Scanner input = new Scanner(System.in);
	    int test = input.nextInt();
	    int vowel_count[] = new int[5];
	    
	    while(test-->0){
	      long result = 1;
	      for(int i =0;i<5;i++){
	          vowel_count[i] = input.nextInt();
	      }
	      String str = input.next();
	      int cache[] = new int[5];
	      for(int i =0;i<str.length();i++){
	          if(str.charAt(i) == 'a'){
	              cache[0]++;
	          }else if(str.charAt(i) == 'e'){
	              cache[1]++;
	          }else if(str.charAt(i) =='i'){
	              cache[2]++;
	          }else if(str.charAt(i) == 'o'){
	              cache[3]++;
	          }else if(str.charAt(i)=='u'){
	              cache[4]++;
	          }
	          
	      }
	      for(int i =0;i<5;i++){
	          if(cache[i] == 0)continue;
	          result*=dp[cache[i]][vowel_count[i]];
	          result=result%mod;
	      }
	      System.out.println(result);
	    }


	}
}
