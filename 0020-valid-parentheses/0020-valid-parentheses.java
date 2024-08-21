class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
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

            if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        
        return stack.isEmpty();
    }
}