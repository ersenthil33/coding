import java.util.*;

class Solution {
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        List<Integer> values = new ArrayList<>();
        
        // Traverse first list
        while(list1 != null) {
            values.add(list1.val);
            list1 = list1.next;
        }
        
        // Traverse second list
        while(list2 != null) {
            values.add(list2.val);
            list2 = list2.next;
        }
        
        // Sort the collected values
        Collections.sort(values);
        
        // Create new linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for(int i = 0; i < values.size(); i++) {
            current.next = new ListNode(values.get(i));
            current = current.next;
        }
        
        return dummy.next;
    }
}