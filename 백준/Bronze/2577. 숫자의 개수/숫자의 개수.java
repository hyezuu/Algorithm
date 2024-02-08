import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        bw.write(T.solution(a, b, c));
        bw.flush();
    }

    public String solution(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        String answer = a*b*c+"";
        int[] nums = new int[10];
        for(int i=0; i<answer.length(); i++){
            int index = answer.charAt(i)-'0';
            nums[index] = nums[index]+1;
        }
        for(int num : nums){
            sb.append(num).append("\n");
        }
        return sb.toString();
    }
}
