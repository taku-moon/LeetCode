class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().replaceAll("[^a-z]", " ").split("\\s+");
        List<String> ban = new ArrayList<>(Arrays.asList(banned));

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (!ban.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}