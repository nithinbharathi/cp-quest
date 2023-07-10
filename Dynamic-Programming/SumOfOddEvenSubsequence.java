/* Problem Statement: Given an array, find the number of subsequences whose sum is even and the number of subsequences
whose sum is odd in total
{1,2,3} => odd_subsequences  = {1},{3},{1,2},{2,3}count:4
        => even Subsequences = {2},{1,3},{1,2,3} count:3
         total count: 6 
So output = 7
*/

//Time Complexity= O(n)
//Space Compexity = O(2n) = O(n)

import java.util.*;
import java.lang.*;
import java.io.*;

class SumOfOddEvenSubsequence
{
    public static void main (String[] args) throws java.lang.Exception
    {
         Scanner input = new Scanner(System.in);
           int arr[] = {1, 2, 2, 3 };
           int odd[] = new int[arr.length];
           int even[] = new int[arr.length];
           if(arr[0]%2 == 0)even[0] = 1;
           if(arr[0]%2 != 0)odd[0] = 1;
           for(int i=1;i<arr.length;i++){
                if(arr[i]%2 == 0){
                    even[i] = even[i-1]+even[i-1]+1;
                    odd[i] = odd[i-1]+odd[i-1];
                    
                }else{
                    odd[i] = 1+even[i-1]+odd[i-1];
                    even[i] = odd[i-1]+even[i-1];
                }
           }
           System.out.println(even[arr.length-1]+odd[arr.length-1]);
    }
} 

//Better space complexity Approach => O(1) and Time being same as the  previous approach which is O(N)


import java.util.*;
import java.lang.*;
import java.io.*;

class SumOfOddEvenSubsequence
{
    public static void main (String[] args) throws java.lang.Exception
    {
         Scanner input = new Scanner(System.in);
           int arr[] = {1, 2,3 };
           int odd = 0,even =0;
           if(arr[0]%2 == 0)even=1;
           if(arr[0]%2 != 0)odd = 1;
           for(int i=1;i<arr.length;i++){
               if(arr[i]%2 == 0){
                   even = even+even+1;
                   odd = odd + odd;
               }else{
                   int temp = even;   // the reason we use temp is because if we update even count  directly then 
                                      //odd result will get affected as its based on even count as well
                   even = odd+temp;   
                   odd = odd + temp+1;  // we want to calculate odd based on previous even count and not the updated count
               }
           }
           System.out.println(even+odd);
    }
}

