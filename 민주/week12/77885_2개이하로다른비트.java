class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int n=0; n<numbers.length; n++){
            if(numbers[n] % 2 == 0){
                answer[n] = numbers[n]+1;
                continue;
            }
            
            String number = Long.toBinaryString(numbers[n]);
            StringBuilder sb = new StringBuilder(number);
            sb.insert(0, '0');
            // System.out.println(sb);
            for(int i=sb.length()-1; i>=0; i--){
                
                if(sb.charAt(i) == '1' && sb.charAt(i-1) == '0'){
                    sb.setCharAt(i, '0'); 
                    sb.setCharAt(i-1, '1'); 
                    break;
                }
            }
            
            String next = sb.toString();
            answer[n] = Long.parseLong(next, 2);
            
        } // for n
        return answer;
    }
}