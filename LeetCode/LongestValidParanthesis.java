class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer>stack = new Stack<>();
        int count =0;
        int longest = 0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    if(longest < i-stack.peek()){
                        longest = i-stack.peek();
                    }
                }    
        }
    }
        return longest;     
  }
}
