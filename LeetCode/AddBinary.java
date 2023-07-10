class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        int i = a.length()-1;
        int j = b.length()-1;
        int sum = 0;
        while(i >=0 || j>=0 || sum >0){
            sum+= i>=0?a.charAt(i)-'0':0;
            sum+= j>=0?b.charAt(j)-'0':0;
            result = (char)((sum%2)+'0') + result;
            sum/=2;
            i--;
            j--;
        }
        return result;
    }
}
