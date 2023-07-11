import java.util.*;
import java.lang.*;
import java.io.*;

public class BooksExchange
{
 
	public static void main (String[] args) throws java.lang.Exception
    {
        Scanner input = new Scanner(System.in);
        int test = input.nextInt();
        while(test-->0){
            int n = input.nextInt();
            int arr[] = new int[n];
            for(int i =0;i<n;i++){
                arr[i] = input.nextInt();
                arr[i] = arr[i]-1;
            }
            for(int i =0;i<n;i++){
                int pos = i;
                int count =0;
                do{
                    ++count;
                    pos = arr[pos];
                }while(pos != i);
                System.out.print(count+" ");
            }
            System.out.println();
        }
    }
}
