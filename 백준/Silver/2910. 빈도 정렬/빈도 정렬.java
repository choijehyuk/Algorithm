import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> index = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            index.add(num);

            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1) == map.get(o2)) {
                    return Integer.compare(index.indexOf(o1), index.indexOf(o2));
                } else {
                    return Integer.compare(map.get(o2), map.get(o1));
                }
            }
        });

        for (Integer i : list) {
            for (int j = 0; j < map.get(i); j++) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }
}