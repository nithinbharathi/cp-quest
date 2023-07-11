

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class solution {
static int count = 0;
	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 int n = Integer.parseInt(br.readLine());
	 int m=0,c=0,i=0;
	 while(i<n) {
		 String line[] = br.readLine().split(" ");
		 if(Integer.parseInt(line[0])>Integer.parseInt(line[1])) {
			 m++;
			
		 }else if(Integer.parseInt(line[0])<Integer.parseInt(line[1]))  {
			 c++;
		 }
		 i++;
	 }
	 if(m == c)System.out.println("Friendship is magic!^^");
	 if(m>c)System.out.println("Mishka");
	 else if(c>m)System.out.println("Chris");
	 
	}
	
}
