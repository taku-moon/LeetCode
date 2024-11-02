class Solution {
    public int numIslands(char[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    answer++;
                }
            }
        }

        return answer;
    }

    public void dfs(int i, int j, char[][] grid) {
        // grid의 범위를 넘어갔거나, grid[i][j]의 값이 0이면 해당 호출은 종료
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(i, j+1, grid);  // 동
        dfs(i, j-1, grid);  // 서
        dfs(i+1, j, grid);  // 남
        dfs(i-1, j, grid);  // 북
    }
}