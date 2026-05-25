class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int i=0, j=1, k=nums.length -1;
        int sum = 0;
        Arrays.sort(nums);
        while(i < k -1) {
            while(j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j+1]) j++;
                    j++;
                    k--;
                } else if(sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }

            while(i < k -1 && nums[i] == nums[i+1]) {
                i++;
            }
            i++;
            j = i+1;
            k = nums.length -1;
        }
        return result;
    }
}