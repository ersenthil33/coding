class Solution {
    
    public boolean isPalindrome(int x) {
        
        if (x < 0) {
            return false;
        }
        
        int temp = x;
        int count = 0;
        
        // Step 1: Count digits
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }
        
        int[] digits = new int[count];
        
        temp = x;
        
        // Step 2: Store digits in array
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }
        
        // Step 3: Compare from both ends
        int left = 0;
        int right = count - 1;
        
        while (left < right) {
            if (digits[left] != digits[right]) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}