import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine());
	        int counter = 0;
	        int result =0;
	        int flag =0;
	        HashSet<Integer>set = new HashSet<>();
	        while(true){
	            while(n>0){
    	            result = result+((n%10)*(n%10));
    	            n/=10;
	            }
	            n = result;
	            counter++;
	            if(set.contains(n)){
	                flag = 1;
	                break;
	            }else if(result == 1){
	                break;
	            }
	            set.add(n);
	            result =0;
	            
	        }
	        if(flag == 1){
	            System.out.println("-1");
	        }else{
	            System.out.println(counter);
	        }
	       
	}
}
