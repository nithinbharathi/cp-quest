import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class spoj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader input = new FastReader();
		
		int test = input.nextInt();
		while(test-->0){
			long n = Long.parseLong(input.next());
			int num_zero = factorial(n);
			System.out.println(num_zero);
		}
	}
		public static int  factorial(long n){
			int count =0;
			for(int i =5;n/i>=1;i*=5){
				count+=n/i;
			}
			return count;
			
		}
		
	}
	
	
	   
class FastReader{
	StringTokenizer str;
	BufferedReader br;
	public FastReader(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	public String next(){
		while(str == null || !str.hasMoreTokens()){
			try{
				str = new StringTokenizer(br.readLine());

			}
			catch (Exception e){
				throw new RuntimeException(e);
			}
		}
		return str.nextToken();
	}
	public int nextInt(){
		return Integer.parseInt(next());
	}
}
