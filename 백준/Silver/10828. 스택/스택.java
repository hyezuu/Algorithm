import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public String solution(int n, String[] arr) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(String str : arr){
            if(str.contains("push")){
                stack.push(Integer.parseInt(str.substring(5)));
            }
            else if(str.equals("pop")){
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
            }
            else if(str.equals("size")){
                sb.append(stack.size()).append("\n");
            }
            else if(str.equals("empty")){
                sb.append(stack.isEmpty()?1:0).append("\n");
            }
            else if(str.equals("top")){
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }
        bw.write(T.solution(n,arr));
        bw.flush();
    }
}