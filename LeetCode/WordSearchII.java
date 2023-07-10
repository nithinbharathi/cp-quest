class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String>result = new ArrayList<>();
        Trie obj = new Trie();
        TrieNode root = new TrieNode();
        for(int i = 0;i<words.length;i++){
            obj.insert_words(root,words[i],0);
        }
        for(int i=0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                search(board,root,i,j,result);
            }
        }
        return result;
        
    }
    public void search(char[][] arr,TrieNode root,int row,int col,List<String>result){
        
         if(root.is_word){
             root.is_word = false;
            result.add(root.word);          
        }
        if(row>arr.length-1 || col>arr[0].length-1 || row<0 || col<0)return;
        char c = arr[row][col];
        if(c ==  '$' || !root.map.containsKey(c))return;
        arr[row][col] = '$';
        search(arr,root.map.get(c),row,col+1,result);
        search(arr,root.map.get(c),row,col-1,result);
        search(arr,root.map.get(c),row+1,col,result);
        search(arr,root.map.get(c),row-1,col,result);
        arr[row][col] = c;



        
    }
}
class Trie{
    public void insert_words(TrieNode root,String word,int index){
        if(index == word.length()){
            root.word = word;
            root.is_word = true;
            return;
        }

        char c = word.charAt(index);
        if(root.map.containsKey(c)){
            insert_words(root.map.get(c),word,index+1);
        }else{
            TrieNode node = new TrieNode();
            root.map.put(c,node);
            insert_words(node,word,index+1);
        } 
    }
}
class TrieNode{
    boolean is_word;
    Map<Character,TrieNode>map;
    String word;
    public TrieNode(){
        is_word = false;
        map = new HashMap<>();
        word = null;
    }
}
