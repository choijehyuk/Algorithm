import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        int len = str[0].length();

        for (int k = 1; k <= len; k++) {
            for (int i = 0; i < N; i++) {
                set.add(str[i].substring(len - k));
            }
            if (set.size() == N) {
                System.out.println(k);
                System.exit(0);
            }
            set.clear();
        }

    }
}
