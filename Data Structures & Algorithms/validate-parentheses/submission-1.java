class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            switch (c) {
                case '}':
                    if(stack.isEmpty() || stack.peek() != '{') return false;
                    stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek() != '[') return false;
                    stack.pop();
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek() != '(') return false;
                    stack.pop();
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }

        return stack.isEmpty();
    }
}
