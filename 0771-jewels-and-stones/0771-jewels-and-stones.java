class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character jewel : jewels.toCharArray()) {
            map.put(jewel, 0);
        }
        
        for (Character stone : stones.toCharArray()) {
            if (!map.containsKey(stone)) {
                continue;
            }
            map.put(stone, map.get(stone) + 1);
        }

        int answer = 0;
        for (Character jewel : jewels.toCharArray()) {
            answer += map.get(jewel);
        }

        return answer;
    }
}