import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
            System.out.println(answer[i]);
        }
    }

    public static int[] solution(int n, int[] nums, int m, int[] targets) {
        Arrays.sort(nums);
        int[] answer = new int[m];

        for (int i = 0; i < m; i++) {
            int lt = 0, rt = n - 1;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (targets[i] == nums[mid]) {
                    answer[i] = 1;
                    break;
                } else if (targets[i] < nums[mid]) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            }
        }
        return answer;
    }
}