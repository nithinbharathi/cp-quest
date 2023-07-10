class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map = new HashMap<>();
        List<List<String>>result = new ArrayList<>();
        if(strs == null) return result;
        for(String word:strs){
            char arr[] = word.toCharArray();
            Arrays.sort(arr);
            String str = String.valueOf(arr);
            if(map.containsKey(str)){
                 map.get(str).add(word);
            }else{
                List<String> curr = new ArrayList<>();
                curr.add(word);
                map.put(str,curr);
            } 
        }
        for(String s : map.keySet()) {  
             List<String> values = map.get(s);   
                result.add(values); 
           }  
        return result;
        
    }
}
