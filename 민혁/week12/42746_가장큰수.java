import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        boolean isZero = true;
        for(int number : numbers) {
            if(number != 0) {
                isZero = false;
            }
        }

        if(isZero) {
            return "0";
        }

        String[] strns = new String[numbers.length];

        for(int i = 0; i < numbers.length; i ++) {
            String numberToString = String.valueOf(numbers[i]);
            strns[i] = numberToString;
        }

        Arrays.sort(strns,( (s1, s2) -> {
            String a = s1 + s2;
            String b = s2 + s1;

            return -1 * a.compareTo(b);
        }));

        StringBuilder sb = new StringBuilder();

        for(String str : strns) {
            sb.append(str);
        }

        String result = sb.toString();

        return result;




    }
}