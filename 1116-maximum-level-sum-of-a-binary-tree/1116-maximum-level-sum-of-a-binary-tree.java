import java.util.*;

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
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;            // empty tree guard

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level        = 0;                  // current level number
        int bestLevel    = 1;                  // answer (1-indexed)
        int bestSum      = Integer.MIN_VALUE;  // best sum seen so far

        while (!q.isEmpty()) {
            int size = q.size();               // #nodes on this level
            int sum  = 0;                      // sum for this level
            level++;

            /* ---- traverse the current level ---- */
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if (node.left  != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            /* ---- update best level ---- */
            if (sum > bestSum) {               // strictly greater → first
                bestSum   = sum;
                bestLevel = level;
            }
        }
        return bestLevel;
    }
}
