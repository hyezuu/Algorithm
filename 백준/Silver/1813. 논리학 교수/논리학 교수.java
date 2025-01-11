import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[t];
        for(int i=0; i<t; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(Solution.solution(t, arr));
    }

}
class Solution {
    public static int solution (int t, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean existZero = false;
        for(int i=0; i<t; i++){
            if(arr[i]==0) existZero = true;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int max = 0;

        for (int i : map.keySet()){
            if(map.get(i) == i){
                max = Math.max(max, i);
            }
        }
        return max > 0 ? max : existZero ? -1 : 0;
    }
}
