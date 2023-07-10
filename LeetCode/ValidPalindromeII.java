class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return is_palindrome(s,start+1,end) || is_palindrome(s,start,end-1);
            }
            start++;
            end--;
        }
        return true;
    }
    public static  boolean is_palindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
