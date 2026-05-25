class Solution {
    public void sortColors(int[] nums) {
        int sortedIndex = 0;
        for(int i=0; i<3; i++) {
            int currIndex = sortedIndex;
            while(currIndex < nums.length) {
                if(nums[currIndex] == i) {
                    if(currIndex > sortedIndex) {
                        int temp = nums[sortedIndex];
                        nums[sortedIndex] = nums[currIndex];
                        nums[currIndex] = temp;
                    }
                    sortedIndex++;
                }
                currIndex++;
            }
        } 
    }
}