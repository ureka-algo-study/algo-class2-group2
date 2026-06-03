import java.util.Arrays;


class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        // times 를 오름차순 정렬
        Arrays.sort(times);4
        // left right 설정
        long left = 0;
        // long left = (long) times[0] * n;
        long right = (long) times[times.length - 1] * n;
        //모든 사람이 가장 오래걸리는 검사




        while(left <= right) {
            long mid = (left + right) / 2;
            long people = 0;

            // mid 안에 몇명 검사 가능?
            for(int i = 0; i < times.length; i ++) {
                people += mid / times[i];
            }

            if(people >= n) { // 검사가능한 수가 검사해야할 수보다 많을 때 -> 시간이 남음
                answer = mid;
                right = mid - 1;
            } else { // 검사가능한 수가 검사해야할 수보다 적을 때 -> 시간이 더 필요
                left = mid + 1;
            }

        }


        return answer;
    }
}