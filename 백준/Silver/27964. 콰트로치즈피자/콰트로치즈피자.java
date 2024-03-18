import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        HashSet<String> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = st.nextToken();

            if (s.endsWith("Cheese")) set.add(s);
        }

        System.out.println(set.size() >= 4 ? "yummy" : "sad");

    }
}