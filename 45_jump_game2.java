class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int steps = 0;
        int currMax = 0; // current running max reachable range
        int nextMax = 0; // next max reachable range
        for(int i=0; i<n; i++){
            if(i>currMax){
                // when curr max reachable range exhausts
                steps++; // take a step
                currMax = nextMax; // go to next max
                nextMax = i; // reset next max
            }
            nextMax = Math.max(nextMax, i+nums[i]); // update nextMax
        }
        return steps;
    }
}