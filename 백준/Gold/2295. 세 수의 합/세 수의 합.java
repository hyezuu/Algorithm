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

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                list.add(nums[j]+nums[i]);
            }
        }

        Collections.sort(list);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int target = nums[i] - nums[j];
                if (search(list, target)) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public static boolean search(List<Integer> list, int target) {
        int lt = 0, rt = list.size() - 1;
        while (lt < rt) {
            int mid = (lt + rt) / 2;

            if (list.get(mid) == target) {
                return true;
            } else if (list.get(mid) > target) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return false;
    }
}