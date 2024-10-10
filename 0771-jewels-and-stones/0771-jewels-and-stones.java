class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int answer = 0;
        Set<Character> set = new HashSet<>();

        for (Character jewel : jewels.toCharArray()) {
            set.add(jewel);
        }
        
        for (Character stone : stones.toCharArray()) {
            if (set.contains(stone)) {
                answer++;
            }
        }

        return answer;
    }
}