import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();

        bw.write(T.solution(a));
        bw.flush();
    }

    public String solution(String a) {
        int[] nums = new int[10];
        for(char c : a.toCharArray()){
            int num = c-'0';
            if(num==9||num==6){
                if(nums[6]<nums[9]){
                    nums[6] = nums[6]+1;
                }
                else nums[9] = nums[9]+1;
            }
            else nums[num] = nums[num]+1;
        }
        int max = 0;
        for(int i=0; i<10; i++){
            if(max<nums[i]){
                max=nums[i];
            }
        }
        return max+"";
    }
}
