import java.util.*;

class Solution {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null) {
            return null;
        }
        
        ArrayList<ListNode> list = new ArrayList<>();
        
        ListNode temp = head;
        
        // Store nodes
        while(temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        
        int n = list.size();
        
        // Reverse every k nodes
        for(int i = 0; i + k <= n; i = i + k) {
            
            int start = i;
            int end = i + k - 1;
            
            while(start < end) {
                
                ListNode t = list.get(start);
                list.set(start, list.get(end));
                list.set(end, t);
                
                start++;
                end--;
            }
        }
        
        // Rebuild linked list
        for(int i = 0; i < n - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        
        list.get(n - 1).next = null;
        
        return list.get(0);
    }
}