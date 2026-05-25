class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] numPresent = new boolean[100001];
        for(int num: nums) {
            if(numPresent[num]) return num;
            numPresent[num] = true;
        }
        return -1;
    }
}