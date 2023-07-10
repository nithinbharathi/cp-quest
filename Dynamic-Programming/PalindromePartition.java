/* 

Given a String find the minimum partitions to be made on the String such that each partition is a palindrome?

String =>abc
Output: 2     a | b | c   |=> denoting the partitions

string => ab
Output: 1


a => 0 (Since it is already a palindrome) so for all Strings of length 1 it is 0
but for String lengths of 2 There are two cases
 
case 1: aa => 0 Since both characters of the string are already same thus already being a palindrome no partitions is required
case 2: ab=> 1 Since both the characters are different there can one partition between these two characters breaking the String of length 2 to substrings of length 1 for which we already have the solution for which is 
                partitions                          ab
                              
                                  a                                  b                              +1(Since the characters were not matching we splitted them down so each split is a partition thus we add 1)
                          (already a palindrome)          (Already a palindrome so no partitions)
                       
   As we can see Since we recompute the solution again and again we recompute the states which can be cached in some sort of Data Structure
   and reuse them when needed (The so called DYNAMIC PROGRAMMING PART!!!!!!)


*/

import java.util.*;
import java.lang.*;
import java.io.*;

class PalindromePartition
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
                    if(str.charAt(j) == str.charAt(k)){        //checking palindromes of sizes 2,3,4.... as wee know palindromes of size 1 need no partition
                        dp[j][k] = dp[j+1][k-1];     //if they are same no partititons required so check if the middle portion also satisfies the palindromic property
                    }else{
                        dp[j][k] = Math.min(dp[j][k-1],dp[j+1][k])+1;    // if they are no same split is required so adding 1 for each split that is made
                    }
                }
            }
            System.out.println(dp[0][s-1]);    //the final answer is that for a given String of length L the min partitons is found at dp[0][L-1] as we index of from 0
        }
    }
}
