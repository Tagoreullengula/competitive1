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
    Integer nodes[];
    List<Integer> nodesL;
    public void inOrder(TreeNode node){
        if(node==null) return;
        inOrder(node.left);
        nodesL.add(node.val);
        inOrder(node.right);
    }
    public TreeNode balancedBST (int l, int r){
        if(r<l){return null;}
        if(l==r){return new TreeNode(nodes[l]);}
        int m = (l+r)>>1;
        return new TreeNode(nodes[m], balancedBST(l, m-1), balancedBST(m+1,r));
    }
    public TreeNode balanceBST(TreeNode root) {
        nodesL = new LinkedList<>();
        inOrder(root);
        nodes = nodesL.toArray(new Integer[0]);
        return balancedBST(0, nodes.length-1);
    }
}
