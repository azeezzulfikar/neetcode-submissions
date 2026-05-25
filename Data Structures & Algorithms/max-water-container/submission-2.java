class Solution {
    public int maxArea(int[] heights) {
        // lets have 2 pointers that will behave as edges of container l, r, maxArea, currArea
        // to calculate how much water it can store, is by taking the min height of l, r.
        // once we got the area, we will update our maxArea value with currArea and previous maxArea
        // if heights[l] < heights[r] then we will increament l until heights[l] < height[l++] and l < r
        // if heights[l] > heights[r] then we will decreament r until we find next heighest r 

        int l=0, r = heights.length - 1, maxArea = 0, currArea = 0;

        while(l < r) {
            currArea = Math.min(heights[l], heights[r]) * (r - l);
            maxArea = Math.max(maxArea, currArea);
            if(heights[l] <= heights[r]) {
                while(l < r && heights[l] > heights[l+1]) {
                    l++;
                }
                l++;
            } else {
                while(l < r && heights[r] > heights[r-1]) {
                    r--;
                }
                r--;
            }
        }

        return maxArea;
    }
}
