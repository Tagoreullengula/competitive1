class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        int maxmin [][]= new int [n][n];
        char queriesDp [][] = new char [n][n];
        int moveC = 100001;
        List<Boolean> queries = new LinkedList<>();
        for(int q = 0; q<l.length; q++) {
            boolean ans=false;
            if(queriesDp[l[q]][r[q]] == 0){
                if (maxmin[l[q]][r[q]] == 0) {
                    maxmin[l[q]][l[q]] = nums[l[q]] + moveC;
                    for (int i = l[q]+1; i<=r[q]; i++) {
                        if(maxmin[i][r[q]] > 0) {
                            maxmin[l[q]][r[q]] = Math.min(maxmin[l[q]][i-1], maxmin[i][r[q]]);
                            maxmin[r[q]][l[q]] = Math.max(maxmin[i-1][l[q]], maxmin[r[q]][i]);
                            break;
                        } else {
                            maxmin[l[q]][i] = Math.min(maxmin[l[q]][i-1], nums[i] + moveC);
                            maxmin[i][l[q]] = Math.max(maxmin[i-1][l[q]], nums[i] + moveC);
                        }
                    }
                }
                int diff = maxmin[r[q]][l[q]] - maxmin[l[q]][r[q]];
                if(diff > 0 && diff % (r[q]-l[q]) == 0) {
                    BitSet repeated = new BitSet(diff+1);
                    int c = diff/(r[q]-l[q]);
                    ans = true;
                    
                    for(int i=l[q]; i<=r[q] && ans; i++) {
                        int ele = nums[i] - maxmin[l[q]][r[q]]+moveC;
                        ans = !repeated.get(ele) && ele%c==0;
                        if(ans){
                            repeated.set(ele);
                        }
                    }
                    queriesDp[l[q]][r[q]] = (char)(ans?1:2);
                } else {
                    ans = diff==0;
                }
            } else {
                ans = queriesDp[l[q]][r[q]] == 1;
            }
            queries.add(ans);
        }
        return queries;
    }
}
