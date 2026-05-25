class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String c: operations) {
            switch(c) {
                case "+":
                    int sum = 0;
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    sum=num1+num2;
                    stack.push(num2);
                    stack.push(num1);
                    stack.push(sum);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default: 
                    stack.push(Integer.parseInt(c));
                    break;
            }
        }

        int sum=0;
        while(!stack.isEmpty()) sum+=stack.pop();
        return sum;
    }
}