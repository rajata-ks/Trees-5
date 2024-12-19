// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class RecoverBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode first, second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root){
        if(root == null){
            return;
        }

        helper(root.left);

        if(prev != null && prev.val >= root.val){
            if(first == null){
                first = prev;
                second = root;
            }else {
                second = root;
            }
        }
        prev = root;

        helper(root.right);
    }
}
