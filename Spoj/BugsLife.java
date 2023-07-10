Scanner input = new Scanner(System.in);
	    
	    int z = input.nextInt();
	    int test = 1;
	    while(z-->0){
	        int v = input.nextInt();
	        int e = input.nextInt();
	        int graph[][] = new int[2001][2001];
	        for(int i =0;i<e;i++){
	            int a1 = input.nextInt();
	            int a2 = input.nextInt();
	            graph[a1-1][a2-1] = 1;
	            graph[a2-1][a1-1] = 1;
	        }
	        if(bipartite(graph,v)){
	            System.out.println("Scenario #"+test+":\nNo suspicious bugs found!");
	        }else{
	            System.out.println("Scenario #"+test+":\nSuspicious bugs found!");
	        }
	        test++;
	    }
	    
	}
	public static boolean bipartite(int graph[][],int v){
	    int arr[] = new int[v];
	    Arrays.fill(arr,-1);
	    for(int i =0;i<v;i++){
	        if(arr[i] == -1){
	            if(bfs(graph,i,arr,v) == false)return false;
	        }
	    }
	    return true;
	}
	public static boolean bfs(int G[][],int src,int colorArr[],int size){
	    Queue<Integer>q = new LinkedList<>();
	    q.add(src);
	    colorArr[src] = 1;
	    while (!q.isEmpty()) 
        { 
            int u = q.remove(); 
            if (G[u][u] == 1) 
               return false;   
            for (int v = 0; v < size; ++v) 
            { 
                if (G[u][v] ==1 && colorArr[v] == -1) 
                { 
                    colorArr[v] = 1 - colorArr[u]; 
                    q.add(v); 
                } 
       
                else if (G[u][v] ==1 && colorArr[v] ==  
                                         colorArr[u]) 
                    return false; 
            } 
        } 
	    return true;
	}
}
