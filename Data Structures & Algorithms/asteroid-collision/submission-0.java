class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        boolean shouldCollide = false;
        for(int ast: asteroids) {
            if(!stack.isEmpty() && ast < 0 && stack.peek() > 0) shouldCollide = true;
            stack.push(ast);
            while(stack.size() > 1 && shouldCollide) {
                int a1 = stack.pop();
                int a2 = stack.pop();
                if(!(a1 < 0 && a2 > 0)) {
                    shouldCollide = false;
                    stack.push(a2);
                    stack.push(a1);
                    break;
                }
                if(a1*-1 > a2) {
                    stack.push(a1);
                }
                else if(a1*-1 < a2) {
                    stack.push(a2);
                }
            }
        }

        System.out.println(stack.size());

        int[] res = new int[stack.size()];

        for(int i = stack.size() - 1; i>=0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}