class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder result = new StringBuilder();
        int count=0;
        for(int i=S.length()-1;i>=0;i--){
            if(S.charAt(i) == '-'){
                continue;
            }
            if(count ==K){
                result.append('-');
                count=0;
            }
            result.append(Character.toUpperCase(S.charAt(i)));
            count++;
            
        }
        return result.reverse().toString();
    }
}
