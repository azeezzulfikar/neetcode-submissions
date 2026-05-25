class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        while (r >= 0 && nums[r] == val) r--;
        while (l < r) {
            if (nums[l] == val) {
                nums[l] = nums[r];
                nums[r] = val;
                while (r >= 0 && nums[r] == val) r--;
            } 
            l++;
        }

        return r + 1;
    }
}