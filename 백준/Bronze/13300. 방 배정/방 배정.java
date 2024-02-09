import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int room = sc.nextInt();
        int[][] sg = new int[max][2];
        for(int i=0; i<max; i++){
            for(int j=0; j<2; j++){
                sg[i][j] = sc.nextInt();
            }
        }
        bw.write(T.solution(max, room, sg));
        bw.flush();
    }

    public String solution(int max, int room, int[][] sg) {
        int count = 0;
        int[][] gsc = new int[6][2];
        for(int i=0; i<max; i++){
            int grade = sg[i][1]-1;
            int gender = sg[i][0];
            gsc[grade][gender] = gsc[grade][gender]+1;
        }
        for(int[] sc : gsc){
            count += sc[0]/room + sc[0]%room;
            count += sc[1]/room + sc[1]%room;
        }
        return count+"";
    }
}
