class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        boolean division = false;
        
        int value = arrayA[0];
        for(int i=1; i<arrayA.length; i++){
            value = gcd(arrayA[i], value);
        }
        for(int j=0; j<arrayB.length; j++){
            if(arrayB[j] % value == 0){
                division = true;
                break;
            }
        }
        if(!division){
            answer = Math.max(value, answer);
        }

        
        
        division = false;
        
        value = arrayB[0];
        for(int i=1; i<arrayB.length; i++){
            value = gcd(arrayB[i], value);
        }
        for(int j=0; j<arrayA.length; j++){
            if(arrayA[j] % value == 0){
                division = true;
                break;
            }
        }
        if(!division){
            answer = Math.max(value, answer);
        }
        
        return answer;
    }
    
    public int gcd (int a, int b){
        while(b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}