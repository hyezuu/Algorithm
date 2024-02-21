import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class NGE {
    int index;
    int number;

    public NGE(int index, int number) {
        this.index = index;
        this.number = number;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        Stack<NGE> stack = new Stack<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(stk.nextToken());
            while (!stack.isEmpty() && stack.peek().number < num) {
                arr[stack.pop().index] = num;
            }
            stack.push(new NGE(i, num));
        }
        for(int a : arr){
            if(a==0) bw.write("-1 ");
            else bw.write(a + " ");
        }
        bw.flush();
    }
}
