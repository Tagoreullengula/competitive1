class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int arrangedDeck  [] = new int [deck.length];
        LinkedList<Integer> indexDeck = new LinkedList<>();
        
        for (int i =0;i<deck.length; i++) {indexDeck.addLast(i);}
        int i=0, step=0;
        while(!indexDeck.isEmpty()){
            int top = indexDeck.removeFirst();
            if(step==1){
                indexDeck.addLast(top);
            } else {
                arrangedDeck[top] = deck[i];
                i++;
            }
            step=1-step;
        }
        return arrangedDeck;
    }
}
