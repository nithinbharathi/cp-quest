
import java.util.*;
import java.lang.*;
import java.io.*;

class DividingSequence
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
		    arr[i] = input.nextInt();
		}
		int max = 0;
		int dp[]= new int[n];
		Arrays.fill(dp,1);
		for(int i=0;i<n;i++){
		    for(int j =i+1;j<n;j++){
		         if(arr[j]%arr[i] == 0){
		             dp[j] = Math.max(dp[j],dp[i]+1);
		         }
		    }

		}
		for(int i=0;i<n;i++){
		    if(max<dp[i])max = dp[i];
		}
		System.out.println(max);
	}
}
