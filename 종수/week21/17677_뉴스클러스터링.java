package 종수.week21;

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // str1 다중집합
        for (int i = 0; i < str1.length() - 1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);

            if (Character.isLetter(a) && Character.isLetter(b)) {
                String s = "" + a + b;
                map1.put(s, map1.getOrDefault(s, 0) + 1);
            }
        }

        // str2 다중집합
        for (int i = 0; i < str2.length() - 1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);

            if (Character.isLetter(a) && Character.isLetter(b)) {
                String s = "" + a + b;
                map2.put(s, map2.getOrDefault(s, 0) + 1);
            }
        }

        int intersection = 0;
        int union = 0;

        // 합집합 계산용 전체 key
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);

            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }

        if (union == 0) {
            return 65536;
        }

        return (int) ((double) intersection / union * 65536);
    }
}