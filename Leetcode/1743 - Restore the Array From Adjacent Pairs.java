class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length+1;
        int maxRange = 200001;
        int hash[][]= new int[maxRange][2];
        boolean isUnique[] = new boolean[maxRange];
        LinkedList<Integer> firstStack = new LinkedList();
        for (int i =0;i<n-1; i++) {
            int u=adjacentPairs[i][0]+100000;
            int v=adjacentPairs[i][1]+100000;
            
            if (isUnique[u]) {
                hash[u][1]=v;
            } else {
                hash[u][0]= v;
                firstStack.addLast(u);
            }
            isUnique[u]=!isUnique[u];
            
            if (isUnique[v]) {
                hash[v][1] = u;
            } else {
                hash[v][0] = u;
                firstStack.addLast(v);
            }
            isUnique[v]=!isUnique[v];
        }
        int num[] = new int [n];
        int prev =0;
        while (!firstStack.isEmpty()) {
            prev = firstStack.removeLast();
            if (isUnique[prev]) {
                break;
            }
        }
        num[0]=prev - 100000;
        int index = prev;
        for (int i=1; i<n; i++) {
            int next = hash[index][0];
            if(prev == next) {
                next = hash[index][1];
            }
            num[i]=next-100000;
            prev = index;
            index = next;
        }
        return num;
    }
}
