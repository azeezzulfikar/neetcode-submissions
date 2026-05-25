class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int left = 0, right = 0;
        for(int i=0; i< height.length; i++) {
            left = Math.max(height[i], left);
            leftMax[i] = left;
        }

        for(int i = height.length -1; i >=0; i--) {
            right = Math.max(height[i], right);
            rightMax[i] = right;
        }
        int area = 0;

        for(int i=0; i< height.length; i++) {
            int currArea = Math.min(leftMax[i], rightMax[i]) - height[i];
            area+= currArea < 0 ? 0 : currArea;
        }

        return area;
    }
}
