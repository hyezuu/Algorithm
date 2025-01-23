import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> triangleNumList = new ArrayList<>();
		int idx = 1;

		while (true) {
			int num = idx * (idx + 1) / 2;
			if (num > 1000) {
				break;
			}
			triangleNumList.add(num);
			idx++;
		}

		Set<Integer> triangleNumSet = new HashSet<>();

		for (int i = 0; i < triangleNumList.size(); i++) {
			for (int j = 0; j < triangleNumList.size(); j++) {
				for (int k = 0; k < triangleNumList.size(); k++) {
					triangleNumSet.add(
						triangleNumList.get(i) + triangleNumList.get(j) + triangleNumList.get(k));
				}
			}
		}
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(triangleNumSet.contains(num) ? "1" : "0").append("\n");
		}

		System.out.print(sb);
	}

}