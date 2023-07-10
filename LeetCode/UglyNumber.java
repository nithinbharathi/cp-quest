class Solution {
    public boolean isUgly(int num) {
        if(num<=0){
            return false;
        }
       if(num == 1)return true;
       
        while(num%2 == 0){num/=2;}
        while(num%3 == 0){num/=3;}
        while(num%5 == 0){num/=5;}
       
        return num==1?true:false;
        
    }
}
//...................................................
class Solution {
    public boolean isUgly(int num) {
        if(num<=0){
            return false;
        }
       if(num == 1)return true;
       
   for(int i =2;i<=Math.sqrt(num);i++){
       if(num%i == 0){
           if(i>5)return false;
           while(num%i == 0){
               num/=i;
           }
       }
   }
        if(num == 1 || num == 2||num==3 || num == 5)return true;
        return false;
        
    }
}
