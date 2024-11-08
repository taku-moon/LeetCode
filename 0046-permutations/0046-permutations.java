class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        dfs(list, tmp, answer);

        return answer;
    }

    public void dfs(List<Integer> list, List<Integer> tmp, List<List<Integer>> answer) {
        if (list.isEmpty()) {
            answer.add(tmp);
            return;
        }
        for (Integer num : list) {
            tmp.add(num);
            List<Integer> newTmp = new ArrayList<>(tmp);
            List<Integer> newList = new ArrayList<>(list);
            newList.remove(num);
            dfs(newList, newTmp, answer);
            tmp.remove(num);
        }
    }




}