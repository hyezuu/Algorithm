import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] nums = new int[9];

        for(int i=0; i<9; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        bw.write(T.solution(nums));
        bw.flush();
    }
    public String solution(int[] nums){
        int max = 0;
        int rank = 0;
        for(int i=0; i<9; i++){
            if(max<nums[i]){
                max = nums[i];
                rank = i+1;
            }
        }
        return max + "\n" + rank;
    }
}
