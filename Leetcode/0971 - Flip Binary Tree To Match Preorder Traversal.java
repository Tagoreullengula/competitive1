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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> flippedNodes= new LinkedList<>();
        int i=0;
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeLast();
            if(node != null){
                if(node.val != voyage[i]){
                    return new LinkedList<Integer>(Arrays.asList(-1));
                }
                i++;
                if(i < voyage.length){
                    if(node.right!=null && node.right.val == voyage[i] && node.left !=null){
                        flippedNodes.add(node.val);
                        stack.addLast(node.left);
                        stack.addLast(node.right);
                    } else {
                        stack.addLast(node.right);
                        stack.addLast(node.left);
                    }
                }
            }
        }
        return flippedNodes;
        
    }
} 
