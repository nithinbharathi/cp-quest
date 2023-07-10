//DP ON TREES


import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static int dp[] = new int[50];
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner input = new Scanner(System.in);
	    int n = input.nextInt();
	    List<Integer>v[] = new ArrayList[n+1];
	    for(int i=0;i<=n;i++){
	        v[i] = new ArrayList<>();
	    }
	    v[1].add(2); v[2].add(1); 
        v[1].add(3); v[3].add(1); 
        v[1].add(4); v[4].add(1); 
        v[2].add(5); v[5].add(2); 
        v[2].add(6); v[6].add(2); 
        v[3].add(7); v[7].add(3); 
        v[4].add(8); v[8].add(4); 
        v[4].add(9); v[9].add(4); 
        v[4].add(10); v[10].add(4); 
        v[5].add(11); v[11].add(5); 
        v[5].add(12); v[12].add(5); 
        v[7].add(13); v[13].add(7); 
        v[7].add(14); v[14].add(7); 
	    int a[] = { 3, 2, 1, 10, 1, 3, 9, 1, 5, 3, 4, 5, 9, 8 }; 
	   System.out.println(max(v,a));
	    
	}
	public static int max(List<Integer>l[],int a[]){
	    dfs(l,a,1,0);
	    return dp[1];
	}
	public static void dfs(List<Integer>l[],int a[],int u,int p){
	    dp[u] =a[u-1];
	    int max =0;
	    for(int c:l[u]){
	        if(c == p)continue;
	        dfs(l,a,c,u);
	        max = Math.max(max,dp[c]);
	    }
	    dp[u]+=max;
	}
}
