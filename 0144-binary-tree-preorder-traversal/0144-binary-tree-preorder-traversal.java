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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfs(ans,root);
        return ans;
    }
    private void dfs(List<Integer> ans , TreeNode root){
        if(root==null) return;
        ans.add(root.val);
        dfs(ans, root.left);
        dfs(ans, root.right);
    }
}