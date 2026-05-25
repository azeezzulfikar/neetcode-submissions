class Solution {
    public int removeDuplicates(int[] nums) {
        int k=0;
        for(int i=0; i< nums.length; i++) {
            nums[k] = nums[i];
            k++;
            while(i< nums.length -1 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return k;
    }
}