import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {

        List<Long> list = new ArrayList<>();

        // 이진수 변환 했을때 0으로 끝난 경우 -> 마지막 자리 수를 1로 변환
        // 이진수 변환 했을 때 1로 끝난 경우 ->
        // 1) 0으로 끝나는 수를 1로 변환
        // 2) 0으로 끝나는 수가 없으면 앞자리 수 1 증가

        for(long number : numbers) {
            String binary =  "0" + Long.toBinaryString(number);

            char[] binaryArray = binary.toCharArray();

            //이진수 변환 했을때 0으로 끝난 경우 -> 마지막 자리 수를 1로 변환
            if(binaryArray[binaryArray.length - 1] == '0') {
                binaryArray[binaryArray.length - 1] = '1';
                // 이진수 변환 했을 때 1로 끝난 경우
            } else {
                // 1) 0으로 끝나는 수를 1로 변환

                for(int i = binaryArray.length - 2; i >= 0; i--) {
                    if(binaryArray[i] == '0') {
                        binaryArray[i] = '1';
                        binaryArray[i + 1] = '0';
                        break;
                    }
                } //for
            }

            String result = String.valueOf(binaryArray);
            Long l = Long.parseLong(result, 2);

            list.add(l);


        } //for number : numbers

        long[] answer = new long[numbers.length];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;

       /*
       7 = 111(2)
       111 -> 0111 -> 1111 -> 1011 = 8 + 2 + 1 = 11

       */

    }
}