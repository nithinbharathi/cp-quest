class Solution {
    public String numberToWords(int num) {
       if(num==0){
           return "Zero";
       }
        if(num<10){
            return ones(num);
        }
        if(num<20){
            return teens(num);
        }
       if(num<100){
            int x = num/10;
            int y = num%10;
            if(y==0)return tens(x);
            return tens(x)+" "+ ones(y);
        }
        if(num<1000){
            int x =num/100;
            int y = num%100;
            if(y == 0)return ones(x)+" Hundred";
            return ones(x)+" Hundred "+numberToWords(y);
        }
        if(num<1000000){
            int x = num/1000;
            int y = num%1000;
            if(y == 0)return numberToWords(x)+" Thousand";
            return numberToWords(x)+" Thousand "+numberToWords(y);
        }
        if(num<1000000000){
            int x = num/1000000;
            int y = num%1000000;
            if(y == 0)return numberToWords(x)+" Million";
            return numberToWords(x)+" Million "+numberToWords(y);
            
        }
            int x = num/1000000000;
            int y = num%1000000000;
            if(y == 0)return numberToWords(x)+" Billion";
            return numberToWords(x)+" Billion "+numberToWords(y);
        }
        
    public static String ones(int num){
        if(num == 1)return "One";
        if(num ==2 )return "Two";
        if(num == 3)return "Three";
        if(num ==4 )return "Four";
        if(num == 5)return "Five";
        if(num ==6 )return "Six";
        if(num ==7 )return "Seven";
        if(num == 8)return "Eight";
        return "Nine";
    }
     public static String teens(int num){
        if(num == 10)return "Ten";
        if(num == 11)return "Eleven";
        if(num ==12 )return "Twelve";
        if(num == 13)return "Thirteen";
        if(num ==14 )return "Fourteen";
        if(num == 15)return "Fifteen";
        if(num ==16 )return "Sixteen";
        if(num ==17 )return "Seventeen";
        if(num == 18)return "Eighteen";
        return "Nineteen";
    }
     public static String tens(int num){
        if(num == 2)return "Twenty";
        if(num == 3)return "Thirty";
        if(num == 4)return "Forty";
        if(num ==5 )return "Fifty";
        if(num == 6)return "Sixty";
        if(num ==7 )return "Seventy";
        if(num ==8)return "Eighty";
        return "Ninety";
    }
      
}
