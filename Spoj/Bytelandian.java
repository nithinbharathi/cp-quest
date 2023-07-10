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
		helper(10);
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
		if(n<1000001){
		if(dp.containsKey(n)){
			return dp.get(n);
		}else{
		
			for(int i =1;i<1000001;i++){
				long temp =i;
				dp.put(temp,temp);
				long sum =0;
				for(int j =2;j<=4;j++){
						long ans = i/j;
						sum += dp.get(ans);
				}
				
				dp.put(temp, Math.max(temp, sum));
			}
		}

	}else{
		long val = helper(n/2)+helper(n/3)+helper(n/4);
		dp.put(n,val);
	}
		return dp.get(n);
	}
}
