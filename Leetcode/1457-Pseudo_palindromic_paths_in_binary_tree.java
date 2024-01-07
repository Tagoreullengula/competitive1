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
    public int frequency[];
    public int output;
    public int oddCounter;
    public void recursivity(TreeNode node) {
        if (node == null) return;
        frequency[node.val]++;
        oddCounter += 2*(frequency[node.val]%2) -1;
        if (node.left == null && node.right == null) {
            if(oddCounter <=1) output++;
        } else {
            recursivity(node.left);
            recursivity(node.right);
        }
        oddCounter -= 2*(frequency[node.val]%2) -1;
        frequency[node.val]--;
    }
    
    public int pseudoPalindromicPaths (TreeNode root) {
        frequency = new int [10];
        output = 0;
        oddCounter = 0;
        recursivity(root);
        return output;
    }
}