import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, String> map = new HashMap<>();

        String[] arr = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = br.readLine();
            map.put(arr[i], String.valueOf(i));
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            bw.write(map.containsKey(s) ? map.get(s) : arr[Integer.parseInt(s)]);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}