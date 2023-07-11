import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		while(test-->0){
		    int n = input.nextInt();
		    int score[] = new int[200];
		    int foul [] = new int[200];
		    for(int i=0;i<n;i++){
		        score[i] = input.nextInt();
		    }
		    for(int i =0;i<n;i++){
		        foul[i] = input.nextInt();
		    }
		    
		   int foul_ptr = 0;
		   int score_ptr =0;
		   int max_score = Integer.MIN_VALUE;
		   while(foul_ptr<n){
		      max_score = Math.max(max_score,(score[score_ptr]*20 - foul[foul_ptr]*10));
		       foul_ptr++;
		       score_ptr++;
		   }
		   if(max_score<0){
		       System.out.println(0);
		   }
		   else{
		       System.out.println(max_score);
		   }
		}
	}
}
