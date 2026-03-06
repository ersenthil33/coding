class Solution {

    public int removeDuplicates(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        int k = 1;

        for(int i = 1; i < nums.length; i++){

            boolean duplicate = false;

            for(int j = 0; j < k; j++){

                if(nums[i] == nums[j]){
                    duplicate = true;
                    break;
                }
            }

            if(duplicate == false){
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}