class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for(int i=1;i<n;i++){
            StringBuilder temp = new StringBuilder();
            char arr[] = ans.toCharArray();
            for(int j=0;j<arr.length;j++){
                int count =1;
                while(j<arr.length-1&&arr[j] == arr[j+1]){
                    count++;
                }
                temp.append(count);
                temp.append(arr[j]);
            }
            ans = temp.toString();
        }
        return ans;
    }
}
