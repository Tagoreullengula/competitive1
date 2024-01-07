class Solution {
    public boolean canTransform(String start, String end) {
        char startArray [] = (start + " ").toCharArray();
        char endArray [] = (end + " ").toCharArray();
        int sIt = 0;
        int eIt =-1;
        while (sIt < startArray.length) {
            if (startArray[sIt]!='X') {
                while (eIt < endArray.length-1) {
                    eIt++;
                    if (endArray[eIt]!='X') {
                        if ( endArray[eIt] != startArray[sIt] || 
                            (endArray[eIt] == 'R' && sIt > eIt) ||
                            (endArray[eIt] == 'L' && sIt < eIt) ||
                            (endArray[eIt] == ' ' && sIt != eIt)
                        ) {
                            return false;
                        } else break;
                    }
                }
            }
            sIt++;
        }
        return true;
    }
}
