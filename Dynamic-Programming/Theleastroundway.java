//****************************Problem Link****************************************

https://codeforces.com/problemset/problem/2/B

import java.util.*;
import java.lang.*;
import java.io.*;
 
class Code
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int arr[][] = new int[n][n];
		int x=0,y=0;
		boolean f = false;
		for(int i=0;i<n;i++){
		    for(int j =0;j<n;j++){
		        arr[i][j] = input.nextInt();
		        if(arr[i][j] == 0){
		            arr[i][j] = 10;
		            x= i;
		            y = j;
		            f = true;
		        }
		    }
		}
	
		int dp[][][]= new int[n][n][2];
		char d[][][] = new char[n][n][2];
		dp[0][0][0]  = get(arr[0][0],2);
		dp[0][0][1]  = get(arr[0][0],5);
		for(int i=1;i<n;i++){
		     dp[0][i][0] = get(arr[0][i],2)+dp[0][i-1][0];
		     dp[0][i][1] = get(arr[0][i],5)+dp[0][i-1][1];
		     dp[i][0][0] = get(arr[i][0],2)+dp[i-1][0][0];
		     dp[i][0][1] = get(arr[i][0],5)+dp[i-1][0][1];
		     d[0][i][0] = 'R';
		     d[0][i][1] = 'R';
		     d[i][0][0] = 'D';
		     d[i][0][1] = 'D';
		     
		}
		
		for(int i=1;i<n;i++){
		    int p1=0,p2=0,c1=0,c2=0;
		    for(int j =1;j<n;j++){
		        p1 = get(arr[i][j],2)+dp[i-1][j][0];
		        p2 = get(arr[i][j],5)+dp[i-1][j][1];
		        c1 = get(arr[i][j],2)+dp[i][j-1][0];
		        c2 = get(arr[i][j],5)+dp[i][j-1][1];
		        if(p1<c1){
		            dp[i][j][0]=p1;
		            d[i][j][0] = 'D';
		        }else{
		            dp[i][j][0]=c1;
		            d[i][j][0] = 'R';
		        }
		      if(p2<c2){
		            dp[i][j][1] = p2;
		            d[i][j][1] = 'D';
		        }else{
		            dp[i][j][1] = c2;
		            d[i][j][1] = 'R';
		        }
		    }
		}
		int ans = Math.min(dp[n-1][n-1][0],dp[n-1][n-1][1]);
		int k =0;
		if(dp[n-1][n-1][0]>dp[n-1][n-1][1]){
		    k =1;
		}
		//print(n,dp);
		if(f && ans>0){
		    System.out.print(1);
		    System.out.println();
		    for(int i=0;i<x;i++){
		        System.out.print("D");
		    }
		    for(int i=0;i<y;i++){
		        System.out.print("R");
		    }
		    for(int i =0;i<n-x-1;i++){
		        System.out.print("D");
		    }
		    for(int i=0;i<n-y-1;i++){
		        System.out.print("R");
		    }
		}else{
    	    System.out.print(ans);
    	    System.out.println();
    	    print(n-1,n-1,d,k);
    	}
	}
	public static int get(int n,int i){
	    int count =0;
	    while(n>0 && n%i == 0){
	        n/=i;
	        count++;
	    }
	    return count;
	}
	public static void print(int i,int j ,char d[][][],int k){
	    if(i ==0 && j == 0)return;
	    if(d[i][j][k] == 'D'){
	        print(i-1,j,d,k);
	    }else{
	        print(i,j-1,d,k);
	    }
	    System.out.print(d[i][j][k]);
	}
	public static void print(int n,int dp[][][]){
	    for(int i =0;i<n;i++){
	        for(int j =0;j<n;j++){
	            System.out.print(dp[i][j][0]+" ");
	        }
	        System.out.println();
	    }
	    
	}
}
