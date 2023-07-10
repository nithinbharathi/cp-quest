import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class spoj {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// TODO Auto-generated method stub
		int test = input.nextInt();
		while(test-->0){
			int a = input.nextInt();
			int b = input.nextInt();
		    int rem = exp(a,b);
		    System.out.println(rem);
			
		}
		
	}
	public static int exp(int a,int b){
		if(b == 0){
			return 1;
		}
		if(b%2 == 0){
			int r = exp(a,b/2)%10;
			return (r*r)%10;
		}else{
			return (a*exp(a,b-1))%10;
		}
	}
} 
