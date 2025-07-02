/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=height(root.left);
        int r=height(root.right);
        return Math.max(l,r)+1;
    }
    public int findBottomLeftValue(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        if(lh==0 && rh==0){
            return root.val;
        }
        if(lh>=rh){
            return findBottomLeftValue(root.left);
        }else if(lh<rh){
            //root=root.right;
            return findBottomLeftValue(root.right);
        }
        return root.val;
    }

}