import java.util.*;

class Solution {
    static Set<Integer> result = new HashSet<>();
    static String[] bannedIds;
    static String[] userIds;
    
    public int solution(String[] userIds, String[] bannedIds) {
        this.bannedIds = bannedIds;
        this.userIds = userIds;
        dfs(0, 0);
        return result.size();
    }

    private void dfs(int bannedIdx, int bit) {
        if (bannedIdx == bannedIds.length) {
            result.add(bit);
            return;
        }

        for (int i = 0; i < userIds.length; i++) {
            if ((bit & (1 << i)) != 0) continue;
            if (!checkFormat(bannedIds[bannedIdx], userIds[i])) continue;

            dfs(bannedIdx + 1, bit | (1 << i));
        }
    }

    private boolean checkFormat(String masked, String full) {
        if (masked.length() != full.length()) return false;
        for (int i = 0; i < masked.length(); i++) {
            if (masked.charAt(i) == '*') continue;
            if (masked.charAt(i) != full.charAt(i)) return false;
        }
        return true;
    }
}
