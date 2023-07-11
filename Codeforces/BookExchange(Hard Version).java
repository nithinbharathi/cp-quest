import java.util.*;
import java.lang.*;
import java.io.*;
 
public class BookExchange
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
            int visit[] = new int[n];
            int ans[] = new int[n];
            for(int i =0;i<n;i++){
              int pos = i;
                if(visit[pos] == 0){
                    ArrayList<Integer>curr = new ArrayList<>();
                    while(visit[pos] == 0){
                        curr.add(pos);
                        visit[pos] = 1;
                        pos = arr[pos];
                    }
                    for(int j:curr){
                        ans[j] = curr.size();
                    }
                }
            }
           for(int i =0;i<n;i++){
               System.out.print(ans[i]+" ");
           }
           System.out.println();
        }
    }
}
