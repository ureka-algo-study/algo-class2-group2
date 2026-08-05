package 종수.week16;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();

        long fac = 1;

        // 사용할 숫자와 n!  계산
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
         fac *= i;
        }

        // 인덱스를 0부터 사용하기 위해 변경
        k--;

        for (int i = 0; i < n; i++) {
         fac /= n - i;

            int index = (int) (k / fac);

            answer[i] = numbers.remove(index);

            k %= fac;
        }

        return answer;
    }
}

// class Solution {

//     static int[] result;
//     static boolean[] visited;
//     static int[] arr;

//     static long count;
//     static long target;
//     public int[] solution(int n, long k) {
        
//         result = new int[n];
//         visited = new boolean[n];
//         arr = new int[n];
//         count = 0;

//         target = k;

//         for(int i = 0; i < n; i++){
//             arr[i] = i + 1;
//         }

//         permutation(0, n);


//         return result;
//     }

//     static boolean permutation(int depth, int r){

//         if(depth == r){
//             count++;

//             return count == target;
//         }

//         for(int i = 0; i < arr.length; i++){

//             if(visited[i]){
//                 continue;
//             }

//             visited[i] = true;
//             result[depth] = arr[i];

//             if( permutation( depth + 1, r)){
//                 return true;
//             }

//             visited[i] = false;
//         }

//         return false;
//     }
// }