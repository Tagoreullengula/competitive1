class Solution {
    
    public int replaceIn(int num, int x, int y) {
        String n = num+"";
        int newNum = 0;
        for(int i=0;i<n.length(); i++) {
            if(n.charAt(i)-48 == x) {
                newNum = newNum*10 + y;
            } else {
                newNum = newNum*10+n.charAt(i)-48;
            }
        }
        return newNum;
    }
    
    public int findMinimun ( int num) {
        String n = num+"";
        boolean isFirstDigitOne = (num + "").charAt(0) == 49;
    
        if(isFirstDigitOne){
            for(int i = 0; i<n.length(); i++){
                if( n.charAt(i)-48 > 1){
                    return replaceIn(num, n.charAt(i)-48, 0);
                }
            }
        } else {
            return replaceIn(num, n.charAt(0)-48, 1);
        }
        return num;
    }
    
    public int findMaximun (int num) {
        String n = num+"";
        
        for(int i=0; i<n.length(); i++){
            if( n.charAt(i)-48 <9){
                return replaceIn(num, n.charAt(i)-48, 9);
            }
        }
        return num;
    }
    
    public int maxDiff(int num) {
        return findMaximun(num) - findMinimun(num);
    }
}