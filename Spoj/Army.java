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
	        br.readLine();
	       String arr[] = br.readLine().split(" ");
	        int n1 =  Integer.parseInt(arr[0]);
	        int n2 = Integer.parseInt(arr[1]);
	        String g[] = br.readLine().split(" ");
	        String m[] = br.readLine().split(" ");
	        int l1 = largest(g,n1);
	        int l2 = largest(m,n2);
	        if(l1<l2){
	            System.out.println("MechaGodzilla");
	        }else{
	            System.out.println("Godzilla");
	        }
	    }
	}
	public static int largest(String arr[],int size){
	    int l = Integer.MIN_VALUE;
	    for(int i =0;i<size;i++){
        if(Integer.parseInt(arr[i])>l){
            l = Integer.parseInt(arr[i]);
        }
	    }
	    return l;
	}
}
