package week1;

/*
각 직원의 출근희망시간과 실제 출근시간을 비교하는 문제로 이해

1. 직원의 출근 희망시간과 실제 출근 시간을 비교

    n(=schedules.length)만큼 반복 -> (각각의 직원의 출근시간을 확인)
        -timelogs만큼 반복 -> (각각의 직원이 출근시간을 매일 잘 지켰는지 확인)
            --주말인지 체크(주말이라면 확인 예외)
            --직원들이 설정한 출근시간(schedules)에서 +10분 안에 드는지 체크
            --평일 모두 조건을 만족하면 answer++

2. return answer

시간 복잡도 O(n)
 */

public class Main {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) { // 직원 수만큼 확인
            boolean commute = true;
            for (int j = 0; j < timelogs[i].length; j++) { //개별 직원이 매일 잘 출근했는지 확인

                //시간 비교를 위해 분으로 변환 (이유) 설정이750인 경우에는 10분 뒤가 800으로 넘어가 +10 비교 불가
                int st = schedules[i] / 100 * 60 + schedules[i] % 100; //schedules 분 변환
                int tt = timelogs[i][j] / 100 * 60 + timelogs[i][j] % 100; // timelogs 분 변환

                //if 주말 체크
                if(j == ((6 - startday) + 7) % 7 || j == ((7 - startday) + 7) % 7) {
                    // (6 - startday) 가 음수로 넘어가는 것을 방지하기 위헤 +7 을 한 뒤 % 7
                    continue;
                }

                // 평일 해당 요일에 출근을 잘했는가?
                if(!(tt <= st + 10)) {
                    commute = false; // 시간 안에 못 왔으면 false로 바꿔줌
                    break; // 하루라도 못지켰으면 그 인원은 out, 반복문 탈출
                }
            }
            // 만약 평일 모두 출근을 잘했다면 commute == true   answer++
            if(commute) {
                answer++;
            }
        }

        return answer;
    }
}
