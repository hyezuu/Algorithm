import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer [] A = new Integer[n];
        Integer [] B = new Integer[n];
        for(int i=0; i<2; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                if(i==0){
                   A[j] = Integer.parseInt(stk.nextToken());
                }
                else B[j] = Integer.parseInt(stk.nextToken());
            }
        }

        System.out.print(solution(A,B, n));
        br.close();
    }

    static int solution(Integer[] A, Integer[]B, int n){
        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);
        int s = 0;
        for(int i=0; i<n; i++){
            s+=A[i]*B[i];
        }
        return s;
    }
}