import java.util.*;
import java.lang.*;

class Main
{
	static Map<Long,Long> dp = new HashMap<>();
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		long temp =0;
		dp.put(temp, temp);
		helper(10);    // precomputing till 10^6
		while(input.hasNext()){
			int n = input.nextInt();
			if(n<10){
				System.out.println(n);
			}else{
				System.out.println(helper(n));
			}
			
		}
		input.close();
	}
	public static long helper(long n ){
	if(n<1000001){    // Checking if n is less than 10^6
  
     if(dp.containsKey(n)){
        return dp.get(n);    //checking if we have the answer for the current n value
        
      }else{
        for(int i =1;i<1000001;i++){   //precomputation
          long temp =i;               
          dp.put(temp,temp);       // for all value temporarily storing the value as the maximum result 1->1,2->2,3->3...... so on initially
          long sum =0;
            for(int j =2;j<=4;j++){    // n/2,n/3,n/4
                long ans = i/j;
                sum += dp.get(ans);
            }
          dp.put(temp, Math.max(temp, sum));   // checking if the computed sum is greater then the temporary value that was put into the map and storing the maximum value
        }
		}
    
	}else{
		long val = helper(n/2)+helper(n/3)+helper(n/4);    // when n>10^6 solving it down by breaking it down into sub-problems
		dp.put(n,val);   // storing the computed result
	}
		return dp.get(n);
		
	}
}
