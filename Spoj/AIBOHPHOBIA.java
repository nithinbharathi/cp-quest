/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-->0){
            String str = br.readLine();
            int s = str.length();
            int dp[][] = new int[s][s];
            for(int i =1;i<s;i++){
                for(int j =0,k =i;k<s;j++,k++){
                    if(str.charAt(j) == str.charAt(k)){
                        dp[j][k] = dp[j+1][k-1];
                    }else{
                        dp[j][k] = Math.min(dp[j][k-1],dp[j+1][k])+1;
                    }
                }
            }
            System.out.println(dp[0][s-1]);
        }
    }
}
