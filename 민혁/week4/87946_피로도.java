class Solution {

    static int N,count;
    static int[][] D;
    static boolean[] visited;
    static int answer = 0 ;

    public int solution(int k, int[][] dungeons) {


        // 순열 탐색

        N = dungeons.length; // 던전의 수

        D = dungeons; // 던전
        visited = new boolean[N];
        dfs(k,0);

        return answer;
    }
    private static void dfs(int tiredness,int count) {
        // answer = Math.max(answer, count);

        for(int i = 0; i < N; i ++) {
            if(!visited[i] && tiredness >= D[i][0]) {
                visited[i] = true;
                dfs(tiredness - D[i][1], count + 1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }
}