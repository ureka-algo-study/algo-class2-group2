package 종수.week16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    static String[] users;
    static String[] banned;

    static boolean[] selected;

    static List<boolean[]> results;

    public int solution(String[] user_id, String[] banned_id) {

        users = user_id;
        banned = banned_id;

        selected = new boolean[user_id.length];
        results = new ArrayList<>();

        dfs(0);

        return results.size();
    }

 static void dfs(int depth) {

    if (depth == banned.length) {

        for (boolean[] result : results) {
            if (Arrays.equals(result, selected)) {
                return;
            }
        }

        results.add(selected.clone());
        return;
    }

    for (int i = 0; i < users.length; i++) {

        if (selected[i]) {
            continue;
        }

        if (!match(users[i], banned[depth])) {
            continue;
        }

        // 현재 사용자 선택
        selected[i] = true;

        // 다음 banned_id 탐색
        dfs(depth + 1);

        // 현재 사용자 선택 취소
        selected[i] = false;
    }
}

    static boolean match(String user, String pattern) {

        if (user.length() != pattern.length()) {
            return false;
        }

        for (int i = 0; i < user.length(); i++) {

            if (pattern.charAt(i) == '*') {
                continue;
            }

            if (user.charAt(i) != pattern.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
