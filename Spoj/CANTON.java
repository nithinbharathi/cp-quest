import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int test = Integer.parseInt(br.readLine());
	    while(test-->0){
	        int n = 1,d=1;
	        int k = Integer.parseInt(br.readLine());
	        int i =1,terms = 1;
	        while(i<k){
	            int z =0;
	            d++;
	            i++;
	            if(i == k)break;
	            while(z<terms && i <k){
	                d--;
	                n++;
	                i++;
	                z++;
	                
	            }
	            
	            if(i == k){
	                break;
	            }
	            terms++;
	            n++;
	            i++;
	            if(i == k)break;
	            z=0;
	            while(z<terms && i<k){
	                n--;
	                d++;
	                i++;
	                z++;
	            }
	            terms++;
	            if(i == k)break;
	        }
	        System.out.println("TERM "+k+" IS "+n+"/"+d);
	    }
	    
	    
	}
}
