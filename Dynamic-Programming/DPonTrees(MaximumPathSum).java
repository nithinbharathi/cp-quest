
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{ 
    static int vis[] = new int[1000];
    static int dp[] = new int[1000];
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		ArrayList<Integer>t[] = new ArrayList[n+1];
		for(int i=1;i<=n;i++){
		    t[i] = new ArrayList<>();
		}
		for(int i=0;i<n-1;i++){
		    int u = input.nextInt();
		    int v = input.nextInt();
		    t[u].add(v);
		    t[v].add(u);
		    
		}
		for(int i=1;i<=n;i++){
		    int val = input.nextInt();
		    dp[i] = val;
		}
      
		dfs(t,1);
		System.out.println(dp[1]);
		
	}
	public static void dfs(ArrayList<Integer>t[],int r){
	    vis[r] = 1;
	    int max =0;
	    for(int j=0;j<t[r].size();j++){
	        int c =t[r].get(j);
	           if(vis[c] == 0){
	               dfs(t,c);
	               max = Math.max(max,dp[c]);
	           }
	    }
	    dp[r]+=max;
	}
}
