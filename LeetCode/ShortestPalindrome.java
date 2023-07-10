class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0)return "";
        int first = 0;
        int last = s.length()-1;
        int last_ptr = last;
        int j =0;
        while(true){
           while(first <last){
            if(s.charAt(first) != s.charAt(last)){
                break;
                }
               first++;
               last--;    
            }
            if(first == last || last<first){
                break;
            }
            j++;
            first =0;
            last = s.length()-j;
            last_ptr = last;
               
        }
        String str = s.substring(last_ptr+1,s.length());
        String result ="";
        for(int i = str.length()-1;i>=0;i--){
            result +=str.charAt(i);
        }
        result+=s;
        return result;
        
        
        
    }
}
