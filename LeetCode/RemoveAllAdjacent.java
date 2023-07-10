class Solution {
    public String removeDuplicates(String S) {
        String result = "";
        if(S.length() == 0 || S == null)return result;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<S.length();i++){
            if( !stack.isEmpty() && stack.peek() == S.charAt(i)){
               stack.pop(); 
            }else{
                stack.push(S.charAt(i));
            }
        }
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        str.append(result);
        return str.reverse().toString();
    }
}
