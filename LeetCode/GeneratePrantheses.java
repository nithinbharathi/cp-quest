class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String>list = new ArrayList<>();
        if(n<=0){
            return list;
        }
         backtrack(list,0,0,n,"");
        return list;
    }
     public void backtrack(ArrayList<String> list,int open, int close, int max,String str){
        
        if(str.length() == 2*max){
            list.add(str);
            return;
        }
         if(open<max){
             backtrack(list,open+1,close,max,str+"(");
         }
         if(close<open){
             backtrack(list,open,close+1,max,str+")");
         }
    
}
}
