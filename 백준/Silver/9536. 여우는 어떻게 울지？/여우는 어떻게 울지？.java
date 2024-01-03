import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            ArrayList<String> list = new ArrayList<>();
            HashSet<String> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }

            while (true) {
                st = new StringTokenizer(br.readLine());

                String animal = st.nextToken();
                String goes = st.nextToken();
                String sound = st.nextToken();

                if (animal.equals("what")) {
                    break;
                }

                set.add(sound);
            }

            for (int i = 0; i < set.size(); i++) {
                list.removeAll(Arrays.asList(set.toArray()));
            }

            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }

}