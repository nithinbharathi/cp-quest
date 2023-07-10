import java.math.*;
class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.length() == 0)return 0;
        String result ="";
        if(str.charAt(0)>='a' && str.charAt(0)<='z')return 0;
        int m =0;
        for(int i=0;i<str.length();i++){
            if(i == 0 && str.charAt(i) == '-' || i==0 && str.charAt(i) == '+'){
                result+=str.charAt(i);
            }
            else if(str.charAt(i)-'0'>=0 && str.charAt(i)-'0' <=9){
                  result+=str.charAt(i);  
              }else{
                  break;
              }
        }
        int length = result.length();
        if(length == 0)return 0;
        if(length == 1 &&  result.charAt(0)=='-' ||  length  == 1 && result.charAt(0) == '+')return 0;        
        int s =1;
        long r =0;
        for(int i=0;i<result.length();i++){
           if(result.charAt(i) == '-'){
               s = -1;
               i++;
           }else if(result.charAt(i) == '+')i++;
            r = r*10+(((int)result.charAt(i)-'0')*s);
            if(r>Integer.MAX_VALUE)return Integer.MAX_VALUE;
            if(r<Integer.MIN_VALUE)return Integer.MIN_VALUE;
        }
        
        
        return Integer.parseInt(result);
    }
}






//better run time
import java.math.*;
class Solution {
    public int myAtoi(String s) {
        s = s.trim(); 
        if(s == null || s.length() == 0)return 0;
        char str[] = s.toCharArray();
        String result ="";
        if(str[0]>='a' && str[0]<='z')return 0;
        int m =0;
        for(int i=0;i<str.length;i++){
            if(i == 0 && str[0] == '-' || i==0 && str[0] == '+'){
                result+=str[0];
            }
            else if(str[i]>='0' && str[i] <='9'){
                  result+=str[i];  
              }else{
                  break;
              }
        }
        int length = result.length();
        if(length == 0)return 0;
        if(length == 1 &&  result.charAt(0)=='-' ||  length  == 1 && result.charAt(0) == '+')return 0;        
        int sign =1;
        long r =0;
        for(int i=0;i<result.length();i++){
           if(result.charAt(i) == '-'){
               sign = -1;
               i++;
           }
           else if(result.charAt(i) == '+')i++;
            r = r*10+(((int)result.charAt(i)-'0')*sign);
            if(r>Integer.MAX_VALUE)return Integer.MAX_VALUE;
            if(r<Integer.MIN_VALUE)return Integer.MIN_VALUE;
        }
        
        
        return Integer.parseInt(result);
    }
}
