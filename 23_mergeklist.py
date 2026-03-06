class Solution(object):
    
    def mergeKLists(self, lists):
        
        if not lists:
            return None
        
        values = []
        
        # Collect all values
        for l in lists:
            while l:
                values.append(l.val)
                l = l.next
        
        # Sort values
        values.sort()
        
        # Create new linked list
        dummy = ListNode(0)
        current = dummy
        
        for v in values:
            current.next = ListNode(v)
            current = current.next
        
        return dummy.next