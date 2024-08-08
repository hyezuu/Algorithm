import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][2];
        int[] max = new int[2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());

            max[0] = Math.max(max[0], matrix[i][0]);
            max[1] = Math.max(max[1], matrix[i][1]);
        }

        System.out.println(area(matrix, max));
    }

    static int area (int[][] matrix, int[] max) {
        int[][] area = new int[max[0]+10][max[1]+10];

        int cnt = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=matrix[i][0]; j<matrix[i][0]+10; j++) {
                for(int k=matrix[i][1]; k<matrix[i][1]+10; k++) {
                    if(area[j][k] == 1) cnt++;
                    else area[j][k] = 1;
                }
            }
        }

        return matrix.length*100 - cnt;
    }
}
