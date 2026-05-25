class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l =0, r = people.length -1, count = 0;
        while(l <= r) {
            if(people[l] == limit) {
                l++;
            } else if(people[r] == limit) {
                r--;
            } else {
                if(l != r && people[l] + people[r] <= limit) {
                    l++;
                    r--;
                } else {
                    r--;
                }
            }
            count++;
        }
        
        return count;
    }
}