import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        List<Time> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            list.add(new Time(start, end));
        }

        Collections.sort(list);
        int cur = 0;
        int cnt = 0;
        for(Time time : list){
            if(cur<=time.start){
                cnt++;
                cur = time.end;
            }
        }

        System.out.print(cnt);
        br.close();
    }
}
class Time implements Comparable<Time>{
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Time o){
        if(this.end == o.end){
            return this.start-o.end;
        }
        return this.end-o.end;
    }
}