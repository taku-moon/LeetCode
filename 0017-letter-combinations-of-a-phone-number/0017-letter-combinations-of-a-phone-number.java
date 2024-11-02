class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return answer;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        dfs(digits, map, 0, new StringBuilder(), answer);

        return answer;
    }

    private void dfs(String digits, Map<Character, String> map, int index, StringBuilder sb, List<String> answer) {
        if (index == digits.length()) {
            answer.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            sb.append(letter);
            dfs(digits, map, index + 1, sb, answer);
            sb.deleteCharAt(sb.length() - 1); // 백트래킹
        }
    }
}