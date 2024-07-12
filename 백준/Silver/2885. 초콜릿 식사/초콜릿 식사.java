import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        int size = 1;
        int size2 = 0;
        int count = 0;

        while (size < K) {
            size *= 2;
            size2 = size;
        }

        while (K > 0) {
            if (K < size) {
                size /= 2;
                count++;
            } else {
                K -= size;
            }
        }

        System.out.println(size2 + " " + count);

    }
}