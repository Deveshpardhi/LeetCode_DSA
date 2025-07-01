class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        if (root == null) {
            return al;                // return empty list instead of null
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);                  // level delimiter

        List<Integer> arr = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (curr == null) {
                al.add(arr);
                if (q.isEmpty()) {
                    break;            
                }
                arr = new ArrayList<>(); // start new level
                q.add(null);             // add delimiter for next level
            } else {
                arr.add(curr.val);
                if (curr.left  != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return al;
    }
}
