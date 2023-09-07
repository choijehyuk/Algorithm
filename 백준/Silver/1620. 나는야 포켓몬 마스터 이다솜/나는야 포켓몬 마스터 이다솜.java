import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> mapp = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, i + 1);
            mapp.put(i + 1, s);

        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();

            if (s.charAt(0) - 'A' >= 0) {
                sb.append(map.get(s) + "\n");
            } else {
                sb.append(mapp.get(Integer.parseInt(s)) + "\n");
            }
        }

        System.out.println(sb);
    }
}