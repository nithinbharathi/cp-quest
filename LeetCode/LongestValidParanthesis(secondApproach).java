//Time Complexity: O(n)
// Space Complexity: O(1)


class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0)return 0;
        int open =0;
        int close =0;
        int max = 0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == '('){
             open++;
            }else if(s.charAt(i) == ')'){
                close++;
            }
            if(open == close){ .              //when open == close we know we have a valid sequence of
                                              //brackets so we see if it is greater than max and update it accordingly
                if(max<2*close)max = 2*close;
            }else if(close>open){    //when count of close becomes more than open we know we are dealing with an invalid sequence 
                                     //so we start from first i.e look for a valid sequence from left to right
              open = 0;close =0;
            }
        }
        open = 0;
        close =0;
        
 //Another pass from right to left since one pass is not enough for cases like ()(() ())() because 
 //the middle brackets add to open or close before hitting the next part of the valid bracket sequence       
        
        for(int i =s.length()-1;i>=0;i--){
            if(s.charAt(i) == '('){
             open++;
            }else if(s.charAt(i) == ')'){
                close++;
            }
            if(open == close){
                if(max<2*open)max = 2*open;
            }else if(open>close){     //now if count of open becomes greater than count of close then we know it is an invalid sequence 
                                      //so we look for another valid sequence from right to left
                open = 0;
                close =0;
            }
        }
        return max;
    }
}
