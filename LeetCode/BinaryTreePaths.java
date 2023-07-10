class Solution {
    ArrayList<String>result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(result == null){
            return result;
        }
        helper(root,"");
        return result;
    }
    public void helper(TreeNode root,String str){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            str+=root.val;
            result.add(str);
            return;
        }
        helper(root.left,str+root.val+"->");
        helper(root.right,str+root.val+"->");
    }
}
