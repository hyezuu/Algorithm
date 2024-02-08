import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int[] nums = new int[a];
        for (int i = 0; i < a; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        bw.write(T.solution(a, nums, x));
        bw.flush();
    }

    public String solution(int a, int[] nums, int x) {
        int count = 0;
        Arrays.sort(nums);
        for(int i=0; i<a; i++){
            if(nums[i]==x){
                count++;
                if(i<a-1 && nums[i+1]!=x){
                    break;
                }
            }
        }
        return count + "";
    }
}
