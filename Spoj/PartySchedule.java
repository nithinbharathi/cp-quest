import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
	Scanner input = new Scanner(System.in);
		  while(true){
		      int n = input.nextInt();
		      int m = input.nextInt();
		      if(n == 0 && m == 0)break;
		      int dp[][] = new int[m+1][n+1];
		      int items[][] = new int[m][2];
		      for(int i =0;i<m;i++){
		          int a = input.nextInt();
		          int b= input.nextInt();
		          items[i][0] = a;
		          items[i][1] = b;
		      }
		      for(int j =1;j<=m;j++){
		          int item = items[j-1][0];
		          int val = items[j-1][1];
		          for(int i =1;i<=n;i++){
		              if(i>=item){
		                  dp[j][i] = Math.max(dp[j-1][i],dp[j-1][i-item]+val);
		              }else{
		                  dp[j][i] = dp[j-1][i];
		              }
		          }
		      }
		      int ans = dp[m][n];
		      int r =0;
		      for(int i =0;i<=n;i++){
		          if(dp[m][i] == ans){
		              r = i;
		              break;
		          }
		      }
		      System.out.println(r+" "+ans);
		  }
	}
}
