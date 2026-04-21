class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {

            int limit = toMinute(schedules[i]) + 10; // 각 직원별 설정시간 분으로 계산
                                                     // +10분이 범위

            int j;
            for (j = 0; j < 7; j++) {
                int day = (startday + j) % 7;        // 시작요일 + j을 7로 나눈 나머지값이
                if (day == 0 || day == 6) continue;  // 토요일 혹은 일요일이라면 다음반복

                int log = toMinute(timelogs[i][j]);  // 실제 출근시간 분으로 변경
                if (log > limit) break;              // 실제 출근시간이 범위보다 높으면 탈출
            }


            if (j == 7) answer++;  //끝까지 다 돌았으면 j == 7, 상품을 받을 직원 확정
        }

        return answer;
    }

    int toMinute(int time) { //분으로 계산
        return (time / 100) * 60 + (time % 100);
    }
}