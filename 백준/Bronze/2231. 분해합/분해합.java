import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.print(Solution.solution(N));
    }

}

class Solution {

    public static int solution(int N) {
        for (int i = 1; i < N; i++) {
            int sum = i;
            int tmp = i;
            while (tmp >= 1) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (N == sum) {
                return i;
            }
        }
        return 0;
    }
}
