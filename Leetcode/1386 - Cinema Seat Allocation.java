class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int maxNum = 2*n;
        Map <Integer, Short> rows = new TreeMap();
        for(int i =0;i<reservedSeats.length; i++){
            int row = reservedSeats[i][0];
            int pos = reservedSeats[i][1];
            if (1<pos&&pos<10) {
                pos = pos/2 - 1;
                if(rows.containsKey(row)){
                    short availableSeats = rows.get(row);
                    int newAvailable = availableSeats | (1 << pos);
                    if(availableSeats < 15 && newAvailable != availableSeats) {
                       if(((newAvailable & 5) == 5) ||
                          ((newAvailable & 6) == 6) ||
                          ((newAvailable & 10) == 10) 
                         ) {
                            rows.put(row, (short)16);
                            maxNum--;
                       } else {
                           rows.put(row, (short)newAvailable);
                       }
                    }
                } else {
                    rows.put(row, (short)(1<<pos));
                    maxNum--;
                }
            }
        }
        return maxNum;
    }
}