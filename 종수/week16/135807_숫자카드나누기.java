package 종수.week16;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {

        int gcdA = getGcd(arrayA);
        int gcdB = getGcd(arrayB);

        int resultA = divide(gcdA, arrayB) ? gcdA : 0;
        int resultB = divide(gcdB, arrayA) ? gcdB : 0;

        return Math.max(resultA, resultB);

    }

    int getGcd(int[] array) { // 배열의 최대공약수 구하는 함수

        int result = array[0];

        for (int i = 1; i < array.length; i++) {
            result = gcd(result, array[i]);
        }

        return result;
    }

    int gcd(int a, int b) { // 숫자 두 개의 최대공약수 구하는 함수
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    boolean divide(int divisor, int[] array) { // 어떠한 숫자로 배열의 숫자들이 나눠지는지 확인
        for (int number : array) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}

//