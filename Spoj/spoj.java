package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class spoj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader input = new FastReader();
		 int test = input.nextInt();
		 while(test-->0){
			 int num1 = input.nextInt();
			 int num2 = input.nextInt();
			 int reverse_num1 = reverse(num1);
			 int reverse_num2 = reverse(num2);
			 System.out.println(reverse(reverse_num1+reverse_num2));
		 }
		 
			
		
		 
		
		}
	public static int reverse(int num){
		int reverse_num =0;
		 while(num>0){
			 reverse_num = (reverse_num*10)+num%10;
			 num/=10;
		 }
		 return reverse_num;
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