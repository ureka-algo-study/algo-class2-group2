class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
       /*
       최대공약수
       */
        int resultA = arrayA[0];
        int resultB = arrayB[0];
        
        // 배열 A의 최대공약수
        for(int i = 1; i < arrayA.length; i ++) {
            resultA = gcd(resultA,arrayA[i]);
        }
        
        // 배열 B의 최대공약수
        for(int i = 1; i < arrayB.length; i ++) {
            resultB = gcd(resultB,arrayB[i]);
        }
        
        boolean possibleA = true;
        boolean possibleB = true;
        
        // B로 배열A를 나눌수있는지 확인  
        for(int i = 0; i < arrayA.length; i ++) {
            if(arrayA[i] % resultB == 0) {
                possibleB = false;
                break;
            }
        }
        
        // A로 배열B를 나눌수있는지 확인
         for(int i = 0; i < arrayB.length; i ++) {
            if(arrayB[i] % resultA == 0) {
                possibleA = false;
                break;
            }
        }
        
        // 둘다 나눌수있으면 더큰거 하나만이면 하나만 둘다 아니면 0
        if(possibleA && possibleB) {
            return Math.max(resultA,resultB);
        } else if(possibleA && !possibleB) {
            return resultA;
        } else if(!possibleA && possibleB) {
            return resultB;
        } else {
            return 0;
        }
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
