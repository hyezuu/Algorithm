import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] input = new int[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(stk.nextToken());
            input[i][1] = Integer.parseInt(stk.nextToken());
        }
        bw.write(T.solution(input));
        bw.flush();
    }
    public String solution(int[][] input) {
        StringBuilder sb = new StringBuilder();
        for(int[] arr : input){
            sb.append(arr[0]+arr[1]).append("\n");
        }
        return sb.toString();
    }
}
