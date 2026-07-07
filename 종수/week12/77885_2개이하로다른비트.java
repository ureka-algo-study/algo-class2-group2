package 종수.week12;

// 비트 풀이법


// 문자열 풀이법
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

    for (int idx = 0; idx < numbers.length; idx++) {            
            long num = numbers[idx];

            // 7일 경우 111인데 이 때 앞에 0이 하나 더 필요
            String binary = "0" + Long.toBinaryString(num);
            StringBuilder sb = new StringBuilder(binary);


            for(int i = sb.length()-1; i >= 0; i--){
                if(sb.charAt(i) == '0'){
                    sb.setCharAt(i, '1');// 일단 커야하니까 가장 끝에 1을 더하고

                    if (i + 1 < sb.length()) {
                        sb.setCharAt(i + 1, '0');
                    }

                    break;
                }
            }

            // 2진수 문자열을 다시 long으로 변환
            answer[idx] = Long.parseLong(sb.toString(), 2);
        }
    return answer;
    }
}
