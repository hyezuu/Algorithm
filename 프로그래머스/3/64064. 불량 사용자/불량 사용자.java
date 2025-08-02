import java.util.*;

class Solution {
    static Set<Set<String>> result = new HashSet<>();
    static String[] bannedIds;
    static String[] userIds;
    
    public int solution(String[] userIds, String[] bannedIds) {
        this.bannedIds = bannedIds;
        this.userIds = userIds;
        dfs(0, new HashSet<>());
        return result.size();
    }

    private void dfs(int bannedIdx, Set<String> selected) {
        if (bannedIdx == bannedIds.length) {
            result.add(new HashSet<>(selected));
            return;
        }

        for (int i = 0; i < userIds.length; i++) {
            if (selected.contains(userIds[i])) continue;
            if (!checkFormat(bannedIds[bannedIdx], userIds[i])) continue;

            selected.add(userIds[i]);
            dfs(bannedIdx + 1, selected);
            selected.remove(userIds[i]);
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
