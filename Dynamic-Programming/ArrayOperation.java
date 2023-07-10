//Time Complexity = O(n*m)
//Space Complexity = O(n*m)


import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		    int n = input.nextInt();
		    int m = input.nextInt();
		    int arr[] = new int[n];
		    for(int i =0;i<n;i++){
		        arr[i] = input.nextInt();
		    }
		   
		    for(int j =0;j<m;j++){
		         HashSet<Integer> set = new HashSet<>();
		        int q = input.nextInt();
		        for(int i =q-1;i<n;i++){
		            set.add(arr[i]);
		        }
		        System.out.println(set.size());
		    }
		}
}

//---------------------------------------------------------------------------------------------------------------------------------------------------

//Time Complexity=O(n)
//Space Complexity =O(n)

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		    int n = input.nextInt();
		    int m = input.nextInt();
		    int arr[] = new int[n];
		    int hash[] = new int[200000];
		    int result[] = new int[n];
		    for(int i =0;i<n;i++){
		        arr[i] = input.nextInt();
		    }
		    int ans =0;
		   for(int i = n-1;i>=0;i--){
		       hash[arr[i]]++;
		       if(hash[arr[i]] == 1){
		           ans++;
		       }
		       result[i] = ans;
		   }
		   for(int i =0;i<m;i++){
		       int q = input.nextInt();
		       System.out.println(result[q-1]);
		   }
		    
		}
}

