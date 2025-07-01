class Solution {

    /* unchanged helper signature */
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);

        /* FIX 1: height of a node is 1 + max(left, right) */
        return Math.max(l, r) + 1;
    }

    public boolean isBalanced(TreeNode root) {

        /* FIX 2: an empty subtree is balanced */
        if (root == null) {
            return true;
        }

        /* FIX 3: compare left vs. right heights, not left vs. left */
        int diff = Math.abs(height(root.left) - height(root.right));

        /* FIX 4: the node is balanced only if
                  current diff ≤ 1 AND both sub-trees are balanced   */
        if (diff <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }

        return false;
    }
}
