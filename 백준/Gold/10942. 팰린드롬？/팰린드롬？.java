import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int lt = Integer.parseInt(st.nextToken())-1;
            int rt = Integer.parseInt(st.nextToken())-1;
            boolean isPalindrome = true;
            while(lt < rt){
                if(nums[lt] == nums[rt]){
                    lt++;
                    rt--;
                }
                else {
                    isPalindrome = false;
                    break;
                }
            }
            bw.write(isPalindrome ? "1" : "0");
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
