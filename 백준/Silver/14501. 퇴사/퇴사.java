import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N+1][2];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }
        getMaxProfit(schedule);
    }

    static void getMaxProfit(int[][] schedule){
        int quitDate = schedule.length;
        //범위 벗어나는 exception 방지
        int[] dp = new int[quitDate+1];
        
        for(int i=quitDate-1; i>=1; i--){
            int nextDay = i+schedule[i][0];
            //오늘 + 기간이 퇴사날 이전인경우(해당 날짜의 업무를 수행할 수 있는 경우)
            if(nextDay <= quitDate){
                dp[i] = schedule[i][1] + dp[nextDay];
            }
            //이날 일하든 안하든.. 최댓값을 저장하겠다
            dp[i] = Math.max(dp[i], dp[i+1]);
        }
        System.out.print(dp[1]);
    }
}