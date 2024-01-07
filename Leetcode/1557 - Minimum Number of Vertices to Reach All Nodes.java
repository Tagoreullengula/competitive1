class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        BitSet nodesWithFather = new BitSet(n);
        for(List<Integer> edge: edges){
            int from = edge.remove(0);
            int to = edge.remove(0);
            nodesWithFather.set(to);
        }
        List<Integer> rootNodes = new LinkedList<>();
        for(int index = nodesWithFather.nextClearBit(0); index<n; index= nodesWithFather.nextClearBit(index+1)) {
            rootNodes.add(index);
        }
        return rootNodes;
    }
}
