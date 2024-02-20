import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String s = br.readLine();

            if (set.contains(s)) {
                set.remove(s);
            }
            set.add(s);
        }

        int cnt = 0;
        for (String string : set) {
            sb.append(string).append("\n");
            cnt++;
            if (cnt == K) break;
        }
        System.out.println(sb);
    }
}