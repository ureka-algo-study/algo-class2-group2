package 종수.week4;

class Solution {
    // k는 내 피로도
    // dungeons[최소필요피로도, 소모피로도]
    static int answer = -1;
    static boolean visited[];

    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];

        dfs(k, dungeons, 0);

        return answer;
    }

    public void dfs(int k, int[][] dungeons, int count) {

        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++){

            if (visited[i]) {
                continue;
            }

            if (k < dungeons[i][0]) {
                continue;
            }

            visited[i] = true;
            dfs( k - dungeons[i][1], dungeons, count +1);

            visited[i] = false;

        }
    }
}