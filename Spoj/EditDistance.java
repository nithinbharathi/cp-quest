import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    String a = br.readLine();
		    String b = br.readLine();
		    int dp[][] = new int[a.length()+1][b.length()+1];
		    for(int i =1;i<=b.length();i++){
		        dp[0][i] = i;
		    }
		    for(int i =1;i<=a.length();i++){
		        dp[i][0] = i;
		    }
		    for(int i =1;i<=a.length();i++){
		        for(int j =1;j<=b.length();j++){
		            if(a.charAt(i-1) == b.charAt(j-1)){
		                dp[i][j] = dp[i-1][j-1];
		            }else{
		                    dp[i][j] =Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
		            }
		        }
		    }
		    System.out.println(dp[a.length()][b.length()]);
		}
	}
}
