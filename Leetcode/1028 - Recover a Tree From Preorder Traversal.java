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
    int nodes[];
    int deeps[];
    int i;
    
    public TreeNode getNode(){
        TreeNode node = new TreeNode(nodes[i]);
        int deep = i;
        i++;
        
        if(i<nodes.length && deeps[i] == deeps[deep]+1){
            node.left=getNode();
        }
        
        if(i<nodes.length && deeps[i] == deeps[deep]+1){
            node.right=getNode();
        }
        return node;
    }
    
    public TreeNode recoverFromPreorder(String S) {
        nodes = Arrays.stream(S.split("-+", 0))
            .mapToInt(Integer::parseInt)
            .toArray();
        deeps = Arrays.stream(S.split("[0-9]+", 0))
            .mapToInt(d -> d.length())
            .toArray();
        i=0;
        return getNode();
    }
}
