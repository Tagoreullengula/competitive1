class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (r1, r2) ->  -Integer.compare(r1[1]-r1[0], r2[1]-r2[0]));
        int totalMinEnergy = 0;
        for(int i = 0, currentEnergy=0; i< tasks.length; i++){
            if(currentEnergy < tasks[i][1]){
                int newEnergy = tasks[i][1] - currentEnergy;
                totalMinEnergy += newEnergy;
                currentEnergy += newEnergy;
            }
            currentEnergy -= tasks[i][0];
        }
        return totalMinEnergy;
    }
}
