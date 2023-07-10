import java.util.*;
import java.lang.*;
 
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
				int test = input.nextInt();
				while(test-->0){
					int n = input.nextInt();
					PriorityQueue<Long>q = new PriorityQueue<>();
					for(int i =0;i<n;i++){
						long num = input.nextLong();
						q.add(num);
					}
					long min_cost = 0;
					while(q.size() != 1){
						long first = q.remove();
						long second = q.remove();
						min_cost += first+second;
						q.add(first+second);
						
					}
					System.out.println(min_cost);
					
				}
		input.close();
		
	}
}
