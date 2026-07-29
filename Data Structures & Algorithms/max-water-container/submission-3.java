class Solution {
    public int maxArea(int[] heights) {
        int l=0, r=heights.length -1, maxArea = 0;
        while(l<r) {
            int currArea = (r - l) * Math.min(heights[l], heights[r]);
            maxArea = Math.max(maxArea, currArea);
            if(heights[l] < heights[r]) l++;
            else r--;
        }
        return maxArea;
    }
}
