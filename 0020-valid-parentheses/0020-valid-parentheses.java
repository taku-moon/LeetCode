class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> table = new HashMap<>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};

        for (char c : s.toCharArray()) {
            if (table.containsKey(c)) {
                stack.push(table.get(c));
                continue;
            }
            if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}