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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
         if(n == 0){
             return null;
         }
        int mid = (n-1)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,n));
        return root;
    }
}

/*A more iterative approach 
using start and end pointers just like binary search*/




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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        return helper(nums,0,nums.length-1);
        
    }
    public static TreeNode helper(int arr[],int start,int end){
        if(end<start){
           return null; 
        }
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = helper(arr,start,mid-1);
        node.right = helper(arr,mid+1,end);
        return node;
    }
}
