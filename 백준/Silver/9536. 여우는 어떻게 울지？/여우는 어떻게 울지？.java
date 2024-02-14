import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    public String solution(int n, String[] tests, ArrayList<ArrayList<String>> arr) {
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<String> inner = new ArrayList<>();
            for (int j = 0; j < arr.get(i).size(); j++) {
                inner.add(arr.get(i).get(j).substring(arr.get(i).get(j).lastIndexOf(" ") + 1));
            }
            ans.add(inner);
        }
        for (int i = 0; i < n; i++) {
            String[] test = tests[i].split(" ");
            for (String t : test) {
                boolean isContains = false;
                for(int j=0; j<ans.get(i).size() ;j++){
                    if(t.equals(ans.get(i).get(j))) isContains = true;
                }
                if(!isContains) sb.append(t).append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] tests = new String[n];
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tests[i] = br.readLine();
            ArrayList<String> inners = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                String input = br.readLine();
                if (input.equals("what does the fox say?")) break;
                else inners.add(input);
            }
            arr.add(inners);
        }
        bw.write(T.solution(n, tests, arr));
        bw.flush();
    }
}
