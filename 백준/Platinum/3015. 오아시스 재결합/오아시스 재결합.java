import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Pair {
    int height;
    int cnt;

    public Pair(int height, int cnt) {
        this.height = height;
        this.cnt = cnt;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            Pair pair = new Pair(num, 1);
            while (!stack.isEmpty() && stack.peek().height <= num) {
                Pair pop = stack.pop();
                answer+=pop.cnt;
                if(pop.height==num){
                    pair.cnt+= pop.cnt;
                }
            }
            if (!stack.isEmpty())answer++;
            stack.push(pair);
        }
        bw.write(answer+"");
        bw.flush();
    }
}

