class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if head is None: return False

        FIXED_SIZE = 100
        sliding_window = [None] * FIXED_SIZE
        hashed_window = set()
        window_ptr = 0

        stride = 1
        window_stride = stride
        i = 0
        curr = head
        while i := i+1:
            curr = curr.next
            if curr is None: return False
            if curr in hashed_window: return True

            if i % stride == 0:
                if prev := sliding_window[window_ptr]:
                    hashed_window.remove(prev)
                sliding_window[window_ptr] = curr
                hashed_window.add(curr)
                window_ptr += window_stride
                window_ptr %= FIXED_SIZE
            
            if i == FIXED_SIZE * stride:
                window_ptr += window_stride
                window_ptr %= FIXED_SIZE
                i = 0
                stride *= 2
                window_stride = stride % FIXED_SIZE