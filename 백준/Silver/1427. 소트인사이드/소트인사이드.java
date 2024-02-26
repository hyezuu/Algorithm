import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        for(char a :str.toCharArray()){
            list.add(a-'0');
        }
        list.sort(Comparator.reverseOrder());
        for(int a : list) {
            bw.write(a+"");
        }
        bw.flush();
    }
}
