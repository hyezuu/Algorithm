import java.util.*;

class Solution {
    static Set<Set<String>> result = new HashSet<>();
    static boolean[] visited;
    static String[] bannedIds;
    static String[] userIds;
    
    public int solution(String[] userIds, String[] bannedIds) {
        Solution.bannedIds = bannedIds;
        Solution.userIds = userIds;
        visited = new boolean[userIds.length];
        
        dfs(0, new HashSet<>());
        
        return result.size();
    }

    private void dfs(int bannedIdx, Set<String> selected) {
        if (bannedIdx == bannedIds.length) {
            result.add(new HashSet<>(selected));
            return;
        }

        for (int i = 0; i < userIds.length; i++) {
            if (visited[i]) continue;
            if (!checkFormat(bannedIds[bannedIdx], userIds[i])) continue;

            visited[i] = true;
            selected.add(userIds[i]);

            dfs(bannedIdx + 1, selected);

            visited[i] = false;
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
