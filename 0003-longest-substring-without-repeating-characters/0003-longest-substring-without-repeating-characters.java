class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        int maxLen = 0;

        while (end < s.length()) {
            if (map.containsKey(array[end])) {
                map.remove(array[start++]);
            } else {
                map.put(array[end], end++);
                maxLen = Math.max(maxLen, map.size());
            }
        }

        return maxLen;
    }
}