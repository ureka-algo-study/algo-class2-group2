package 종수.week25;


class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int move = n - 1;

        for (int i = 0; i < n; i++) {
            // 1. 상하 이동
            int up = name.charAt(i) - 'A';
            int down = 'Z' - name.charAt(i) + 1;

            answer += Math.min(up, down);

            // 2. 연속된 A 구간 탐색
            int next = i + 1;

            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            // 3. 오른쪽 이동 후 왼쪽으로 돌아가는 경우
            int rightFirst = 2 * i + n - next;

            // 4. 왼쪽 이동 후 오른쪽으로 돌아가는 경우
            int leftFirst = i + 2 * (n - next);

            // 5. 최소 좌우 이동 횟수 갱신
            move = Math.min(move,
                    Math.min(rightFirst, leftFirst));
        }

        return answer + move;
    }
}
