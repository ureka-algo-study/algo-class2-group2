class Solution {

    public int[] solution(String[][] places) {

        int[] answer = new int[5];

        // 대기실 5개 검사
        for (int k = 0; k < 5; k++) {

            String[] place = places[k];

            // 일단 거리두기를 지킨다고 가정
            answer[k] = 1;

            // 첫 번째 사람 찾기
            for (int r1 = 0; r1 < 5; r1++) {
                for (int c1 = 0; c1 < 5; c1++) {

                    // 현재 칸이 사람이 아니면 패스
                    if (place[r1].charAt(c1) != 'P') {
                        continue;
                    }

                    // 비교할 다른 사람 찾기
                    for (int r2 = r1; r2 < 5; r2++) {
                        for (int c2 = 0; c2 < 5; c2++) {

                            // 자기 자신이면 패스
                            if (r1 == r2 && c1 == c2) {
                                continue;
                            }

                            // 사람이 아니면 패스
                            if (place[r2].charAt(c2) != 'P') {
                                continue;
                            }

                            // 두 사람 사이 맨해튼 거리
                            int distance =
                                    Math.abs(r1 - r2)
                                  + Math.abs(c1 - c2);

                            // 거리 2보다 멀면 문제 없음
                            if (distance > 2) {
                                continue;
                            }

                            // 거리 1이면 무조건 위반
                            if (distance == 1) {
                                answer[k] = 0;
                            }

                            // 거리 2라면 파티션 확인
                            else if (distance == 2) {

                                // 같은 행이면 사이에 파티션이 있어야함
                                if (r1 == r2) {

                                    int middleC = (c1 + c2) / 2;

                                    if (place[r1].charAt(middleC) != 'X') {
                                        answer[k] = 0;
                                    }
                                }

                                // 같은 열이면 그 사이에 파티션이 있어야함
                                else if (c1 == c2) {

                                    int middleR = (r1 + r2) / 2;

                                    if (place[middleR].charAt(c1) != 'X') {
                                        answer[k] = 0;
                                    }
                                }

                                // 대각선이면 양쪽 모두에 파티션이 있어야함
                                else {

                                    if (place[r1].charAt(c2) != 'X'
                                            || place[r2].charAt(c1) != 'X') {

                                        answer[k] = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
