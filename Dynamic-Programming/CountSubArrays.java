//Count Number of increasing subarrays in a given array
//Time Complexity = O(N)
//Space Complexity O(N)

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		while(test-->0){
		    int n = input.nextInt();
		    long dp[] = new long[n];        //each index i tells us the longest increasing sequence ending at this index i
		    Arrays.fill(dp,1);
		    int arr[] = new int[n];
		    for(int i =0;i<n;i++){
		        arr[i] = input.nextInt();
		    }
		    for(int i =0;i<n;i++){
		        if(i == 0){
		            continue;
		        }else if(arr[i]>=arr[i-1]){                   //if the current element is greater than the previous element
                                                          //then this is an increasing sequence so we add it to the increasing sequence
		            dp[i] = dp[i-1]+1;
		        }else{
		            continue;      //elese the increasing sequence is 1 which is already filled so we continue
		        }
		    }
		    long sum=0;
		    for(int i =0;i<n;i++){
		        sum+=dp[i];
		    }
		    System.out.println(sum);
		}
	}
}


//---------------------------------------------------------------------------------------------------------------------------
//Time Complexity = O(n)
//Space Complexity = O(1)
//Same Approach without the use of dp array and the input array

public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		while(test-->0){
		    int n = input.nextInt();
		    long sum = 0;
		    long ans = 0;
		    int n1=0,n2=0;
		    for(int i =0;i<n;i++){
		        n1 = input.nextInt();
		        if(i == 0){
		            sum=1;
		        }else if(n1>=n2){
		            sum++;
		        }else{
		            sum =1;
		        }
		        ans +=sum;
		        n2 = n1;
		    }
		    System.out.println(ans);
		}
	}
