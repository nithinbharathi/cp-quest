class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length == 0){
            return  "";
        }
        String longest = strs[0];
        for(int i=1;i<strs.length;i++){
            int j=0;
            String current = strs[i];
            while(j<current.length() && j<longest.length() && 
                  current.charAt(j) == longest.charAt(j)){
                j++;
            }
            if(j == 0){
                return "";
            }
            longest = longest.substring(0,j);
            
        }
        return longest;
        
    }
}
