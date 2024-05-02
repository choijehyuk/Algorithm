import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        K = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>(map.keySet());

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        int answer = 0;
        for (String string : list) {
            int cnt = 0;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '0') cnt++;
            }

            if (cnt <= K && (K - cnt) % 2 == 0) {
                answer = Math.max(map.get(string), answer);
            }

//            System.out.print(map.get(string) + " ");
//            System.out.println(string);
        }

        System.out.println(answer);


    }
}