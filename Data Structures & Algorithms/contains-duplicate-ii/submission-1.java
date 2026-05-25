class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            if(valueIndexMap.containsKey(nums[i])) {
                if(Math.abs(valueIndexMap.get(nums[i]) - i) <= k) return true;
            }
            valueIndexMap.put(nums[i], i);
        }

        return false;
        
    }
}