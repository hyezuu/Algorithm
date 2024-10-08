import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(solution(k, nums));
    }

    public static long solution(int k, int[] nums) {
        long sum = 0;
        for(int num : nums) {
            sum+=num;
        }

        long max = (sum/k);
        long min = 1;

        while(min<=max){
            long mid = min+(max-min)/2;
            int cnt = 0;
            for(int num : nums) {
                cnt+=num/mid;
            }
            if(cnt>=k){
                min = mid+1;
            }
            else max = mid-1;
        }
        return max;
    }
}