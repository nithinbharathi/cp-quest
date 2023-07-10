class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) =='[' || s.charAt(i) =='{' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else{
                if(!stack.empty() && isp( stack.peek(),s.charAt(i))){
                   stack.pop();
                    
                }
           else{
                    return false;
                }
            }
        }
        return stack.empty();
    }
    public boolean isp(char right,char left){
        return right == '{'&& left == '}'||right == '('&& left == ')'||right == '['&& left == ']';
    }
}