class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() == 0 && magazine.length() == 0){
            return true;
        }
        if(ransomNote.length() == 0)return true;
        if(magazine.length() == 0) return false;
        HashMap<Character,Integer>map = new HashMap<>();
        int cache[] = new int[27];
        for(int i = 0;i<magazine.length();i++){
            map.put(magazine.charAt(i),map.getOrDefault(magazine.charAt(i),0)+1);
        }
       int length = ransomNote.length();
        for(int i =0;i<length;i++){
            cache[ransomNote.charAt(i)-'a']++;
        }
        for(int i = 0;i<length;i++){
            if(map.containsKey(ransomNote.charAt(i))){
                if(cache[ransomNote.charAt(i)-'a'] > map.get(ransomNote.charAt(i)))return false;
            }else{
                return false;
            }
        }
        return true;
    }
}
