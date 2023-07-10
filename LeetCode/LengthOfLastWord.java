class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0||s == null){
            return 0;
        }
        int count =0;
        String str = s.trim();
        int last = str.length()-1;
        while(last >=0 && str.charAt(last) != ' '){
            count++;
            last--;
        }
        
        return count;
    }
}
