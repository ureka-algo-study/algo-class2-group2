import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        /*
        전부 대문자로
        두개씩 자르기
        문자열 아니면 패스
        합집합 교집합 하나씩 체크
        */
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        for(int i = 0; i < str1.length() - 1; i ++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);
            
            if(first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z') {
                String multiSet = str1.substring(i, i+2);
                list1.add(multiSet);
            }
        } //for
        
        for(int i = 0; i < str2.length() - 1; i ++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);
            
            if(first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z') {
                String multiSet = str2.substring(i, i+2);
                list2.add(multiSet);
            }
        } //for
        
        List<String> interSet = new ArrayList<>();
        List<String> unionSet = new ArrayList<>();
        
        
        for(int i = list1.size() - 1; i >= 0; i--) {
            String picked = list1.get(i);
            
            if(list2.contains(picked)) {
                list2.remove(picked);
                interSet.add(picked);
            }
            unionSet.add(picked);
        } //for
        unionSet.addAll(list2);
        
        double union = (double) unionSet.size();
        double inter = (double) interSet.size();
        
        if(union == 0 && inter == 0) {
            return 65536;
        }
        
        return (int) ((inter / union) * 65536);
    }
}
