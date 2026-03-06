import java.util.*;

class Solution {
    
    public ListNode swapPairs(ListNode head) {
        
        if(head == null) {
            return null;
        }
        
        // Store nodes in ArrayList
        ArrayList<ListNode> list = new ArrayList<>();
        
        ListNode temp = head;
        
        while(temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        
        // Swap nodes in pairs
        for(int i = 0; i < list.size() - 1; i = i + 2) {
            
            ListNode first = list.get(i);
            ListNode second = list.get(i + 1);
            
            list.set(i, second);
            list.set(i + 1, first);
        }
        
        // Rebuild the linked list
        for(int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        
        // Last node should point to null
        list.get(list.size() - 1).next = null;
        
        return list.get(0);
    }
}