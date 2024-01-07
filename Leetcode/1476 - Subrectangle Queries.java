class SubrectangleQueries {
    int rectangle [][];
    int rows,cols, updateCounter;
    Pair<Integer,Integer> segmentTree[]; 
    
    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
        this.rows = rectangle.length;
        this.cols = rectangle[0].length;
        this.updateCounter=0;
        double pow = Math.log(Math.max(rows, cols)) / Math.log(2);
        if((int)pow< pow){
            pow++;
        }
        segmentTree = new Pair[2 * (int)Math.pow(4, (int)pow) ];
    }
    
    public void update (int row1, int col1, int row2, int col2, int newValue, int r1, int c1, int r2, int c2, int index) {
        if (r1 > row2 || r2 < row1 || c1 > col2 || c2 < col1) {
            return;
        }
        if (row1 <= r1 && r2 <= row2 && col1 <= c1 && c2 <= col2) {
            segmentTree[index] = new Pair(updateCounter, newValue);
            return;
        }
        int rm1= r1 + (r2-r1)/2;
        int cm1= c1 + (c2-c1)/2;
        int rm2=Math.min(rm1+1, r2);
        int cm2=Math.min(cm1+1, c2);
        update(row1, col1, row2, col2, newValue, r1, c1, rm1, cm1, index*4 + 1);
        update(row1, col1, row2, col2, newValue, r1, cm2, rm1, c2, index*4 + 2);
        update(row1, col1, row2, col2, newValue, rm2, c1, r2, cm1, index*4 + 3);
        update(row1, col1, row2, col2, newValue, rm2, cm2, r2, c2, index*4 + 4);
    }
                              
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        updateCounter++;
        update(row1, col1, row2, col2, newValue, 0, 0, rows-1, cols-1, 0);
    }
    
    public Pair<Integer,Integer> getValue(int row, int col, int r1, int c1, int r2, int c2, int index) {
        Pair<Integer, Integer> answer = new Pair(-1, -1);
        
        if(row > r2 || row < r1 || col > c2 || col < c1) {
            return answer;
        }
        
        if(r1 == r2 && c1 == c2) {
            if(segmentTree[index] == null) {
                segmentTree[index] = new Pair(0, this.rectangle[row][col]);
            }
            return segmentTree[index];
        }
        
        if(segmentTree[index] != null) {
            answer = segmentTree[index];
        }
        
        int rm1= r1 + (r2-r1)/2;
        int cm1= c1 + (c2-c1)/2;
        int rm2=Math.min(rm1+1, r2);
        int cm2=Math.min(cm1+1, c2);
        
        Pair<Integer, Integer> newAns = getValue(row, col, r1, c1, rm1, cm1, index*4 + 1);
        answer = (newAns.getKey() > answer.getKey()) ? newAns: answer;
        
        newAns = getValue(row, col, r1, cm2, rm1, c2, index*4 + 2);
        answer = (newAns.getKey() > answer.getKey()) ? newAns: answer;
        
        newAns = getValue(row, col, rm2, c1, r2, cm1, index*4 + 3);
        answer = (newAns.getKey() > answer.getKey()) ? newAns: answer;
        
        newAns = getValue(row, col, rm2, cm2, r2, c2, index*4 + 4);
        answer = (newAns.getKey() > answer.getKey()) ? newAns: answer;
        
        return answer;
    }
                              
    public int getValue(int row, int col) {
        return getValue(row, col, 0, 0, rows-1, cols-1, 0).getValue();
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
