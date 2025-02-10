import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();

		String answer = "z".repeat(word.length());

		for(int i=1; i<word.length()-1; i++) {
			for(int j=i+1; j<word.length(); j++){
				String first = new StringBuilder(word.substring(0, i)).reverse().toString();
				String middle = new StringBuilder(word.substring(i, j)).reverse().toString();
				String last = new StringBuilder(word.substring(j)).reverse().toString();

				String tmp  = first + middle + last;

				if(tmp.compareTo(answer)<0){
					answer = tmp;
				}
			}
		}

		System.out.print(answer);
	}
}