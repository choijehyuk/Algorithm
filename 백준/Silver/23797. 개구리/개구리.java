import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        int K = 0;
        int P = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'K') {
                K++;
                if (P > 0) P--;
            } else {
                P++;
                if (K > 0) K--;
            }
        }

        System.out.println(K + P);

    }
}