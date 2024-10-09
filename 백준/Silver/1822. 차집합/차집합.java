import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Set<Integer> set = new TreeSet<>();

        for(int i = 0; i < nA; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < nB; i++) {
            int k = Integer.parseInt(st.nextToken());

            set.remove(k);
        }

        if(set.isEmpty()) {
            bw.write("0");
        }
        else {
            bw.write(set.size() + "\n");

            for(int a : set){
                bw.write(a+" ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}