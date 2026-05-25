class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int num: piles) {
            sum+=num;
            if(num > max) max = num;
        }

        int min = sum/h;
        int res = max;
        while(min <= max) {
            int mid = (max + min)/2;
            if(canFinish(mid, piles, h)) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return res;
    }

    boolean canFinish(int mid, int[] piles, int h) {
        int sum = 0;
        for(int n: piles) {
            sum+= Math.ceil((double)n / mid);
        }

        return sum <= h;
    }
}
