class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int answer = 0;
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

        for (Character jewel : jewels.toCharArray()) {
            answer += map.get(jewel);
        }

        return answer;
    }
}