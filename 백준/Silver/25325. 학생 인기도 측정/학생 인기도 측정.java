import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = st.nextToken();

            map.put(input, 0);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String like = st.nextToken();

                map.put(like, map.get(like) + 1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort(((o1, o2) -> {
            if (map.get(o1) - map.get(o2) == 0) return o1.compareTo(o2);
            else return map.get(o2) - map.get(o1);
        }));

        for (String string : list) {
            System.out.println(string + " " + map.get(string));
        }
    }
}