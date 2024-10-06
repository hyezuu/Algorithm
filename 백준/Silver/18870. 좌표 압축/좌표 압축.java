import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, nums, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void solution(int n, int[] x, BufferedWriter bw) throws IOException {
        int[] clone = x.clone();
        Arrays.sort(clone);

        Map<Integer, Integer> map = new HashMap<>(n);

        int rank = 0;
        for (int num : clone) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(map.get(x[i]) + " ");
        }
    }
}