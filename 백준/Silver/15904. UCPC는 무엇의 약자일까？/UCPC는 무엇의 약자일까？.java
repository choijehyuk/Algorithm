import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        char[] c = {'U', 'C', 'P', 'C'};
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c[idx]) idx++;
            if (idx == 4) {
                System.out.println("I love UCPC");
                System.exit(0);
            }
        }

        System.out.println("I hate UCPC");

    }
}