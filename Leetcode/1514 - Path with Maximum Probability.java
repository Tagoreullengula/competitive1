class Solution {
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Integer>[] adjNodeLists = new LinkedList[n];
        List<Double>[] adjProbLists = new LinkedList[n];
        for (int i = 0; i<n; i++) {
            adjNodeLists[i] = new LinkedList<Integer>();
            adjProbLists[i] = new LinkedList<Double>();
        }
        for (int i = 0; i<edges.length; i++) {
            adjNodeLists[edges[i][0]].add(edges[i][1]);
            adjProbLists[edges[i][0]].add(succProb[i]);
            
            adjNodeLists[edges[i][1]].add(edges[i][0]);
            adjProbLists[edges[i][1]].add(succProb[i]);
        }
        
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<Pair<Double, Integer>>(n, (a,b) -> {
            if(b.getKey() > a.getKey()){
                return 1;
            } else {
                if(b.getKey() < a.getKey()){
                    return -1;
                }
            }
            return 0; 
        });
        
        double[] maxProb = new double[n];
        pq.add(new Pair(1, start));
        maxProb[start] = 1.0;
        boolean [] visited = new boolean [n];
        while (pq.size() != 0) {
            Integer node = pq.peek().getValue();
            pq.poll();
            if(visited[node]) continue;
            visited[node] = true;
            if (node == end) {
                break;
            }
            
            Iterator <Double> probItr = adjProbLists[node].iterator();
            for (Integer adjNode: adjNodeLists[node] ) {
                Double adjProb = probItr.next();
                if (maxProb[node] * adjProb > maxProb[adjNode]) {
                    maxProb[adjNode] = maxProb[node] * adjProb;
                    pq.add(new Pair(maxProb[adjNode], adjNode));
                }
            }
        }
        return maxProb[end];
        
    }
}