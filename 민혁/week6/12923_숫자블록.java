class Solution {
    public int[] solution(long begin, long end) {
        /*
        블록을 다 깔아놓고 [begin,end] 를 return 해야하나 아니면 begin end를 정해놓고 return해야하나
        블럭숫자는 long으로 깔아놓고 return은 int로 해라?
        블럭은 자기 자신의 약수 중에서 가장 크지만 자신의 크기 / 2보다는 작거나 같은 숫자를 가지게 됨
        */
        int[] solution = new int[(int)(end - begin + 1)]; // long 연산이니 int로 변환

        for (long i = begin; i <= end; i++) {
            solution[(int)(i - begin)] = whoAmI(i);
        }

        return solution;
    }

//     public static long whoAmI(long n) {
//         if (n == 1) {
//             return 0;
//         }

//         for (long i = n / 2; i >= 1; i--) {
//             if (n % i == 0) {
//                 return i;
//             }
//         }

//         return 0;
//     } 시간 초과

    public static int whoAmI(long n) {
        if(n == 1) { //첫번째껀 원래 0
            return 0;
        }

        int result = 1;

        for(long i = 2; i <= n / i; i++) { // i*i <= n
            if(n % i == 0) {
                long pair = n / i;

                if(pair <= 10000000) { // 첫만보다 작으면 그대로 리턴 pair 는 큰 순서대로 나오기 때문
                    return (int)pair;
                }

                if (i <= 10000000) {
                    result = (int) i; // result를 점점 큰수로 초기화
                }
            }
        }

        return result;
        // 기존에 약수를 구하던 거에서 제곱근만큼 약수를 구하는 방법을 학습
    }
}