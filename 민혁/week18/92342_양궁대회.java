import java.util.*;

class Solution {

    public static int[] apeach; 
    public static int[] lion = new int[11]; 
    public static int[] answer = {-1}; // 최종 정답 배열 없을 경우 -1
    public static int max = 0; // 지금까지 발견한 가장 큰 점수 차이

    public int[] solution(int n, int[] info) {
        apeach = info; 
        dfs(0, n); // 10점부터 탐색 시작, n개의 화살
        return answer; 
    }

    static void dfs(int index, int remain) {

        // index가 10이면 0점까지 도착했다는 뜻
        if (index == 10) {

            lion[index] = remain; // 남은 화살은 전부 0점에 몰아줌

            int lionScore = 0; // 라이언 점수
            int apeachScore = 0; // 어피치 점수

            // 10점부터 0점까지 확인
            for (int i = 0; i < 11; i++) {

                int score = 10 - i; // 현재 과녁 점수 계산

                // 두 사람 모두 화살을 하나도 안 쐈다면 아무도 점수를 얻지 않음
                if (lion[i] == 0 && apeach[i] == 0) {
                    continue;
                }

                // 라이언이 어피치보다 더 많은 화살을 쏘면 라이언 득점
                if (lion[i] > apeach[i]) {
                    lionScore += score;
                } else {
                    apeachScore += score; // 같거나 적으면 어피치
                }
            }

            int diff = lionScore - apeachScore; // 두 사람의 점수 차이 계산

            // 라이언이 이긴 경우에만 정답 후보
            if (diff > 0) {

                // 기존 최대 점수 차이보다 더 큰 경우
                if (diff > max) {

                    max = diff; // 최대 점수 차이 갱신

                    answer = lion.clone(); // 현재 라이언 화살 분배를 정답으로 저장

                // 기존 최대 점수 차이와 같은 경우
                } else if (diff == max) {

                    // 더 낮은 점수에 화살을 많이 쏜 경우인지 확인
                    if (which(lion, answer)) {

                        answer = lion.clone(); // 조건에 맞으면 정답 갱신
                    }
                }
            }

            lion[index] = 0; // 다음 탐색을 위해 0점 화살 개수 원상복구

            return; // 현재 DFS 종료
        }

        // 현재 점수를 라이언이 가져가기 위해 필요한 화살 수
        int need = apeach[index] + 1;

        // 필요한 화살보다 남은 화살이 많거나 같다면
        if (remain >= need) {

            lion[index] = need; // 어피치보다 1발 더 쏴서 점수를 가져감

            dfs(index + 1, remain - need); // 다음 점수 탐색

            lion[index] = 0; // 백트래킹을 위해 현재 위치를 다시 0으로 복구
        }

        // 이번 점수는 포기하고 화살을 하나도 쏘지 않는 경우
        lion[index] = 0; // 현재 점수에는 화살을 사용하지 않음

        dfs(index + 1, remain); // 화살을 그대로 가지고 다음 점수 탐색
    }

    public static boolean which(int[] now, int[] old) {

        // 0점부터 10점 방향으로 확인
        for (int i = 10; i >= 0; i--) {

            // 현재 후보가 기존 정답보다 해당 점수에 화살을 더 많이 쐈다면 현재 후보가 더 좋은 정답
            if (now[i] > old[i]) {
                return true; 
            }

            // 현재 후보가 기존 정답보다 해당 점수에 화살을 적게 쐈다면 기존 정답이 더 좋은 정답
            if (now[i] < old[i]) {
                return false; 
            }
        }

        return false; // 완전히 같은 경우에는 기존 정답
    }
}
