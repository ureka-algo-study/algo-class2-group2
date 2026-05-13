package 종수.week4;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Arrays.fill(answer, -1);
        
        Stack<Integer> stack = new Stack<>();

        for( int i = 0; i < numbers.length; i++){
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int n = stack.pop();

                answer[n] = numbers[i];
            }
            stack.push(i);
        }

        return answer;
    }//psvm


}//class




// 시간 초과
// import java.util.Arrays;

// class Solution {
//     public int[] solution(int[] numbers) {
//         int[] answer = {};

//         answer = new int[numbers.length];
//         Arrays.fill(answer, -1);

//         boolean fixed[] = new boolean[numbers.length - 1];

//         for (int i = 0; i < numbers.length; i++) {

//             if (i == numbers.length - 1) {
//                 answer[i] = -1;
//             }

//             for (int j = 0; j < i; j++) {

//                 if (numbers[j] < numbers[i]) {
//                     if (!fixed[j]) {
//                         answer[j] = numbers[i];
//                     }
//                     fixed[j] = true;

//                 }

//             }
//         }

//         return answer;
//     }

// }



// 처음에 반복문을 0부터 배열의 길이만큼 돌려서 i와 j를 비교
// 이때 j의 범위는 i를 넘어서면 안됨
