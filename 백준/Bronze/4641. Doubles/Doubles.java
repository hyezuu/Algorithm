import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tmp = br.readLine();
		StringBuilder sb = new StringBuilder();
		while(!tmp.equals("-1")){
			StringTokenizer st = new StringTokenizer(tmp);
			Set<Integer> set = new HashSet<>();
			int cnt = 0;
			while (st.hasMoreTokens()) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			for(int a : set){
				if(a == 0) continue;
				if(set.contains(a*2)){
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
			tmp = br.readLine();
		}
		System.out.print(sb);
	}
}