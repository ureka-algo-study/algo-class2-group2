class Solution {
    public String solution(String p) {
        transform(p);
    }
    
    private void transform(String p) {
        //1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(p.equals("")) {
            return ""
        }
        
        //2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        int countL = 0;
        int countR = 0;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == "(") {
                countL++;
            } else {
                countR++;
            }
            
            if(countL == countR) {
                break;
            }
        } // for
        
        String u = p.subString(0,countL); //0 부터 countL까지
        String v = p.subString(countL); // countL부터 끝까지
        //...이어서하기
        
    }
}
