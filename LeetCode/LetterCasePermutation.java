class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if(S.length() ==0 || S == null){
            return result;
        }
        helper(S,"",result,0);
        return result;
    }
    public static void helper(String str,String curr,List<String> result,int index){
        if(curr.length() == str.length()){
            result.add(new String(curr));
            return;
        }

       if(Character.isLowerCase(str.charAt(index))){
            helper(str,curr+Character.toUpperCase(str.charAt(index)),result,index+1);
   
       }
       if(Character.isUpperCase(str.charAt(index))){
             helper(str,curr+Character.toLowerCase(str.charAt(index)),result,index+1);

       }
        helper(str,curr+str.charAt(index),result,index+1);  
    }
}
