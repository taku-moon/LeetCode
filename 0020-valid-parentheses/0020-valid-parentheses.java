class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // 여는 괄호면 stact.push()
            if (c == '(') {
                stack.push(')');
                continue;
            }
            if (c == '{') {
                stack.push('}');
                continue;
            }
            if (c == '[') {
                stack.push(']');
                continue;
            }

            // 닫는 괄호면 stack.pop()
            if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}