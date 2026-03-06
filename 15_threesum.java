import java.util.*;

class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        if (n < 3) return result;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 2; i++) {
            
            // If current number > 0, no need to continue
            if (nums[i] > 0) break;
            
            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    left++;
                    right--;
                    
                    // Skip duplicates on left
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    
                    // Skip duplicates on right
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
}