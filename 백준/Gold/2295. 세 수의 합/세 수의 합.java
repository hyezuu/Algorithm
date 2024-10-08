import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        System.out.print(solution(n, nums));
    }

    public static int solution(int n, int[] nums) {
        Arrays.sort(nums);

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                set.add(nums[j]+nums[i]);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int target = nums[i] - nums[j];
                if (set.contains(target)) {
                    return nums[i];
                }
            }
        }
        return 0;
    }
}