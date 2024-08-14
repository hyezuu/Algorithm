import java.io.*;
import java.util.*;

class Main {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(nums));
        br.close();
    }

    static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            set.add(nums[i] - nums[i - 1]);
        }
        for (int a : set) {
            count(nums, a, 0, 0);
        }
        return min;
    }

    static void count(int[] nums, int diff, int idx, int cnt) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        for (int i = idx; i < nums.length - 1; i++) {
            if (copy[i + 1] - copy[i] != diff) {
                cnt++;
                int tmp = copy[i];
                copy[i] = copy[i + 1] - diff;
                count(copy, diff, i+1, cnt);
                copy[i] = tmp;
                copy[i + 1] = copy[i] + diff;
            }
        }
        min = Math.min(min, cnt);
    }
}