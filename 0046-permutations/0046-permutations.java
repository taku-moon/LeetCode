class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        dfs(numsList, tmp, answer);

        return answer;
    }

    public void dfs(List<Integer> numsList, List<Integer> tmp, List<List<Integer>> answer) {
        if (numsList.isEmpty()) {
            answer.add(tmp);
            return;
        }

        for (Integer num : numsList) {
            tmp.add(num);

            List<Integer> newTmp = new ArrayList<>(tmp);
            List<Integer> newList = new ArrayList<>(numsList);
            newList.remove(num);
            
            dfs(newList, newTmp, answer);

            tmp.remove(num);
        }
    }
}