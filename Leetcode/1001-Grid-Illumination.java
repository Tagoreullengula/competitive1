class Solution {
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        HashMap<Integer, HashSet<Integer>> rowColumn = new HashMap<Integer, HashSet<Integer>>();
        HashMap<Integer, Integer> rows = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> columns = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> diffDiagonals = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> addDiagonals = new HashMap<Integer, Integer>();
        
        for(int i = 0; i<lamps.length; i++) {
            HashSet<Integer> col = rowColumn.get(lamps[i][0]);
            if( col == null) {
                col=new HashSet<Integer>();
            }
            col.add(lamps[i][1]);
            rowColumn.put(lamps[i][0], col);
            
            Integer counter = rows.get(lamps[i][0]);
            if(counter == null){counter = 0;}
            counter++;
            rows.put(lamps[i][0],counter);
            
            counter = columns.get(lamps[i][1]);
            if(counter == null){counter = 0;}
            counter++;
            columns.put(lamps[i][1],counter);
            
            counter = diffDiagonals.get(lamps[i][1]-lamps[i][0]);
            if(counter == null){counter = 0;}
            counter++;
            diffDiagonals.put(lamps[i][1]-lamps[i][0], counter);
            
            counter = addDiagonals.get(lamps[i][1]+lamps[i][0]);
            if(counter == null){counter = 0;}
            counter++;
            addDiagonals.put(lamps[i][1]+lamps[i][0], counter);   
        }
        
        int ans[] = new int [queries.length];
        int rowChanges[]={-1,-1,-1,0,0,0,1,1,1};
        int columnChanges[]={-1,0,1,-1,0,1,-1,0,1};
        for(int i=0;i<queries.length; i++){
            int x = queries[i][0];
            int y = queries[i][1];
            if(rows.containsKey(x) || columns.containsKey(y) || diffDiagonals.containsKey(y-x) || addDiagonals.containsKey(y+x)){
                ans[i]=1;
            }
            for(int j = 0;j<9;j++){
                int offX = x+rowChanges[j];
                int offY = y+columnChanges[j];
                if(rowColumn.containsKey(offX) && rowColumn.get(offX).contains(offY)){
                    rowColumn.get(offX).remove(offY);
                    if(rowColumn.get(offX).isEmpty()){
                        rowColumn.remove(offX);
                    }
                    
                    if(rows.containsKey(offX)){
                    rows.put(offX,rows.get(offX)-1);
                    if(rows.get(offX) == 0){
                        rows.remove(offX);
                    }
                    }
                
                if(columns.containsKey(offY)){
                columns.put(offY, columns.get(offY)-1);
                if(columns.get(offY) == 0){
                    columns.remove(offY);
                }
                }
                
                if(diffDiagonals.containsKey(offY-offX)){
                diffDiagonals.put(offY-offX, diffDiagonals.get(offY-offX)-1);
                if(diffDiagonals.get(offY-offX) == 0){
                    diffDiagonals.remove(offY-offX);
                }
                }
                
                if(addDiagonals.containsKey(offY+offX)){
                addDiagonals.put(offY+offX, addDiagonals.get(offY+offX)-1);
                if(addDiagonals.get(offY+offX) == 0){
                    addDiagonals.remove(offY+offX);
                }
                }
                }
                
            }
        }
        return ans;
    }
}