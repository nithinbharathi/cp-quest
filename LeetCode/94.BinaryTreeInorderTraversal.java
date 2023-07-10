/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        while(root != null || !stack.isEmpty()){
        if(root != null){
            stack.push(root);
            root =root.left;
            
        }
        else{
            root = stack.pop();
            list.add(root.val);
            root = root.right;
            
        }
      }
      return list;  
    }
}