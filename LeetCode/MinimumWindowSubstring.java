class Solution {
    int arr[] = new int[256];
    int total =0;
    public String minWindow(String s, String t) {
        if(s == null || t == null){
            return "";
        }
        for(char c:t.toCharArray()){
            arr[c]++;
        }
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        String min_string ="";
        while(right<s.length()){
            if(arr[s.charAt(right++)]-->0){
                count++;
            }
            while(count == t.length()){
                if(min>right-left){
                    min = right-left;
                    min_string = s.substring(left,right);

                }
                if(++arr[s.charAt(left++)]>0){
                    count--;
                }
            }
            
        }
        return min_string;
        
        
    }
        
        
}
