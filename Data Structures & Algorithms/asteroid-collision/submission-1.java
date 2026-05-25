class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        boolean shouldCollide = false;
        for(int ast: asteroids) {
            if(ast > 0 || stack.isEmpty()) stack.push(ast);
            else {
                while(!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                    int ast2 = stack.peek();
                    if(ast*-1 > ast2) {
                        stack.pop();
                    } else if(ast*-1 == ast2) {
                        ast = 0;
                        stack.pop();
                    } else {
                        ast = 0;
                    }
                }
                if(ast != 0) stack.push(ast);
            }
        }


        int[] res = new int[stack.size()];

        for(int i = stack.size() - 1; i>=0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}