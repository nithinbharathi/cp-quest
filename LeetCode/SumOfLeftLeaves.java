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
    private int  sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root,false);
        return sum;
}
    public void helper(TreeNode root,boolean left){
         if(root == null){
            return;
        }
        if(left && root.left == null && root.right == null){
            sum += root.val;
            return;
        }
       
         helper(root.left,true);
         helper(root.right,false);
    }
}
