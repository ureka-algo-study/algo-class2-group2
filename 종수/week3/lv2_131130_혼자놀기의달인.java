package 종수.week3;

class Solution {

    static boolean[] visited;
    static int[] card;
    static int max1;
    static int max2;
    static int count;

    public int solution(int[] cards) {
        int answer = 0;

        max1 = 0;
        max2 = 0;
        count = 0;// 초기화를 solution 안에서

        int n = cards.length;
        visited = new boolean[n];
        card = cards.clone();

        for (int i = 0; i < n; i++) {
            if (visited[i] == true) {
                continue;
            }
            dfs(i);
            if (count > max1) {//최댓값 2개 뽑는 로직 틀려서 다시 작성
                max2 = max1;
                max1 = count;
            } else if (count > max2) {
                max2 = count;
            }
            // System.out.println("최댓값 확인 : " + max1 + " " + max2);
            count = 0;
        }
        if (max2 == 0)
            return 0; // 빠트린 조건;
        return max1 * max2;
    }

    void dfs(int index) {

        if (visited[index] == true) {
            return;
        }

        visited[index] = true;
        // System.out.println(index + "번째 방문확인");
        dfs(card[index] - 1);
        count++;
    }
}