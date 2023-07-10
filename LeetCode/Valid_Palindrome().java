class Solution {
    public boolean isPalindrome(String s) {
        if(s == null){
            return true;
        }
        int start =0;
        int end = s.length()-1;
      while(start <end){
            while(start<s.length() && !isAlphanum(Character.toLowerCase(s.charAt(start)))){
                start++;
            }
            while(end>=0 && !isAlphanum(Character.toLowerCase(s.charAt(end)))){
                end--;
            }
            if(start<end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
               return false;
            }
            start++;
            end--;
        }
        return true;
    }
     private boolean isAlphanum(char a){
        return (a >= 'a' && a <= 'z') || (a>='0' && a<= '9');
    }
}
