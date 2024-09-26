import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Date [] dates = new Date[n];

        for(int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(stk.nextToken());
            int startDate = Integer.parseInt(stk.nextToken());
            int endMonth = Integer.parseInt(stk.nextToken());
            int endDate = Integer.parseInt(stk.nextToken());

            dates[i] = new Date(startMonth*100+startDate, endMonth*100+endDate);
        }

        System.out.println(solution(dates, n));
        br.close();
    }

    static int solution(Date[] dates, int n){
        Arrays.sort(dates);
        int end = 301;
        int maxEnd = end;
        int cnt = 0;
        int i = 0;

        while(maxEnd < 1201){
            boolean found = false;
            while(i<n && dates[i].startDay<=end){
                if(dates[i].endDay>maxEnd){
                    maxEnd = dates[i].endDay;
                    found=true;
                }
                i++;
            }
            if(!found) return 0;
            cnt++;
            end = maxEnd;
        }
        return cnt;
    }
}
class Date implements Comparable<Date>{
    int startDay;
    int endDay;

    public Date(int startDay, int endDay) {
        this.startDay = Math.max(startDay, 301);
        this.endDay = Math.min(endDay, 1201);
    }

    @Override
    public int compareTo(Date o){
        if(this.startDay==o.startDay){
            return o.endDay-this.endDay;
        }
        return this.startDay-o.startDay;
    }
}