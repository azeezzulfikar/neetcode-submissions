class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int i=0, j=1, k=nums.length -1;
        int sum = 0;
        Arrays.sort(nums);
        while(i < k -1) {
            while(j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
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
        List<List<Integer>> res = new ArrayList<>(result);
        return res;
    }
}