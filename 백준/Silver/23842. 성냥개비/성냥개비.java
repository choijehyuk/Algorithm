import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[]{6, 2, 5, 5, 4, 5, 6, 4, 7, 6};

        int[] num = new int[100];

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                num[idx] = arr[i] + arr[j];
                idx++;
            }
        }

        int total = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100 - i; j++) {
                total = num[i] + num[j] + num[i + j] + 4;
                if (total == N) {
                    if (i < 10) System.out.print("0" + i + "+");
                    else System.out.print(i + "+");

                    if (j < 10) System.out.print("0" + j + "=");
                    else System.out.print(j + "=");

                    if (i + j < 10) System.out.print("0" + (i + j));
                    else System.out.print((i + j));

                    System.exit(0);

                }
            }
        }

        System.out.println("impossible");


    }
}