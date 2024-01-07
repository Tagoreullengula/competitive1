/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer compressedTree = new StringBuffer("");
        LinkedList <TreeNode> bfs = new LinkedList<TreeNode>();
        if(root != null){
            bfs.addLast(root);
            while(!bfs.isEmpty()){
                TreeNode node= bfs.removeFirst();
                if (node == null) {
                    compressedTree.append(" ");
                } else {
                    compressedTree.append(node.val);
                    bfs.addLast(node.left);
                    bfs.addLast(node.right);
                }
                compressedTree.append(",");
            }
        }
        return compressedTree.toString();   
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        if (data.length()>0) {
            StringTokenizer tk = new StringTokenizer(data, ",");
            root = new TreeNode (Integer.parseInt(tk.nextToken()));
            LinkedList <TreeNode> bfs = new LinkedList<TreeNode> ();
            bfs.addLast(root);
            while (!bfs.isEmpty()) {
                TreeNode node = bfs.removeFirst();
                String token = tk.nextToken();
                if(!token.equals(" ")){
                    node.left=new TreeNode(Integer.parseInt(token));
                    bfs.addLast(node.left);
                }
                token = tk.nextToken();
                if(!token.equals(" ")){
                    node.right=new TreeNode(Integer.parseInt(token));
                    bfs.addLast(node.right);
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
