class Solution {

    static int[] answer = {-1};
    static int maxDiff = 0;

    public int[] solution(int n, int[] info) {

        int[] ryan = new int[11];

        // 10점부터, 화살수, appeach, ryan
        dfs(0, n, info, ryan); 

        return answer;
    }

    void dfs(int index, int remain, int[] info, int[] ryan) {

        // 10점 ~ 1점까지 결정 완료
        if (index == 10) {

            // 남은 화살은 0점에 넣기
            ryan[10] = remain;

            int ryanScore = 0;
            int apeachScore = 0;

            // 점수 계산 ryan이 apeach보다 더 많이 맞힌 경우만 점수를 얻는다
            for (int i = 0; i < 11; i++) {

                if (ryan[i] == 0 && info[i] == 0) {
                    continue;
                }

                if (ryan[i] > info[i]) {
                    ryanScore += 10 - i;
                } else {
                    apeachScore += 10 - i;
                }
            }

            int diff = ryanScore - apeachScore;

            // 더 큰 점수차
            if (diff > maxDiff) {
                maxDiff = diff;
                answer = ryan.clone();
            }

            // 같은 점수차
            else if (diff == maxDiff && diff > 0) {

                // 가장 낮은 점수부터 비교
                for (int i = 10; i >= 0; i--) {

                    if (ryan[i] > answer[i]) {
                        answer = ryan.clone();
                        break;
                    }

                    if (ryan[i] < answer[i]) {
                        break;
                    }
                }
            }

            // ryan[10] = remain; 했던거를 복구
            ryan[10] = 0;
            return;
        }

        // 1. 현재 점수를 먹는다
        int need = info[index] + 1;

        if (remain >= need) {

            ryan[index] = need;

            dfs(
                index + 1,
                remain - need,
                info,
                ryan
            );

            // 다시 돌아왔을때 안먹는 경우를 보기위해 원상복구
            ryan[index] = 0;
        }

        // 2. 현재 점수를 안 먹는다
        dfs(
            index + 1,
            remain,
            info,
            ryan
        );
    }
}
