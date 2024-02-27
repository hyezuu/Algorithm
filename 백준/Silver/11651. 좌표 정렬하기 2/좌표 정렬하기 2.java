import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point o){
        if(this.y==o.y) return this.x-o.x;
        else return this.y-o.y;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer nums = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(nums.nextToken());
            int y = Integer.parseInt(nums.nextToken());
            list.add(new Point(x,y));
        }
        Collections.sort(list);
        for(Point o : list){
            bw.write(o.x+" "+o.y+"\n");
        }
        bw.flush();
    }
}
