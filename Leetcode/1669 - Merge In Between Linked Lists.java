/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode getNodeInPos(int pos, ListNode list){
        for(int i =0; i<pos && list.next != null; i++, list=list.next);
        return list;
    }
    
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aNode = getNodeInPos(a-1, list1);
        ListNode bNode = getNodeInPos(b-a+1, aNode.next);
        ListNode finalList2= getNodeInPos(Integer.MAX_VALUE, list2);
        aNode.next = list2;
        finalList2.next = bNode;
        return list1;
    }
}
