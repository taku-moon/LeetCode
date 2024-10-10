class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<String, Integer> map = new HashMap<>();
        for (String jewel : jewels.split("")) {
            map.put(jewel, 0);
        }
        
        for (String stone : stones.split("")) {
            if (!map.containsKey(stone)) {
                continue;
            }
            map.put(stone, map.get(stone) + 1);
        }

        int answer = 0;
        for (String jewel : jewels.split("")) {
            answer += map.get(jewel);
        }

        return answer;
    }
}