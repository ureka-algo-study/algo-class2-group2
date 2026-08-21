package study.week17;

public class Solution_92342_양궁대회 {
    int[] info;
    int maxDiff = 0;
    int[] bestRyan = null; //라이언의 점수 배치

    public int[] solution(int n, int[] info) {
        this.info = info;

        dfs(0, n, new int[11]);

        //라이언이 이기지 못하면 -1 반환
        if (bestRyan == null) {
            return new int[] {-1};
        }

        return bestRyan;
    }

    void dfs(int idx, int left, int[] ryan) {
        if (idx == 11) {
            ryan[10] += left;

            int diff = calcDiff(ryan);

            if (diff > 0 && diff >= maxDiff) {
                if (diff > maxDiff) { //점수 차가 더 크면 무조건 갱신
                    maxDiff = diff;
                    bestRyan = ryan.clone(); //복사하여 저장 (원본은 계속 바뀜)
                } else {
                    if (isLower(ryan, bestRyan)) {
                        bestRyan = ryan.clone();
                    } //if - 점수 차가 같을 때 -> 낮은 구역을 더 많이 쏜 쪽으로 갱신 *이게뭔소리냐고
                } //if ~ else
            } //if

            ryan[10] -= left;
            return;
        } //if - 탈출조건

        for (int shot = 0; shot <= left; shot++) {
            ryan[idx] = shot;
            dfs(idx + 1, left - shot, ryan);
            ryan[idx] = 0;
        }
    } //dfs

    int calcDiff(int[] ryan) { //라이언과 어피치 점수차 구하기
        int apeach = 0;
        int ryanScore = 0;

        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && ryan[i] == 0) continue;  // 둘 다 0발 → 아무도 못 가져감

            if (ryan[i] > info[i]) { // 라이언이 더 많음 → 라이언이 (10-i)점
                ryanScore += (10 - i);
            } else { // 어피치가 같거나 많음(동점도 어피치) → 어피치가 가져감
                apeach += (10 - i);
            }
        }

        return ryanScore - apeach;
    } //calcDiff

    boolean isLower(int[] a, int[] b) {
        for (int i = 10; i >= 0; i--) {
            if (a[i] == b[i]) continue;
            return a[i] > b[i];   // 낮은 구역(뒤쪽)에서 먼저 더 많이 쏜 쪽이 우선
        }
        return false;
    } //isLower
}
