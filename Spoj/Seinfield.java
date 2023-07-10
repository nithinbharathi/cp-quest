import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
 Scanner input = new Scanner(System.in);
		  int t=1;
		  while(true){
		      String a = input.next();
		      if(a.charAt(0) == '-'){
		          break;
		      }
		      Stack<Character>stack = new Stack<>();
		      int count =0;
		      for(int i =0;i<a.length();i++){
		          if(a.charAt(i) == '{'){
		              stack.push('{');
		          }else if(!stack.isEmpty() && stack.peek()=='{'){
		              stack.pop();
		          }else{
		              stack.push('{');
		              count++;
		          }
		      }
		      
		          int ans = (stack.size()/2)+count;
		          System.out.println(t+". "+ans);
		      t++;
		  }
	}
}
