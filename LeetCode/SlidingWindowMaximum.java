class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        if(arr == null || arr.length == 0)return new int[]{};
        ArrayList<Integer>templist= new ArrayList<>();
        Deque<Integer>deque = new LinkedList<>();
        int ptr =1;
        deque.add(0);
        while(ptr<k){
	    	while(!deque.isEmpty() && arr[ptr]>=arr[deque.peekLast()]){
	    		deque.removeLast();
	    	}
	    	deque.add(ptr);
	    	ptr++;
	    }
        ArrayList<Integer>result = new ArrayList<>();
	    for(;ptr<arr.length;ptr++){													

	    	result.add(arr[deque.peek()]);
	    	while(!deque.isEmpty() && deque.peek()<=ptr-k){
	    		 deque.removeFirst();
	    	}
	    	while(!deque.isEmpty() && arr[ptr]>=arr[deque.peekLast()]){
	    		deque.removeLast();
	    	}
	    	deque.addLast(ptr);
	    }
        result.add(arr[deque.peek()]);
        
        
        int r[] = new int[result.size()];
        for(int j =0;j<result.size();j++){
            r[j] = result.get(j);
            
        }
        return r;
    }
}
