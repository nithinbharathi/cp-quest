
import java.util.*;
import java.lang.*;
import java.io.*;

class OptimalGame
{
    static class pair{
        int first,second,pick;
        public pair(){
            first =0;
            second =0;
        }
    } 
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int arr[] = {3,9,1,2};
		pair dp[][] = new pair[arr.length][arr.length];
		for(int i=0;i<arr.length;i++){
		    for(int j =0;j<arr.length;j++){
		        dp[i][j] = new pair();
		    }
		}
		for(int i=0;i<arr.length;i++){
		    dp[i][i].first = arr[i];
		}
		for(int i=1;i<arr.length;i++){
		    for(int j =0;j<arr.length-i;j++){
		        int k = j+i;
		       
		        if(arr[j]+dp[j+1][k].second > arr[k]+dp[j][k-1].second){
		          
		             dp[j][k].first = arr[j]+dp[j+1][k].second;
		             dp[j][k].second = dp[j+1][k].first;
		             
		        }else{
		             
		            dp[j][k].first = arr[k]+dp[j][k-1].second;
		             dp[j][k].second = dp[j][k-1].first;
		            
		        }
		    }
		}
		System.out.println(dp[0][arr.length-1].first);
	    	
		
	}
}
