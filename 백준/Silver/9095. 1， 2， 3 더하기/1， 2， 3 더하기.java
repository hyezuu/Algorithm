import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] arr = new int[t];

        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(main.solution(arr));
        br.close();
    }

    public String solution(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int[] arr = {1, 2, 3};

        for (int n : nums) {
            int cnt = 0;
            stack.push(1);
            stack.push(2);
            stack.push(3);

            while (!stack.isEmpty()) {
                int tmp = stack.pop();
                if (tmp > n) continue;
                if (tmp == n) {
                    cnt++;
                    continue;
                }

                for (int a : arr) {
                    stack.push(tmp + a);
                }
            }
            sb.append(cnt).append("\n");
        }
        return sb.toString();
    }
}