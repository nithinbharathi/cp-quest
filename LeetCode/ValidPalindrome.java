class Solution {
    public boolean isPalindrome(String s) {
        if(s == null){
            return true;
        }
        String S = s.replaceAll("[^0-9a-zA-Z]","");
        int start =0;
        int end = S.length()-1;
        while(start <end){
            if(Character.toLowerCase(S.charAt(start)) != Character.toLowerCase(S.charAt(end))){
               return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
