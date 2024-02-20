import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public String solution(int[] arr) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int a : arr){
            if(a!=0){
                stack.push(a);
            }
            else stack.pop();
        }

        for(int a : stack){
            answer+=a;
        }
        return answer+"";
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
        bw.write(T.solution(arr));
        bw.flush();
    }
}