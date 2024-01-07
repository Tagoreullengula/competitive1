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
    int tree[];
    
    List<TreeNode>list;
    public TreeNode getTree () {
        LinkedList< Pair<TreeNode, Integer> > bfs = new LinkedList();
        TreeNode root = new TreeNode(0);
        bfs.add(new Pair(root, 1));
        while(!bfs.isEmpty()){
            TreeNode node = bfs.getFirst().getKey();
            Integer index = bfs.getFirst().getValue();
            bfs.removeFirst();
            int left = index*2;
            int right = index*2+1;
            if( left < tree.length && tree[left] >= 0){
                node.left = new TreeNode(0);
                bfs.add(new Pair(node.left, left));
            }
            if( right < tree.length && tree[right] >= 0){
                node.right = new TreeNode(0);
                bfs.add(new Pair(node.right, right));
            }
        }
        return root;
    }
    
    public void recursive(int index, int n) {
        if(n==0){
            list.add(getTree());
            return;
        }
        while (index>0) {
            int left = index*2;
            int right = index*2+1;
            tree[right] = tree[index];
            tree[left] = right;
            recursive(left, n-2);
            tree[right] = -1;
            tree[left] = -1;
            index = tree[index];
        }
    }
    
    public List<TreeNode> allPossibleFBT(int n) {
        list = new LinkedList();
        if((n&1) == 0){return list;}
        tree = new int[ 1<< ((n>>1)+1) ];
        Arrays.fill(tree, -1);
        tree[1] = 0;
        recursive(1, n-1);
        return list;
    }
}
