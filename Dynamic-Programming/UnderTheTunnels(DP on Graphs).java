//https://www.codechef.com/LTIME80B/problems/POPTUNNL

//Solution: BFS + DP

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		while(test-->0){
		    int n = input.nextInt();
		    int k = input.nextInt();
		    input.nextLine();
		    String arr[] = new String[n];
		    for(int i=0;i<n;i++){
		        arr[i] = input.nextLine();
		    }
		    
		    int dp[] = new int[n];
		    Queue<Integer>q = new LinkedList<>();
		    q.add(0);
		    Arrays.fill(dp,Integer.MAX_VALUE);
		    dp[0] = 0;
		    int vis[] = new int[n];
		    while(!q.isEmpty()){
		        int node = q.remove();
		        
		        vis[node] = 1;
		        for(int i=0;i<arr[node].length();i++)
		            if(arr[node].charAt(i) == '1' && i != node){
		                if(Math.abs(node-i)<=k && dp[node]+1<dp[i] && vis[i] == 0){
		                     q.add(i);
		                    dp[i] = dp[node]+1;
		                }
		            }
		        }
		   if(dp[n-1] == Integer.MAX_VALUE)System.out.println("-1");
		   else System.out.println(dp[n-1]);
		}
	}
}
