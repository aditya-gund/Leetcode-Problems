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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfs(ans,root);
        return ans;
    }
    private void dfs(List<Integer> ans , TreeNode root){
        if(root==null) return;
        dfs(ans, root.left);
        dfs(ans, root.right);
        ans.add(root.val);
    }
}