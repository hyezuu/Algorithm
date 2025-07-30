import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  static int H, W;
  static int[] heights;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());

    heights = new int[W];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < W; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

    System.out.print(solve());
  }

  static int solve() {
    int max = 0;
    Stack<Integer> stack = new Stack<>();
    int total = 0;

    for (int i = 0; i < W; i++) {
      int cur = heights[i];
      if(cur > max) {
        while (!stack.isEmpty()) {
          total += max - stack.pop();
        }
        max = cur;
        continue;
      }
      stack.push(cur);
    }

    if(stack.isEmpty()) return total;
    int last = stack.pop();
    while (!stack.isEmpty()) {
      if(last > stack.peek()) {
        total += last - stack.pop();
      }
      else {
        last = stack.pop();
      }
    }
    return total;
  }
}