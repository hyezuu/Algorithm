import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] minutes = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            minutes[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.print(solution(minutes, n));
        br.close();
    }

    static int solution(int[] minutes, int n){
        Arrays.sort(minutes);
        int min = 0;
        for(int i=0; i<n; i++){
            min+=minutes[i]*(n-i);
        }

        return min;
    }
}