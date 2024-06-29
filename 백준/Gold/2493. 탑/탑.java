import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Tower {
    int index;
    int height;

    public Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer nums = new StringTokenizer(br.readLine());
        Stack<Tower> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(nums.nextToken());

            while (!stack.isEmpty() && stack.peek().height <= height){
                stack.pop();
            }

            if(!stack.isEmpty()) {
                bw.write(stack.peek().index+" ");
            }
            else bw.write("0 ");

            stack.push(new Tower(i+1, height));
        }
        bw.flush();
        bw.close();
    }
}