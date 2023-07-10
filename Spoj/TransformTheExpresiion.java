import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		HashMap<Character,Integer>map = new HashMap<>();
		map.put('^',3);
		map.put('*',2);
		map.put('/',2);
		map.put('+',1);
		map.put('-',1);
		while(test-->0){
		    String s = br.readLine();
		    String result ="";
		    Stack<Character>stack = new Stack<>();
		    for(int i =0;i<s.length();i++){
		        if(s.charAt(i) == '('){
		            stack.push('(');
		        }else if(s.charAt(i)>='a' && s.charAt(i)<='z'){
		            result+=s.charAt(i);
		        }else if(s.charAt(i) == '+'|| s.charAt(i) == '-'||s.charAt(i) == '*'||s.charAt(i) == '/' || s.charAt(i)=='^'){
		            if(!stack.isEmpty() && map.containsKey(stack.peek()) && map.get(stack.peek())<=map.get(s.charAt(i))){
		                stack.push(s.charAt(i));
		            }else if(stack.isEmpty() && map.containsKey(stack.peek()) && map.get(stack.peek()) > map.get(s.charAt(i))){
		                result+=stack.pop();
		                stack.push(s.charAt(i));
		            }else{
		                stack.push(s.charAt(i));
		            }
		        } else{
		            while(!stack.isEmpty() && stack.peek() != '('){
		                result+=stack.pop();
		            }
		            stack.pop();
		        }
		    }
		    System.out.println(result);
		}
	}
}
