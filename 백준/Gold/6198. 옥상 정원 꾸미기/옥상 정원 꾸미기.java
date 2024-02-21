import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= height) stack.pop();
            answer+=stack.size();
            stack.push(height);
        }
        System.out.print(answer);
    }
}
