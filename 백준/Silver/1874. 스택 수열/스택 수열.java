import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public String solution(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> answer = new Stack<>();
        int lt=0;
        for(int i=1; i<=n; i++){
            stack.push(i);
            sb.append("+").append("\n");

            while (!stack.isEmpty()&&stack.peek()==arr[lt]){
                answer.push(stack.pop());
//                System.out.print(answer.peek()+" ");
                sb.append("-").append("\n");
                lt++;
            }
        }

        return answer.size()!= arr.length ? "NO" : sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        bw.write(T.solution(n, arr));
        bw.flush();
    }
}