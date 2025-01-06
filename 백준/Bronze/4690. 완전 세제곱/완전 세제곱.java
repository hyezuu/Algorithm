import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        for(int i=2; i<=100; i++){
            for(int j=2; j<=100; j++){
                for(int k=j+1;k<=100 ; k++){
                    for(int l=k+1; l<=100; l++){
                        if(i*i*i == j*j*j + k*k*k + l*l*l){
                            System.out.printf("Cube = %d, Triple = (%d,%d,%d)", i, j, k, l);
                            System.out.println();
                        }
                    }
                }
            }
        }

    }

}
