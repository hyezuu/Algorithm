import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] targets = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = solution(n, nums, m, targets);
        for (int i = 0; i < m; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] solution(int n, int[] nums, int m, int[] targets) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] answer = new int[m];

        for(int i=0; i<m; i++){
            answer[i] = map.getOrDefault(targets[i], 0);
        }

        return answer;
    }
}