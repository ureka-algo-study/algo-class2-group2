package 종수.week7;

class Solution {
    public long solution(int n, int[] times) {

        
        // 시간 t가 주어졌을때 이 t 동안 n을 처리할수있냐
        // t를 구하려면 1 ~ 가장느린심사관이 전부를 처리했을 때를 구하고
        // 평균값을 t로 두면서 t값을 구해야함
        long left = 1;
        long right = 0;

        // 최댓값 찾기
        for (int time : times) {
            right = Math.max(right, time);
        }

        // 가장 느린 심사관이 혼자 전부 처리하는 경우
        right *= n;

        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0;

            // mid 시간 동안 처리 가능한 사람 수
            for (int time : times) {
                count += mid / time;

                // 오버플로우 방지 및 불필요한 계산 방지
                if (count >= n) {
                    break;
                }
            }

            if (count >= n) {
                // 가능 -> 더 짧은 시간도 가능한지 탐색
                answer = mid;
                right = mid - 1;
            } else {
                // 불가능 -> 시간 늘리기
                left = mid + 1;
            }
        }

        return answer;
    }
}

// 끝나는 시간도 계산해서 어느 심사관으로 했을때 더 빠르게 끝날지도 생각
//심사를 기다리는 사람 n
// times.length = 심사관 숫자
// times[x] = x번째 심사관의 심사 시간
