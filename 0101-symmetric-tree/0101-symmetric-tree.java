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
    public boolean same(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }else if(p==null || q==null ||p.val!=q.val){
            return false;
        }
        if(!same(p.left,q.right)){
            return false;
        }
        if(!same(p.right,q.left)){
            return false;
        }
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null && root.right==null){
            return true;
        }
        return same(root.left,root.right);
    }
}