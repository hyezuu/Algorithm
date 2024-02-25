import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.naturalOrder());
        for(int a : list){
            bw.write(a+"\n");
        }
        bw.flush();
    }
}