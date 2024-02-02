import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        String s = br.readLine();
        int idx = 0;

        int num = 1;

        while (true) {
            String word = String.valueOf(num);

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == s.charAt(idx)) {
                    idx++;
                }
                if (idx == s.length()) {
                    System.out.println(num);
                    System.exit(0);
                }
            }
            num++;
        }
    }
}