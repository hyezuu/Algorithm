import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int a3 = 0, b3 = 0, c3 = 0, d3 = 0;

        for (int i = 2; i <= 100; i++) {
            a3 = i * i * i;
            for (int j = 2; j <= 100; j++) {
                b3 = j * j * j;
                if (b3 >= a3) {
                    break;
                }
                for (int k = j + 1; k <= 100; k++) {
                    c3 = k * k * k;
                    if (b3 + c3 >= a3) {
                        break;
                    }
                    for (int l = k + 1; l < i; l++) {
                        d3 = l * l * l;
                        if (b3 + c3 + d3 > a3) {
                            break;
                        }
                        if (b3 + c3 + d3 == a3) {
                            System.out.printf("Cube = %d, Triple = (%d,%d,%d)", i, j, k, l);
                            System.out.println();
                        }
                    }
                }
            }
        }

    }

}
