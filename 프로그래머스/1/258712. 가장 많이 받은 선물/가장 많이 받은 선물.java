import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<friends.length; i++){
            map.put(friends[i], i);
        }
        int len = friends.length, answer = 0;
        int[][] arr = new int[len][len];
        int[] gt = new int[len], take = new int[len];
        for(String gift : gifts){
            StringTokenizer stk = new StringTokenizer(gift);
            int gIdx = map.get(stk.nextToken());
            int tIdx = map.get(stk.nextToken());
            arr[gIdx][tIdx]++;
            gt[gIdx]++;
            gt[tIdx]--;
        }
        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                if(arr[i][j]>arr[j][i]) take[i]++;
                else if(arr[i][j]<arr[j][i]) take[j]++;
                else{
                    if(gt[i]>gt[j]) take[i]++;
                    else if(gt[i]<gt[j]) take[j]++;
                }
                answer = Math.max(answer, Math.max(take[i], take[j]));
            }
        }
        return answer;
    }
}