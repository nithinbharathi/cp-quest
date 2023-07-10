import java.util.*;
import java.lang.*;

class Main
{
	static int flag = 0;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input  = new Scanner(System.in);
		int v = input.nextInt();
		int e = input.nextInt();
		LinkedList<Integer>graph[] = new LinkedList[v];
		for(int i =0;i<v;i++){
		    graph[i] = new LinkedList<>();
		}
		
		for(int i =0;i<e;i++){
		    int a = input.nextInt();
		    int b = input.nextInt();
		    graph[a-1].add(b-1);
		    graph[b-1].add(a-1);
		}
		Stack<Integer>stack = new Stack<>();
		boolean visited[] = new boolean[v];
		stack.push(0);
		 get_adjacent(0,visited,graph);
		for(int i =0;i<v;i++){
		    if(visited[i] == false){
		        flag = 1;
		        break;
		    }
		}
		if(flag == 1 || e != v-1){
		    System.out.println("NO");
		}else{
		    System.out.println("YES");
		}
	}
	public static void get_adjacent(int node,boolean visited[],LinkedList<Integer>graph[]){
	    int i = 0;
	    visited[node] = true;
	    for(i =0;i<graph[node].size();i++){
	        if(visited[graph[node].get(i)] == false){
		            get_adjacent(graph[node].get(i),visited,graph);
		        }
	    }
	}
}
