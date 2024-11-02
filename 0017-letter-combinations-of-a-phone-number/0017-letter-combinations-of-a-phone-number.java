class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits == null || digits.length == 0) {
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

        dfs(digits, map, 0, new StringBuilder, answer);

        return asnwer;
    }

    public void dfs(String digits, Map<Character, String> map, int idx, StringBuilder sb, List<String> answer) {
        if (idx == digits.length()) {
            answer.add(sb.toString());
            retrun;
        }
        
        String letters = map.get(digits.charAt(idx))
        for (char letter : letters.toCharArray()) {
            sb.append(letter);
            dfs(digits, map, idx+1, sb, answer);
            sb.deleteCharAt(sb.length-1);
        }



    }
}