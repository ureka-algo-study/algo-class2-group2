package study.week16;

public class Solution_135807_숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        boolean divided = false;

        if (arrayA.length == 1) {
            if (arrayB[0] % arrayA[0] != 0) answer = arrayA[0];
            if (arrayA[0] % arrayB[0] != 0) answer = Math.max(answer, arrayB[0]);
            return answer;
        }

        int gcdA = gcd(arrayA[0], arrayA[1]);
        for (int i = 2; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        for (int b : arrayB) {
            if (b % gcdA == 0) divided = true;
        }
        if (!divided) answer = gcdA;

        divided = false;
        int gcdB = gcd(arrayB[0], arrayB[1]);
        for (int i = 2; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        for (int a : arrayA) {
            if (a % gcdB == 0) divided = true;
        }
        if (!divided) answer = Math.max(answer, gcdB);

        return answer;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
