class Solution {
    public int solution(String word) {
        /*
        A AA AAA AAAA 
        AAAAA AAAAE AAAAI AAAAO AAAAU
        AAAE AAAI AAAO AAAU
        AAE AAI AAO AAU
        AE AI AO AU
        E EE EEE EEEE
        EEEEA ...
        사전 순 나열
        I인경우
        앞에 A E가 지나감
        A로 시작하는경우
        A 1
        AX 5
        AXX 25
        AXXX 125
        AXXXX 625
        781
        781 + 781 = 1562
        
        EIO인경우
        E앞에 A -> 781 + 1
        I앞에 AE -> 156 * 2 + 1 = 312 + 1
        O앞에 AEI -> 31 * 3 + 1 = 93 + 1
        */
    
        int[] nums = {781, 156, 31, 6, 1};
        char[] vowel = {'A', 'E', 'I', 'O', 'U'};
        
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            char thisChar = word.charAt(i);

            for (int j = 0; j < vowel.length; j++) {
                if (vowel[j] == thisChar) {
                    answer += j * nums[i] + 1;
                    break;
                }
            }
        }
        return answer;
    }
}
